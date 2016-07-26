package com.dot.config;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.RegexRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("INNNNN" + dataSource.getConnection());
		
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("select username,password,true AS enabled from dot.users where USERNAME=?")
			.authoritiesByUsernameQuery("select username, role from dot.user_roles where USERNAME=?");
		
		System.out.println("out");
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http
	      .csrf().disable();*/
		   http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/welcome/**").access("hasRole('ROLE_ADMIN')")
			
			.and()
				.formLogin().loginPage("/login").failureUrl("/login?error").successHandler(successHandler())
					.usernameParameter("username").passwordParameter("password")
			.and()
				.logout().logoutSuccessUrl("/login?logout")
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			.and()
				.csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
			        private Pattern allowedMethods = Pattern.compile("^(POST|GET|HEAD|TRACE|OPTIONS)$");
			        private RegexRequestMatcher apiMatcher = new RegexRequestMatcher("/unprotected", null);

			        @Override
			        public boolean matches(HttpServletRequest request) {
			            // No CSRF due to allowedMethod
			        	System.out.println("Method"+request.getMethod());
			            if(allowedMethods.matcher(request.getMethod()).matches())
			                return false;

			            // No CSRF due to api call
			            if(apiMatcher.matches(request))
			                return false;

			            // CSRF for everything else that is not an API call or an allowedMethod
			            return true;
			        }

					
			    });
		
	}
	 @Bean
	 public SavedRequestAwareAuthenticationSuccessHandler successHandler() {
	     SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
	     //successHandler.setTargetUrlParameter("welcome");
	     successHandler.setDefaultTargetUrl("/welcome");
		return successHandler;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
		
}