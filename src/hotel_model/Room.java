package hotel_model;

public class Room {
	private int rId;
	   private String rType;
	   private int rPrize;
	   private String rStatus;
	   private int hId;
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrType() {
		return rType;
	}
	public void setrType(String rType) {
		this.rType = rType;
	}
	public int getrPrize() {
		return rPrize;
	}
	public void setrPrize(int rPrize) {
		this.rPrize = rPrize;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	public Room(int rId, String rType, int rPrize, String rStatus ,int hId) {
		super();
		this.rId = rId;
		this.rType = rType;
		this.rPrize = rPrize;
		this.rStatus = rStatus;
		this.hId=hId;
	}
	public Room(){
		
	}
	   
}
