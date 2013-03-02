package es.cylicon.yourcommitment.model;

import java.io.Serializable;

public class Update implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String image;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(final String image) {
		this.image = image;
	}

}
