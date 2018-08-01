package com.eakay.next.repository.mybatis.master.order;

import com.eakay.next.client.domain.OrderDO;
import com.eakay.next.repository.base.BaseMyBatisMapper;
import org.apache.ibatis.annotations.Param;

public interface OrderDOMapper extends BaseMyBatisMapper<OrderDO> {

    Boolean existTable(@Param("tableName") String tableName);

    void createTableIfNotExist(@Param("tableName") String tableName);

    int copyOrderToSplit(@Param("tableName") String tableName, @Param("orderId") Integer orderId);

    OrderDO selectByPrimaryKeyAndTablename(@Param("tableName") String tableName, @Param("orderId") Integer orderId);

}