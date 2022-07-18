package electricity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.*;

public class SignUp extends JFrame implements ActionListener{

	
	JButton btCreate, btBack;
	JTextField txtPassword, txtmeter, txtName, txtusername; 
	Choice accountType;
	public SignUp() {
		
		super("Sign Up");
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		
		getContentPane().setBackground(Color.WHITE);
		setSize(700, 400);
		setResizable(false);
		setLocation(450, 150);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 20, 650, 300);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230),2),"Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172,216, 230)));
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setForeground(new Color(34,139, 34));
		add(panel);
		
		JLabel lbheading = new JLabel("Create Account As");  
		lbheading.setBounds(100, 50, 140, 20);
		lbheading.setForeground(Color.GRAY);
		lbheading.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lbheading);
		
		JLabel lblmeter = new JLabel("Meter Number");  
		lblmeter.setBounds(100, 90, 140, 20);
		lblmeter.setForeground(Color.GRAY);
		lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmeter.setVisible(false);
		panel.add(lblmeter);
		
		txtmeter = new JTextField();
		txtmeter.setBounds(260, 90, 150, 20);
		txtmeter.setVisible(false);
		panel.add(txtmeter);
		
		JLabel lbusername = new JLabel("User Name");  
		lbusername.setBounds(100, 130, 140, 20);
		lbusername.setForeground(Color.GRAY);
		lbusername.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lbusername);
		
		txtusername = new JTextField();
		txtusername.setBounds(260, 130, 150, 20);
		panel.add(txtusername);
		
		
		
		JLabel lblname = new JLabel("Name");  
		lblname.setBounds(100, 170, 140, 20);
		lblname.setForeground(Color.GRAY);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblname);
		
		txtName = new JTextField();
		txtName.setBounds(260, 170, 150, 20);
		panel.add(txtName);
		
		txtmeter.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent fe) {
				try {
					Connect con = new Connect();
					ResultSet rs = con.stmt.executeQuery("select * from login where meter_no= '"+txtmeter.getText()+"'");
					while(rs.next()) {
						txtName.setText(rs.getString("name"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void focusGained(FocusEvent fe) {
				
			}
		});
		
		JLabel lblPassword = new JLabel("Password");  
		lblPassword.setBounds(100, 210, 140, 20);
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(260, 210, 150, 20);
		panel.add(txtPassword);
		
		btCreate = new JButton("Create");
		btCreate.setBackground(Color.BLACK);
		btCreate.setForeground(Color.WHITE);
		btCreate.setBounds(140,250, 120, 30);
		btCreate.addActionListener(this);
		panel.add(btCreate);
		
		btBack = new JButton("Back");
		btBack.setBackground(Color.BLACK);
		btBack.setForeground(Color.WHITE);
		btBack.setBounds(300,250, 120, 30);
		btBack.addActionListener(this);
		panel.add(btBack);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
		Image i2 = i1.getImage().getScaledInstance(250 , 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(410, 30, 250, 250);
		panel.add(image);
		
		accountType = new Choice();
		accountType.add("Admin");
		accountType.add("Customer");
		accountType.setFont(new Font("Tahoma", Font.BOLD, 13));
		accountType.setBounds(260, 50, 150, 20);
		panel.add(accountType);
		
		accountType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String user = accountType.getSelectedItem();
				if(user.equals("Customer")) {
					lblmeter.setVisible(true);
					txtmeter.setVisible(true);
					txtName.setEditable(false);
					btCreate.setText("Update");
				}else if(user.equals("Admin")) {
						lblmeter.setVisible(false);
						txtmeter.setVisible(false);
						txtName.setEditable(true);
						btCreate.setText("Create");
				}
				
			}
		});
		
		setBounds(450, 150, 700, 400);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btBack) {
			setVisible(false);
			
			new Login();
		}else if (ae.getSource() == btCreate) {
			String aType = accountType.getSelectedItem();
			String username = txtusername.getText().trim();
			String name = txtName.getName();
			String password = txtPassword.getText().trim();
			String meter = txtmeter.getText().trim();
			
			try {
				Connect con = new Connect();
				String query = null; 
				if(accountType.equals("Admin")) {
					
					query = "insert into login(meter_no,user_name,password,name,user_type) values('"+meter+"','"+username+"','"+password+"','"+name+"','"+aType+"')";
				}else {
					query = "update login set user_name = '"+username+"', password='"+password+"', name ='"+name+"', user_type = '"+aType+"' where meter_no = '"+meter+"'";
				}
				con.stmt.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account Created Sucessfully");
				
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new SignUp();

	}

	

}
