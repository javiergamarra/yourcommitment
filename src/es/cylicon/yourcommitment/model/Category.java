package es.cylicon.yourcommitment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.parse.ParseObject;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String description;
	private String image;

	public Category(final ParseObject object) {
		name = object.getString("name");
		description = object.getString("description");
		image = object.getString("image");
		id = object.getObjectId();
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(final String image) {
		this.image = image;
	}

	public static List<Category> create(final List<ParseObject> objects) {
		final List<Category> categories = new ArrayList<Category>();
		for (final ParseObject object : objects) {
			categories.add(new Category(object));
		}
		return categories;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

}
