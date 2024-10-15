package hotel_main;

import java.util.List;
import java.util.Scanner;

import hotel_model.Guest;
import hotel_model.Hotel;
import hotel_service.HotelServ;
import hotel_service.HotelServImpli;


public class HotelMain {
	private static Scanner sc = new Scanner(System.in);
	private static HotelServ  Hoteluse = new HotelServImpli();
	public  void hotelOpen() {
		while(true){
 		   System.out.println("press 1 for add hotel \n"+
 				  "press 2 get hotel by city name \n"+
 				 "press 3 to get all hotel \n"+
 				  "prees 4 for return"
 				   
						);
 		   
 		   int choice= sc.nextInt();
 		   switch(choice){
 		      case 1: 
 			      System.out.println("ooh you want to insert hotel");
 			      
 			      Hotel h = new Hotel();
 			      System.out.println("enter your hotel id");
 			      h.sethId(sc.nextInt());
 			      System.out.println("enter your hotel name");
 			      h.sethName(sc.next());
 			      System.out.println("enter  hotel city");
 			      h.sethCity(sc.next());
 			      System.out.println("enter total room of hotel");
 			      h.settRoom(sc.nextInt());
 			      System.out.println("enter available room of hotel ");
 			      h.setaRoom(sc.nextInt());
 			      
 			     String ans = Hoteluse.addHotel(h);
 			     System.out.println(ans);
 			      break;
 			      
 		      case 2:
 		    	 System.out.println("enter city name ");
			      String city=sc.next();
			      Hotel hotel = Hoteluse.getHotelByCity(city);
 		    	  break;
 		    	  
 		      case 3:
 		    	 List<Hotel> hh = Hoteluse.getAllHotel();
 		    	  break;
 		    	  
 		     case 4:
		    	  return;	  
 			  
	}
}
}
	
}