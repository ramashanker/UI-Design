package com.rama.basic.security.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityBasicConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers("/swagger*").permitAll()
				.antMatchers(HttpMethod.GET, "/admin-name").hasAnyRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/user-name").hasAnyRole("USER", "ADMIN")
				.and()
				.authorizeRequests().antMatchers("/**")
				.hasAnyRole("USER")
				.and()
				.csrf()
				.disable()
				.headers()
				.frameOptions()
				.disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user123").password("{noop}password").roles("USER")
				.and()
				.withUser("admin123").password("{noop}password").roles("ADMIN");
	}
}
