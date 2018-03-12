package ua.kyiv.hotel.dao;

public interface BaseDao<T> {

	void save(T enttity);
	void update(T entity);
	T byId(int primaryKey);
}
