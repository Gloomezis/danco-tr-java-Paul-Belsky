package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.danco.dao.api.IHotelRoomDAO;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;
import com.danco.model.HotelRoom;
import com.danco.model.IBaseModel;

public class HotelRoomDAO implements IDAO<HotelRoom>, IHotelRoomDAO {

	public HotelRoomDAO() {

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#create(java.sql.Connection,
	 * com.danco.model.IBaseModel)
	 */

	@Override
	public int create(Connection con, IBaseModel baseModel) throws SQLException {

		TExecutor exec = new TExecutor();
		String name = ((HotelRoom) baseModel).getNumber();
		int rP = ((HotelRoom) baseModel).getRoomPrice();
		int sN = ((HotelRoom) baseModel).getSleepingNumber();
		int sC = ((HotelRoom) baseModel).getStarCategory();
		boolean busy = ((HotelRoom) baseModel).isBusy();
		boolean status = ((HotelRoom) baseModel).isStatus();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO hotel_room (number,room_price,sleeping_number,star_category, busy,status) values ('");
		sql.append(name);
		sql.append("',");
		sql.append(rP);
		sql.append(",");
		sql.append(sN);
		sql.append(",");
		sql.append(sC);
		sql.append(",");
		sql.append(busy);
		sql.append(",");
		sql.append(status);
		sql.append(");");
		
		return exec.execUpdate(con,sql.toString());

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#read(java.sql.Connection, int)
	 */

	@Override
	public HotelRoom read(Connection con, int id) throws SQLException {
		TExecutor exec = new TExecutor();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM hotel_room WHERE idHotelRoom =");
		sql.append(id);
		sql.append(";");
		
		
		return exec.execQuery(con, sql.toString(),
				new TResultHandler<HotelRoom>() {

					@Override
					public HotelRoom handle(ResultSet result)
							throws SQLException {
						HotelRoom hr = null;
						if (result.next()) {
							hr = parseResultForRoom(result);
						}
						return hr;
					}
				});
	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IHotelRoomDAO#readByName(java.sql.Connection,
	 * java.lang.String)
	 */

	@Override
	public HotelRoom readByName(Connection con, String number)
			throws SQLException {
		TExecutor exec = new TExecutor();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM hotel_room WHERE number ='");
		sql.append(number);
		sql.append("';");
		
		return exec.execQuery(con, sql.toString(),
				new TResultHandler<HotelRoom>() {

					@Override
					public HotelRoom handle(ResultSet result)
							throws SQLException {
						HotelRoom hr = null;
						if (result.next()) {
							hr = parseResultForRoom(result);
						}
						return hr;
					}
				});
	}

	// TODO
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#update(java.sql.Connection,
	 * int, com.danco.model.IBaseModel)
	 */

	@Override
	public int update(Connection con, int id, IBaseModel baseModel)
			throws SQLException {
		TExecutor exec = new TExecutor();
		HotelRoom room = (HotelRoom) baseModel;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE  Room SET number = ");
		sql.append(room.getNumber());
		sql.append(", room_price = ");
		sql.append(room.getRoomPrice());
		sql.append(", sleeping_number = ");
		sql.append(room.getSleepingNumber());
		sql.append(", stat_category = ");
		sql.append(room.getStarCategory());
		sql.append(", busy = ");
		sql.append(room.isBusy());
		sql.append(", status = ");
		sql.append(room.isStatus());
		sql.append(" WHERE idHotelRoom = ");
		sql.append(id);
		sql.append(" ;");
		
		return exec.execUpdate(con, sql.toString());

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#delete(java.sql.Connection,
	 * int)
	 */

	@Override
	public int delete(Connection con, int id) throws SQLException {

		TExecutor exec = new TExecutor();
		
        StringBuilder sql = new StringBuilder();
		
		sql.append("DELETE  FROM hotel_room WHERE idHotelRoom =");
		sql.append(id);
		sql.append(";");
		
		return exec.execUpdate(con, sql.toString());

	}

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.gloomezis.dao.IHotelRoomDAO#getAll(java.sql.Connection)
	 */

	@Override
	public List<HotelRoom> getAll(Connection con) throws SQLException {
		String sql = "SELECT * FROM hotel_room;";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql, new TResultHandler<List<HotelRoom>>() {

			@Override
			public List<HotelRoom> handle(ResultSet result) throws SQLException {
				List<HotelRoom> list = new ArrayList<HotelRoom>();
				while (result.next()) {
					list.add(parseResultForRoom(result));
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
	 * com.danco.gloomezis.dao.IHotelRoomDAO#getAllSorted(java.sql.Connection,
	 * java.lang.String)
	 */
	@Override
	public List<HotelRoom> getAllSorted(Connection con, String sortCondition)
			throws SQLException {
		
        StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM hotel_rooom ORDER BY");
		sql.append(sortCondition);
		sql.append(";");
		
		
		
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(), new TResultHandler<List<HotelRoom>>() {

			@Override
			public List<HotelRoom> handle(ResultSet result) throws SQLException {
				List<HotelRoom> list = new ArrayList<HotelRoom>();
				while (result.next()) {
					list.add(parseResultForRoom(result));
				}
				return list;
			}
		});
	}
	
	
	
	
	//TODO may replaced by serviceLayer

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IHotelRoomDAO#getAllFreeSorted(java.sql.Connection
	 * , java.lang.String)
	 */
	@Override
	public List<HotelRoom> getAllFreeSorted(Connection con, String sortCondition)
			throws SQLException {
		
		
		 StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT * FROM hotel_room WHERE busy = true ORDER BY");
			sql.append(sortCondition);
			sql.append(";");
		
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(), new TResultHandler<List<HotelRoom>>() {

			@Override
			public List<HotelRoom> handle(ResultSet result) throws SQLException {
				List<HotelRoom> list = new ArrayList<HotelRoom>();
				while (result.next()) {
					list.add(parseResultForRoom(result));
				}
				return list;
			}
		});
	}
	
	//TODO may replaced by serviceLayer

	// +
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IHotelRoomDAO#getNumberFreeHotelRooms(java.sql
	 * .Connection)
	 */
	
	
	
	@Override
	public int getNumberFreeHotelRooms(Connection con) throws SQLException {
		String sql = "SELECT COUNT('idHotelRoom') FROM hotel_room WHERE busy = true";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql, new TResultHandler<Integer>() {

			@Override
			public Integer handle(ResultSet result) throws SQLException {

				result.next();

				return result.getInt(1);
			}
		});
	}

	//TODO may replaced by serviceLayer
	
	// write to select last of hotel room oorder
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IHotelRoomDAO#getFreeHotelRoomsAfterDate(java
	 * .sql.Connection, java.lang.String, java.util.Date)
	 */
	@Override
	public List<HotelRoom> getFreeHotelRoomsAfterDate(Connection con,
			String sortCondition, Date date) throws SQLException {

		
		 StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT  hotel_room.* FROM hotel_room INNER join orders ON orders.hotel_room_id=hotel_room.idHotelRoom WHERE date_departure < '");
			sql.append(date);
			sql.append("' ORDER BY ");
			sql.append(sortCondition);
			sql.append(";");
		
		
		
		
		
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(), new TResultHandler<List<HotelRoom>>() {

			@Override
			public List<HotelRoom> handle(ResultSet result) throws SQLException {
				List<HotelRoom> list = new ArrayList<HotelRoom>();
				while (result.next()) {
					list.add(parseResultForRoom(result));
				}
				return list;
			}
		});
	}

	///TODO may replaced by serviceLayer
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IHotelRoomDAO#updatePrice(java.sql.Connection,
	 * int, int)
	 */
	@Override
	public int updatePrice(Connection con, int id, int rPrice)
			throws SQLException {
		TExecutor exec = new TExecutor();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE  hotel_room SET room_price=");
		sql.append(rPrice);
		sql.append("where idHotelRoom=");
		sql.append(id);
		sql.append(";");
		
		return exec.execUpdate(con, sql.toString());
		
		

	}

	//TODO may replaced by serviceLayer
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IHotelRoomDAO#updateStatus(java.sql.Connection,
	 * int, int)
	 */
	@Override
	public int updateStatus(Connection con, int id, boolean status)
			throws SQLException {
		TExecutor exec = new TExecutor();
		
        StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE  hotel_room SET status=");
		sql.append(status);
		sql.append("WHERE idHotelRoom=");
		sql.append(id);
		sql.append(";");
		
		return exec.execUpdate(con,sql.toString());

	}

	
	//TODO may replaced by serviceLayer
	// составное с ценой номеров - возможно можно заменить на обычный достать
	// все хотелрумы
	// + get price all service order by price
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.gloomezis.dao.IHotelRoomDAO#getPriceHotelRoom(java.sql.Connection
	 * )
	 */
	@Override
	public List<String> getPriceHotelRoom(Connection con) throws SQLException {
		TExecutor exec = new TExecutor();
		return exec
				.execQuery(
						con,
						"SELECT DISTINCT number,room_price FROM  hotel_room ORDER BY room_price;",
						new TResultHandler<List<String>>() {

							@Override
							public List<String> handle(ResultSet result)
									throws SQLException {
								List<String> list = new ArrayList<String>();
								while (result.next()) {
									String res = result.getString("number")
											+ "-" + result.getInt("room_price")
											+ " \n ";
									list.add(res);
								}
								return list;
							}

						});

	}

	@Override
	public Boolean getStatus(Connection con, String number) throws SQLException {
		
StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT status FROM hotel_room where number= '");
		sql.append(number);
		sql.append("';");
		
		
		
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql.toString(), new TResultHandler<Boolean>() {

			@Override
			public Boolean handle(ResultSet result) throws SQLException {

				result.next();

				Boolean rez = result.getBoolean(1);

				return rez;
			}
		});
	}

	private HotelRoom parseResultForRoom(ResultSet result) throws SQLException {
		HotelRoom room = null;
		int id = result.getInt("idHotelRoom");
		String number = result.getString("number");
		int roomPrice = result.getInt("room_price");
		int sleepingNumber = result.getInt("sleeping_number");
		int starCategory = result.getInt("star_category");
		boolean busy = result.getBoolean("busy");
		boolean status = result.getBoolean("status");

		room = new HotelRoom(id, number, roomPrice, sleepingNumber,
				starCategory);
		room.setBusy(busy);
		room.setStatus(status);

		return room;
	}

}
