package hotel_main;

import java.util.List;
import java.util.Scanner;

import hotel_model.Book;
import hotel_model.Guest;
import hotel_service.BookServ;
import hotel_service.BookServImpli;


public class BookMain {
	private static Scanner sc = new Scanner(System.in);
	private static BookServ  Bookuse = new BookServImpli();
	public  void bookOpen() {
		while(true){
			System.out.println("press 1 for book room  \n"+
					"press 2 to get all booking by guest id  \n"+
					"press 3 for cancle booking  \n"+
					"press 4 for return   \n"
					);
			int choice= sc.nextInt();
			switch(choice){
		      case 1: 
			      System.out.println("ooh you want to book room");
			      
			      Book b = new Book();

			      System.out.println("enter your booking id ");
			      b.setbId(sc.nextInt());
			      System.out.println("enter your guest id ");
			      b.setGuestId(sc.nextInt());
			      System.out.println("enter your room id  ");
			      b.setRoomId(sc.nextInt());
			      System.out.println("enter your check in date  ");
			      b.setCheckIn(sc.next());
			      System.out.println("enter your check out date  ");
			      b.setCheckOut(sc.next());
			      System.out.println("enter your hotel id");
			      b.sethId(sc.nextInt());
			      
			     Bookuse.bookRoom(b);
			     
			      break;
			      
		      case 2: 
		    	  System.out.println("enter guest id for retirive");
			      int guestid=sc.nextInt();
		    	  List<Book> bk = Bookuse.getBookingByGuestId(guestid);
		    	  break;
		      case 3:
		    	  Book book3 = new Book();
					System.out.println("Enter room Id");
					book3.setRoomId(sc.nextInt());
					System.out.println("Enter hotel Id");
					book3.sethId(sc.nextInt());
					Bookuse.cancelBooking(book3.getRoomId(),book3.gethId());
		    	  break;
		      case 4:
		    	  return;		  
		     
		}}
	}
	
	
}
