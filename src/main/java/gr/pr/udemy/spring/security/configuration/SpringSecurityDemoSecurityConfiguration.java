package gr.pr.udemy.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityDemoSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
/*
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
				.withUser(users.username("PR").password("test123").Role("USER","OVERLORD","Awesome"))
				.withUser(users.username("McCoy").password("test123").Role("USER","PLEB"))
				.withUser(users.username("Angel").password("test123").Role("USER","CRUSADER","Awesome"));
*/
		auth.jdbcAuthentication().dataSource(securityDataSource)
				.usersByUsernameQuery("select username,password, enabled from users_normalized where username=?");
	}
	
	// TODO : fix redirect when not logged in
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/overLords/**").hasRole("OVERLORD")
				.antMatchers("/plebs/**").hasRole("PLEB")
				.antMatchers("/castle/**").hasRole("Awesome")
				.and()
				.formLogin()
					.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/accessDenied");
	}
}
