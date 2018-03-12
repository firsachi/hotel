package ua.kyiv.hotel.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the price_room database table.
 * 
 */
@Entity
@Table(name="price_room")
@NamedQuery(name="PriceRoom.findAll", query="SELECT p FROM PriceRoom p")
public class PriceRoom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "priceRoomIds", sequenceName = "price_room_ids", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "priceRoomIds")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_price")
	private Date dataPrice;

	@Column(name = "disable", columnDefinition = "boolean default false", nullable = false)
	private boolean disable;

	private double price;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;

	public PriceRoom() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataPrice() {
		return this.dataPrice;
	}

	public void setDataPrice(Date dataPrice) {
		this.dataPrice = dataPrice;
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

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dataPrice == null) ? 0 : dataPrice.hashCode());
		result = prime * result + (disable ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PriceRoom other = (PriceRoom) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dataPrice == null) {
			if (other.dataPrice != null)
				return false;
		} else if (!dataPrice.equals(other.dataPrice))
			return false;
		if (disable != other.disable)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PriceRoom [id=" + id + ", dataPrice=" + dataPrice + ", disable=" + disable + ", price=" + price
				+ ", category=" + category + "]";
	}

	
}