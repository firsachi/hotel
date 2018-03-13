package ua.kyiv.hotel.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ua.kyiv.hotel.dao.RoomDao;
import ua.kyiv.hotel.entites.Room;
import ua.kyiv.hotel.model.AvailableRoom;

@Repository
public class RoomsDaoImpl extends BaseDaoImpl<Room> implements RoomDao{


	@Override
	public List<AvailableRoom> availableRooms() {
		String sql = "SELECT rooms.number_room, price_room.price, rooms.category, price_room.data_price " + 
				"	FROM  price_room " + 
				"		JOIN rooms ON rooms.category = price_room.id_category" + 
				"		JOIN orders ON rooms.number_room != orders.id_room" + 
				"	WHERE price_room.data_price >= '2018-02-12'ORDER BY price_room.data_price;";
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> list =  query.getResultList();
		List<AvailableRoom> result = new ArrayList<>();
		result = list.stream().map(val-> new AvailableRoom((int)val[0], val[1].toString(), (int) val[2], val[3].toString())).collect(Collectors.toList());
		return result;
	}

}
