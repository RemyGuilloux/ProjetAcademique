package fr.formation.Gardens.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserAuthLoginDto {
	/**
     * <p>
     * The username of the given entity.
     */
    @NotBlank
    @Size(min = 3, max = 60)
    private String username;

    /**
     * <p>
     * The password of the given entity.
     */
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    /**
     * <p>
     * Default empty no-arg constructor
     */
    protected UserAuthLoginDto() {
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
