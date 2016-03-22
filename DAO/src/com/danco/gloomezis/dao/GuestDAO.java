package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.danco.gloomezis.dataSet.Guest;
import com.danco.gloomezis.dataSet.IBaseModel;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;

public class GuestDAO implements IDAO<Guest> {

	private Connection con;

	public GuestDAO(Connection con) {
		this.con = con;
	}

	// +
	@Override
	public int create(IBaseModel baseModel) throws SQLException {

		TExecutor exec = new TExecutor();
		String name = ((Guest) baseModel).getName();
		// String sql = "INSERT INTO guest (name) values ("+name+");"; need
		// prepared statement
		return exec.execUpdate(con, "INSERT INTO guest (name) values (" + name
				+ ");");

	}

	// +
	@Override
	public Guest read(int id) throws SQLException {

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
	@Override
	public Guest readByName(String name) throws SQLException {

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
	@Override
	public int update(int id, IBaseModel baseModel) throws SQLException {

		TExecutor exec = new TExecutor();
		String name = ((Guest) baseModel).getName();
		return exec.execUpdate(con, "UPDATE  guest SET name=" + name
				+ "where id=" + id + ";");
	}

	// +
	@Override
	public int delete(int id) throws SQLException {

		TExecutor exec = new TExecutor();
		String sql = "DELETE  FROM guest WHERE id =";
		return exec.execUpdate(con, sql + id + ";"); // need prepared statement
	}

	// +
	@Override
	public List<Guest> getAll() {

		String sql = "SELECT * FROM guest;";
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
	public int getAllGuestNumber() throws SQLException {
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

	public List<String> getNameGuestsAndTheyHotelRoom(String sortCondition) {
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
	
	
	
	
	public List<String> getGuestServiceAndTheyPrice(int id ) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT service.name,service.price FROM orders ");
		sql.append("INNER JOIN service ON ");
		sql.append("orders.id=service.orders_id ");
		sql.append("WHERE orders.guest_id "+id);
		sql.append("ORDER BY service.price ; ");
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(),
				new TResultHandler<List<String>>() {

					@Override
					public List<String> handle(ResultSet result)
							throws SQLException {
						List<String> list = new ArrayList<String>();

						while (result.next()) {
							String res = result.getString("name")+"-"+ result.getString("price");
							list.add(res);
						}
						return list;
					}
				});

	}

}
