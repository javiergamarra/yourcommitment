package es.cylicon.yourcommitment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.parse.ParseObject;

public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String country;
	private String image;
	private List<Proyect> proyects = new ArrayList<Proyect>();

	public Organization(final ParseObject parseProyect) {
		name = parseProyect.getString("GNO");
		country = parseProyect.getString("country");
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<Proyect> getProyects() {
		return proyects;
	}

	public void setProyects(final List<Proyect> proyects) {
		this.proyects = proyects;
	}

	public String getImage() {
		return image;
	}

	public void setImage(final String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return name + " at " + country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

}
