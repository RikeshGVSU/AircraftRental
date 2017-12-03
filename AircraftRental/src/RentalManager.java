import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

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
	
	public ArrayList<String> search(String data) throws IOException {
		String record;
		ArrayList<String> searchResults = new ArrayList<String>();
  		BufferedReader br = new BufferedReader( new FileReader("rentalLog.txt") );
  		while( ( record = br.readLine() ) != null ) {
  			
  			
  			
  			StringTokenizer st = new StringTokenizer(record,",");
  			if( record.contains(data) ) {
  				searchResults.add("| "+st.nextToken()+"	"+st.nextToken()+" "+st.nextToken()+" "+st.nextToken()+" "+st.nextToken()+" "+st.nextToken()+" "+st.nextToken()+" |\n");
  			}
 		
  		}
  		
  		br.close();
		return searchResults;

	}

}
