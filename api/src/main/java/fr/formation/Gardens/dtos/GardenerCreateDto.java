package fr.formation.Gardens.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class GardenerCreateDto {
	private long id;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String name;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 500, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String type;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String localisation;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String lastname;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 10, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String phone;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String mail;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String gender;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
