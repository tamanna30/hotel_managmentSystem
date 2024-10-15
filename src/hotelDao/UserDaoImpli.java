package hotelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hotel_model.User;
import hotel_utility.ConnHotel;

public class UserDaoImpli implements UserDao  {

	@Override
	public boolean signup(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO user (username, password, email) VALUES (?, ?, ?)";
		
		try(Connection conn= ConnHotel.getinstance().getConnection();
				PreparedStatement ppst  = conn.prepareStatement(sql)){
			 ppst.setString(1, user.getUsername());
	            ppst.setString(2, user.getPassword());  
	            ppst.setString(3, user.getEmail());
	            int rowsAffected = ppst.executeUpdate();
	            return rowsAffected > 0;  
			
		}
catch (SQLException e) {
            
            System.err.println("SQL error during signup: " + e.getMessage());
            throw e; 
        }
	
	}

	@Override
	public boolean login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		try(Connection conn= ConnHotel.getinstance().getConnection();
				PreparedStatement ppst  = conn.prepareStatement(sql)){
			 ppst.setString(1, username);
	            ppst.setString(2, password);
	            ResultSet rs = ppst.executeQuery();
	            return rs.next();  
		}
		catch (SQLException e) {
            System.err.println("SQL error during login: " + e.getMessage());
            throw e; 
        }
	}

}
