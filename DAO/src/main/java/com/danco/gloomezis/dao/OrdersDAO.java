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
import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.IBaseModel;
import com.danco.model.Orders;
import com.danco.model.Service;

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
		int gId = ((Orders) baseModel).getGuest().getId();
		int hrId = ((Orders) baseModel).getHotelRoom().getId();
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
		
		StringBuilder sql = new StringBuilder();
		
		
		
		sql.append("SELECT * FROM orders ");
		sql.append("Inner join guest on ");
		sql.append("guest.idGuest=orders.guest_id ");
		sql.append("Inner join hotel_room on ");
		sql.append("orders.hotel_room_id=hotel_room.idHotelRoom ");
		sql.append("Inner join service on ");
		sql.append("orders.idOrders=service.orders_id ");
		
		sql.append("WHERE orders.idOrders = " + id + "; ");
		
		
		
		return exec.execQuery(con, sql.toString(),
				new TResultHandler<Orders>() {

					@Override
					public Orders handle(ResultSet result) throws SQLException {
						
						List<Orders> ordersList = new ArrayList<Orders>(); 
						
						while(result.next()) {
							Orders order = parseResultForOrders(result);
							Service service = parseResultForService(result);
							ordersList = addOrdersInList(ordersList, service, order) ;
						}
						return ordersList.get(0); 
					}
				});
	}


	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#update(java.sql.Connection, int, com.danco.model.IBaseModel)
	 */
	
	@Override
	public int update(Connection con, int id, IBaseModel baseModel)
			throws SQLException {
		
		TExecutor exec = new TExecutor();
		int oId=((Orders) baseModel).getId();
		int gId = ((Orders) baseModel).getGuest().getId();
		int hrId = ((Orders) baseModel).getHotelRoom().getId();
		Date dArrive = ((Orders) baseModel).getDateOfArrival();
		Date dDeparture = ((Orders) baseModel).getDateOfDeparture();
		boolean paidOrders =((Orders)baseModel).isPaid();
		
		String sql = "UPDATE  orders SET date_arrive = '"
				+ dArrive+ "', date_departure = '"
				+ dDeparture + "', paid_orders = " + paidOrders
				+ ", hotel_room_id = " + hrId
				+ ", guest_id = " + gId
				+ " WHERE idOrders = " + oId + ";";
		
		
		return exec.execUpdate(con, sql);
		

	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#delete(java.sql.Connection, int)
	 */
	
	@Override
	public int delete(Connection con, int id) throws SQLException {

		TExecutor exec = new TExecutor();
		String sql = "DELETE  FROM orders WHERE idOrders =";
		return exec.execUpdate(con, sql + id + ";");

	}

	// +
	/* (non-Javadoc)
	 * @see com.danco.gloomezis.dao.IOrdersDAO#getAll(java.sql.Connection)
	 */
	
	@Override
	public List<Orders> getAll(Connection con) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM orders ");
		sql.append("Inner join guest on ");
		sql.append("guest.idGuest=orders.guest_id ");
		sql.append("Inner join hotel_room on ");
		sql.append("orders.hotel_room_id=hotel_room.idHotelRoom ");
		sql.append("Inner join service on ");
		sql.append("orders.idOrders=service.orders_id ");
		
		
		
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(), new TResultHandler<List<Orders>>() {

			@Override
			public List<Orders> handle(ResultSet result) throws SQLException {
				List<Orders> list = new ArrayList<Orders>();
				
				while (result.next()) {
					Orders order = parseResultForOrders(result);
					Service service = parseResultForService(result);
					
					list = addOrdersInList(list, service, order) ;
					
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
		return exec.execUpdate(con, "UPDATE  orders SET paid = true where idOrders="
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
		sql.append("orders.guest_id=guest.idGuest ");
		sql.append("INNER JOIN hotel_room ON ");
		sql.append("orders.hotel_room_id=hotel_room.idHotelRoom ");
		sql.append("WHERE guest.name = '" + name + "' and orders.paid_orders=false");
		sql.append("UNION ");
		sql.append("SELECT SUM(service.service_price) AS price FROM orders ");
		sql.append("INNER JOIN guest ON ");
		sql.append("orders.guest_id=guest.idGuest ");
		sql.append("INNER JOIN service ON ");
		sql.append("orders.idOrders=service.orders_id ");
		sql.append("WHERE guest.name = '" + name
				+ "' and service.paid_service=false )AS guest_summ_paid; ");
		
		
		
		
		

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
	
	
	
	
	private Orders parseResultForOrders(ResultSet result) throws SQLException {

		Orders order = null;
		int idOrder = result.getInt("idOrders");
		Date dateArrive = result.getDate("date_arrive");
		Date dateDeparture = result.getDate("date_departure");
		boolean paid = result.getBoolean("paid_orders");

		int idGuest = result.getInt("idGuest");
		String name = result.getString("name");
		Guest guest = new Guest(idGuest,name);
		

		int idRoom = result.getInt("idHotelRoom");
		String number = result.getString("number");
		int roomPrice = result.getInt("room_price");
		int sleepingNumber = result.getInt("sleeping_number");
		int starCategory = result.getInt("star_category");
		boolean busy = result.getBoolean("busy");
		boolean status = result.getBoolean("status");
		HotelRoom room = new HotelRoom(idRoom, number, roomPrice, sleepingNumber,
				starCategory);
		room.setBusy(busy);
		room.setStatus(status);
		order = new Orders(idOrder,room, dateArrive, dateDeparture, paid);
		order.setGuest(guest);
		
		return order;
	}
	
	private Service parseResultForService(ResultSet result) throws SQLException{
		
		int idService = result.getInt("idService");
		String nameService = result.getString("name_service");
		int priceService = result.getInt("service_price");
		boolean paidService = result.getBoolean("paid_service");


		Service service = new Service(idService,nameService, priceService,paidService);
		
		return service;
	}

	private void addServiceForOrders(Service service, Orders order){
		List<Service> serviceList = new ArrayList<Service>();
		if (order.getServices()!=null){
			serviceList = order.getServices();
		} 
		serviceList.add(service);
			order.setServices(serviceList);	
	}
	
	private List<Orders> addOrdersInList(List<Orders> orderList, Service service,
			Orders order) {

		if (orderList.size() == 0) {
			addServiceForOrders(service, order);
			orderList.add(order);
		} else {
			boolean isOrder = false;
			int index = 0;
			
			for (int i = 0; i < orderList.size(); i++) {
				if (orderList.get(i).getId() == order.getId()) {
					isOrder = true;
					index = i;
				}
			}
			
			if (isOrder) {
				order = orderList.get(index);
				addServiceForOrders(service, order);
				orderList.set(index, order);
			} else {
				addServiceForOrders(service, order);
				orderList.add(order);
			}
		}
		return orderList;
	}

	
	//Not needed
	@Override
	public Orders readByName(Connection con, String name) throws SQLException {
		
		return null;
	}
 

}
