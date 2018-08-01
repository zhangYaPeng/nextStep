package com.eakay.next.repository.mongodb.order;

import com.eakay.next.client.mongodb.order.OrderHistoryMongo;
import com.eakay.next.repository.mongodb.MongoDaoSupport;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderMongoDao extends MongoDaoSupport<OrderHistoryMongo> {

	@Override
	protected Class<OrderHistoryMongo> getEntityClass() {
		return OrderHistoryMongo.class;
	}

	public List<OrderHistoryMongo> list(Integer customerId) {
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.and("customerid").is(customerId);

		query.addCriteria(criteria);
		query.with(new Sort(Sort.Direction.DESC, "id"));

		List<OrderHistoryMongo> list = find(query);

		return list;
	}
}
