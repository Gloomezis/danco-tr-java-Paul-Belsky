/*
 * 
 */
package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.danco.dao.api.IGuestDAO;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.IBaseModel;
import com.danco.model.Orders;
import com.danco.model.Service;

public class GuestDAO implements IDAO<Guest>, IGuestDAO {

	public GuestDAO() {

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IGuestDAO#create(java.sql.Connection,
	 * com.danco.gloomezis.dataSet.IBaseModel)
	 */

	@Override
	public int create(Connection con, IBaseModel baseModel) throws SQLException {

		TExecutor exec = new TExecutor();
		String name = ((Guest) baseModel).getName();

		return exec.execUpdate(con, "INSERT INTO guest (name) values ('" + name
				+ "');");

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IGuestDAO#read(java.sql.Connection, int)
	 */

	@Override
	public Guest read(Connection con, int id) throws SQLException {

		TExecutor exec = new TExecutor();
		// String sql = "SELECT * FROM guest WHERE id =";

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM guest ");
		sql.append("Inner join orders on ");
		sql.append("guest.idGuest=orders.guest_id ");
		sql.append("Inner join hotel_room on ");
		sql.append("orders.hotel_room_id=hotel_room.idHotelRoom ");
		sql.append("WHERE guest.idGuest = " + id + "; ");

		return exec.execQuery(con, sql.toString(), new TResultHandler<Guest>() {

			@Override
			public Guest handle(ResultSet result) throws SQLException {

				Guest dataSetGuest;
				Orders dataSetOrders;
				List<Guest> guestList = new ArrayList<Guest>();

				while (result.next()) {
					dataSetGuest = parseResultForGuest(result);
					dataSetOrders = parseResultForOrders(result);
					guestList = addGuestInList(guestList, dataSetGuest,
							dataSetOrders);
				}

				return guestList.get(0);
			}
		});
	}

	// +
	// TODO may be multiple name
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IGuestDAO#readByName(java.sql.Connection,
	 * java.lang.String)
	 */

	@Override
	public Guest readByName(Connection con, String name) throws SQLException {

		TExecutor exec = new TExecutor();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM guest ");
		sql.append("Inner join orders on ");
		sql.append("guest.idGuest=orders.guest_id ");
		sql.append("Inner join hotel_room on ");
		sql.append("orders.hotel_room_id=hotel_room.idHotelRoom ");
		sql.append("WHERE guest.name ='" + name + "'; ");

		return exec.execQuery(con, sql.toString(), // need prepared statement
				new TResultHandler<Guest>() {

					@Override
					public Guest handle(ResultSet result) throws SQLException {

						Guest dataSetGuest;
						Orders dataSetOrders;
						List<Guest> guestList = new ArrayList<Guest>();

						while (result.next()) {
							dataSetGuest = parseResultForGuest(result);
							dataSetOrders = parseResultForOrders(result);
							guestList = addGuestInList(guestList, dataSetGuest,
									dataSetOrders);
						}

						return guestList.get(0);
					}
				});
	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IGuestDAO#update(java.sql.Connection, int,
	 * com.danco.gloomezis.dataSet.IBaseModel)
	 */

	@Override
	public int update(Connection con, int id, IBaseModel baseModel)
			throws SQLException {

		TExecutor exec = new TExecutor();
		String name = ((Guest) baseModel).getName();
		return exec.execUpdate(con, "UPDATE  guest SET name=" + name
				+ "where idGuest=" + id + ";");
	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IGuestDAO#delete(java.sql.Connection, int)
	 */

	@Override
	public int delete(Connection con, int id) throws SQLException {

		TExecutor exec = new TExecutor();
		String sql = "DELETE  FROM guest WHERE idGuest =";
		return exec.execUpdate(con, sql + id + ";"); // need prepared statement
	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IGuestDAO#getAll(java.sql.Connection)
	 */

	@Override
	public List<Guest> getAllSorted(Connection con, String sortCondition)
			throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM guest ");
		sql.append("Inner join orders on ");
		sql.append("guest.idGuest=orders.guest_id ");
		sql.append("Inner join hotel_room on ");
		sql.append("orders.hotel_room_id=hotel_room.idHotelRoom ");
		sql.append("order by " + sortCondition + ";");

		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(),
				new TResultHandler<List<Guest>>() {

					@Override
					public List<Guest> handle(ResultSet result)
							throws SQLException {
						List<Guest> list = new ArrayList<Guest>();

						while (result.next()) {

							Guest guest = parseResultForGuest(result);
							Orders order = parseResultForOrders(result);

							list = addGuestInList(list, guest, order);
						}
						return list;
					}
				});

	}

	@Override
	public List<Guest> getAll(Connection con) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM guest ");
		sql.append("Inner join orders on ");
		sql.append("guest.idGuest=orders.guest_id ");
		sql.append("Inner join hotel_room on ");
		sql.append("orders.hotel_room_id=hotel_room.idHotelRoom ");

		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(),
				new TResultHandler<List<Guest>>() {

					@Override
					public List<Guest> handle(ResultSet result)
							throws SQLException {

						List<Guest> list = new ArrayList<Guest>();

						while (result.next()) {

							Guest guest = parseResultForGuest(result);
							Orders order = parseResultForOrders(result);

							list = addGuestInList(list, guest, order);
						}
						return list;

					}
				});

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IGuestDAO#getAllGuestNumber(java.sql.Connection)
	 */
	@Override
	public int getAllGuestNumber(Connection con) throws SQLException {
		String sql = "SELECT COUNT('idGuest') FROM guest";
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IGuestDAO#getNameGuestsAndTheyHotelRoom(java.
	 * sql.Connection, java.lang.String)
	 */
	@Override
	public List<String> getNameGuestsAndTheyHotelRoom(Connection con,
			String sortCondition) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" Select guest.name, hotel_room.number, orders.date_arrive,orders.date_departure from orders ");
		sql.append("INNER JOIN guest ON guest.idGuest=orders.guest_id ");
		sql.append("INNER JOIN hotel_room ON hotel_room.idHotelRoom=orders.hotel_room_id ");
		sql.append("WHERE orders.paid_orders=false");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IGuestDAO#getGuestServiceAndTheyPrice(java.sql
	 * .Connection, int)
	 */
	@Override
	public List<Service> getGuestService(Connection con, String name)
			throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT service.* FROM orders ");
		sql.append("INNER JOIN service ON ");
		sql.append("orders.idOrders=service.orders_id ");
		sql.append("INNER JOIN guest ON ");
		sql.append("orders.guest_id=guest.idGuest ");
		sql.append("WHERE guest.name = '" + name + "'");
		sql.append("ORDER BY service.service_price ; ");
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(),
				new TResultHandler<List<Service>>() {

					@Override
					public List<Service> handle(ResultSet result)
							throws SQLException {
						List<Service> list = new ArrayList<Service>();

						while (result.next()) {

							Service serv = new Service(result.getInt("idService"),
									
									result.getString("name_service"), 
									result.getInt("service_price"),
                                    result.getBoolean("paid_service"));

							list.add(serv);
						}
						return list;
					}
				});

	}

	private Guest parseResultForGuest(ResultSet result) throws SQLException {
		Guest guest = null;
		int id = result.getInt("idGuest");
		String name = result.getString("name");

		guest = new Guest(id, name);
		guest.setId(id);

		return guest;
	}

	private Orders parseResultForOrders(ResultSet result) throws SQLException {
		Orders order = null;
		int idRoom = result.getInt("idHotelRoom");
		String number = result.getString("number");
		int roomPrice = result.getInt("room_price");
		int sleepigNumbers = result.getInt("sleeping_number");
		int starCategory = result.getInt("star_category");

		HotelRoom room = new HotelRoom(idRoom, number, roomPrice,
				sleepigNumbers, starCategory);

		room.setBusy(result.getBoolean("busy"));
		room.setStatus(result.getBoolean("status"));

		int idOrders = result.getInt("idOrders");
		Date dateArrive = result.getDate("date_arrive");
		Date dateDeparture = result.getDate("date_departure");
		boolean paid = result.getBoolean("paid_orders");

		order = new Orders(idOrders, room, dateArrive, dateDeparture, paid);

		return order;

	}

	private List<Guest> addGuestInList(List<Guest> guestList, Guest guest,
			Orders order) {

		if (guestList.size() == 0) {
			addOrdersForGuest(guest, order);
			guestList.add(guest);
		} else {
			boolean isGuest = false;
			int index = 0;

			for (int i = 0; i < guestList.size(); i++) {
				if (guestList.get(i).getId() == guest.getId()) {
					isGuest = true;
					index = i;
				}
			}
			// if guest is exist - modify
			if (isGuest) {
				guest = guestList.get(index);
				addOrdersForGuest(guest, order);
				guestList.set(index, guest);
			} else {
				addOrdersForGuest(guest, order);
				guestList.add(guest);
			}
		}
		return guestList;
	}

	private void addOrdersForGuest(Guest guest, Orders order) {
		List<Orders> ordersList = new ArrayList<Orders>();
		if (guest.getOrders() != null) {
			ordersList = guest.getOrders();
		}
		ordersList.add(order);
		guest.setOrders(ordersList);
	}

}
