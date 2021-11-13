package fr.formation.Gardens.dtos.responses;

public class UserAuthViewDto {
	 private Long id;

	    private String username;

	    private String password;

	    private boolean enabled;

	    private boolean accountNonExpired;

	    private boolean accountNonLocked;

	    private boolean credentialsNonExpired;

	    public UserAuthViewDto() { }

	    public Long getId(){ return id; }

	    public String getUsername() { return username; }

	    public String getPassword() { return password; }

	    public boolean isEnabled() { return enabled; }

	    public boolean isAccountNonExpired() { return accountNonExpired; }

	    public boolean isAccountNonLocked() { return accountNonLocked; }

	    public boolean isCredentialsNonExpired() { return credentialsNonExpired; }

		public void setId(Long id) {
			this.id = id;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public void setAccountNonExpired(boolean accountNonExpired) {
			this.accountNonExpired = accountNonExpired;
		}

		public void setAccountNonLocked(boolean accountNonLocked) {
			this.accountNonLocked = accountNonLocked;
		}

		public void setCredentialsNonExpired(boolean credentialsNonExpired) {
			this.credentialsNonExpired = credentialsNonExpired;
		}
	    
	    

}
