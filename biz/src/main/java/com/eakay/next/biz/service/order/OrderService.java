package com.eakay.next.biz.service.order;


import com.eakay.next.client.domain.OrderDO;
import com.eakay.next.client.mongodb.order.OrderHistoryMongo;

import java.util.List;

/**
 * Created by 张亚鹏 on 2018/5/17.
 */
public interface OrderService {

    void add(OrderDO orderDO);

    void cancelOrder(Integer orderId, int flag);

    void returnCar(Integer orderId);

    void hasPayed(Integer orderId, Integer flag);

    OrderDO currentOrder(Integer customerId);

    OrderDO orderDetail(Integer orderId);

    List<OrderHistoryMongo> historyList(Integer customerId);

    void putDataToMongo(Integer orderId);

}
