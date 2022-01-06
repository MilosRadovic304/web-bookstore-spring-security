package spring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import spring.service.CustomerService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomerService customerService;


    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider()); //here we are telling spring to authenticate users from the DB 
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()	//restrict access based on the HttpServletRequest
		.antMatchers("/").hasRole("EMPLOYEE")	//restrict access to specific pages based on given user roles 
		.antMatchers("/managers/**").hasRole("MANAGER") //   ** - all sub-directories
		.antMatchers("/admins/**").hasRole("ADMIN")
		.and()
		.formLogin()
			.loginPage("/showMyLoginPage")	//show custom login form at the request mapping
			.loginProcessingUrl("/authenticateTheUser")	//login form should POST data to this URL for processing (check username and password) - this is done in the background by Spring 
			.successHandler(customAuthenticationSuccessHandler)
			.permitAll() //allow everyone to see the login page 
		.and()
		.logout().permitAll() //allow everyone to logout 
		.and()
		.exceptionHandling().accessDeniedPage("/accessDenied"); //if user doesn't have authority to enter 
		//a certain part of the application this will redirect user to accessDenied.jsp
		
	}
	
	
	//beans
	//bcrypt bean definition
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	//authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(customerService); //set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
		return auth;
	}
	
}
