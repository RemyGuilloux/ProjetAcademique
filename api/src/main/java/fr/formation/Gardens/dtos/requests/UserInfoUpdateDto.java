package fr.formation.Gardens.dtos.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoUpdateDto {
	@NotBlank
	@Size(min = 3, max = 50)
	String username;

	@Size(max = 60)
	@Email
	String email;

	protected UserInfoUpdateDto() {
		//
	}

	/**
	 * <p>
	 * Return User username
	 * </p>
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <p>
	 * Return User email
	 * </p>
	 */
	public String getEmail() {
		return email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
