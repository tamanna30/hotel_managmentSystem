package hotel_service;

import java.util.List;

import hotelDao.RoomDao;
import hotelDao.RoomDaoImpli;
import hotel_Exception.RoomException;
import hotel_model.Room;

public class RoomServImpli implements RoomServ {
   RoomDao Dao = new RoomDaoImpli();
	@Override
	public String addRoom(Room r) throws RoomException {
		// TODO Auto-generated method stub
       String msg = Dao.addRoom(r);
		
		return msg;
		
	}

	

	@Override
	public Room getRoomById(int id) throws RoomException {
		// TODO Auto-generated method stub
		Room msg = Dao.getRoomById(id);
		return msg;
	}

	@Override
	public List<Room> getAllRoom() throws RoomException {
		// TODO Auto-generated method stub
		return Dao.getAllRoom();
	}

}
