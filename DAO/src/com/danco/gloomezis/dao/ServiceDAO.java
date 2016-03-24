/*
 * 
 */
package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.danco.dao.api.IServiceDAO;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;
import com.danco.model.IBaseModel;
import com.danco.model.Service;

public class ServiceDAO implements IDAO<Service>, IServiceDAO{

	

	public ServiceDAO() {
		
	}

	
    //+
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IServiceDAO#create(java.sql.Connection, com.danco.model.IBaseModel)
	 */
	
	@Override
	public int create(Connection con,IBaseModel baseModel) throws SQLException {
		TExecutor exec = new TExecutor();
		int  oId = ((Service) baseModel ).getOrderId();
		String name=((Service) baseModel ).getName();
		int price=((Service) baseModel ).getPrice();
		return exec.execUpdate(con, 
				"INSERT INTO service (order_id,name,price,)"
				+ "values ("+oId+",'"+name+"',"+price+";)");	
		
	}

	
	//+
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IServiceDAO#read(java.sql.Connection, int)
	 */
	
	@Override
	public Service read(Connection con,int id) throws SQLException {
		TExecutor exec = new TExecutor();
		String sql = "SELECT * FROM service WHERE id ="; 
		return exec.execQuery(con, sql + id+ ";",   	
				new TResultHandler<Service>() {

					@Override
					public Service handle(ResultSet result)
							throws SQLException {
						result.next();
						Service service = new Service(result
								.getInt("id"), result.getInt("order_id"),result.getString("name"),result.getInt("price"),result.getBoolean("paid"));
						return service;
					}
				}
		);
	}

	
	//+
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IServiceDAO#readByName(java.sql.Connection, java.lang.String)
	 */
	
	@Override
	public Service readByName(Connection con,String name) throws SQLException {
		TExecutor exec = new TExecutor();
		String sql = "SELECT * FROM service WHERE name ="; 
		return exec.execQuery(con, sql + name + ";",   	
				new TResultHandler<Service>() {

					@Override
					public Service handle(ResultSet result)
							throws SQLException {
						result.next();
						Service service = new Service(result
								.getInt("id"), result.getInt("order_id"),result.getString("name"),result.getInt("price"),result.getBoolean("paid"));
						return service;
					}
				}
		);
	}
	
	//+
	//update only price
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IServiceDAO#update(java.sql.Connection, int, com.danco.model.IBaseModel)
	 */
	
	@Override
	public int update(Connection con,int id,IBaseModel baseModel) throws SQLException {
		
		TExecutor exec = new TExecutor();
		int sPrice = ((Service) baseModel).getPrice();
		return exec.execUpdate(con, "UPDATE  service SET price="+sPrice+"where id="+id+";");	

	}
	
	
	//+
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IServiceDAO#delete(java.sql.Connection, int)
	 */
	
	@Override
	public int delete(Connection con,int id) throws SQLException {

		TExecutor exec = new TExecutor();
		String sql="DELETE  FROM service WHERE id =";
		return exec.execUpdate(con, sql + id+";");	
		
	}

	
	//+
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IServiceDAO#getAll(java.sql.Connection)
	 */
	
	@Override
	public List<Service> getAll(Connection con) throws SQLException {
		String sql = "SELECT * FROM service;";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql,
				new TResultHandler<List<Service>>() {

					@Override
					public List<Service> handle(ResultSet result)
							throws SQLException {
						List<Service> list = new ArrayList<Service>();
						while (result.next()) {
							Service service = new Service(result
									.getInt("id"), result.getInt("order_id"),result.getString("name"),result.getInt("price"),result.getBoolean("paid"));
							list.add(service);
						}
						return list;
					}
				}
		);
	}


	 //+ update only paid for method departure
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IServiceDAO#updatePaid(java.sql.Connection, int)
	 */
	@Override
	public int updatePaid(Connection con,String id) throws SQLException {
		TExecutor exec = new TExecutor();
		return exec.execUpdate(con, "UPDATE  service SET paid = true where order_id="+id+";");	

	}
	
	
	//составное с ценой номеров - возможно можно заменить на обычный достать все сервисы 
	
	 //+ get price all service order by price
		/* (non-Javadoc)
		 * @see com.danco.gloomezis.dao.IServiceDAO#getPriceService(java.sql.Connection)
		 */
		@Override
		public List<String> getPriceService(Connection con) throws SQLException {
			TExecutor exec = new TExecutor();
			return exec.execQuery(con, "SELECT name ,price FROM service ORDER BY price ",new TResultHandler<List<String>>(){

				@Override
				public List<String> handle(ResultSet result) throws SQLException {
					List<String> list = new ArrayList<String>();
					while (result.next()) {
						String res =result.getString("name")+"-"+result.getInt("price")+";";	
						list.add(res);
					}
					return list;
				}
				
			});	

		}
	
		@Override
		public int updatePrice(Connection con,int id,int price) throws SQLException {
			TExecutor exec = new TExecutor();
			return exec.execUpdate(con, "UPDATE  service SET price = true where id="+id+";");	

		}
	
	
}
