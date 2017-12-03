import javax.swing.JOptionPane;

public class WithInstructor extends Flying {
	
public WithInstructor(String name, String startTime, String endTime, String flyingDate, String airCraft) {
	super(name, startTime, endTime, flyingDate, airCraft, totalFee);	
	JOptionPane.showMessageDialog(null, "WithInstructor class constructor");
	}
	public String calculate() {
		totalFee = 2;
		return "need some code here";
	}
	public String toString(){
		return  name + "," + startTime + "," + endTime + "," + flyingDate + "," + airCraft + "," + totalFee + ",Flying With Instructor";
	}

}
