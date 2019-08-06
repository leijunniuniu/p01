package com.czxy.service;

import com.czxy.domain.Cart;
import com.czxy.domain.Cartitem;

import java.util.List;

public interface CartService {
    public void insertCart(Cart cart);
    public void insertCartitem(Cartitem cartitem);
    public List<Cart> findAllCartByUid(String uid);
    public List<Cartitem> findAllCartitem();
    public Cart findCartById(String cartId);
    public Cartitem findCartitemById(String cartitem_id);
    public void updateCart(Cart cart);
    public void updateCartitem(Cartitem cartitem);
    public void deleteCartitem(String cartitem_id);
    public void deleteCart(String cartId);
}
