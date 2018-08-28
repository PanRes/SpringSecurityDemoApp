package gr.pr.udemy.spring.security.dao;

import gr.pr.udemy.spring.security.enitity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.util.List;

public interface UserDAO {
	
	User getUserByUserName(String userName);
	List<User> getAllUsers();
}
