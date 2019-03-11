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
	private String accessDeniedUrl 			= "/accessDenied";
	private String inicio	 				= "/";
	private String panel   					= "/panel";
	private String roleAdmin 				= "hasRole('ROLE_ADMIN')";
	//private String roleUser               = "hasRole('ROLE_USER')";
	private String roleAdminUser 			= "hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')";
	private String confUsuario 				= "/panelUsuario";
	
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
		
		http.exceptionHandling()
		.accessDeniedPage(accessDeniedUrl);
		
		http.authorizeRequests()
			.antMatchers(inicio).permitAll()
			.antMatchers(panel).access(roleAdminUser)
			.antMatchers(confUsuario).access(roleAdmin);
		
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
