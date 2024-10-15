package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel_Exception.GuestException;
import hotel_Exception.HotelException;
import hotel_model.Guest;
import hotel_model.Hotel;
import hotel_utility.ConnHotel;

public class HotelDaoImpli implements HotelDao {

	@Override
	public String addHotel(Hotel h) throws HotelException {
		// TODO Auto-generated method stub
		String query="insert into hotel values(?,?,?,?,?)";
		String msg=null;
		try {
			Connection conn= ConnHotel.getinstance().getConnection();
			PreparedStatement ppst  = conn.prepareStatement(query);
			ppst.setInt(1, h.gethId());
			ppst.setString(2, h.gethName());
			ppst.setString(3,h.gethCity());
			ppst.setInt(4,h.gettRoom());
			ppst.setInt(5,h.getaRoom());
			
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
	public Hotel getHotelByCity(String city) throws HotelException {
		// TODO Auto-generated method stub
		String query="select hId,hName,hCity,tRoom,aRoom from hotel where hcity = ?";
		Hotel hotel=null;
		try {
			Connection conn= ConnHotel.getinstance().getConnection();
			PreparedStatement ppst  = conn.prepareStatement(query);
			
			ppst.setString(1, city);
			
			try(ResultSet rs = ppst.executeQuery()){
				
					System.out.println("+-----+-------+--- --+----------+--------------+");
					System.out.println("| hId | name | city | totalroom | avilable room");
					System.out.println("+-----+-------+--- --+----------+---------------+");
					if(rs.next()){
					int hId=rs.getInt("hId");
					String hName = rs.getString("hName");
					String hCity = rs.getString("hCity");
					int tRoom = rs.getInt("tRoom");
					int aRoom = rs.getInt("aRoom");
					
					hotel = new Hotel(hId,hName,hCity,tRoom,aRoom);
//					System.out.println("| %-10d | %-5s | %-5s| %-5s | %-5s |\n"+gId+gName+gPhone+gEmail+gAdd);
					System.out.println(hId+" "+hName+" "+hCity+" "+tRoom+" "+aRoom);
					System.out.println("+-----+-------+--- --+------+-----+");
					
				}
				else{
					System.out.println("hotel with this city ="+city+" is not found");
				}
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return hotel;
	
	}

	@Override
	public List<Hotel> getAllHotel() throws HotelException {
		// TODO Auto-generated method stub
		String query="select hId,hName,hCity,tRoom,aRoom from hotel ";
		List<Hotel> hot=new ArrayList<>();
		
		try(Connection conn= ConnHotel.getinstance().getConnection()){
			if(conn==null){
				throw new GuestException("failed to make connection");
				}
			try( PreparedStatement ppst  = conn.prepareStatement(query);
					ResultSet rs = ppst.executeQuery())
			{
				System.out.println("current hotel");
				System.out.println("+-----+-------+--- --+----------+--------------+");
				System.out.println("| hId | name | city | totalroom | avilable room");
				System.out.println("+-----+-------+--- --+----------+---------------+");
				while(rs.next()){
					int hId=rs.getInt("hId");
					String hName = rs.getString("hName");
					String hCity = rs.getString("hCity");
					int tRoom = rs.getInt("tRoom");
					int aRoom = rs.getInt("aRoom");
					
					Hotel hotel = new Hotel(hId,hName,hCity,tRoom,aRoom);
					System.out.println(hId+" "+hName+" "+hCity+" "+tRoom+" "+aRoom);
					
				}
				System.out.println("+-----+-------+--- --+------+-----+");
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
				
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hot;
	}

}
