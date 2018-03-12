package ua.kyiv.hotel.entites;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private UUID id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_registration")
	private Date dateRegistration;

	@Column(name = "disable", columnDefinition = "boolean default false", nullable = false)
	private Boolean disable;

	private double price;

	//bi-directional many-to-many association to BaseOption
	@ManyToMany
	@JoinTable(
		name="order_options"
		, joinColumns={
			@JoinColumn(name="id_order")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_options")
			}
		)
	private List<BaseOption> baseOptions;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="id_costumer")
	private Customer customer;

	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="id_room")
	private Room room;

	public Order() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getDateRegistration() {
		return this.dateRegistration;
	}

	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	public Boolean getDisable() {
		return this.disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<BaseOption> getBaseOptions() {
		return this.baseOptions;
	}

	public void setBaseOptions(List<BaseOption> baseOptions) {
		this.baseOptions = baseOptions;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", dateRegistration=" + dateRegistration + ", disable=" + disable + ", price="
				+ price + ", baseOptions=" + baseOptions + ", customer=" + customer + ", room=" + room + "]";
	}


}