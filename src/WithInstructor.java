import javax.swing.JOptionPane;

public class WithInstructor extends Flying {
	
public WithInstructor(String name, String startTime, String endTime, String flyingDate) {
	super(name, startTime, endTime, flyingDate);	
	JOptionPane.showMessageDialog(null, "WithInstructor class constructor");
	}
	public String calculate() {
		
		return "need some code here";
	}

}
