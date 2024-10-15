package hotel_service;

import java.util.List;

import hotelDao.BookDao;
import hotelDao.BookDaoImpli;
import hotel_Exception.BookException;
import hotel_model.Book;

public class BookServImpli implements BookServ {
      BookDao Dao= new BookDaoImpli();
	@Override
	public void bookRoom(Book b) throws BookException {
		// TODO Auto-generated method stub
		Dao.bookRoom(b);
	}

	@Override
	public List<Book> getBookingByGuestId(int guestId) throws BookException {
		// TODO Auto-generated method stub
		return Dao.getBookingByGuestId(guestId);
	}

	@Override
	public void cancelBooking(int roomId,int hotelId) throws BookException {
		// TODO Auto-generated method stub
		Dao.cancelBooking(roomId,hotelId);
		
	}

}
