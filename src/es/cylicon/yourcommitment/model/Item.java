package es.cylicon.yourcommitment.model;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Proyect proyect;
	private Double amount;

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

}
