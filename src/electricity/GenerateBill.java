package electricity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class GenerateBill extends JFrame implements ActionListener {
	
	String meter;
	JButton bill;
	Choice cmonth;
	JTextArea txtarea;
	ResultSet rs;
	GenerateBill(String meter)	{
		super("Generate Bill");
		this.meter = meter;
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		setSize(500, 750);
		
		setLocation(500, 50);
		
		
		Panel panel = new Panel();
		
		JLabel heading = new JLabel("Generate Bill");
		JLabel meter_num = new JLabel(meter);
		
		cmonth = new Choice();
		
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
		
		txtarea = new JTextArea(30, 10);
		txtarea.setText("\n\n\t---------------Click on the -------------\n\t Generate Button to get \n\t the bill Selected Month");
		txtarea.setFont(new Font("Senserif", Font.ITALIC, 18));
		
		
		JScrollPane scPanel = new JScrollPane(txtarea);
		
		bill = new JButton("Generate Bill");
		bill.addActionListener(this);
		
		panel.add(heading);
		panel.add(meter_num);
		panel.add(cmonth);
		add(panel, "North");
		
		add(scPanel, "Center");
		add(bill, "South");
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			Connect con = new Connect();
			
			String month = cmonth.getSelectedItem();
			
			txtarea.setText("\tReliance Power Limited\n\tELECTRICITY BILL GENERATED FOR\n\tTHE MONTH OF " +month+",2022\n\n\n");
			
			 rs = con.stmt.executeQuery("select * from customer where meter_no = '"+meter+"'");
			//rs = con.stmt.executeQuery("select * from customer where meter_no = '376035'");
			
			if(rs.next()) {
				txtarea.append("\n   Customer Name:  "+ rs.getString("customer"));
				txtarea.append("\n   Meter Number:   "+ rs.getString("meter_no"));
				txtarea.append("\n   Address:  "+ rs.getString("address"));
				txtarea.append("\n   City: 	   "+ rs.getString("city"));
				txtarea.append("\n   State:    "+ rs.getString("state"));
				txtarea.append("\n   Email     "+ rs.getString("email"));
				txtarea.append("\n   Phone:    "+ rs.getString("phone"));
				txtarea.append("\n----------------------------------------");
				txtarea.append("\n");
			}
			
			rs = con.stmt.executeQuery("select * from meter_info where meter_no = '"+meter+"'");
			
			if(rs.next()) {
				txtarea.append("\n   Meter Number: "+ rs.getString("meter_no"));
				txtarea.append("\n   Meter Location: "+ rs.getString("meter_location"));
				txtarea.append("\n   Meter Type: "+ rs.getString("meter_type"));
				txtarea.append("\n   Phase Code: "+ rs.getString("phase_code"));
				txtarea.append("\n   Bill Type: "+ rs.getString("bill_type"));
				txtarea.append("\n   Days: "+ rs.getString("days"));
				txtarea.append("\n----------------------------------------");
				txtarea.append("\n");
			}
			
			rs = con.stmt.executeQuery("select * from tax ");
			
			if(rs.next()) {
				txtarea.append("\n");
				txtarea.append("\n   Meter Type: "+ rs.getString("cost_per_unit"));
				txtarea.append("\n   Meter Rent: "+ rs.getString("meter_rent"));
				txtarea.append("\n   Service Change: "+ rs.getString("service_change"));
				txtarea.append("\n   Service Tax: "+ rs.getString("service_tax"));
				txtarea.append("\n   Cess: "+ rs.getString("cess"));
				txtarea.append("\n   Fixed Tax: "+ rs.getString("fixed_tax"));
				txtarea.append("\n----------------------------------------");
				txtarea.append("\n");
			}
			
			rs = con.stmt.executeQuery("select * from bill where meter_no = '"+meter+"' and month = '"+cmonth.getSelectedItem()+"'");
			
			if(rs.next()) {
				txtarea.append("\n");
				txtarea.append("\n   Current Month: "+ rs.getString("month"));
				txtarea.append("\n   Unit Consunmed: "+ rs.getString("units"));
				txtarea.append("\n   Total Charges: "+ rs.getString("total_bill"));
				txtarea.append("\n   Status: "+ rs.getString("status"));
				txtarea.append("\n----------------------------------------");
				txtarea.append("\n   Total Payable: "+ rs.getString("total_bill"));
				txtarea.append("\n");
			} else if (!rs.next()) {
				txtarea.setText("\tReliance Power Limited\n\tELECTRICITY BILL GENERATED FOR\n\tTHE MONTH OF " +month+",2022\n\n\n\n\n\n\tNot Found Bill of the " +month + ", 2022" );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new GenerateBill("");

	}

}
