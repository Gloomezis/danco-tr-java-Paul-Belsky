/*
 * 
 */
package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.danco.dao.api.IGuestDAO;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;
import com.danco.model.Guest;
import com.danco.model.IBaseModel;
import com.danco.model.Service;

public class GuestDAO implements IDAO<Guest>, IGuestDAO {

	public GuestDAO() {

	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#create(java.sql.Connection, com.danco.gloomezis.dataSet.IBaseModel)
	 */
	
	@Override
	public int create(Connection con, IBaseModel baseModel) throws SQLException {

		TExecutor exec = new TExecutor();
		String name = ((Guest) baseModel).getName();
		// String sql = "INSERT INTO guest (name) values ("+name+");"; need
		// prepared statement
		return exec.execUpdate(con, "INSERT INTO guest (name) values (" + name
				+ ");");

	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#read(java.sql.Connection, int)
	 */
	
	@Override
	public Guest read(Connection con, int id) throws SQLException {

		TExecutor exec = new TExecutor();
		String sql = "SELECT * FROM guest WHERE id =";
		return exec.execQuery(con, sql + id + ";", new TResultHandler<Guest>() {

			@Override
			public Guest handle(ResultSet result) throws SQLException {
				result.next();
				Guest dataSet = new Guest(result.getInt(1), result.getString(2));
				return dataSet;
			}
		});
	}

	// +
	// TODO may be multiple name
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#readByName(java.sql.Connection, java.lang.String)
	 */
	
	@Override
	public Guest readByName(Connection con, String name) throws SQLException {

		TExecutor exec = new TExecutor();
		String sql = "SELECT * FROM guest WHERE name =";
		return exec.execQuery(con, sql + name + ";", // need prepared statement
				new TResultHandler<Guest>() {

					@Override
					public Guest handle(ResultSet result) throws SQLException {
						result.next();
						Guest dataSet = new Guest(result.getInt(1), result
								.getString(2));
						return dataSet;
					}
				});
	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#update(java.sql.Connection, int, com.danco.gloomezis.dataSet.IBaseModel)
	 */
	
	@Override
	public int update(Connection con, int id, IBaseModel baseModel)
			throws SQLException {

		TExecutor exec = new TExecutor();
		String name = ((Guest) baseModel).getName();
		return exec.execUpdate(con, "UPDATE  guest SET name=" + name
				+ "where id=" + id + ";");
	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#delete(java.sql.Connection, int)
	 */
	
	@Override
	public int delete(Connection con, int id) throws SQLException {

		TExecutor exec = new TExecutor();
		String sql = "DELETE  FROM guest WHERE id =";
		return exec.execUpdate(con, sql + id + ";"); // need prepared statement
	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#getAll(java.sql.Connection)
	 */
	
	@Override
	public List<Guest> getAllSorted(Connection con, String sortCondition) {

		String sql = "SELECT * FROM guest order by "+sortCondition+";";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql, new TResultHandler<List<Guest>>() {

			@Override
			public List<Guest> handle(ResultSet result) throws SQLException {
				List<Guest> list = new ArrayList<Guest>();
				while (result.next()) {
					Guest g = new Guest(result.getInt("id"), result
							.getString("name"));
					list.add(g);
				}
				return list;
			}
		});

	}
	
	@Override
	public List<Guest> getAll(Connection con) {

		String sql = "SELECT * FROM guest ;";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql, new TResultHandler<List<Guest>>() {

			@Override
			public List<Guest> handle(ResultSet result) throws SQLException {
				List<Guest> list = new ArrayList<Guest>();
				while (result.next()) {
					Guest g = new Guest(result.getInt("id"), result
							.getString("name"));
					list.add(g);
				}
				return list;
			}
		});

	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#getAllGuestNumber(java.sql.Connection)
	 */
	@Override
	public int getAllGuestNumber(Connection con) throws SQLException {
		String sql = "SELECT COUNT('id') FROM guest";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql, new TResultHandler<Integer>() {

			@Override
			public Integer handle(ResultSet result) throws SQLException {
				result.next();
				return result.getInt(1);
			}
		});
	}

	// + sort by data/price

	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#getNameGuestsAndTheyHotelRoom(java.sql.Connection, java.lang.String)
	 */
	@Override
	public List<String> getNameGuestsAndTheyHotelRoom(Connection con,
			String sortCondition) {
		StringBuilder sql = new StringBuilder();
		sql.append(" Select guest.name, hotel_room.number, orders.date_arrive,orders.date_departure from orders ");
		sql.append("INNER JOIN guest ON guest.id=orders.guest_id ");
		sql.append("INNER JOIN hotel_room ON hotel_room.id=orders.hotel_room_id ");
		sql.append("WHERE orders.paid=false");
		sql.append("order by orders.");
		sql.append(sortCondition + ";");

		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(),
				new TResultHandler<List<String>>() {

					@Override
					public List<String> handle(ResultSet result)
							throws SQLException {
						List<String> list = new ArrayList<String>();

						while (result.next()) {
							String res = result.getString("name")
									+ result.getString("number")
									+ result.getString("date_arrive")
									+ result.getString("date_departure");
							list.add(res);
						}
						return list;
					}
				});

	}

	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IGuestDAO#getGuestServiceAndTheyPrice(java.sql.Connection, int)
	 */
	@Override
	public List<Service> getGuestService(Connection con, String name) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT service.* FROM orders ");
		sql.append("INNER JOIN service ON ");
		sql.append("orders.id=service.orders_id ");
		sql.append("INNER JOIN guest ON ");
		sql.append("orders.guest_id=guest.id ");
		sql.append("WHERE guest.name = '" + name+"'");
		sql.append("ORDER BY service.price ; ");
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(),
				new TResultHandler<List<Service>>() {

					@Override
					public List<Service> handle(ResultSet result)
							throws SQLException {
						List<Service> list = new ArrayList<Service>();

						while (result.next()) {
							
							Service serv = new Service(result.getInt("id"), result.getInt("order_id"),result.getString("name"), result.getInt("price"), result.getBoolean("paid")) ;
									
							list.add(serv);
						}
						return list;
					}
				});

	}

}
