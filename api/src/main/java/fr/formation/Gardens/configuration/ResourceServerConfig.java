package fr.formation.Gardens.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	/**
	 * Configures the HTTP security for this application.
	 * <p>
	 * Defines this application as stateless (no HTTP session), and disables HTTP
	 * basic auth, CSRF and Spring default login form.
	 *
	 * @param the HttpSecurity to configure
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.httpBasic().disable().csrf().disable().cors().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests().antMatchers("/admin")
				.hasRole("ADMIN_ROLE").antMatchers("/user").hasRole("USER_ROLE").antMatchers("api/public/**")
				.permitAll().antMatchers("api/secure/**", "api/profils/**", "api/gardens/**", "api/gardenings/**",
						"api/addresses/**")
				.authenticated();

	}

}
