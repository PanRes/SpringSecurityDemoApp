package gr.pr.udemy.spring.security.service;

import gr.pr.udemy.spring.security.dao.UserDetailsDAO;
import gr.pr.udemy.spring.security.enitity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserAuthenticationService implements UserDetailsService {
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity user = userDetailsDAO.getUserByUserName(userName);
		
		UserBuilder userBuilder = null;
		
		if (user != null) {
			userBuilder = User.withUsername(userName);
			userBuilder.disabled(!user.isEnabled());
			userBuilder.password(user.getPassword());
			String[] authorities = user.getRoles().stream()
					.map(roles -> roles.getRoleName())
					.toArray(String[]::new);
			
			
			userBuilder.authorities(authorities);
		}
		else {
			throw new UsernameNotFoundException(userName);
		}
		
		return userBuilder.build();
	}
}
