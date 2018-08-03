package com.eakay.next.biz.service.order.impl;

import com.eakay.next.biz.job.MyJob;
import com.eakay.next.client.domain.OrderDO;
import com.eakay.next.client.exceptions.CommonRuntimeException;
import com.eakay.next.client.mongodb.order.OrderHistoryMongo;
import com.eakay.next.client.util.BeanCopierUtil;
import com.eakay.next.repository.mongodb.order.OrderMongoDao;
import com.eakay.next.repository.mybatis.master.order.OrderDOMapper;
import com.eakay.next.repository.redis.OrderRedisDao;
import com.eakay.next.repository.util.table.TableSplitStrategy;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import com.eakay.next.biz.service.order.OrderService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by 张亚鹏 on 2018/5/17.
 */
@Service
public class OrderServiceImpl implements OrderService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Autowired
    private OrderMongoDao orderMongoDao;

    @Autowired
    private OrderRedisDao orderRedisDao;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    @Qualifier("orderTableSplitStrategy")
    private TableSplitStrategy orderTableSplitStrategy;

    @Override
    public void add(OrderDO orderDO) {
        orderDOMapper.insertSelective(orderDO);

        orderRedisDao.setOrderStatus(orderDO.getId(), orderDO.getOrderstatus());
        orderRedisDao.setUserOrder(orderDO.getId(), orderDO.getOrderstatus());

        createTableIfNOTExist(orderDO.getId());
    }

    private void createTableIfNOTExist(Integer orderId) {
        String tableName = orderTableSplitStrategy.getTableName(orderId);
        if ( !orderDOMapper.existTable(tableName) ) {
            orderDOMapper.createTableIfNotExist(tableName);
        }
    }

    @Transactional(value = "masterTX", rollbackFor = Exception.class)
    @Override
    public void cancelOrder(Integer orderId, int flag) {
        createTableIfNOTExist(orderId);

        OrderDO updateOrder = new OrderDO();
        updateOrder.setId(orderId);
        updateOrder.setOrderstatus("已取消");

        orderDOMapper.updateByPrimaryKeySelective(updateOrder);

        copyOrderToSplit(orderId);

        orderDOMapper.deleteByPrimaryKey(orderId);

        orderRedisDao.setOrderStatus(orderId, updateOrder.getOrderstatus());
        orderRedisDao.setUserOrder(orderId, updateOrder.getOrderstatus());

        if ( flag == 0 ) {
            throw new CommonRuntimeException("哦，出错了");
        }

    }

    public void copyOrderToSplit(Integer orderId) {
        String tableName = orderTableSplitStrategy.getTableName(orderId);

        orderDOMapper.copyOrderToSplit(tableName, orderId);

    }

    @Override
    public void returnCar(Integer orderId) {
        OrderDO updateOrder = new OrderDO();
        updateOrder.setId(orderId);
        updateOrder.setOrderstatus("已还车");
        updateOrder.setReturncarconfirm("已关门");
        updateOrder.setRelitygetsiteid(2);
        updateOrder.setRealityreturntime(new Date());

        orderDOMapper.updateByPrimaryKeySelective(updateOrder);


        orderRedisDao.setOrderStatus(orderId, updateOrder.getOrderstatus());
        orderRedisDao.setUserOrder(orderId, updateOrder.getOrderstatus());
    }

    @Transactional(value = "masterTX", rollbackFor = Exception.class)
    @Override
    public void hasPayed(Integer orderId, Integer flag) {
        createTableIfNOTExist(orderId);

        OrderDO updateOrder = new OrderDO();
        updateOrder.setId(orderId);
        updateOrder.setOrderstatus("已付费");
        updateOrder.setPayment("78");
        updateOrder.setPaymoney(new BigDecimal("78"));
        updateOrder.setPaymenttime(new Date());

        orderDOMapper.updateByPrimaryKeySelective(updateOrder);

        copyOrderToSplit(orderId);

        orderDOMapper.deleteByPrimaryKey(orderId);

        orderRedisDao.setOrderStatus(orderId, updateOrder.getOrderstatus());
        orderRedisDao.setUserOrder(orderId, updateOrder.getOrderstatus());

        if ( flag == 0 ) {
            throw new CommonRuntimeException("哦，出错了");
        }
    }

    public void putDataToMongo(Integer orderId) {
        String tableName = orderTableSplitStrategy.getTableName(orderId);
        OrderDO orderDO = orderDOMapper.selectByPrimaryKeyAndTablename(tableName, orderId);
        OrderHistoryMongo history = new OrderHistoryMongo();
        BeanCopierUtil.copy(orderDO, history);
        orderMongoDao.saveOrUpdate(history);
    }

    @Override
    public OrderDO currentOrder(Integer customerId) {
        Example example = new Example(OrderDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("customerid", customerId);
        criteria.andNotEqualTo("orderstatus", "已取消");
        example.orderBy("createdtime").desc();

        List<OrderDO> list = orderDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public OrderDO orderDetail(Integer orderId) {

        OrderDO orderDO = orderDOMapper.selectByPrimaryKey(orderId);

        if ( orderDO == null ) {
            String tableName = orderTableSplitStrategy.getTableName(orderId);

            orderDO = orderDOMapper.selectByPrimaryKeyAndTablename(tableName, orderId);
        }

        return orderDO;

    }

    @Override
    public List<OrderHistoryMongo> historyList(Integer customerId) {
        List<OrderHistoryMongo> list = orderMongoDao.list(customerId);
        return list;
    }

    @Override
    public void testType() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int a = 1;
        a++;
        a = a + 15;
        taskExecutor.execute(new MyJob("myjob1"));

    }
}
