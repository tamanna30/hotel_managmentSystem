package hotel_main;

import java.util.List;
import java.util.Scanner;

import hotel_model.Guest;
import hotel_model.Room;
import hotel_service.RoomServ;
import hotel_service.RoomServImpli;

public class RoomMain {
	private static Scanner sc = new Scanner(System.in);
	private static RoomServ  Roomuse = new RoomServImpli();
    public void roomOpen()  {
    	while(true){
    		System.out.println("press 1 for add room  \n"+
 				   "press 2 for get room by id  \n"+
 				   "press 3 for get all rooms  \n"+
 				  "press 4 for return to main menu  \n");
    		int choice= sc.nextInt();
 		   switch(choice){
 		      case 1: 
 			      System.out.println("ooh you want to insert daata");
 			      
 			      Room r = new Room();

 			      System.out.println("enter your room type");
 			      r.setrType(sc.next());
 			      System.out.println("enter your room prize");
 			      r.setrPrize(sc.nextInt());
 			     System.out.println("enter your hotel id");
			      r.sethId(sc.nextInt());

 			      
 			     String ans= Roomuse.addRoom(r);
 			     System.out.println(ans);
 			      break;
 			      
 		      case 2:
 		    	 System.out.println("enter room id for retirive");
			      int rid=sc.nextInt();
			      Room room  = Roomuse.getRoomById(rid);
			      break;
			    
 		      case 3:
 		    	  List<Room> ro = Roomuse.getAllRoom();
 		    	 break;
 		    	 
 		     case 4:
		    	  return;	 
 			  
    	}
      }
}
    
    
}