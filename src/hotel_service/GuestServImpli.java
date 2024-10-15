package hotel_service;

import java.util.List;

import hotelDao.GuestDao;
import hotelDao.GuestDaoImpli;
import hotel_Exception.GuestException;
import hotel_model.Guest;

public class GuestServImpli implements GuestServ {
	GuestDao dao = new GuestDaoImpli();

	@Override
	public String addGuest(Guest g) throws GuestException {
		
        String msg=dao.addGuest(g);
		
		return msg;
	}

	@Override
	public String updateGuest(Guest g) throws GuestException {
		String msg=dao.updateGuest(g);
		return msg;
	}

	@Override
	public Guest getGuestId(int id) throws GuestException {
		// TODO Auto-generated method stub
		Guest msg = dao.getGuestId(id);
		return msg;
	}

	@Override
	public Guest deletebyid(int id) throws GuestException {
		// TODO Auto-generated method stub
		return dao.deletebyid(id);
	}

	@Override
	public List<Guest> getAllGuest() throws GuestException {
		// TODO Auto-generated method stub
		return dao.getAllGuest();
	}

}
