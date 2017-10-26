package com.packt.webstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManager) throws Exception {
		authenticationManager.inMemoryAuthentication().withUser("trann").password("trann").roles("USER");
		authenticationManager.inMemoryAuthentication().withUser("admin").password("admin").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.formLogin().loginPage("/login").usernameParameter("userName").passwordParameter("password");
		httpSecurity.formLogin().defaultSuccessUrl("/market/products/add").failureUrl("/login?error");
		httpSecurity.logout().logoutSuccessUrl("/login?logout");
		httpSecurity.exceptionHandling().accessDeniedPage("/login?accessDenied");
		httpSecurity.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/**/add").access("hasRole('ADMIN')")
			.antMatchers("/**/market/**").access("hasRole('USER')");
		httpSecurity.csrf().disable();
		
	}

}
