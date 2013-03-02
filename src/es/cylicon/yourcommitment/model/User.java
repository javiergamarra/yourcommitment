package es.cylicon.yourcommitment.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private List<Proyect> proyects;
	private List<Organization> ongs;

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public List<Proyect> getProyects() {
		return proyects;
	}

	public void setProyects(final List<Proyect> proyects) {
		this.proyects = proyects;
	}

	public List<Organization> getOngs() {
		return ongs;
	}

	public void setOngs(final List<Organization> ongs) {
		this.ongs = ongs;
	}

}
