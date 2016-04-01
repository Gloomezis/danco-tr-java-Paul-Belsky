package com.danco.dao.api;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.danco.model.IBaseModel;
import com.danco.model.Orders;

public interface IOrdersDAO {

	// Settle
	public int create(Connection con, IBaseModel baseModel) throws SQLException;

	// +
	public Orders read(Connection con, int id) throws SQLException;

	// +
	public Orders readByName(Connection con, String name) throws SQLException;

	// +
	public int update(Connection con, int id, IBaseModel baseModel)
			throws SQLException;

	// +
	public int delete(Connection con, int id) throws SQLException;

	// +
	public List<Orders> getAll(Connection con) throws SQLException;

	// + update only paid for departure
	public int updatePaid(Connection con, String id) throws SQLException;

	public int getSummToDeparture(Connection con, String name) throws SQLException;

}