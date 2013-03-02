package es.cylicon.yourcommitment.model;

import java.io.Serializable;

public class Proyect implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Double amount;
	private Double progress;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	public Double getProgress() {
		return progress;
	}

	public void setProgress(final Double progress) {
		this.progress = progress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

}
