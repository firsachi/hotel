package ua.kyiv.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kyiv.hotel.dao.DaoFactory;
import ua.kyiv.hotel.model.AvailableRoom;


@Controller
public class RoomController {

	@Autowired
	private DaoFactory daoFactory;
	
	@RequestMapping("/available-rooms")
	public ResponseEntity<List<AvailableRoom>> all() {
		List<AvailableRoom> availableRooms = daoFactory.createRoomDao().availableRooms();
		return new ResponseEntity<List<AvailableRoom>>(availableRooms, HttpStatus.OK);
	}
}
