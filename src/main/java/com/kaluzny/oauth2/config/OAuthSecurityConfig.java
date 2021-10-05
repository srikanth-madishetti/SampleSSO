package com.kaluzny.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Modifying or overriding the default spring boot security.
 */
@Configuration
@EnableWebSecurity
public class OAuthSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * super.configure(web); web.ignoring().antMatchers("/**"); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and()
		.oauth2Login().defaultSuccessUrl("/hello");

	}

}
