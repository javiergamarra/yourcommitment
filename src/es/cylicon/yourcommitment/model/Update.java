package es.cylicon.yourcommitment.model;

import java.io.Serializable;

import com.parse.ParseObject;

public class Update implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
	private String image;

	
	public Update(final ParseObject parseProyect) {
		setDescription(parseProyect.getString("description"));
		setImage(parseProyect.getString("image"));
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

}
