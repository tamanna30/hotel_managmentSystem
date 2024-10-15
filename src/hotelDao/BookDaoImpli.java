package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel_Exception.BookException;
import hotel_Exception.GuestException;
import hotel_model.Book;
import hotel_model.Guest;
import hotel_model.Room;
import hotel_utility.ConnHotel;

public class BookDaoImpli implements BookDao {

	@Override
	public void bookRoom(Book b) throws BookException {
		// TODO Auto-generated method stub
		String query="insert into book(bId , guestId,roomId,checkIn,CheckOut,hId) values(?,?,?,?,?,?)";
		 String updateRoom = "UPDATE room SET rStatus = ? WHERE rId = ?";
		 String updateHotel="update hotel set aRoom = aRoom - ? where hId = ?";
		try {
			Connection conn= ConnHotel.getinstance().getConnection();
			PreparedStatement ppst  = conn.prepareStatement(query);
//			ppst.setString(1, r.getrType());
			ppst.setInt(1, b.getbId());
			ppst.setInt(2, b.getGuestId());
			ppst.setInt(3, b.getRoomId());
			ppst.setString(4, b.getCheckIn());
			ppst.setString(5, b.getCheckOut());
			ppst.setInt(6, b.gethId());
            int x= ppst.executeUpdate();
			
			if(x>0){
				System.out.println("data inserted");
			}
			 PreparedStatement Update = conn.prepareStatement(updateRoom);
		        Update.setString(1, "Booked");  
		        Update.setInt(2, b.getRoomId());
		        int Res = Update.executeUpdate(); 
		        if (Res <= 0) {
		            throw new BookException("Failed to update the room status.");
		        }
		        
		        PreparedStatement Update1 = conn.prepareStatement(updateHotel); 
		        Update1.setInt(1, 1);
		        Update1.setInt(2, b.gethId());
		        int Res1 = Update1.executeUpdate(); 
		        if (Res1 <= 0) {
		            throw new BookException("Failed to update the available room.");
		        }
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> getBookingByGuestId(int guestId) throws BookException {
		// TODO Auto-generated method stub
		String query="select bId,guestid,roomId,bookDate,checkIn,checkOut,hId from book where guestId = ?";
		List<Book> bk=new ArrayList<>();
		try(Connection conn= ConnHotel.getinstance().getConnection()){
			if(conn==null){
				throw new GuestException("failed to make connection");
				}
			try( PreparedStatement ppst  = conn.prepareStatement(query);
					)
			
			{ppst.setInt(1, guestId);
			ResultSet rs = ppst.executeQuery();
				System.out.println("current booking ");
				System.out.println("+-----+---------+----- --+----------+---------+---------+------+");
				System.out.println("| bId | guestid | roomId | bookDate | checkIn | checkOut| hId |");
				System.out.println("+-----+---------+----- --+----------+---------+---------+-------+");
				while(rs.next()){
					int bId=rs.getInt("bId");
					int guesId = rs.getInt("guestId");
					int roomId = rs.getInt("roomId");
					String bookDate = rs.getString("bookDate");
					String CheckIn = rs.getString("checkIn");
					String CheckOut = rs.getString("CheckOut");
					int hId= rs.getInt("hId");
					
					Book book = new Book(bId,guesId,roomId,bookDate,CheckIn,CheckOut,hId);
					System.out.println(bId+"   "+guesId+"    "+roomId+"     "+bookDate+"     "+CheckIn+"     "+CheckOut+"  "+hId);
					
				}
				System.out.println("+-----+---------+----- --+----------+---------+---------+----------+");
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
				
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bk;
	}

	@Override
	public void cancelBooking(int roomId,int hotelId) throws BookException {
		// TODO Auto-generated method stub
		String delete = "DELETE FROM book WHERE roomId = ?";
		String updateRoom = "UPDATE room SET rStatus = ? WHERE rId = ?";
		String updateHotel="update hotel set aRoom = aRoom + ? where hId = ?";
		Book book = null;
		
		try(Connection conn= ConnHotel.getinstance().getConnection();
				PreparedStatement canbook = conn.prepareStatement(delete)){
			canbook.setInt(1,roomId);
			  int rowsAffected = canbook.executeUpdate();
			  if (rowsAffected > 0) {
		            book = new Book();  
		            book.setRoomId(roomId);
		            System.out.println("Booking with ID " + roomId + " Cancel Successfully.");
		        } else {
		            System.out.println("No found  Booking  with ID " + roomId+ " Cancel failed.");
		        }
			  PreparedStatement psUpdate = conn.prepareStatement(updateRoom);
			  psUpdate.setString(1, "Available");  
		        psUpdate.setInt(2, roomId);
		        int updateResult = psUpdate.executeUpdate();
		        if (updateResult <= 0) {
		            throw new BookException("Failed to update room status.");
		        }
		        PreparedStatement Update1 = conn.prepareStatement(updateHotel); 
		        Update1.setInt(1, 1);
		        Update1.setInt(2, hotelId);
		        int Res1 = Update1.executeUpdate(); 
		        if (Res1 <= 0) {
		            throw new BookException("Failed to update the available room.");
		        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
