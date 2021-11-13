package fr.formation.Gardens.dtos.requests;

import java.util.Set;

import javax.persistence.Convert;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fr.formation.Gardens.entities.BooleanConverter;
import fr.formation.Gardens.entities.Role;

public class UserInfoCreateDto {

	@NotBlank
	@Size(min = 3, max = 50)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "User name must be alphanumeric with no spaces")
	private String username;

	@Size(max = 60)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 40)
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$", message = "Password must contains at least one number")
	private String password;

	private Set<Role> roles;

	@Convert(converter = BooleanConverter.class)
	private boolean enabled = true;

	@Convert(converter = BooleanConverter.class)
	private boolean accountNonExpired = true;

	@Convert(converter = BooleanConverter.class)
	private boolean accountNonLocked = true;

	@Convert(converter = BooleanConverter.class)
	private boolean credentialsNonExpired = true;

	protected UserInfoCreateDto() {
	}

	/**
	 * <p>
	 * returns User username
	 * </p>
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * <p>
	 * returns User email
	 * </p>
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * <p>
	 * returns User roles
	 * </p>
	 */
	public Set<Role> getRoles() {
		return this.roles;
	}

	/**
	 * <p>
	 * Returns User password (internal purpose only)
	 * </p>
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <p>
	 * Set User password (internal purpose only)
	 * </p>
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
