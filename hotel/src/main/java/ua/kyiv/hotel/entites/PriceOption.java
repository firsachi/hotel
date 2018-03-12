package ua.kyiv.hotel.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the price_options database table.
 * 
 */
@Entity
@Table(name="price_options")
@NamedQuery(name="PriceOption.findAll", query="SELECT p FROM PriceOption p")
public class PriceOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "priceOptionIds", sequenceName = "price_options_ids", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "priceOptionIds")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_price")
	private Date dataPrice;
	
	@Column(name = "disable", columnDefinition = "boolean default false", nullable = false)
	private boolean disable;

	private double price;

	//bi-directional many-to-one association to BaseOption
	@ManyToOne
	@JoinColumn(name="id_base_options")
	private BaseOption baseOption;

	public PriceOption() {
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

	public BaseOption getBaseOption() {
		return this.baseOption;
	}

	public void setBaseOption(BaseOption baseOption) {
		this.baseOption = baseOption;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseOption == null) ? 0 : baseOption.hashCode());
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
		PriceOption other = (PriceOption) obj;
		if (baseOption == null) {
			if (other.baseOption != null)
				return false;
		} else if (!baseOption.equals(other.baseOption))
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
		return "PriceOption [id=" + id + ", dataPrice=" + dataPrice + ", disable=" + disable + ", price=" + price
				+ ", baseOption=" + baseOption + "]";
	}

	
}