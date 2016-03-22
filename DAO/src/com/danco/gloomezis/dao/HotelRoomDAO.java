package com.danco.gloomezis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.danco.gloomezis.dataSet.HotelRoom;
import com.danco.gloomezis.dataSet.IBaseModel;
import com.danco.gloomezis.executor.TExecutor;
import com.danco.gloomezis.hadleer.TResultHandler;

public class HotelRoomDAO implements IDAO<HotelRoom> {

	private Connection con;

	public HotelRoomDAO(Connection con) {
		this.con = con;
	}
	
    //+
	@Override
	public int create(IBaseModel baseModel) throws SQLException {

		TExecutor exec = new TExecutor();
		String name = ((HotelRoom) baseModel).getNumber();
		int rP = ((HotelRoom) baseModel).getRoomPrice();
		int sN = ((HotelRoom) baseModel).getSleepingNumbers();
		int sC = ((HotelRoom) baseModel).getStarCategory();
		boolean busy = ((HotelRoom) baseModel).getBusy();
		boolean status = ((HotelRoom) baseModel).getStatus();

		return exec
				.execUpdate(
						con,
						"INSERT INTO hotel_room (number,room_price,sleeping_number,star_category, busy,status) "
								+ "values ('"
								+ name
								+ "',"
								+ rP
								+ ","
								+ sN
								+ "," + sC + "," + busy + "," + status + ");");

	}

	//+
	@Override
	public HotelRoom read(int id) throws SQLException {
		TExecutor exec = new TExecutor();
		String sql = "SELECT * FROM hotel_room WHERE id =";
		return exec.execQuery(con, sql + id + ";",
				new TResultHandler<HotelRoom>() {

					@Override
					public HotelRoom handle(ResultSet result)
							throws SQLException {
						result.next();
						HotelRoom hotelRoom = new HotelRoom(
								result.getInt("id"),
								result.getString("number"), result
										.getInt("room_price"), result
										.getInt("sleeping_number"), result
										.getInt("star_category"));
						hotelRoom.setBusy(result.getBoolean("busy"));
						hotelRoom.setStatus(result.getBoolean("status"));
						return hotelRoom;
					}
				});
	}
	
    //+
	@Override
	public HotelRoom readByName(String number) throws SQLException {
		TExecutor exec = new TExecutor();
		String sql = "SELECT * FROM hotel_room WHERE number =";
		return exec.execQuery(con, sql + number + ";",
				new TResultHandler<HotelRoom>() {

					@Override
					public HotelRoom handle(ResultSet result)
							throws SQLException {
						result.next();
						HotelRoom hotelRoom = new HotelRoom(
								result.getInt("id"),
								result.getString("number"), result
										.getInt("room_price"), result
										.getInt("sleeping_number"), result
										.getInt("star_category"));
						hotelRoom.setBusy(result.getBoolean("busy"));
						hotelRoom.setStatus(result.getBoolean("status"));
						return hotelRoom;
					}
				});
	}
    
	//TODO
	@Override
	public int update(int id, IBaseModel baseModel) throws SQLException {
		
		return 0;
	}
   
	//+
	@Override
	public int delete(int id) throws SQLException {

		TExecutor exec = new TExecutor();
		String sql="DELETE  FROM hotel_room WHERE id =";
		return exec.execUpdate(con, sql + id+";");	

	}

	//+
	@Override
	public List<HotelRoom> getAll() throws SQLException {
		String sql = "SELECT * FROM hotel_rooom;";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql,
				new TResultHandler<List<HotelRoom>>() {

					@Override
					public List<HotelRoom> handle(ResultSet result)
							throws SQLException {
						List<HotelRoom> list = new ArrayList<HotelRoom>();
						while (result.next()) {
							HotelRoom hotelRoom = new HotelRoom(
									result.getInt("id"),
									result.getString("number"), result
											.getInt("room_price"), result
											.getInt("sleeping_number"), result
											.getInt("star_category"));
							hotelRoom.setBusy(result.getBoolean("busy"));
							hotelRoom.setStatus(result.getBoolean("status"));
							list.add(hotelRoom);
						}
						return list;
					}
				}
		);
	}
	
	//+
	public List<HotelRoom> getAllSorted(String sortCondition) throws SQLException {
		String sql = "SELECT * FROM hotel_rooom ORDER BY"+sortCondition+";";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql,
				new TResultHandler<List<HotelRoom>>() {

					@Override
					public List<HotelRoom> handle(ResultSet result)
							throws SQLException {
						List<HotelRoom> list = new ArrayList<HotelRoom>();
						while (result.next()) {
							HotelRoom hotelRoom = new HotelRoom(
									result.getInt("id"),
									result.getString("number"), result
											.getInt("room_price"), result
											.getInt("sleeping_number"), result
											.getInt("star_category"));
							hotelRoom.setBusy(result.getBoolean("busy"));
							hotelRoom.setStatus(result.getBoolean("status"));
							list.add(hotelRoom);
						}
						return list;
					}
				}
		);
	}
	
	
 
	//+
	public List<HotelRoom> getAllFreeSorted(String sortCondition) throws SQLException {
		String sql = "SELECT * FROM hotel_room WHERE busy = true ORDER BY"+sortCondition+";";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql,
				new TResultHandler<List<HotelRoom>>() {

					@Override
					public List<HotelRoom> handle(ResultSet result)
							throws SQLException {
						List<HotelRoom> list = new ArrayList<HotelRoom>();
						while (result.next()) {
							HotelRoom hotelRoom = new HotelRoom(
									result.getInt("id"),
									result.getString("number"), result
											.getInt("room_price"), result
											.getInt("sleeping_number"), result
											.getInt("star_category"));
							hotelRoom.setBusy(result.getBoolean("busy"));
							hotelRoom.setStatus(result.getBoolean("status"));
							list.add(hotelRoom);
						}
						return list;
					}
				}
		);
	}
	
	//+
	public int getNumberFreeHotelRooms() throws SQLException {
		String sql = "SELECT COUNT('id') FROM hotel_room WHERE busy = true";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql,
				new TResultHandler<Integer>() {

					@Override
					public Integer handle(ResultSet result)throws SQLException {
						
						result.next();
							
						
						return result.getInt(1);
					}
				}
		);
	}
	
	//+
	//write to select last of hotel room oorder
	public List<HotelRoom> getFreeHotelRoomsAfterDate(Date date) throws SQLException {
		String sql = "SELECT  * FROM hotel_room WHERE date_departure < "+date+";";
		TExecutor exec = new TExecutor();

		return exec.execQuery(con, sql,
				new TResultHandler<List<HotelRoom>>() {

			@Override
			public List<HotelRoom> handle(ResultSet result)
					throws SQLException {
				List<HotelRoom> list = new ArrayList<HotelRoom>();
				while (result.next()) {
					HotelRoom hotelRoom = new HotelRoom(
							result.getInt("id"),
							result.getString("number"), result
									.getInt("room_price"), result
									.getInt("sleeping_number"), result
									.getInt("star_category"));
					hotelRoom.setBusy(result.getBoolean("busy"));
					hotelRoom.setStatus(result.getBoolean("status"));
					list.add(hotelRoom);
				}
				return list;
			}
				}
		);
	}
	
	    //+ update only price
		public int updatePrice(int id, int rPrice) throws SQLException {
			TExecutor exec = new TExecutor();
			return exec.execUpdate(con, "UPDATE  hotel_room SET room_price="+rPrice+"where id="+id+";");	

		}
		
		 //+ update only status
		public int updateStatus(int id, int status) throws SQLException {
			TExecutor exec = new TExecutor();
			return exec.execUpdate(con, "UPDATE  hotel_room SET status="+status+"WHERE id="+id+";");	

		}
		
		
		 //+ get price all service order by price
		public String getPriceHotelRoom(int id) throws SQLException {
			TExecutor exec = new TExecutor();
			return exec.execQuery(con, "SELECT DISTINCT name,price FROM  service ORDER BY price;",new TResultHandler<String>(){

				@Override
				public String handle(ResultSet result) throws SQLException {
					StringBuilder sb = new StringBuilder();
					while (result.next()) {
						sb.append(result.getString("name")+"-"+result.getInt("price")+";");	
					}
					return sb.toString();
				}
				
			});	

		}


}
