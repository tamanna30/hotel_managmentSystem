package hotelDao;

import java.util.List;

import hotel_Exception.RoomException;
import hotel_model.Room;



public interface RoomDao {
	public String addRoom(Room r) throws RoomException ;
	public Room getRoomById(int id) throws RoomException ;
	public List<Room> getAllRoom() throws RoomException;
}
