package ua.kyiv.hotel.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ua.kyiv.hotel.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	protected Class<T> type;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public final void setType(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	@Override
	public void update(T entity) {
		entityManager.merge(entity);	}
	
	@Override
	public T byId(int primaryKey) {
	 	return entityManager.find(type, primaryKey);
	}

}
