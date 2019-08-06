package com.czxy.controller;

import com.czxy.domain.*;
import com.czxy.service.CartService;
import com.czxy.service.OrderService;
import com.czxy.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private ProductService productService;
    @Resource
    private CartService cartService;
    @Resource
    private OrderService orderService;

    @PostMapping("/addCart")
    public ResponseEntity<Void> addCart(String pid, String num, String type, String price, HttpServletRequest request) {
        User loginU = (User) request.getSession().getAttribute("loginU");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Product product = productService.findById(pid);
        product.setPrice(Integer.parseInt(price));
        if (cart == null) {
            cart = new Cart();
            cart.setUid(loginU.getUid());
            cart.setCartId(UUID.randomUUID().toString().replace("-", ""));
            cart.add(Integer.parseInt(num), product, type);
            cartService.insertCart(cart);
        } else {
            cart.add(Integer.parseInt(num), product, type);
            cartService.updateCart(cart);
        }

        request.getSession().setAttribute("cart", cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/buyNow")
    public ResponseEntity<Void> buyNow(String pid, String num, String type, String price, HttpServletRequest request) {
        User loginU = (User) request.getSession().getAttribute("loginU");
        Product product = productService.findById(pid);
        Orders orders = new Orders();
        orders.setOid(UUID.randomUUID().toString().replace("-", ""));
        orders.setStatu("未支付");
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        orders.setTime(df.format(date));
        orders.setUid(loginU.getUid());
        orders.setPicture(product.getPicture());

        List<Orderitem> orderitems = new ArrayList<>();
        Orderitem orderitem = new Orderitem();
        orderitem.setProduct(product);
        orderitem.setOiid(UUID.randomUUID().toString().replace("-", ""));
        orderitem.setNum(Integer.parseInt(num));
        orderitem.setSubprice(Integer.parseInt(price) * Integer.parseInt(num));
        orderitem.setPid(pid);
        orderitem.setType(type);
        orderitem.setOid(orders.getOid());

        orderitems.add(orderitem);
        orders.setOrderitems(orderitems);

        orderService.addOrder(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getCart")
    public ResponseEntity<List<Cartitem>> getCart(HttpServletRequest request) {
        User loginU = (User) request.getSession().getAttribute("loginU");
        List<Cart> allCartByUid = cartService.findAllCartByUid(loginU.getUid());
        List<Cartitem> allCartitem = new ArrayList<>();
        for (Cart cart : allCartByUid) {
            List<Cartitem> cartitems = cart.getCartitems();
            for (Cartitem cartitem : cartitems) {
                allCartitem.add(cartitem);
            }
        }
        return ResponseEntity.ok(allCartitem);
    }

//    @GetMapping("/getBuyNow")
//    public ResponseEntity<VoBuyBow> getBuyNow(HttpServletRequest request){
//        VoBuyBow voBuyBow = (VoBuyBow) request.getSession().getAttribute("voBuyBow");
//        return ResponseEntity.ok(voBuyBow);
//    }

    @DeleteMapping("/deleteCartItem/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable("id") String id, HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.getMap().remove(id);
        }
        request.getSession().setAttribute("cart", cart);
        cartService.deleteCartitem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
