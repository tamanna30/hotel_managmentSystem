package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel_Exception.GuestException;
import hotel_Exception.RoomException;
import hotel_model.Guest;
import hotel_model.Room;
import hotel_utility.ConnHotel;

public class RoomDaoImpli implements RoomDao {

	@Override
	public String addRoom(Room r) throws RoomException {
		// TODO Auto-generated method stub
		String query="insert into room(rType,rPrize,rStatus,hId) values(?,?,'available',?)";
		String msg=null;
	
		try {
			Connection conn= ConnHotel.getinstance().getConnection();
			PreparedStatement ppst  = conn.prepareStatement(query);
			ppst.setString(1, r.getrType());
			ppst.setInt(2,r.getrPrize());
			ppst.setInt(3, r.gethId());
//			ppst.setString(3,r.getrStatus());
			
			int x= ppst.executeUpdate();
			
			if(x>0){
				msg="data inserted";
			}
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	
	@Override
	public Room getRoomById(int id) throws RoomException {
		// TODO Auto-generated method stub
		String query="select rId, rType,rPrize,rStatus,hIdfrom room where rId = ?";
		Room room=null;
		
		try {
			Connection conn= ConnHotel.getinstance().getConnection();
			PreparedStatement ppst  = conn.prepareStatement(query);
			
			ppst.setInt(1, id);
			
			try(ResultSet rs = ppst.executeQuery()){
				
					System.out.println("+-----+-------+--- --+------+---------+");
					System.out.println("| rId | rType | rPrize | rStatus | hId |");
					System.out.println("+-----+-------+--- --+------+----------+");
					if(rs.next()){
					int rId = rs.getInt("rId");
					String rType = rs.getString("rType");
					int rPrize = rs.getInt("rPrize");
					String rStatus = rs.getString("rStatus");
					int hId=rs.getInt("hId");
					
					room = new Room(rId,rType,rPrize,rStatus,hId);
//					System.out.println("| %-10d | %-5s | %-5s| %-5s | %-5s |\n"+gId+gName+gPhone+gEmail+gAdd);
					System.out.println(rId+" "+rType+" "+rPrize+" "+rStatus+" "+hId);
					System.out.println("+-----+-------+--- --+------+-----+");
					
				}
				else{
					System.out.println("room id with"+id+"not found");
				}
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return room;
	}

	@Override
	public List<Room> getAllRoom() throws RoomException {
		// TODO Auto-generated method stub
		String query="select rId,rType,rPrize,rStatus,hId from room";
		List<Room> roo=new ArrayList<>();
		
		try(Connection conn= ConnHotel.getinstance().getConnection()){
			if(conn==null){
				throw new GuestException("failed to make connection");
				}
			try( PreparedStatement ppst  = conn.prepareStatement(query);
					ResultSet rs = ppst.executeQuery())
			{
				System.out.println("current room");

				System.out.println("+-----+-------+--- --+------+--------+");
				System.out.println("| rId | rType | rPrize | rStatus | hId");
				System.out.println("+-----+-------+--- --+------+---------+");
				while(rs.next()){
					
					int rId = rs.getInt("rId");
					String rType = rs.getString("rType");
					int rPrize = rs.getInt("rPrize");
					String rStatus = rs.getString("rStatus");
					int hId=rs.getInt("hId");
					
					Room room = new Room(rId,rType,rPrize,rStatus,hId);
					System.out.println(rId+" "+rType+" "+rPrize+" "+rStatus+" "+hId);
				}
				System.out.println("+-----+-------+--- --+------+------+");
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
				
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return roo;
	}

}
