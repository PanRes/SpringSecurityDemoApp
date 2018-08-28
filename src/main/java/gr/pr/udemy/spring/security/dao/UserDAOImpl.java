package gr.pr.udemy.spring.security.dao;

import gr.pr.udemy.spring.security.enitity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private static SessionFactory sessionFactory;
	
	public List<User> getAllUsers() {
		Session session = UserDAOImpl.sessionFactory.getCurrentSession();
		
		TypedQuery<User> query = session.createNamedQuery("User.findAll",User.class);
		
		List<User> users = query.getResultList();
		
		return users;
		
	}

	public User getUserByUserName(String userName) {
		Session session = UserDAOImpl.sessionFactory.getCurrentSession();
		
		TypedQuery<User> query = session.createNamedQuery("User.findUserByUserName",User.class).setParameter("userName", userName);

		return query.getResultList().get(0);
	}
	
	
}
