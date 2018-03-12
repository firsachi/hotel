package ua.kyiv.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.hotel.dao.CustomerDao;
import ua.kyiv.hotel.entites.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public String getAll(){
		List<Customer> customers = customerDao.getAll();
		return "";
 	}

}
