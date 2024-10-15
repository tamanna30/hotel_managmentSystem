package hotel_service;

import java.util.List;

import hotel_Exception.BookException;
import hotel_model.Book;

public interface BookServ {
	void bookRoom(Book b) throws BookException;
    List<Book> getBookingByGuestId(int guestId) throws BookException;
    void cancelBooking(int roomId,int hotelId) throws BookException;
}
