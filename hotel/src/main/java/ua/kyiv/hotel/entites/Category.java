package ua.kyiv.hotel.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "categoryIds", sequenceName = "category_ids", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryIds")
	private Integer id;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "name", nullable = false)
	private String name;

	//bi-directional many-to-one association to PriceRoom
	@OneToMany(mappedBy="category")
	private List<PriceRoom> priceRooms;

	//bi-directional many-to-one association to Room
	@OneToMany(mappedBy="categoryBean")
	private List<Room> rooms;

	public Category() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PriceRoom> getPriceRooms() {
		return this.priceRooms;
	}

	public void setPriceRooms(List<PriceRoom> priceRooms) {
		this.priceRooms = priceRooms;
	}

	public PriceRoom addPriceRoom(PriceRoom priceRoom) {
		getPriceRooms().add(priceRoom);
		priceRoom.setCategory(this);

		return priceRoom;
	}

	public PriceRoom removePriceRoom(PriceRoom priceRoom) {
		getPriceRooms().remove(priceRoom);
		priceRoom.setCategory(null);

		return priceRoom;
	}

	public List<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room addRoom(Room room) {
		getRooms().add(room);
		room.setCategoryBean(this);

		return room;
	}

	public Room removeRoom(Room room) {
		getRooms().remove(room);
		room.setCategoryBean(null);

		return room;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", description=" + description + ", name=" + name + ", priceRooms=" + priceRooms
				+ ", rooms=" + rooms + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((priceRooms == null) ? 0 : priceRooms.hashCode());
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priceRooms == null) {
			if (other.priceRooms != null)
				return false;
		} else if (!priceRooms.equals(other.priceRooms))
			return false;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.equals(other.rooms))
			return false;
		return true;
	}

	
}