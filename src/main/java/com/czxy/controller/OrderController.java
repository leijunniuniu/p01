package com.czxy.controller;

import com.czxy.domain.*;
import com.czxy.service.CartService;
import com.czxy.service.OrderService;
import com.czxy.service.PCDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private CartService cartService;
    @Resource
    private PCDService pcdService;

    @PostMapping("/addOrder/{caritemIds}")
    public ResponseEntity<Void> addOrder(@PathVariable("caritemIds") String caritemIds, HttpServletRequest request){
        User loginU = (User) request.getSession().getAttribute("loginU");

        String[] s = caritemIds.split(",");
        Orders orders = new Orders();
        orders.setOid(UUID.randomUUID().toString().replace("-",""));
        orders.setStatu("未支付");
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        orders.setTime(df.format(date));
        orders.setUid(loginU.getUid());

        List<Orderitem> orderitems = new ArrayList<>();
        for (String s1 : s) {
            Cartitem cartitem = cartService.findCartitemById(s1);

            Orderitem orderitem = new Orderitem();
            orderitem.setOid(orders.getOid());
            orderitem.setOiid(UUID.randomUUID().toString().replace("-",""));
            orderitem.setPid(cartitem.getPid());
            orderitem.setNum(cartitem.getNum());
            orderitem.setType(cartitem.getType());
            orderitem.setSubprice(cartitem.getSubprice());
            orderitem.setProduct(cartitem.getProduct());

            orderitems.add(orderitem);

            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart != null) {
                cart.getMap().remove(cartitem.getPid());
            }
            cartService.deleteCartitem(s1);
            request.getSession().setAttribute("cart", cart);

            Cart cartById = cartService.findCartById(cartitem.getCartId());
            if (cartById.getCartitems().isEmpty()){
                cart.getMap().clear();
                cartService.deleteCart(cartitem.getCartId());
                request.getSession().removeAttribute("cart");
            }
        }

        orders.setOrderitems(orderitems);

        orderService.addOrder(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getOrder")
    public ResponseEntity<List<Orders>> getOrder(HttpServletRequest request){
        User loginU = (User) request.getSession().getAttribute("loginU");

        List<Orders> allOrders = orderService.findOrdersByUid(loginU.getUid());
        for (Orders allOrder : allOrders) {
            List<Orderitem> orderitems = allOrder.getOrderitems();
            allOrder.setPicture(orderitems.get(0).getProduct().getPicture());
        }
        return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/findOrderitemByOid/{oid}")
    public ResponseEntity<List<Orderitem>> findOrderitemByOid(@PathVariable("oid") String oid){
        List<Orderitem> orderitemByOid = orderService.findOrderitemByOid(oid);
        return ResponseEntity.ok(orderitemByOid);
    }

    @DeleteMapping("/deleteOrderitem/{oiid}/{oid}")
    public ResponseEntity<Void> deleteOrderitem(@PathVariable("oiid") String oiid, @PathVariable("oid") String oid) throws IOException {
        orderService.deleteOrderitem(oiid);
        List<Orderitem> orderitems = orderService.findOrderitemByOid(oid);
        if (orderitems.isEmpty()){
            orderService.deleteOrder(oid);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/buy/{oiids}")
    public ResponseEntity<Void> buy(@PathVariable("oiids") String oiids,HttpServletRequest request){
        String[] split = oiids.split(",");
        List<VoBuyBow> voBuyBows = new ArrayList<>();
        for (String s : split) {
            Orderitem orderitem = orderService.findOrderitemByOiid(s);
            VoBuyBow voBuyBow = new VoBuyBow();
            voBuyBow.setProduct(orderitem.getProduct());
            voBuyBow.setType(orderitem.getType());
            voBuyBow.setNum(orderitem.getNum());
            voBuyBow.setSubprice(orderitem.getSubprice());
            voBuyBows.add(voBuyBow);
        }

        request.getSession().setAttribute("voBuyBows",voBuyBows);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getBuy")
    public ResponseEntity<List<VoBuyBow>> getBuy(HttpServletRequest request){
        List<VoBuyBow> voBuyBows = (List<VoBuyBow>) request.getSession().getAttribute("voBuyBows");
        return ResponseEntity.ok(voBuyBows);
    }
    //结算
    @PutMapping("/accontOrder")
    public ResponseEntity<Void> accontOrder(Orders orders){
        String address = orders.getAddress();
        System.out.println(address);
        String[] split = address.split(",");
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < split.length; i++) {
            if (i<3){
                PCD pcd = pcdService.findPCD(split[i]);
                s1+=pcd.getName();
            }else {
                s2=split[i];
            }
        }
        orders.setAddress(s1+s2);
        orders.setStatu("已支付");

        orderService.updateOrder(orders);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
