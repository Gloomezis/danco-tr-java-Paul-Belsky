package com.danco.dao;

import org.springframework.stereotype.Repository;

import com.danco.api.dao.IUserDetailsDAO;
import com.danco.model.UserDetails;

@Repository 
public class UserDetailsDAO extends BaseDAO<UserDetails> implements IUserDetailsDAO {

	
	
		
	   
		
	    public UserDetailsDAO() {
			 super(UserDetails.class);
			System.out.println("UserDetail dao created");
		}

		
	  

		
		
}
