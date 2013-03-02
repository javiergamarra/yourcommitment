package es.cylicon.yourcommitment.model;

import java.io.Serializable;

import com.parse.ParseObject;

public class Donation implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String description;
	private Proyect proyect;
	private Double amount;
	
	public Donation(final ParseObject parseDonation) {
		setId(parseDonation.getString("objectId"));
		setName(parseDonation.getString("name"));
		setDescription(parseDonation.getString("description"));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Proyect getProyect() {
		return proyect;
	}

	public void setProyect(final Proyect proyect) {
		this.proyect = proyect;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

}
