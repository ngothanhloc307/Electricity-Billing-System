package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateInformation extends JFrame implements ActionListener{

	JTextField txtAddress,txtCity, txtState, txtEmail, txtPhone;
	JButton btUpdate, btCancel;
	JLabel name;
	String meter;
	UpdateInformation(String meter){
		super("Update Customer Information");
		this.meter = meter;
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		setResizable(false);
		
		setBounds(300, 150, 850, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		

		JLabel heading = new JLabel("Update Customer Information");
		heading.setBounds(300, 0, 400, 30);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(heading);
		 
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(30, 70, 100, 20);
		add(lblName);
		
		name = new JLabel("");
		name.setBounds(150, 70, 200, 20);
		add(name);
		
		JLabel lblMeterNum = new JLabel("Meter Number");
		lblMeterNum.setBounds(30, 110, 100, 20);
		add(lblMeterNum);
		
		JLabel meter_number = new JLabel("");
		meter_number.setBounds(150, 110, 100, 20);
		add(meter_number);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(30, 150, 100, 20);
		add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(150, 150, 100, 20);
		add(txtAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(30, 190, 100, 20);
		add(lblCity);
		
		txtCity = new JTextField("");
		txtCity.setBounds(150, 190, 100, 20);
		add(txtCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(30, 230, 100, 20);
		add(lblState);
		
		txtState = new JTextField();
		txtState.setBounds(150, 230, 200, 20);
		add(txtState);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 270, 100, 20);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(150, 270, 200, 20);
		add(txtEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(30, 310, 100, 20);
		add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(150, 310, 200, 20);
		add(txtPhone);
		
		try {
			Connect con = new Connect();
			ResultSet rs= con.stmt.executeQuery("select * from customer where meter_no = '"+meter+"'");
			while(rs.next()) {
				name.setText(rs.getString("customer"));
				meter_number.setText(rs.getString("meter_no"));
				txtAddress.setText(rs.getString("address"));
				txtCity.setText(rs.getString("city"));
				txtState.setText(rs.getString("state"));
				txtEmail.setText(rs.getString("email"));
				txtPhone.setText(rs.getString("phone"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		btUpdate = new JButton("Update");
		btUpdate.setBackground(Color.BLACK);
		btUpdate.setForeground(Color.WHITE);
		btUpdate.setBounds(70, 360, 100, 25);
		btUpdate.addActionListener(this);
		add(btUpdate);
		
		btCancel = new JButton("Cancel");
		btCancel.setBackground(Color.BLACK);
		btCancel.setForeground(Color.WHITE);
		btCancel.setBounds(250, 360, 100, 25);
		btCancel.addActionListener(this);
		add(btCancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
		Image i1_1 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1_1);
		JLabel image = new JLabel(i2);
		image.setBounds(450, 50, 400, 300);
		add(image);
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btUpdate) {
			String address = txtAddress.getText();
			String city = txtCity.getText();
			String state = txtState.getText();
			String email = txtEmail.getText();
			String Phone = txtPhone.getText();
			
			try {
				Connect con = new Connect();
				con.stmt.executeUpdate("update customer set address='"+address+"', city = '"+city+"', state = '"+state+"', email = '"+email+"', phone = '"+Phone+"' where meter_no = '"+meter+"'");
				
				JOptionPane.showMessageDialog(null, "User Information Updated Sucessfully");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == btCancel) {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateInformation("");
	}

}
