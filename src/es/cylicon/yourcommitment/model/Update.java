package es.cylicon.yourcommitment.model;

import java.io.Serializable;

import com.parse.ParseObject;

public class Update implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String description;
	private String image;
	private String proyectId;

	public Update(final ParseObject parseProyect) {
		id = parseProyect.getObjectId();
		setDescription(parseProyect.getString("description"));
		setImage(parseProyect.getString("image"));
		setProyectId(parseProyect.getString("proyectId"));
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

	public String getProyectId() {
		return proyectId;
	}

	public void setProyectId(final String proyectId) {
		this.proyectId = proyectId;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

}
