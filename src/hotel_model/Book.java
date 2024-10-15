package hotel_model;

public class Book {
	private int bId;
	   private int guestId;
	   private int roomId;
	   private String bookDate;
	   private String checkIn;
	   private String checkOut;
	   private int hId;
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public Book(int bId, int guestId, int roomId, String bookDate, String checkIn, String checkOut,int hId) {
		super();
		this.bId = bId;
		this.guestId = guestId;
		this.roomId = roomId;
		this.bookDate = bookDate;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.hId=hId;
	}
	public Book(){
		
	}
	
	   
}
