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
	private Double amount;
	private Double totalAmount;
	private String address;
	private Category category;
	private List<Update> updates;
	private String channelName;
	private String categoryId;

	public Proyect(final String name) {
		this.name = name;
	}

	public Proyect(final ParseObject parseProyect) {
		setId(parseProyect.getObjectId());
		setName(parseProyect.getString("name"));
		setDescription(parseProyect.getString("description"));
		setAmount(parseProyect.getDouble("amount"));
		setTotalAmount(parseProyect.getDouble("totalAmount"));
		setAddress(parseProyect.getString("address"));
		categoryId = parseProyect.getString("categoryId");
		channelName = parseProyect.getString("channelName");
	}

	public Proyect() {
		// TODO Auto-generated constructor stub
	}

	public Proyect(final ParseObject parseProyect,
			final List<Category> categories) {
		this(parseProyect);
		for (final Category category : categories) {
			if (categoryId != null && categoryId.equals(category.getId())) {
				this.category = category;
			}
		}
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	public String getPercentage() {
		return getDoublePercentage().toString();
	}

	public Double getDoublePercentage() {
		if (amount == null || totalAmount == null) {
			return 0D;
		}
		final double percentage = amount / totalAmount * 100;
		return percentage > 100 ? 100D : formatted(percentage);
	}

	private double formatted(final Double percentage) {
		return new Double(new Double(percentage * 100).intValue() / 100.0D);
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(final String categoryId) {
		this.categoryId = categoryId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(final String channelName) {
		this.channelName = channelName;
	}
}
