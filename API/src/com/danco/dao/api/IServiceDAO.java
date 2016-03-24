package com.danco.dao.api;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.danco.model.IBaseModel;
import com.danco.model.Service;

public interface IServiceDAO {

	//+
	public int create(Connection con, IBaseModel baseModel) throws SQLException;

	//+
	public Service read(Connection con, int id) throws SQLException;

	//+
	public Service readByName(Connection con, String name) throws SQLException;

	//+
	//update only price
	public int update(Connection con, int id, IBaseModel baseModel)
			throws SQLException;

	//+
	public int delete(Connection con, int id) throws SQLException;

	//+
	public List<Service> getAll(Connection con) throws SQLException;

	//+ update only paid for method departure
	public int updatePaid(Connection con, String id) throws SQLException;

	//+ get price all service order by price
	public List<String> getPriceService(Connection con) throws SQLException;

	int updatePrice(Connection con, int id, int price) throws SQLException;

}