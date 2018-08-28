package gr.pr.udemy.spring.security.service;

import gr.pr.udemy.spring.security.dao.UserDAO;
import gr.pr.udemy.spring.security.enitity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserAuthenticationService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDAO.getUserByUserName(userName);
		
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		
		return null;
	}
}
