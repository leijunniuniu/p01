package com.czxy.service.ImpI;

import com.czxy.dao.OrderItemMapper;
import com.czxy.dao.OrderMapper;
import com.czxy.domain.Orderitem;
import com.czxy.domain.Orders;
import com.czxy.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public void addOrder(Orders orders) {
        orderMapper.insert(orders);
        List<Orderitem> orderitems = orders.getOrderitems();
        for (Orderitem orderitem : orderitems) {
            orderItemMapper.insert(orderitem);
        }
    }

    @Override
    public List<Orders> findOrdersByUid(String uid) {
        return orderMapper.findOrdersByUid(uid);
    }

    @Override
    public List<Orderitem> findOrderitemByOid(String oid) {
        return orderItemMapper.findOrderitemByOid(oid);
    }

    @Override
    public void deleteOrderitem(String oiid) {
        orderItemMapper.deleteByPrimaryKey(oiid);
    }

    @Override
    public void deleteOrder(String oid) {
        orderMapper.deleteByPrimaryKey(oid);
    }

    @Override
    public Orderitem findOrderitemByOiid(String oiid) {
        return orderItemMapper.findOrderitemByOiid(oiid);
    }

    @Override
    public void updateOrder(Orders orders) {
        orderMapper.updateByPrimaryKeySelective(orders);
    }
}
