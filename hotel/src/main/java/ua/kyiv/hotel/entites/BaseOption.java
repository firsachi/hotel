package ua.kyiv.hotel.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the base_options database table.
 * 
 */
@Entity
@Table(name="base_options")
@SequenceGenerator(name = "baseOptionIds", sequenceName = "base_options_ids", allocationSize = 1)
public class BaseOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baseOptionIds")
	@Column(name = "id")
	private Integer id;

	@Column(name = "disable", columnDefinition = "boolean default false", nullable = false)
	private boolean disable;

	@Column(name = "name", nullable = false)
	private String name;

	//bi-directional many-to-many association to Order
	@ManyToMany(mappedBy="baseOptions")
	private List<Order> orders;

	//bi-directional many-to-one association to PriceOption
	@OneToMany(mappedBy="baseOption")
	private List<PriceOption> priceOptions;

	public BaseOption() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDisable() {
		return this.disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<PriceOption> getPriceOptions() {
		return this.priceOptions;
	}

	public void setPriceOptions(List<PriceOption> priceOptions) {
		this.priceOptions = priceOptions;
	}

	public PriceOption addPriceOption(PriceOption priceOption) {
		getPriceOptions().add(priceOption);
		priceOption.setBaseOption(this);

		return priceOption;
	}

	public PriceOption removePriceOption(PriceOption priceOption) {
		getPriceOptions().remove(priceOption);
		priceOption.setBaseOption(null);

		return priceOption;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (disable ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((priceOptions == null) ? 0 : priceOptions.hashCode());
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
		BaseOption other = (BaseOption) obj;
		if (disable != other.disable)
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
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (priceOptions == null) {
			if (other.priceOptions != null)
				return false;
		} else if (!priceOptions.equals(other.priceOptions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseOption [id=" + id + ", disable=" + disable + ", name=" + name + ", orders=" + orders
				+ ", priceOptions=" + priceOptions + "]";
	}

	
}