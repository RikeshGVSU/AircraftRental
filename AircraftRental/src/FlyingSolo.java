import javax.swing.JOptionPane;

public class FlyingSolo extends Flying {
	
	public FlyingSolo(String name, String startTime, String endTime, String flyingDate, String airCraft) {
		super(name, startTime, endTime, flyingDate, airCraft, totalFee);	
		JOptionPane.showMessageDialog(null, "Flying Solo class constructor");
	}
	public String calculate() {
		totalFee = 1;
		return "need some code here";
	}
	public String toString(){
		return  name + "," + startTime + "," + endTime + "," + flyingDate + ","  + airCraft + ","+ totalFee + ",Flying Solo";
	}

}
