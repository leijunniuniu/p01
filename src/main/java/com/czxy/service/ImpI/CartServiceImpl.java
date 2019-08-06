package com.czxy.service.ImpI;

import com.czxy.dao.CartMapper;
import com.czxy.dao.CartitemMapper;
import com.czxy.domain.Cart;
import com.czxy.domain.Cartitem;
import com.czxy.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;
    @Resource
    private CartitemMapper cartitemMapper;

    @Override
    public void insertCart(Cart cart) {
        cartMapper.insert(cart);
        List<Cartitem> cartitems = cart.getCartitems();
        for (Cartitem cartitem : cartitems) {
            Cartitem cartitem1 = cartitemMapper.selectByPrimaryKey(cartitem.getCartitem_id());
            if (cartitem1 != null) {
                cartitemMapper.updateByPrimaryKeySelective(cartitem);
            } else {
                cartitemMapper.insert(cartitem);
            }
        }
    }

    @Override
    public void updateCart(Cart cart) {
        List<Cartitem> cartitems = cart.getCartitems();
        for (Cartitem cartitem : cartitems) {
            Cartitem cartitem1 = cartitemMapper.selectByPrimaryKey(cartitem.getCartitem_id());
            if (cartitem1 != null) {
                cartitemMapper.updateByPrimaryKeySelective(cartitem);
            } else {
                cartitemMapper.insert(cartitem);
            }
        }
    }

    @Override
    public void insertCartitem(Cartitem cartitem) {
        cartitemMapper.insert(cartitem);
    }

    @Override
    public List<Cart> findAllCartByUid(String uid) {
        return cartMapper.findAllCartByUid(uid);
    }

    @Override
    public List<Cartitem> findAllCartitem() {
        return cartitemMapper.findAllCartitem();
    }

    @Override
    public Cart findCartById(String cartId) {
        return cartMapper.findCartById(cartId);
    }

    @Override
    public Cartitem findCartitemById(String cartitem_id) {
        Cartitem cartitemById = cartitemMapper.findCartitemById(cartitem_id);
        return cartitemById;
    }


    @Override
    public void updateCartitem(Cartitem cartitem) {
        cartitemMapper.updateByPrimaryKeySelective(cartitem);
    }

    @Override
    public void deleteCartitem(String cartitem_id) {
        cartitemMapper.deleteByPrimaryKey(cartitem_id);
    }

    @Override
    public void deleteCart(String cartId) {
        cartMapper.deleteByPrimaryKey(cartId);
    }

}
