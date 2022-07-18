package electricity;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Paytm extends JFrame implements ActionListener{

	String meter;
	JButton btnBack;
	Paytm(String meter){
		this.meter = meter;
		
		JEditorPane edit_panel = new JEditorPane();
		edit_panel.setEditable(false);
		
		try {
			edit_panel.setPage("https://paytm.com/online-payments");
		} catch (Exception e) {
			edit_panel.setContentType("text/html");
			edit_panel.setText("<html>Could not load<html>");
			
		}
		
		JScrollPane scPane = new JScrollPane(edit_panel);
		add(scPane);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(640, 20, 80, 20);
		btnBack.addActionListener(this);
		edit_panel.add(btnBack);
		
		setSize(800, 600);
	    setLocation(400, 150);
	    setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new PayBill(meter);
		
	}
	
	public static void main(String[] args) {
		new Paytm("");

	}
	

}
