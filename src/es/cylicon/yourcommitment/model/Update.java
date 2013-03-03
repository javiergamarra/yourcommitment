package es.cylicon.yourcommitment.model;

import java.io.Serializable;

import com.parse.ParseObject;

public class Update implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String description;
	private String imagen;
	private String proyectId;

	public Update(final ParseObject parseProyect) {
		id = parseProyect.getObjectId();
		setDescription(parseProyect.getString("description"));
		setImagen(parseProyect.getString("imagen"));
		setProyectId(parseProyect.getString("proyectId"));
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(final String imagen) {
		this.imagen = imagen;
	}

}
