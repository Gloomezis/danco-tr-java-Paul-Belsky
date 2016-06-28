package com.danco.dao;

import org.springframework.stereotype.Repository;

import com.danco.api.dao.IUserRoleDAO;
import com.danco.model.UserRole;

@Repository
public class UserRoleDAO extends BaseDAO<UserRole> implements IUserRoleDAO {

	
	
		
	    
		
	    public UserRoleDAO() {
			 super(UserRole.class);
			System.out.println("UserRole dao created");
		}

		

}
