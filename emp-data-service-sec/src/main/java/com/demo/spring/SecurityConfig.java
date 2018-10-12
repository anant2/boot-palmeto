package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource ds;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/info").permitAll()
		.antMatchers("/emp/**").hasAnyRole("ADMIN","USER").and().httpBasic().and().csrf().disable();
		
	}
	
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		String en = encoder().encode("ant1");
		System.out.println("asdasdasdasd"+en);
		auth.inMemoryAuthentication().withUser("ant").password(en).roles("USER");
		auth.inMemoryAuthentication().withUser("pavan").password(en).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("arun").password(en).roles("CLIENT");
	}*/
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds).
		usersByUsernameQuery("select username,password,enabled from users where username=?").
		authoritiesByUsernameQuery("select username,authority from authorities where username=?");
		
	}
	
	@Bean 
	public BCryptPasswordEncoder  encoder() {
		return new BCryptPasswordEncoder();
	}

}
