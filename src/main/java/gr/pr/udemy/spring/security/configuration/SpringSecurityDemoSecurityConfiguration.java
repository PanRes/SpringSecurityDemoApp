package gr.pr.udemy.spring.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SpringSecurityDemoSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
				.withUser(users.username("PR").password("test123").roles("OVERLORD"))
				.withUser(users.username("McCoy").password("test123").roles("PLEB"))
				.withUser(users.username("Angel").password("test123").roles("CRUSADER"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				.and()
				.logout().permitAll();
	}
}
