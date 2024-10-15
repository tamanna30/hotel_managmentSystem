package hotel_service;

import java.util.List;

import hotelDao.HotelDao;
import hotelDao.HotelDaoImpli;
import hotel_Exception.HotelException;
import hotel_model.Hotel;

public class HotelServImpli implements HotelServ {
    HotelDao Dao = new HotelDaoImpli();
	@Override
	public String addHotel(Hotel h) throws HotelException {
		// TODO Auto-generated method stub
		String msg = Dao.addHotel(h);
		return msg;
	}

	@Override
	public Hotel getHotelByCity(String city) throws HotelException {
		// TODO Auto-generated method stub
		Hotel msg = Dao.getHotelByCity(city);
		return msg;
	}

	@Override
	public List<Hotel> getAllHotel() throws HotelException {
		// TODO Auto-generated method stub
		return Dao.getAllHotel();
	}

}
