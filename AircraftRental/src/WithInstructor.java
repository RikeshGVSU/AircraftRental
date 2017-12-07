
public class WithInstructor extends Flying {
	
	//WithInstructor class constructor
	public WithInstructor(String name, String startTime, String endTime, String flyingDate, String airCraft) {
		super(name, startTime, endTime, flyingDate, airCraft, totalFee);	
	}
	
	// this method calculates the total fee of the rental while flying with Instructor
	public String calculate() {
		totalFee = 2;
		return "need some code here";
	}
	public String toString(){
		return  name + "," + startTime + "," + endTime + "," + flyingDate + "," + airCraft + "," + totalFee + ",Flying With Instructor";
	}

}
