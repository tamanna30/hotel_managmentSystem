package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel_Exception.GuestException;
import hotel_model.Guest;
import hotel_utility.ConnHotel;

public class GuestDaoImpli implements GuestDao {

	@Override
	public String addGuest(Guest g) throws GuestException {
		String query="insert into guest values(?,?,?,?,?)";
		String msg=null;
	
		try {
			Connection conn= ConnHotel.getinstance().getConnection();
			PreparedStatement ppst  = conn.prepareStatement(query);
			ppst.setInt(1, g.getgId());
			ppst.setString(2, g.getgName());
			ppst.setString(3,g.getgPhone());
			ppst.setString(4,g.getgEmail());
			ppst.setString(5,g.getgAdd());
			
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
	public String updateGuest(Guest g) throws GuestException {
		// TODO Auto-generated method stub
		String query="update guest set gName = ? where gId = ?";
		String msg=null;
		
		
		try {
			Connection conn= ConnHotel.getinstance().getConnection();
			PreparedStatement ppst  = conn.prepareStatement(query);
			ppst.setString(1, g.getgName());
			ppst.setInt(2, g.getgId());
			
			int rowsAffected = ppst.executeUpdate();
			if(rowsAffected >0){
				msg="update sucessfully";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
		
	}

	@Override
	public Guest getGuestId(int id) throws GuestException {
		// TODO Auto-generated method stub
		String query="select gId,gName,gPhone,gEmail,gAdd from guest where gId = ?";
		Guest guest=null;
		
		
		try {
			Connection conn= ConnHotel.getinstance().getConnection();
			PreparedStatement ppst  = conn.prepareStatement(query);
			
			ppst.setInt(1, id);
			
			try(ResultSet rs = ppst.executeQuery()){
				
					System.out.println("+-----+-------+--- --+------+-----+");
					System.out.println("| gId | name | phone | email | add");
					System.out.println("+-----+-------+--- --+------+-----+");
					if(rs.next()){
					int gId=rs.getInt("gId");
					String gName = rs.getString("gName");
					String gPhone = rs.getString("gPhone");
					String gEmail = rs.getString("gEmail");
					String gAdd = rs.getString("gAdd");
					
					guest = new Guest(gId,gName,gPhone,gEmail,gAdd);
//					System.out.println("| %-10d | %-5s | %-5s| %-5s | %-5s |\n"+gId+gName+gPhone+gEmail+gAdd);
					System.out.println(gId+" "+gName+" "+gPhone+" "+gEmail+" "+gAdd);
					System.out.println("+-----+-------+--- --+------+-----+");
					
				}
				else{
					System.out.println("gest id with"+id+"not found");
				}
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return guest;
	}

	@Override
	public Guest deletebyid(int id) throws GuestException {
		// TODO Auto-generated method stub
		String query="delete from guest where gId=?";
         try(Connection conn= ConnHotel.getinstance().getConnection()){
        	 PreparedStatement ppst  = conn.prepareStatement(query);
        	 ppst.setInt(1, id);
        	 int result = ppst.executeUpdate();
        	 if(result>0){
        		 System.out.println("guest is deleted succesfully");
        	 }
        	 else{
        		 throw new GuestException("guest not found with this id");
        	 }
         } 
         catch (SQLException e) {
			// TODO Auto-generated catch block
        	 throw new GuestException("eroor deleting guest "+ e.getMessage());
		
		}
		return null;
	}

	@Override
	public List<Guest> getAllGuest() throws GuestException {
		// TODO Auto-generated method stub
		String query="select gId,gName,gPhone,gEmail,gAdd from guest";
		List<Guest> gus=new ArrayList<>();
		
		try(Connection conn= ConnHotel.getinstance().getConnection()){
			if(conn==null){
				throw new GuestException("failed to make connection");
				}
			try( PreparedStatement ppst  = conn.prepareStatement(query);
					ResultSet rs = ppst.executeQuery())
			{
				System.out.println("current guest");
				System.out.println("+-----+-------+--- --+------+-----+");
				System.out.println("| gId | name | phone | email | add");
				System.out.println("+-----+-------+--- --+------+-----+");
				while(rs.next()){
					int gId=rs.getInt("gId");
					String gName = rs.getString("gName");
					String gPhone = rs.getString("gPhone");
					String gEmail = rs.getString("gEmail");
					String gAdd = rs.getString("gAdd");
					Guest guest = new Guest(gId,gName,gPhone,gEmail,gAdd);
					System.out.println(gId+" "+gName+" "+gPhone+" "+gEmail+" "+gAdd);
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
		
		return gus;
	}

}
