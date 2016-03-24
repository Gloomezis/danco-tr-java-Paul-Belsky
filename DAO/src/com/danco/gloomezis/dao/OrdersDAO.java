package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.danco.dao.api.IOrdersDAO;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;
import com.danco.model.IBaseModel;
import com.danco.model.Orders;

public class OrdersDAO implements IDAO<Orders>, IOrdersDAO {

	public OrdersDAO() {

	}

	// Settle
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#create(java.sql.Connection, com.danco.model.IBaseModel)
	 */

	@Override
	public int create(Connection con, IBaseModel baseModel) throws SQLException {

		TExecutor exec = new TExecutor();
		int gId = ((Orders) baseModel).getGuestId();
		int hrId = ((Orders) baseModel).getHotelRoomId();
		Date dArrive = ((Orders) baseModel).getDateOfArrival();
		Date dDeparture = ((Orders) baseModel).getDateOfDeparture();
		return exec.execUpdate(con,
				"INSERT INTO orders (guest_id,hotel_room_id,date_arrive,date_departure) "
						+ "values (" + gId + "," + hrId + ",'" + dArrive
						+ "','" + dDeparture + "';)");

	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#read(java.sql.Connection, int)
	 */
	
	@Override
	public Orders read(Connection con, int id) throws SQLException {
		TExecutor exec = new TExecutor();
		String sql = "SELECT * FROM orders WHERE id =";
		return exec.execQuery(con, sql + id + ";",
				new TResultHandler<Orders>() {

					@Override
					public Orders handle(ResultSet result) throws SQLException {
						result.next();
						Orders orders = new Orders(result.getInt("id"), result
								.getInt("guest_id"), result
								.getInt("hotel_room_id"), result
								.getDate("date_arrive"), result
								.getDate("date_departure"), result
								.getBoolean("paid"));
						return orders;
					}
				});
	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#readByName(java.sql.Connection, java.lang.String)
	 */
	
	@Override
	public Orders readByName(Connection con, String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#update(java.sql.Connection, int, com.danco.model.IBaseModel)
	 */
	
	@Override
	public int update(Connection con, int id, IBaseModel baseModel)
			throws SQLException {
		return id;
		// TODO Auto-generated method stub

	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#delete(java.sql.Connection, int)
	 */
	
	@Override
	public int delete(Connection con, int id) throws SQLException {

		TExecutor exec = new TExecutor();
		String sql = "DELETE  FROM orders WHERE id =";
		return exec.execUpdate(con, sql + id + ";");

	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#getAll(java.sql.Connection)
	 */
	
	@Override
	public List<Orders> getAll(Connection con) throws SQLException {
		String sql = "SELECT * FROM odrers;";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql, new TResultHandler<List<Orders>>() {

			@Override
			public List<Orders> handle(ResultSet result) throws SQLException {
				List<Orders> list = new ArrayList<Orders>();
				while (result.next()) {
					Orders orders = new Orders(result.getInt("id"), result
							.getInt("guest_id"),
							result.getInt("hotel_room_id"), result
									.getDate("date_arrive"), result
									.getDate("date_departure"), result
									.getBoolean("paid"));
					list.add(orders);
				}
				return list;
			}
		});
	}

	// + update only paid for departure
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#updatePaid(java.sql.Connection, int)
	 */
	@Override
	public int updatePaid(Connection con, String id) throws SQLException {
		TExecutor exec = new TExecutor();
		return exec.execUpdate(con, "UPDATE  orders SET paid = true where id="
				+ id + ";");

	}

	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#getSummToDeparture(java.sql.Connection, int)
	 */
	@Override
	public int getSummToDeparture(Connection con, String name) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT DISTINCT SUM(guest_summ_paid.price) AS  price FROM ( ");
		sql.append("SELECT SUM(hotel_room.room_price) AS price FROM orders ");
		sql.append("INNER JOIN guest ON ");
		sql.append("orders.guest_id=guest.id ");
		sql.append("INNER JOIN hotel_room ON ");
		sql.append("orders.hotel_room_id=hotel_room.id ");
		sql.append("WHERE guest.name = '" + name + "' and orders.paid=false");
		sql.append("UNION ");
		sql.append("SELECT SUM(service.price) AS price FROM orders ");
		sql.append("INNER JOIN guest ON ");
		sql.append("orders.guest_id=guest.id ");
		sql.append("INNER JOIN service ON ");
		sql.append("orders.id=service.orders_id ");
		sql.append("WHERE guest.name = '" + name
				+ "' and service.paid=false )AS guest_summ_paid; ");

		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(),
				new TResultHandler<Integer>() {

					@Override
					public Integer handle(ResultSet result) throws SQLException {
						result.next();
						return result.getInt(1);
					}
				});
	}

}
