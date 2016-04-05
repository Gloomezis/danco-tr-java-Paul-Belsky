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

import com.danco.dao.api.IServiceDAO;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.IBaseModel;
import com.danco.model.Orders;
import com.danco.model.Service;

public class ServiceDAO implements IDAO<Service>, IServiceDAO {

	public ServiceDAO() {

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IServiceDAO#create(java.sql.Connection,
	 * com.danco.model.IBaseModel)
	 */

	@Override
	public int create(Connection con, IBaseModel baseModel) throws SQLException {
		TExecutor exec = new TExecutor();
		int oId = ((Service) baseModel).getOrder().getId();
		String name = ((Service) baseModel).getName();
		int price = ((Service) baseModel).getPrice();

		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO service (orders_id,name_service,service_price) values (");
		sql.append(oId);
		sql.append(",'");
		sql.append(name);
		sql.append("',");
		sql.append(price);
		sql.append(";)");

		return exec.execUpdate(con, sql.toString());

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IServiceDAO#read(java.sql.Connection, int)
	 */

	@Override
	public Service read(Connection con, int id) throws SQLException {
		TExecutor exec = new TExecutor();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM service ");
		sql.append("Inner join orders on ");
		sql.append("service.idService=orders.idOrders ");
		sql.append("Inner join hotel_room on ");
		sql.append("orders.hotel_room_id=hotel_room.idHotelRoom ");
		sql.append("Inner join guest on ");
		sql.append("orders.guest_id=guest.idGuest ");
		sql.append("WHERE idService = ");
		sql.append(id);
		sql.append(";");

		return exec.execQuery(con, sql.toString(),
				new TResultHandler<Service>() {

					@Override
					public Service handle(ResultSet result) throws SQLException {
						Service service = null;
						if (result.next()) {
							service = parseResultSet(result);
						}
						return service;
					}
				});
	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IServiceDAO#readByName(java.sql.Connection,
	 * java.lang.String)
	 */

	@Override
	public Service readByName(Connection con, String name) throws SQLException {
		TExecutor exec = new TExecutor();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM service ");
		sql.append("Inner join orders on ");
		sql.append("service.idService=orders.idOrders ");
		sql.append("Inner join hotel_room on ");
		sql.append("orders.hotel_room_id=hotel_room.idHotelRoom ");
		sql.append("Inner join guest on ");
		sql.append("orders.guest_id=guest.idGuest ");
		sql.append("WHERE name_service = '");
		sql.append(name);
		sql.append("';");

		return exec.execQuery(con, sql.toString(),
				new TResultHandler<Service>() {

					@Override
					public Service handle(ResultSet result) throws SQLException {
						Service service = null;
						if (result.next()) {
							service = parseResultSet(result);
						}
						return service;
					}
				});
	}

	// +
	// update only price
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IServiceDAO#update(java.sql.Connection, int,
	 * com.danco.model.IBaseModel)
	 */

	@Override
	public int update(Connection con, int id, IBaseModel baseModel)
			throws SQLException {

		TExecutor exec = new TExecutor();
		int sPrice = ((Service) baseModel).getPrice();
		String sName = ((Service) baseModel).getName();
		boolean sPaid = ((Service) baseModel).isPaid();

		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE  service SET orders_id=");
		sql.append(((Service) baseModel).getOrder().getId());
		sql.append(", name_service='");
		sql.append(sName);
		sql.append("', service_price=");
		sql.append(sPrice);
		sql.append(",paid_service=");
		sql.append(sPaid);
		sql.append("where id=");
		sql.append(id);
		sql.append(";");

		return exec.execUpdate(con, sql.toString());

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IServiceDAO#delete(java.sql.Connection, int)
	 */

	@Override
	public int delete(Connection con, int id) throws SQLException {

		TExecutor exec = new TExecutor();
		StringBuilder sql = new StringBuilder();

		sql.append("DELETE  FROM service WHERE idService =");
		sql.append(id);
		sql.append(";");

		return exec.execUpdate(con, sql.toString());

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IServiceDAO#getAll(java.sql.Connection)
	 */

	@Override
	public List<Service> getAll(Connection con) throws SQLException {

		TExecutor exec = new TExecutor();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM service ");
		sql.append("Inner join orders on ");
		sql.append("service.idService=orders.idOrders ");
		sql.append("Inner join hotel_room on ");
		sql.append("orders.hotel_room_id=hotel_room.idHotelRoom ");
		sql.append("Inner join guest on ");
		sql.append("orders.guest_id=guest.idGuest ");

		return exec.execQuery(con, sql.toString(),
				new TResultHandler<List<Service>>() {

					@Override
					public List<Service> handle(ResultSet result)
							throws SQLException {
						List<Service> list = new ArrayList<Service>();
						while (result.next()) {
							list.add(parseResultSet(result));
						}
						return list;
					}
				});
	}

	// + update only paid for method departure
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IServiceDAO#updatePaid(java.sql.Connection,
	 * int)
	 */
	@Override
	public int updatePaid(Connection con, String id) throws SQLException {
		TExecutor exec = new TExecutor();
		
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE  service SET paid = true where order_id=");
		sql.append(id);
		sql.append(";");
		
		return exec.execUpdate(con,
				sql.toString());

	}

	// составное с ценой номеров - возможно можно заменить на обычный достать
	// все сервисы

	// + get price all service order by price
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IServiceDAO#getPriceService(java.sql.Connection)
	 */
	@Override
	public List<String> getPriceService(Connection con) throws SQLException {
		TExecutor exec = new TExecutor();
		
		
		
		return exec.execQuery(con,
				"SELECT name ,price FROM service ORDER BY price ",
				new TResultHandler<List<String>>() {

					@Override
					public List<String> handle(ResultSet result)
							throws SQLException {
						List<String> list = new ArrayList<String>();
						while (result.next()) {
							String res = result.getString("name") + "-"
									+ result.getInt("price") + ";";
							list.add(res);
						}
						return list;
					}

				});

	}

	@Override
	public int updatePrice(Connection con, int id, int price)
			throws SQLException {
		TExecutor exec = new TExecutor();
		
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE  service SET price = true where id=");
		sql.append(id);
		sql.append(";");
		
		return exec.execUpdate(con,
				sql.toString());

	}

	private Service parseResultSet(ResultSet result) throws SQLException {
		Service service = null;
		int idService = result.getInt("idService");
		String nameService = result.getString("name_service");
		int priceService = result.getInt("service_price");
		boolean paidService = result.getBoolean("paid_service");

		Orders order = null;
		int idOrder = result.getInt("idOrders");
		Date dateArrive = result.getDate("date_arrive");
		Date dateDeparture = result.getDate("date_departure");
		boolean paid = result.getBoolean("paid_orders");

		int idGuest = result.getInt("idGuest");
		String name = result.getString("name");
		Guest guest = new Guest(idGuest, name);

		int idRoom = result.getInt("idHotelRoom");
		String number = result.getString("number");
		int roomPrice = result.getInt("room_price");
		int sleepingNumber = result.getInt("sleeping_number");
		int starCategory = result.getInt("star_category");
		boolean busy = result.getBoolean("busy");
		boolean status = result.getBoolean("status");
		HotelRoom room = new HotelRoom(idRoom, number, roomPrice,
				sleepingNumber, starCategory);
		room.setBusy(busy);
		room.setStatus(status);
		order = new Orders(idOrder, room, dateArrive, dateDeparture, paid);
		order.setGuest(guest);

		service = new Service(idService, nameService, priceService, paidService);
		service.setOrder(order);

		return service;
	}

}
