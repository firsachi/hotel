package ua.kyiv.hotel.dao;

public abstract class DaoFactory {

	public abstract CustomerDao createCompanyDao();
	public abstract RoomDao createRoomDao();

	public static DaoFactory getInstance() {
		try {
			Class<?> clazz = Class.forName("ua.kyiv.hotel.dao.impl");
			return (DaoFactory) clazz.newInstance();
		} catch (Exception ex) {
			return null;
		}
	}

}
