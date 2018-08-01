package com.eakay.next.repository.redis;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class OrderRedisDao {

	@Resource(name = "stringRedisTemplate")
	private ValueOperations<String, String> valueOps;

	public void setOrderStatus(int orderId, String orderStatus) {
		valueOps.set("test_o_" + orderId, orderStatus);
	}

	public void setUserOrder(int orderId,  String orderStatus) {
		valueOps.set("test_u_" + orderId, orderStatus);
	}

}
