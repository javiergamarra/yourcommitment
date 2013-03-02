package es.cylicon.yourcommitment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.parse.ParseObject;

public class Proyect implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String description;
	private Double totalAmount;
	private Double progress;
	private String address;
	private Double budget;
	private Category category;
	private List<Update> updates;

	public Proyect(final String name) {
		this.name = name;
	}

	public Proyect(final ParseObject parseProyect) {
		setId(parseProyect.getObjectId());
		setName(parseProyect.getString("name"));
		setDescription(parseProyect.getString("description"));
		setTotalAmount(parseProyect.getDouble("totalAmount"));
		setProgress(parseProyect.getDouble("progress"));
		setAddress(parseProyect.getString("address"));
	}

	public Proyect() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
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

	public static List<Proyect> createProyects(final List<ParseObject> objects) {
		final List<Proyect> proyects = new ArrayList<Proyect>();
		for (final ParseObject object : objects) {
			proyects.add(new Proyect(object));
		}
		return proyects;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(final Double budget) {
		this.budget = budget;
	}

}
