package ua.kyiv.hotel.dao;

import java.util.List;

import ua.kyiv.hotel.entites.Customer;

public interface CustomerDao extends BaseDao<Customer>{
	
	List<Customer> getAll();

}
