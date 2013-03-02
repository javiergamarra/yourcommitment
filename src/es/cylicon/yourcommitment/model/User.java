package es.cylicon.yourcommitment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.parse.ParseObject;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String username;
	private String email;
	private Double amount = 0.0D;
	private List<Donation> donations = new ArrayList<Donation>();
	private List<Proyect> proyects = new ArrayList<Proyect>();

	public User(final String username) {
		this.username = username;
	}

	public User(final ParseObject parseObject) {
		username = parseObject.getString("username");
		email = parseObject.getString("email");
		amount = parseObject.getDouble("amount");
		id = parseObject.getObjectId();
	}

	public User() {
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(final List<Donation> donations) {
		this.donations = donations;
	}

	public Integer getAmountLeft() {
		Double amountLeft = amount;
		if (!donations.isEmpty()) {
			for (final Donation donation : donations) {
				amountLeft -= donation.getAmount();
			}
		}
		return (int) Math.floor(amountLeft);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public ParseObject getUserObject() {
		final ParseObject user = new ParseObject("user");
		System.out.println("ID: " + id);
		System.out.println("username: " + username);
		System.out.println("amount: " + amount);
		user.put("objectId", id);
		user.put("username", username);
		user.put("amount", amount);
		return user;
	}

	public List<Proyect> getProyects() {
		return proyects;
	}

	public void setProyects(final List<Proyect> proyects) {
		this.proyects = proyects;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

}
