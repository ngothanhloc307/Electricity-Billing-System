package electricity;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class NewCustomer extends JFrame implements ActionListener{

	JTextField txtName, txtAdd, txtCity, txtState,txtEmail, txtPhone;
	JButton btNext, btCancel;
	JLabel lblMeterNo;
	NewCustomer() {
		setSize(700, 500);
		setResizable(false);
		setLocation(400, 200);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(172, 216, 230));
		add(panel);
		
		JLabel lblHeading = new JLabel("New Customer");
		lblHeading.setBounds(180, 10,200,20);
		lblHeading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblHeading);
		
		JLabel lblName = new JLabel("Customer Name"); 
		lblName.setBounds(100, 80, 140, 20);
		panel.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(240, 80, 200, 20);
		panel.add(txtName);
		
		JLabel lblMeterNum = new JLabel("Meter Number"); 
		lblMeterNum.setBounds(100, 120, 100, 20);
		panel.add(lblMeterNum);
		
		lblMeterNo = new JLabel(""); 
		lblMeterNo.setBounds(240, 120, 100, 20);
		panel.add(lblMeterNo);
		
		Random rd = new Random();
		long number = rd.nextLong() % 1000000;
		lblMeterNo.setText(""+ Math.abs(number));
		
		JLabel lblAddress = new JLabel("Address"); 
		lblAddress.setBounds(100, 160, 140, 20);
		panel.add(lblAddress);
		
		txtAdd = new JTextField();
		txtAdd.setBounds(240, 160, 200, 20);
		panel.add(txtAdd);
		
		JLabel lblCity = new JLabel("City"); 
		lblCity.setBounds(100, 200, 140, 20);
		panel.add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setBounds(240, 200, 200, 20);
		panel.add(txtCity);
		
		JLabel lblState = new JLabel("State"); 
		lblState.setBounds(100, 240, 140, 20);
		panel.add(lblState);
		
		txtState = new JTextField();
		txtState.setBounds(240, 240, 200, 20);
		panel.add(txtState);
		
		JLabel lblEmail = new JLabel("Email"); 
		lblEmail.setBounds(100, 280, 140, 20);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(240, 280, 200, 20);
		panel.add(txtEmail);
		
		JLabel lblPhone = new JLabel("Phone"); 
		lblPhone.setBounds(100, 320, 140, 20);
		panel.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(240, 320, 200, 20);
		panel.add(txtPhone);
		
		btNext = new JButton("Next");
		btNext.setBounds(120, 390, 100, 25);
		btNext.setBackground(Color.BLACK);
		btNext.setForeground(Color.WHITE);
		btNext.addActionListener(this);
		panel.add(btNext);
		
		btCancel = new JButton("Cancel");
		btCancel.setBounds(250, 390, 100, 25);
		btCancel.setBackground(Color.BLACK);
		btCancel.setForeground(Color.WHITE);
		btCancel.addActionListener(this);
		panel.add(btCancel);
		
		setLayout(new BorderLayout());
		add(panel, "Center");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
		Image i1_2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		ImageIcon i1_3 = new ImageIcon(i1_2);
		JLabel image = new JLabel(i1_3);
		add(image, "West");
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btNext) {
			String name = txtName.getText().trim();
			String meter = lblMeterNo.getText().trim();
			String address = txtAdd.getText().trim();
			String city = txtCity.getText().trim();
			String state = txtState.getText().trim();
			String email = txtEmail.getText().trim();
			String phone = txtPhone.getText().trim();
			
			
			try {
				Connect con = new Connect();
				String query1 = "insert into customer values('"+name+"', '"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
				String query2 = "insert into login(meter_no,name,user_type) values('"+meter+"', '"+name+"', 'Customer')";
				con.stmt.executeUpdate(query1);
				con.stmt.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
				setVisible(false);
				
				// new frame
				new MeterInfo(meter);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == btCancel) {
			setVisible(false);
			
		}
		
	}
	
	public static void main(String[] args) {
		new NewCustomer();

	}

	

}
