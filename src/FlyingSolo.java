import javax.swing.JOptionPane;

public class FlyingSolo extends Flying {
	
	public FlyingSolo(String name, String startTime, String endTime, String flyingDate) {
		super(name, startTime, endTime, flyingDate);	
		JOptionPane.showMessageDialog(null, "Flying Solo class constructor");
	}
	public String calculate() {
		
		return "need some code here";
	}

}
