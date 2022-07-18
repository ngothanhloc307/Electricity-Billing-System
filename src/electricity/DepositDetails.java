package electricity;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener{
	
	Choice cmeterNumber, cmonth;
	JTable table;
	JButton btSearch,btPrint;
	
	DepositDetails() {
		super("Deposit Details");
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		
		setSize(700, 700);
		setResizable(false);
		setLocation(400, 100);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblmeterNumber = new JLabel("Search By Meter Number");
		lblmeterNumber.setBounds(20, 20 ,150, 20);
		add(lblmeterNumber);
		
		cmeterNumber = new Choice();
		cmeterNumber.setBounds(180, 20, 150, 20);
		add(cmeterNumber);
		
		try {
			Connect con = new Connect();
			ResultSet rs = con.stmt.executeQuery("select * from customer");
			while(rs.next()) {
				cmeterNumber.add(rs.getString("meter_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblmoth = new JLabel("Search By Moth");
		lblmoth.setBounds(400, 20 ,100, 20);
		add(lblmoth);
		
		cmonth = new Choice();
		cmonth.setBounds(500, 20, 80, 20);
		cmonth.add("January");
		cmonth.add("February");
		cmonth.add("March");
		cmonth.add("April");
		cmonth.add("May");
		cmonth.add("June");
		cmonth.add("July");
		cmonth.add("August");
		cmonth.add("September");
		cmonth.add("October");
		cmonth.add("November");
		cmonth.add("December");
		add(cmonth);
		
		table = new JTable();
		try {
			Connect con = new Connect();
			ResultSet rs = con.stmt.executeQuery("select * from bill");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		JScrollPane scroPanel = new JScrollPane(table);
		scroPanel.setBounds(0, 100, 700, 600);
		add(scroPanel);
		
		btSearch = new JButton("Search");
		btSearch.setBounds(20, 70, 80, 20);
		btSearch.addActionListener(this);
		add(btSearch);
		
		btPrint = new JButton("Print");
		btPrint.setBounds(120, 70, 80, 20);
		btPrint.addActionListener(this);
		add(btPrint);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btSearch) {
			String query = "select * from bill where meter_no= '"+cmeterNumber.getSelectedItem()+"'and month = '"+cmonth.getSelectedItem()+"' ";
			try {
				Connect con = new Connect();
				ResultSet rs = con.stmt.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else {
			try {
				table.print();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		new DepositDetails();

	}

	

}
