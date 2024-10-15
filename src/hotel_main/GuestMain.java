package hotel_main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hotel_model.Guest;
import hotel_service.GuestServ;
import hotel_service.GuestServImpli;



public class GuestMain {
	private static Scanner sc = new Scanner(System.in);
	private static GuestServ  Guestuse = new GuestServImpli();
       public  void guestOpen() {
    	   
    	 		
    	   while(true){
    		   System.out.println("press 1 for add guest  \n"+
    				   "press 2 for update guest  \n"+
    				   "press 3 for get guest by id  \n"+
    				   "press 4 for delete guest  \n"+
    				   "press 5 for all guest list  \n"+
    				   "press 6 for return to main menu  \n"
						);
    		   
    		   int choice= sc.nextInt();
    		   switch(choice){
    		      case 1: 
    			      System.out.println("ooh you want to insert daata");
    			      
    			      Guest g = new Guest();
    			      System.out.println("enter your id");
    			      g.setgId(sc.nextInt());
    			      System.out.println("enter your name");
    			      g.setgName(sc.next());
    			      System.out.println("enter your phone");
    			      g.setgPhone(sc.next());
    			      System.out.println("enter your email");
    			      g.setgEmail(sc.next());
    			      System.out.println("enter your add");
    			      g.setgAdd(sc.next());
    			      
    			     String ans= Guestuse.addGuest(g);
    			     System.out.println(ans);
    			      break;
    			  
    		      case 2: 
                       System.out.println("ooh you want to update daata");
    			      
    			      Guest g1 = new Guest();
    			      System.out.println("enter your id");
    			      g1.setgId(sc.nextInt());
    			      System.out.println("enter your name");
    			      g1.setgName(sc.next());
    			      String up=Guestuse.updateGuest(g1);
    			      System.out.println(up);
    			      break;
    		      case 3:     
    			      System.out.println("enter guest id for retirive");
    			      int gid=sc.nextInt();
    			      Guest guest = Guestuse.getGuestId(gid);
    			      break;
    			    
    		      case 4:
    		    	  System.out.println("enter guest id that you want to delete");
    		    	  int gid1= sc.nextInt();
    		    	  Guest guest1=Guestuse.deletebyid(gid1);
    		    	  break;
    		    	  
    		      case 5:
    		    	  List<Guest> gust = Guestuse.getAllGuest();
    		    	  break;
    		    	  
    		      case 6:
    		    	  return;
    		    	  
    		   }
    		   
    	   }
    	   
	}
       
}
