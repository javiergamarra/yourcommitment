package es.cylicon.yourcommitment.model;

import java.io.Serializable;
import java.util.List;

import com.parse.ParseObject;

public class Donation implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String description;
	private String proyectId;
	private Double amount;
	private Proyect proyect;

	
	public ParseObject getDonationObject() {
		final ParseObject donation = new ParseObject("Donation");
		donation.put("name", name);
		donation.put("description", description);
		donation.put("amount", amount);
		donation.put("proyect", proyect);
		return donation;
	}
	

	public Donation(final ParseObject parseDonation) {
		setId(parseDonation.getString("objectId"));
		setName(parseDonation.getString("name"));
		setDescription(parseDonation.getString("description"));
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public Donation(final String name, final String description,
			final String proyectId) {
		this.name = name;
		this.description = description;
		this.proyectId = proyectId;
	}

	public Donation(final ParseObject object, final List<Proyect> proyects) {
		name = object.getString("name");
		description = object.getString("description");
		amount = object.getDouble("amount");
		proyectId = object.getString("proyectId");
		for (final Proyect supposedProyect : proyects) {
			if (supposedProyect.getId().equals(proyectId)) {
				proyect = supposedProyect;
			}
		}
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getProyectId() {
		return proyectId;
	}

	public void setProyectId(final String proyectId) {
		this.proyectId = proyectId;
	}

	public Proyect getProyect() {
		return proyect;
	}

	public void setProyect(final Proyect proyect) {
		this.proyect = proyect;
	}
}
