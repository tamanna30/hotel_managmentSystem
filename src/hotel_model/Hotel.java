package hotel_model;

public class Hotel {
 private int hId;
 private String hName;
 private String hCity;
 private int tRoom;
 private int aRoom;
public int gethId() {
	return hId;
}
public void sethId(int hId) {
	this.hId = hId;
}
public String gethName() {
	return hName;
}
public void sethName(String hName) {
	this.hName = hName;
}
public String gethCity() {
	return hCity;
}
public void sethCity(String hCity) {
	this.hCity = hCity;
}
public int gettRoom() {
	return tRoom;
}
public void settRoom(int tRoom) {
	this.tRoom = tRoom;
}
public int getaRoom() {
	return aRoom;
}
public void setaRoom(int aRoom) {
	this.aRoom = aRoom;
}
public Hotel(int hId, String hName, String hCity, int tRoom, int aRoom) {
	super();
	this.hId = hId;
	this.hName = hName;
	this.hCity = hCity;
	this.tRoom = tRoom;
	this.aRoom = aRoom;
}
public Hotel(){
	
}

}
