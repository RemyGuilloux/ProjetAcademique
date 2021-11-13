package fr.formation.Gardens.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProfilCreateDto {

	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String localisation;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	private String lastname;
	@NotEmpty(message = "{E_NOT_EMPTY}")
	@Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
	@Email
	private String mail;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
