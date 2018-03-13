package ua.kyiv.hotel.model;

public class AvailableRoom {
	
	private int numberRoom;
	
	private String price;
	
	private int category;
	
	private String priceData;
	
	public AvailableRoom() {
		
	}

	public AvailableRoom(int numberRoom, String price, int category, String priceData) {
		this.numberRoom = numberRoom;
		this.price = price;
		this.category = category;
		this.priceData = priceData;
	}

	public int getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(int numberRoom) {
		this.numberRoom = numberRoom;
	}

	public String getProce() {
		return price;
	}

	public void setProce(String proce) {
		this.price = proce;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getPriceData() {
		return priceData;
	}

	public void setPriceData(String priceData) {
		this.priceData = priceData;
	}

	@Override
	public String toString() {
		return "AvailableRooms [numberRoom=" + numberRoom + ", proce=" + price + ", category=" + category
				+ ", priceData=" + priceData + "]";
	}
	

}
