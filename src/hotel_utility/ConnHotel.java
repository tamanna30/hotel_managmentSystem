package hotel_utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnHotel {
	public static ConnHotel obj = null;
    private ConnHotel(){
	 
       }
    public Connection getConnection() {
    	 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 Connection conn= null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel"
							+ "","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return conn ;
    }
   
    public static ConnHotel getinstance(){
   	 if (obj==null){
   		 obj= new ConnHotel();
   	 }
		return obj;
   	 
    }
}
