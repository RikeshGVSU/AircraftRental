import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalManager {
	private ArrayList<Flying> rentalLog;
	
	public RentalManager() {
		rentalLog = new ArrayList<Flying>();
	}

	public void add(FlyingSolo fs) throws IOException {
		BufferedWriter bw = new BufferedWriter( new FileWriter("rentalLog.txt",true) );	
		   		
		bw.write(fs.toString());
		bw.flush();
		bw.newLine();
		bw.close();		
		
	}
	
	public void add(WithInstructor fs) throws IOException {
		BufferedWriter bw = new BufferedWriter( new FileWriter("rentalLog.txt",true) );	
		   		
		bw.write(fs.toString());
		bw.flush();
		bw.newLine();
		bw.close();		
		
	}

}
