package com.czxy.service;

import com.czxy.domain.Orderitem;
import com.czxy.domain.Orders;

import java.util.List;

public interface OrderService {
    public void addOrder(Orders orders);
    public List<Orders> findOrdersByUid(String uid);
    public List<Orderitem> findOrderitemByOid(String oid);
    public void deleteOrderitem(String oiid);
    public void deleteOrder(String oid);
    public Orderitem findOrderitemByOiid(String oiid);
    public void updateOrder(Orders orders);
}
