package ua.kyiv.hotel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.kyiv.hotel.dao.CustomerDao;
import ua.kyiv.hotel.dao.DaoFactory;
import ua.kyiv.hotel.dao.RoomDao;

@Component
public class DaoFactoryImpl extends DaoFactory{
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired RoomDao roomDao;

	@Override
	public CustomerDao createCompanyDao() {
		return customerDao;
	}

	@Override
	public RoomDao createRoomDao() {
		return roomDao;
	}

}
