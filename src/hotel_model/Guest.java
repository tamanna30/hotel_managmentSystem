package hotel_model;

public class Guest {
   private int gId;
   private String gName;
   private String gPhone;
   private String gEmail;
   private String gAdd;
public int getgId() {
	return gId;
}
public void setgId(int gId) {
	this.gId = gId;
}
public String getgName() {
	return gName;
}
public void setgName(String gName) {
	this.gName = gName;
}
public String getgPhone() {
	return gPhone;
}
public void setgPhone(String gPhone) {
	this.gPhone = gPhone;
}
public String getgEmail() {
	return gEmail;
}
public void setgEmail(String gEmail) {
	this.gEmail = gEmail;
}
public String getgAdd() {
	return gAdd;
}
public void setgAdd(String gAdd) {
	this.gAdd = gAdd;
}
public Guest(int gId, String gName, String gPhone, String gEmail, String gAdd) {
	super();
	this.gId = gId;
	this.gName = gName;
	this.gPhone = gPhone;
	this.gEmail = gEmail;
	this.gAdd = gAdd;
}

public Guest(){
	
}
   
}
