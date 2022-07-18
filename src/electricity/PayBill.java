package electricity;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class PayBill extends JFrame implements ActionListener{

	
	Choice month;
	JButton btnPay, btnBack;
	String meter;
	PayBill(String meter) {
		super("Pay Bill");
		this.meter = meter;
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		setResizable(false);
		setLayout(null);
		setBounds(450, 150, 800, 450);
		
		JLabel heading = new JLabel("Electric Bill");
		heading .setFont(new Font("Tahoma", Font.BOLD, 24));
		heading.setBounds(170, 5 ,500, 30);
		add(heading);
		
		JLabel lblMeter_Number = new JLabel("Meter Number");
		lblMeter_Number.setBounds(35, 80, 200, 20);
		add(lblMeter_Number);
		
		JLabel meter_number = new JLabel();
		meter_number.setBounds(150, 80, 200, 20);
		add(meter_number);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(35, 120, 200, 20);
		add(lblName);
		
		JLabel name = new JLabel("");
		name.setBounds(150, 120, 200, 20);
		add(name);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(35, 160, 50, 20);
		add(lblMonth);
		
		month = new Choice();
		month.setBounds(150, 160, 200, 20);
		month.add("January");
		month.add("February");
		month.add("March");
		month.add("April");
		month.add("May");
		month.add("June");
		month.add("July");
		month.add("August");
		month.add("September");
		month.add("October");
		month.add("November");
		month.add("December");
		add(month);
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setBounds(35, 200, 50, 20);
		add(lblUnit);
		
		JLabel unit = new JLabel("");
		unit.setBounds(150, 200, 200, 20);
		add(unit);
		
		JLabel lblTotal = new JLabel("Total Bill");
		lblTotal.setBounds(35, 240, 50, 20);
		add(lblTotal);
		
		JLabel total_bill = new JLabel("");
		total_bill.setBounds(150, 240, 200, 20);
		add(total_bill);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(35, 280, 50, 20);
		add(lblStatus);
		
		JLabel status = new JLabel("");
		status.setBounds(150, 280, 200, 20);
		add(status);
		
		try {
			Connect con = new Connect();
			ResultSet rs = con.stmt.executeQuery("select * from customer where meter_no= '"+meter+"'");
			while(rs.next()) {
				meter_number.setText(rs.getString("meter_no"));
				name.setText(rs.getString("customer"));
			}
			rs = con.stmt.executeQuery("select * from bill where meter_no= '"+meter+"'and month = '"+month.getSelectedItem()+"'");
			while(rs.next()) {
				unit.setText(rs.getString("units"));
				total_bill.setText(rs.getString("total_bill"));
				status.setText(rs.getString("status"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		month.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent ae) {
				try {
					Connect con = new Connect();
					ResultSet rs = con.stmt.executeQuery("select * from bill where meter_no= '"+meter+"'and month = '"+month.getSelectedItem()+"'");
					if(rs.next()) {
						unit.setText(rs.getString("units"));
						total_bill.setText(rs.getString("total_bill"));
						status.setText(rs.getString("status"));
					}else {
						unit.setText("");
						total_bill.setText("");
						status.setText("");
					}
					
					if(status.getText().equals("Not Paid")) {
						status.setForeground(Color.RED);
					}else if (status.getText().equals("Paid")) {
						status.setForeground(Color.GREEN);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		if(status.getText().equals("Not Paid")) {
			status.setForeground(Color.RED);
		}else if (status.getText().equals("Paid")) {
			status.setForeground(Color.GREEN);
		}
		
		btnPay = new JButton("Pay Bill");
		btnPay.setBackground(Color.BLACK);
		btnPay.setForeground(Color.WHITE);
		btnPay.setBounds(80, 350, 100, 25);
		btnPay.addActionListener(this);
		add(btnPay);
		
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(300, 350, 100, 25);
		btnBack.addActionListener(this);
		add(btnBack);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
		Image i2 = i1.getImage().getScaledInstance(	500, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 80, 500, 250);
		add(image);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnPay) {
			try {
				Connect con = new Connect();
				con.stmt.executeUpdate("update bill set status = 'Paid' where meter_no= '"+meter+"' and month = '"+month.getSelectedItem()+"'");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			setVisible(false);
			new Paytm(meter);
			
		}else if (ae.getSource() == btnBack) {
			setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new PayBill("");
		
	}

}
