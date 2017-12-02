import javax.swing.JFrame;

public class AircraftRental {
	public static void main(String []args){
		RentalManager rent =new RentalManager();
		RentalFrame frame =new RentalFrame(rent);
		
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
