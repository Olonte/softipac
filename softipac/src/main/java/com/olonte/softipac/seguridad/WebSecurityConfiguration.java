package com.olonte.softipac.seguridad;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private String loginPage				="/login";
	private String usernameParameter 		= "username";
	private String passwordParameter 		= "password";
	private String defaultSuccessUrl 		= "/panel";
	private String authenticationFailureUrl = "/login?error";
	private String method	 = "/";
	private String _method   = "/panel";
	private String attribute = "hasRole('ROLE_ADMIN')";
	//private String _attribute = "hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')";
	
	private UserDetailsService userDetailsService;
	
	@Autowired
	public WebSecurityConfiguration(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(loginPage)
			.usernameParameter(usernameParameter)
			.passwordParameter(passwordParameter);
		
		http.formLogin()
				.defaultSuccessUrl(defaultSuccessUrl)
				.failureUrl(authenticationFailureUrl);
		
		http.authorizeRequests()
			.antMatchers(method).permitAll()
			.antMatchers(_method).access(attribute);
		
		http.csrf().disable();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configuredGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	

}
