package ua.kyiv.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.kyiv.hotel.dao.CustomerDao;
import ua.kyiv.hotel.dao.DaoFactory;
import ua.kyiv.hotel.entites.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private DaoFactory daoFactory;

	@RequestMapping("/customer")
	public ResponseEntity<List<Customer>> all() {
		CustomerDao customerDao = daoFactory.createCompanyDao();
		List<Customer> list = customerDao.getAll();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> findId(@PathVariable("id") Integer id) {
		CustomerDao customerDao = daoFactory.createCompanyDao();
		ResponseEntity<Customer> customer = new ResponseEntity<>(customerDao.byId(id), HttpStatus.OK);;
		return customer;
	}
}
