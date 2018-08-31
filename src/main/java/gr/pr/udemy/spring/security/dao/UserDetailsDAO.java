package gr.pr.udemy.spring.security.dao;

import gr.pr.udemy.spring.security.enitity.UserEntity;

import java.util.List;


public interface UserDetailsDAO {
	
	UserEntity getUserByUserName(String userName);
	List<UserEntity> getAllUsers();
}
