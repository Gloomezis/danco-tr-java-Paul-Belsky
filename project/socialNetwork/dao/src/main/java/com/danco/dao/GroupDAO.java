package com.danco.dao;

import org.springframework.stereotype.Repository;

import com.danco.api.dao.IGroupDAO;
import com.danco.model.Group;


/**
 * The Class GroupDAO.
 */
@Repository
public class GroupDAO extends BaseDAO<Group> implements IGroupDAO {

	/** The Constant GROUP_DAO_CREATED. */
	private static final String GROUP_DAO_CREATED = "Group dao created";

	/**
	 * Instantiates a new group DAO.
	 */
	public GroupDAO() {
		super(Group.class);
		System.out.println(GROUP_DAO_CREATED);
	}

}
