package com.eakay.next.repository.mongodb;

import com.eakay.next.client.mongodb.PageVO;
import com.mongodb.client.result.UpdateResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Field;
import java.util.List;

public abstract class MongoDaoSupport<T> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected MongoTemplate orderMongoTemplate;

	protected abstract Class<T> getEntityClass();

	protected String getKey() {
		return getEntityClass().getSimpleName();
	}

	public void save(T entity, String key) {
		orderMongoTemplate.insert(entity, key);
	}

	public void save(T entity) {
		save(entity, getKey());
	}

	public void saveOrUpdate(T entity) {
		saveOrUpdate(entity, getKey());
	}

	public void saveOrUpdate(T entity, String key) {
		orderMongoTemplate.save(entity, key);
	}

	public void remove(Query query, String key){
		orderMongoTemplate.remove(query, this.getEntityClass(), key) ;
	}

	public void remove(Query query) {
		remove(query, getKey());
	}

	public T update(Query query, Update update, String key) {
		return orderMongoTemplate.findAndModify(query, update, this.getEntityClass(), key);
	}

	public T update(Query query, Update update) {
		return update(query, update, getKey());
	}

	public T findById(Object id, String key) {
		return orderMongoTemplate.findById(id, this.getEntityClass(), key);
	}

	public T findById(Object id) {
		return findById(id, getKey());
	}

	public T findOne(Query query, String key) {
		return orderMongoTemplate.findOne(query, this.getEntityClass(), key);
	}

	public T findOne(Query query) {
		return findOne(query, getKey());
	}

	public List<T> find(Query query, String key) {
		return orderMongoTemplate.find(query, this.getEntityClass(), key);
	}

	public List<T> find(Query query) {
		return find(query, getKey());
	}

	public long count(Query query, String key) {
		return orderMongoTemplate.count(query, this.getEntityClass(), key);
	}

	public long count(Query query) {
		return count(query, getKey());
	}

	public void selectByPage(PageVO<T> page, Query query, String key) {
		// 计算总记录数
		long totalCount = this.count(query, key);
		
		//分页查询列表
		int pageNo = page.getPageNo();
		int pageSize = page.getPageSize();
		query.skip((pageNo - 1) * pageSize).limit(pageSize);
		List<T> result = this.find(query, key);

		page.setResult(result);
		page.setTotalCount(totalCount);
	}

	public void selectByPage(PageVO<T> page, Query query) {
		selectByPage(page, query, getKey());
	}

	public Integer updateByIdSelective(Object object, String key) {
		Query query = new Query();
		Update update = new Update();

		Class<?> cls = object.getClass();

		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			Object value = null;
			try {
				field.setAccessible(true);
				value = field.get(object);
				if ("id".equals(name)) {
					query.addCriteria(Criteria.where("id").is(value));
					continue;
				}
				if ( "serialVersionUID".equals(name) ) {
					continue;
				}
			} catch (Exception e) {
				logger.warn("MongoBaseCollDAO->updateByIdSelective", e);
			}
			if(value != null) {
				update.set(name, value);
			}
		}

		UpdateResult updateResult = orderMongoTemplate.updateFirst(query, update, object.getClass(), key);
		return (int)updateResult.getModifiedCount();
	}

	public Integer updateByIdSelective(Object object) {
		return updateByIdSelective(object, getKey());
	}

}
