package fr.formation.Gardens.dtos;

import java.util.Set;

import fr.formation.Gardens.entities.Role;

public interface CustomUserAuthDto {
	Long getId();

    String getUsername();

    String getPassword();

    Set<Role> getRoles();

    boolean isEnabled();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

}
