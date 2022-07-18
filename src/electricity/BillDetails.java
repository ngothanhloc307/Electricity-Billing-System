package electricity;

import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class BillDetails extends JFrame {

	private String meter;
	private DefaultTableModel model_table;
	private JTable table;
	private JScrollPane scroll_table;
	BillDetails(String meter){
		super("Bill Details");
		this.meter = meter;
		setSize(700, 500);
		setLocation(400,150);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		table = new JTable();
		model_table = new DefaultTableModel();
		model_table.addColumn("Meter Number");
	    model_table.addColumn("Moth");
	    model_table.addColumn("Unit");
	    model_table.addColumn("Total Bill");
	    model_table.addColumn("Status");
	    table.setModel(model_table);
	    
	    try {
			Connect con = new Connect();
			String query = "select * from bill where meter_no = '"+meter+"'";
			ResultSet rs = con.stmt.executeQuery(query);
			while(rs.next()) {
				Vector<String> r  = new Vector<String>();
				r.addElement(rs.getString("meter_no"));
				r.addElement(rs.getString("month"));
				r.addElement(rs.getString("units"));
				r.addElement(rs.getString("total_bill"));
				r.addElement(rs.getString("status"));
				model_table.addRow(r);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    scroll_table = new JScrollPane(table);
		scroll_table.setBounds(0, 0, 700, 650);
		add(scroll_table);
		
		setVisible(true);
		
	}	public static void main(String[] args) {
		new BillDetails("");
	}

}
