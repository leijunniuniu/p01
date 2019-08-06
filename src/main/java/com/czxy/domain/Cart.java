package com.czxy.domain;


import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    @Id
    private String cartId;
    private Integer totalmoney;
    private String uid;
    private Map<String, Cartitem> map = new HashMap<>();
    private List<Cartitem> cartitems = new ArrayList<>();
    //加入购物车
    public void add(Integer num,Product product,String type){
        Cartitem cartitem = map.get(product.getPid());
        if (cartitem==null){
            cartitem = new Cartitem();
            cartitem.setNum(num);
            cartitem.setCartitem_id(cartId+product.getPid());
            cartitem.setPid(product.getPid());
            cartitem.setCartId(cartId);
            cartitem.setProduct(product);
            cartitem.setType(type);
            cartitem.setSubprice(product.getPrice()*num);

            map.put(product.getPid(),cartitem);
        }else {
            cartitem.setNum(cartitem.getNum()+num);
        }
        cartitems.add(cartitem);
    }

    //删除购物车项
    public void deleteCartItem(String id){
        map.remove(id);
    }
    //清空购物车


    public Cart() {
    }

    public Cart(String cartId, Integer totalmoney, String uid, Map<String, Cartitem> map, List<Cartitem> cartitems) {
        this.cartId = cartId;
        this.totalmoney = totalmoney;
        this.uid = uid;
        this.map = map;
        this.cartitems = cartitems;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Integer getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Integer totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Map<String, Cartitem> getMap() {
        return map;
    }

    public void setMap(Map<String, Cartitem> map) {
        this.map = map;
    }

    public List<Cartitem> getCartitems() {
        return cartitems;
    }

    public void setCartitems(List<Cartitem> cartitems) {
        this.cartitems = cartitems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", totalmoney=" + totalmoney +
                ", uid='" + uid + '\'' +
                ", map=" + map +
                ", cartitems=" + cartitems +
                '}';
    }
}
