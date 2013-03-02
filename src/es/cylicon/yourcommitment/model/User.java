package es.cylicon.yourcommitment.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private List<Item> items;
	private List<Organization> ongs;
	private Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(final List<Item> items) {
		this.items = items;
	}

	public List<Organization> getOngs() {
		return ongs;
	}

	public void setOngs(final List<Organization> ongs) {
		this.ongs = ongs;
	}

}
