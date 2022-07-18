package electricity;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class ViewInfomation extends JFrame implements ActionListener{

	JButton btCancel;
	String meter;
	
	ViewInfomation(String meter){
		super("View Customer Infomation");
		this.meter = meter;
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		setBounds(370, 100, 850, 650);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setLayout(null);
		
		JLabel heading = new JLabel("View Customer Infomation");
		heading.setBounds(325, 0, 500, 40);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(heading);
		 
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(70, 80, 100, 20);
		add(lblName);
		
		JLabel name = new JLabel("");
		name.setBounds(180, 80, 100, 20);
		add(name);
		
		JLabel lblMeterNum = new JLabel("Meter Number");
		lblMeterNum.setBounds(70, 140, 100, 20);
		add(lblMeterNum);
		
		JLabel meter_number = new JLabel("");
		meter_number.setBounds(180, 140, 100, 20);
		add(meter_number);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(70, 200, 100, 20);
		add(lblAddress);
		
		JLabel address = new JLabel("");
		address.setBounds(180, 200, 100, 20);
		add(address);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(70, 260, 100, 20);
		add(lblCity);
		
		JLabel city = new JLabel("");
		city.setBounds(180, 260, 100, 20);
		add(city);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(450, 80, 100, 20);
		add(lblState);
		
		JLabel state = new JLabel("");
		state.setBounds(500, 80, 100, 20);
		add(state);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(450, 140, 100, 20);
		add(lblEmail);
		
		JLabel email = new JLabel("");
		email.setBounds(500, 140, 200, 20);
		add(email);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(450, 200, 100, 20);
		add(lblPhone);
		
		JLabel phone = new JLabel("");
		phone.setBounds(500, 200, 100, 20);
		add(phone);
		
		try {
			Connect con = new Connect();
			ResultSet rs= con.stmt.executeQuery("select * from customer where meter_no = '"+meter+"'");
			while(rs.next()) {
				name.setText(rs.getString("customer"));
				meter_number.setText(rs.getString("meter_no"));
				address.setText(rs.getString("address"));
				city.setText(rs.getString("city"));
				state.setText(rs.getString("state"));
				email.setText(rs.getString("email"));
				phone.setText(rs.getString("phone"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		btCancel = new JButton("Cancel");
		btCancel.setBackground(Color.BLACK);
		btCancel.setForeground(Color.WHITE);
		btCancel.setBounds(350, 340, 100, 25);
		btCancel.addActionListener(this);
		add(btCancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
		Image i1_1 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1_1);
		JLabel image = new JLabel(i2);
		image.setBounds(30, 350, 600, 300);
		add(image);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
	}
	
	public static void main(String[] args) {
		new ViewInfomation("");

	}

	
	
}
