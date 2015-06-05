package com.cms;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	Logger logger = Logger.getLogger(WebSecurityConfig.class);
	
	@Autowired
	//private LoginService loginService;
    private UserDetailsService userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("inside configure method  " );
        
        http.authorizeRequests()
        .antMatchers(HttpMethod.GET,"/CMS", "/CMS/login","/js/**","/css/**", "/lib/**","/signup").permitAll()
        .antMatchers(HttpMethod.POST,"/CMS", "/CMS/login","/js/**","/css/**", "/lib/**","/CMS/rest/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .failureUrl("/login?error").defaultSuccessUrl("/")
        .usernameParameter("email")
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login")
        .permitAll()
        .and()
        .rememberMe().and().csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("inside configure auth method rajesh here "+userDetailsService.toString());
	    auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

	}
	
}