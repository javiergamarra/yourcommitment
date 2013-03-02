package es.cylicon.yourcommitment.model;

import java.io.Serializable;
import java.util.List;

import com.parse.ParseObject;

public class Proyect implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private Double totalAmount;
	private Double progress;
	private String address;
	private Category category;
	private List<Update> updates;

	public Proyect(final String name) {
		this.name = name;
	}

	public Proyect(final ParseObject parseProyect) {
		setName(parseProyect.getString("name"));
		setDescription(parseProyect.getString("description"));
	}

	public List<Update> getUpdates() {
		return updates;
	}

	public void setUpdates(final List<Update> updates) {
		this.updates = updates;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(final Double totalAmount) {
		this.totalAmount = totalAmount;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

}
