package electricity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.sql.*;

public class Login extends JFrame implements ActionListener{

	JButton btlogin, btsignup, btcancel;
	Choice logginin;
	JTextField txtusername;
	JPasswordField txtpassword;
	Login() {
		super("Login Page");
		setSize(640, 300);
		setResizable(false);
		setLocation(400, 200);
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		getContentPane().setBackground(Color.WHITE);;
		setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(300, 20,100,20);
		add(lblusername);
		
		txtusername = new JTextField();
		txtusername.setBounds(400, 20,150,20);
		add(txtusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(300, 60,100,20);
		add(lblpassword);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(400, 60,150,20);
		add(txtpassword);
		
		JLabel lblloginas = new JLabel("Login in as");
		lblloginas.setBounds(300, 100,100,20);
		add(lblloginas);
		
		logginin = new Choice();
		logginin.add("Admin");
		logginin.add("Customer");
		logginin.setBounds(400,100,150,20);	
		add(logginin);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		btlogin = new JButton("Login", new ImageIcon(i2));
		btlogin.setBounds(330, 160, 100, 20);
		btlogin.addActionListener(this);
		add(btlogin);
		
		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
		Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		btcancel = new JButton("Cancel",new ImageIcon(i4));
		btcancel.setBounds(450, 160, 100, 20);
		btcancel.addActionListener(this);
		add(btcancel);
		
		ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
		Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		btsignup = new JButton("Sign Up", new ImageIcon(i6));
		btsignup.setBounds(380, 200, 100, 20);
		btsignup.addActionListener(this);
		add(btsignup);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
		Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		JLabel image = new JLabel(i9);
		image.setBounds(0,0,250,250);
		add(image);
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btlogin) {
			String userName = txtusername.getText();
			String password = txtpassword.getText();
			String user = logginin.getSelectedItem();
			
			try {
				Connect conn = new Connect();
				String query = "select * from login where user_name='"+userName+"' and password='"+password+"' and user_type='"+user+"' ";
				ResultSet rs= conn.stmt.executeQuery(query);
				if(rs.next()) {
					String meter = rs.getString("meter_no");
					setVisible(false);
					new Project(user, meter);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Login");
					txtusername.setText("");
					txtpassword.setText("");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (ae.getSource() == btcancel) {
			setVisible(false);
		}else if (ae.getSource() == btsignup) {
			setVisible(false);
			
			
			new SignUp();
		}
		
	}
	public static void main(String[] args) {
		new Login();

	}

}
