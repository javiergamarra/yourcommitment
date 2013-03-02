package es.cylicon.yourcommitment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String address;
	private List<Proyect> proyects = new ArrayList<Proyect>();

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public List<Proyect> getProyects() {
		return proyects;
	}

	public void setProyects(final List<Proyect> proyects) {
		this.proyects = proyects;
	}

}
