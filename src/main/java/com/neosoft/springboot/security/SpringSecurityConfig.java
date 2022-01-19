package com.neosoft.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//create 2 users for demo (Authentication)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//{noop} to your password in order for the DelegatingPasswordEncoder
		
		auth.inMemoryAuthentication().withUser("admin@gmail.com").password("{noop}admin123").roles("ADMIN");
	}
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/admin/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/admin/**").hasAnyRole("ADMIN")
		.and().formLogin()
		.loginPage("/login")
        .loginProcessingUrl("/appLogin")
        .usernameParameter("app_username")
        .passwordParameter("app_password")
        .defaultSuccessUrl("/admin")	
        .and().logout()    //logout configuration
        .logoutUrl("/appLogout") 
        .logoutSuccessUrl("/login")
		//.antMatchers(HttpMethod.POST, "/**").hasAnyRole("ADMIN") //for all end points with post
		.and()
		.csrf().disable();
	}
}
