package ua.kyiv.hotel.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rooms database table.
 * 
 */
@Entity
@Table(name="rooms")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="number_room")
	private Integer numberRoom;

	@Column(name = "disable", columnDefinition = "boolean default true", nullable = false)
	private boolean disable;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="room")
	private List<Order> orders;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category")
	private Category categoryBean;

	public Room() {
	}

	public Integer getNumberRoom() {
		return this.numberRoom;
	}

	public void setNumberRoom(Integer numberRoom) {
		this.numberRoom = numberRoom;
	}

	public Boolean getDisable() {
		return this.disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setRoom(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setRoom(null);
		return order;
	}

	public Category getCategoryBean() {
		return this.categoryBean;
	}

	public void setCategoryBean(Category categoryBean) {
		this.categoryBean = categoryBean;
	}

	@Override
	public String toString() {
		return "Room [numberRoom=" + numberRoom + ", disable=" + disable + ", orders=" + orders + ", categoryBean="
				+ categoryBean + "]";
	}
	
	

}