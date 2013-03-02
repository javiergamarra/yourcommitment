package es.cylicon.yourcommitment.model;

import java.io.Serializable;
import java.util.List;

import com.parse.ParseObject;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String email;
	private Double amount;
	private List<Donation> donations;
	private List<Organization> ongs;

	public User(final String username) {
		this.username = username;
	}

	public User(final ParseObject parseObject) {
		username = parseObject.getString("username");
		email = parseObject.getString("email");
		amount = parseObject.getDouble("amount");
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	public List<Organization> getOngs() {
		return ongs;
	}

	public void setOngs(final List<Organization> ongs) {
		this.ongs = ongs;
	}

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(final List<Donation> donations) {
		this.donations = donations;
	}

	public Double getAmountLeft() {
		Double amountLeft = amount;
		for (final Donation donation : donations) {
			amountLeft -= donation.getAmount();
		}
		return amountLeft;
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
		user.put("username", username);
		user.put("amount", 0.0D);
		return user;
	}

}
