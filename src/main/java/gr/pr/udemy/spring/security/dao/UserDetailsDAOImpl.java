package gr.pr.udemy.spring.security.dao;

import gr.pr.udemy.spring.security.enitity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<UserEntity> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		
		TypedQuery<UserEntity> query = session.createNamedQuery("User.findAll", UserEntity.class);
		
		List<UserEntity> users = query.getResultList();
		
		return users;
		
	}

	public UserEntity getUserByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		
		TypedQuery<UserEntity> query = session.createNamedQuery("User.findUserByUserName", UserEntity.class).setParameter("userName", userName);

		return query.getResultList().get(0);
	}
	
	
}
