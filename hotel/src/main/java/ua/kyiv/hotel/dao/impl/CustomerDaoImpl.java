package ua.kyiv.hotel.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.kyiv.hotel.dao.CustomerDao;
import ua.kyiv.hotel.entites.Customer;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	public CustomerDaoImpl() {
		super();
		setType(Customer.class);
	}

	@Override
	public List<Customer> getAll() {
		String hql = "FROM Customer c";
		TypedQuery<Customer> query = entityManager.createQuery(hql, type);
		return query.getResultList();
	}
	
	
}
