package hotelDao;

import java.util.List;
import hotel_Exception.HotelException;
import hotel_model.Hotel;

public interface HotelDao {
	public String addHotel(Hotel h) throws HotelException ;
	public Hotel getHotelByCity(String city) throws HotelException ;
	public List<Hotel> getAllHotel() throws HotelException;
}
