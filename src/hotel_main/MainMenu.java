package hotel_main;

import java.sql.SQLException;
import java.util.Scanner;

import hotelDao.UserDao;
import hotelDao.UserDaoImpli;
import hotel_model.User;

public class MainMenu {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpli(); 
		while (true) {  
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
            case 1: 
                System.out.print("Enter Username: ");
                String loginUsername = sc.nextLine();
                System.out.print("Enter Password: ");
                String loginPassword = sc.nextLine();
                boolean loggedIn = false;
                try {
                    loggedIn = userDao.login(loginUsername, loginPassword);
                }
                catch (SQLException e) {
                    System.out.println("Error during login: " + e.getMessage());
                }
                
                if (loggedIn) {
                    System.out.println("Login Successful!");
                    showMainMenu();  // call all menu 
                } else {
                    System.out.println("Invalid Credentials. Please try again.");
                }
                break;
                
            case 2: 
                User newUser = new User();
                System.out.print("Enter Username: ");
                newUser.setUsername(sc.nextLine());
                System.out.print("Enter Password: ");
                newUser.setPassword(sc.nextLine()); 
                System.out.print("Enter Email: ");
                newUser.setEmail(sc.nextLine());  
                try {
                    userDao.signup(newUser);  
                    System.out.println("Signup Successful!");
                } catch (SQLException e) {
                    System.out.println("Error during signup: " + e.getMessage());
                }
                break;
                
            case 3:
                System.out.println("Exiting...");
                sc.close();
                return;  
            default:  
                System.out.println("Invalid choice. Please try again.");
            }}
	}
	
	 private static void showMainMenu() 
	 {
		// TODO Auto-generated constructor stub
	
		BookMain b = new BookMain();
		RoomMain r = new RoomMain();
		GuestMain g = new GuestMain();
		HotelMain h = new HotelMain();
		while(true){
			System.out.println("press 1 for Guest releted Staff \n"+
					"press 2 for Room releted Staff \n"+
					"press 3 for Booking releted Staff \n"+
					"press 4 for hotel releted Staff \n"+
					"press 5 for return"
					);
			
			int choice = sc.nextInt();
			switch(choice){
			case 1:
				g.guestOpen();
				break;
			case 2:		
			  r.roomOpen();
			  break;
			case 3:		
				  b.bookOpen();
				  break;
				  
			case 4:
				h.hotelOpen();
				break;
			case 5:
				return;
			
			}
		}
	}
}
