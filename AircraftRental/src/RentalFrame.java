import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class RentalFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JRadioButton solo, withInstructor;
	private JLabel name,startTime,endTime, aircraft, flying, flightDate, search;
	private JTextField nameInput,startTimeInput,endTimeInput, flightDateInput, searchInput;
	private JComboBox<Object> comboBox;
	private JButton submit,history,clear, selectNext, update;
	private ButtonGroup group;
	private JTextArea details;
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
	String filename = "RentalDetails.txt";
	
	private RentalManager manager;
	
	ButtonListener handler = new ButtonListener();
	
	public RentalFrame(RentalManager manage) {
		super("Husky Air Aircraft Rental Log");
		
		this.manager = new RentalManager();

		createControlPanel();
		setSize(800,500);
		selectNext.setEnabled(false);
		update.setEnabled(false);
		
		
	}
	
	private class ButtonListener implements ActionListener {
		
		ArrayList<String> searchResults = new ArrayList<String>();
		private int i;
		
		public void actionPerformed (ActionEvent event) {
			if(event.getSource()== submit){
				if(!nameInput.getText().equals("") && !startTimeInput.getText().equals("") &&  !endTimeInput.getText().equals("") && !flightDateInput.getText().equals("") )
				{
					String name = nameInput.getText();
					String startTime = startTimeInput.getText();
					String endTime = endTimeInput.getText();
					String flightDate = flightDateInput.getText();
					String airCraft = (String) comboBox.getSelectedItem();

					if (solo.isSelected()){
						FlyingSolo fs = new FlyingSolo(name,startTime,endTime,flightDate, airCraft);
						fs.calculate();
						try {
							manager.add(fs);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else if (withInstructor.isSelected()){
						WithInstructor wi = new WithInstructor(name,startTime,endTime,flightDate, airCraft);
						wi.calculate();
						try {
							manager.add(wi);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else JOptionPane.showMessageDialog(null, "Select Flying solo or with Instructor");
				}
			
				else
				{
					JOptionPane.showMessageDialog(null, "Some Fields are missing");				   
				}
			}
			else if (event.getSource() == history) {
				if(!searchInput.getText().equals("")) {
					searchResults.clear();
					try {
						searchResults = manager.search(searchInput.getText());
					} catch (IOException e) {
						e.printStackTrace();
					}
					details.setText(searchResults.toString());
					selectNext.setEnabled(true);
					update.setEnabled(true);
					i = -1;
					
				}
				else JOptionPane.showMessageDialog(null, "Input something to search");
				submit.setEnabled(false);
				
			}
			else if (event.getSource() == selectNext) {
				if (i < searchResults.size() - 1){
					i++;
					details.setText(searchResults.get(i).toString());
					StringTokenizer st = new StringTokenizer(searchResults.get(i).toString(),",");
					nameInput.setText(st.nextToken());
					startTimeInput.setText(st.nextToken());
					endTimeInput.setText(st.nextToken());
					flightDateInput.setText(st.nextToken());
					comboBox.setSelectedItem(st.nextToken());
					st.nextToken();
					String checkRedio = st.nextToken();
					if (checkRedio ==  "Flying Solo \n") solo.setSelected(true);
					else withInstructor.setSelected(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "That was the last value");
					i = -1;
				}
				
			}
			else if (event.getSource() == update) {
				if(!nameInput.getText().equals("") && !startTimeInput.getText().equals("") &&  !endTimeInput.getText().equals("") && !flightDateInput.getText().equals("") )
				{
					String name = nameInput.getText();
					String startTime = startTimeInput.getText();
					String endTime = endTimeInput.getText();
					String flightDate = flightDateInput.getText();
					String airCraft = (String) comboBox.getSelectedItem();
					Boolean conformation;
					String newData = null;
					
					if (solo.isSelected()){
						FlyingSolo fs = new FlyingSolo(name,startTime,endTime,flightDate, airCraft);
						fs.calculate();
						newData = fs.toString();
					}
					else if (withInstructor.isSelected()){
						WithInstructor wi = new WithInstructor(name,startTime,endTime,flightDate, airCraft);
						wi.calculate();
						newData = wi.toString();
					}
					else JOptionPane.showMessageDialog(null, "Select Flying solo or with Instructor");
					if (newData != null) {
						try {
							conformation = manager.update(searchResults.get(i).toString(), newData);
						} catch (IOException e) {
							e.printStackTrace();
						}
						if (conformation = true ) details.setText("Data Updated");
						else details.setText("Data Could nopt be updated");
					}
					else JOptionPane.showMessageDialog(null, "newData has null value");
				}
				else JOptionPane.showMessageDialog(null, "Some Fields are missing");
			}
			else if (event.getSource() == clear) {
				nameInput.setText("");
				group.clearSelection();
				startTimeInput.setText("");
				endTimeInput.setText("");
				flightDateInput.setText("");
				details.setText("");
				selectNext.setEnabled(false);
				update.setEnabled(false);
				submit.setEnabled(true);
			}
		}
	}
	
	public void createControlPanel()
	{
		JPanel panel1 = panel1();
		JPanel panel2 = panel2();
		JPanel panel3 = panel3();
		JPanel panel4 = panel4();
		JPanel panel5 = panel5();
		JPanel panel6 = panel6();
		JPanel panel7 = panel7();
		JPanel panel8 = panel8();
		JPanel panel9 = panel9();
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(10,10));
		controlPanel.add(panel1);
		controlPanel.add(panel2);
		controlPanel.add(panel3);
		controlPanel.add(panel4);
		controlPanel.add(panel5);
		controlPanel.add(panel6);
		controlPanel.add(panel7);
		controlPanel.add(panel8);
		controlPanel.add(panel9);
			
		add(controlPanel);
	}
	
	public JPanel panel1(){
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		
		name=new JLabel("Pilot's Name: ");
		nameInput=new JTextField(20);
//		nameInput.addActionListener(handler);
		
		panel1.add(name);
		panel1.add(nameInput);
		
		return panel1;
	}
	public JPanel panel2() {
		
		
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		flying = new JLabel("Flying: ");
		
		solo=new JRadioButton("Fly Solo");
//		solo.addActionListener(handler);
		solo.setActionCommand("Fly Solo");
		
		withInstructor= new JRadioButton("With Instructor");
//		withInstructor.addActionListener(handler);
		withInstructor.setActionCommand("With Instructor");
		
		group=new ButtonGroup();
		group.add(solo);
		group.add(withInstructor);
		
		panel2.add(flying);
		panel2.add(solo);
		panel2.add(withInstructor);
		
		return panel2;
	}
	
	public JPanel panel3() {
		
		
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		
		aircraft = new JLabel("Select aircraft:");
		
		String[] aircrafts = {"aircraft1", "aircraft2", "aircraft3"};
		
		comboBox = new JComboBox<Object>(aircrafts);
//		comboBox.addActionListener(handler);
		
		panel3.add(aircraft);
		panel3.add(comboBox);
		
		return panel3;
		
		
		
	}
	
	public JPanel panel4() {
		
		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		
		startTime = new JLabel("Flight Start Time: ");
		startTimeInput = new JTextField(20);
//		startTimeInput.addActionListener(handler);
		
		panel4.add(startTime);
		panel4.add(startTimeInput);
		
		return panel4;
		
	}
	public JPanel panel5() {
		
		panel5 = new JPanel();
		panel5.setLayout(new FlowLayout());
		
		endTime = new JLabel("Flight End Time: ");
		endTimeInput = new JTextField(20);
//		endTimeInput.addActionListener(handler);
		
		panel5.add(endTime);
		panel5.add(endTimeInput);
		
		return panel5;
		
	}
	
	public JPanel panel6() {
		
		panel6 = new JPanel();
		panel6.setLayout(new FlowLayout());
		
		flightDate = new JLabel("Flight Date: ");
		flightDateInput = new JTextField(20);
//		flightDateInput.addActionListener(handler);
		
		panel6.add(flightDate);
		panel6.add(flightDateInput);
		
		return panel6;
		
	}
	public JPanel panel7(){
		panel7 = new JPanel();
		panel7.setLayout(new FlowLayout());
		
		submit = new JButton("Submit");
		submit.addActionListener(handler);
		
		clear = new JButton("Clear");
		clear.addActionListener(handler);
		
		panel7.add(submit);
		panel7.add(clear);
		
		return panel7;
	}
	public JPanel panel8(){
		panel8 = new JPanel();
		panel8.setLayout(new FlowLayout());
		
		search = new JLabel("Search: ");
		searchInput=new JTextField(20);
//		nameInput.addActionListener(handler);
		
		history = new JButton("Previous Rentals");
		history.addActionListener(handler);
		
		selectNext = new JButton("Select next data");
		selectNext.addActionListener(handler);
		
		update = new JButton("Update Data");
		update.addActionListener(handler);
		
		panel8.add(search);
		panel8.add(searchInput);
		panel8.add(history);
		panel8.add(selectNext);
		panel8.add(update);
		
		return panel8;
	}
	public JPanel panel9() {
		panel9 = new JPanel();
		panel9.setLayout(new FlowLayout());
		
		details = new JTextArea(10,40);
		details.setEditable(false);
		JScrollPane scroll = new JScrollPane(details);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		
		
		//summaryPanel.add(summary);
		panel9.add(scroll);
		return panel9;
	}
	
}
