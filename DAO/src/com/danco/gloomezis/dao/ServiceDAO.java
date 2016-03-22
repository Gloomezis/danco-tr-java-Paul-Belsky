package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.danco.gloomezis.dataSet.IBaseModel;
import com.danco.gloomezis.dataSet.Service;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;

public class ServiceDAO implements IDAO<Service>{

	private Connection con;
	

	public ServiceDAO(Connection con) {
		this.con = con;
	}

	
    //+
	@Override
	public int create(IBaseModel baseModel) throws SQLException {
		TExecutor exec = new TExecutor();
		int  oId = ((Service) baseModel ).getOrderId();
		String name=((Service) baseModel ).getNameOfService();
		int price=((Service) baseModel ).getPrice();
		return exec.execUpdate(con, 
				"INSERT INTO service (order_id,name,price,)"
				+ "values ("+oId+",'"+name+"',"+price+";)");	
		
	}

	
	//+
	@Override
	public Service read(int id) throws SQLException {
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
	@Override
	public Service readByName(String name) throws SQLException {
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
	@Override
	public int update(int id,IBaseModel baseModel) throws SQLException {
		
		TExecutor exec = new TExecutor();
		int sPrice = ((Service) baseModel).getPrice();
		return exec.execUpdate(con, "UPDATE  service SET price="+sPrice+"where id="+id+";");	

	}
	
	
	//+
	@Override
	public int delete(int id) throws SQLException {

		TExecutor exec = new TExecutor();
		String sql="DELETE  FROM service WHERE id =";
		return exec.execUpdate(con, sql + id+";");	
		
	}

	
	//+
	@Override
	public List<Service> getAll() throws SQLException {
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
	public int updatePaid(int id) throws SQLException {
		TExecutor exec = new TExecutor();
		return exec.execUpdate(con, "UPDATE  service SET paid = true where order_id="+id+";");	

	}
	
	 //+ get price all service order by price
		public String getPriceService(int id) throws SQLException {
			TExecutor exec = new TExecutor();
			return exec.execQuery(con, "Select number ,room_price from hotel_room ORDER BY room_price ",new TResultHandler<String>(){

				@Override
				public String handle(ResultSet result) throws SQLException {
					StringBuilder sb = new StringBuilder();
					while (result.next()) {
						sb.append(result.getString("number")+"-"+result.getInt("room_price")+";");	
					}
					return sb.toString();
				}
				
			});	

		}
	
	
	
	
}
