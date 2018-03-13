package ua.kyiv.hotel.dao;

import java.util.List;

import ua.kyiv.hotel.entites.Room;
import ua.kyiv.hotel.model.AvailableRoom;

public interface RoomDao extends BaseDao<Room>{
	
	List<AvailableRoom>  availableRooms();

}
