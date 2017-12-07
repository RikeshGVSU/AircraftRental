
public class FlyingSolo extends Flying {
	
	//FlyingSolo class constructor
	public FlyingSolo(String name, String startTime, String endTime, String flyingDate, String airCraft) {
		super(name, startTime, endTime, flyingDate, airCraft, totalFee);	
	}
	//This method calculates the total fee of the rental while flying solo
	public String calculate() {
		totalFee = 1;
		return "need some code here";
	}
	public String toString(){
		return  name + "," + startTime + "," + endTime + "," + flyingDate + ","  + airCraft + ","+ totalFee + ",Flying Solo";
	}

}