package electricity;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CalculationBill extends JFrame implements ActionListener{

	JTextField txtUnit, txtMoth;
	JButton btSubmit, btCancel;
	JLabel lblMeterNo, lblName;
	Choice cmeterNumber, cMoth;
	CalculationBill() {
		super("Calculation Bill");
		setSize(700, 500);
		setResizable(false);
		setLocation(400, 200);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(172, 216, 230));
		add(panel);
		
		JLabel lblHeading = new JLabel("Calculation Electricity Bill");
		lblHeading.setBounds(110, 10, 400,20);
		lblHeading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblHeading);
		
		JLabel lblMeterNumber = new JLabel("Meter Number"); 
		lblMeterNumber.setBounds(100, 80, 140, 20);
		panel.add(lblMeterNumber);
		
		cmeterNumber = new Choice();
		try {
			Connect con = new Connect();
			ResultSet rs = con.stmt.executeQuery("select * from customer");
			while(rs.next()) {
				cmeterNumber.add(rs.getString("meter_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cmeterNumber.setBounds(240, 80 ,100, 20);
		panel.add(cmeterNumber);		
		
		lblName = new JLabel("Name"); 
		lblName.setBounds(100, 120, 100, 20);
		panel.add(lblName);
		
		JLabel lblbName1 = new JLabel();
		lblbName1.setBounds(240, 120, 200, 20);
		panel.add(lblbName1);
		
		
		JLabel lblAddress = new JLabel("Address"); 
		lblAddress.setBounds(100, 160, 140, 20);
		panel.add(lblAddress);
		
		JLabel lblAddres1 = new JLabel();
		lblAddres1.setBounds(240, 160, 200, 20);
		panel.add(lblAddres1);
		
		try {
			Connect con = new Connect();
			ResultSet rs = con.stmt.executeQuery("select * from customer where meter_no= '"+cmeterNumber.getSelectedItem()+"' ");
			while(rs.next()) {
				lblbName1.setText(rs.getString("customer"));
				lblAddres1.setText(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cmeterNumber.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent ie) {
				try {
					Connect con = new Connect();
					ResultSet rs = con.stmt.executeQuery("select * from customer where meter_no= '"+cmeterNumber.getSelectedItem()+"' ");
					while(rs.next()) {
						lblbName1.setText(rs.getString("customer"));
						lblAddres1.setText(rs.getString("address"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		JLabel blbUnitCon = new JLabel("Unit Consumed"); 
		blbUnitCon.setBounds(100, 200, 140, 20);
		panel.add(blbUnitCon);
		
		txtUnit = new JTextField();
		txtUnit.setBounds(240, 200, 200, 20);
		panel.add(txtUnit);
		
		JLabel lblMoth = new JLabel("Moth"); 
		lblMoth.setBounds(100, 240, 140, 20);
		panel.add(lblMoth);
		
		cMoth = new Choice();
		cMoth.setBounds(240, 240, 100, 20);
		cMoth.add("January");
		cMoth.add("February");
		cMoth.add("March");
		cMoth.add("April");
		cMoth.add("May");
		cMoth.add("June");
		cMoth.add("July");
		cMoth.add("August");
		cMoth.add("September");
		cMoth.add("October");
		cMoth.add("November");
		cMoth.add("December");
		panel.add(cMoth);
		
		
		btSubmit = new JButton("Submit");
		btSubmit.setBounds(120, 300, 100, 25);
		btSubmit.setBackground(Color.BLACK);
		btSubmit.setForeground(Color.WHITE);
		btSubmit.addActionListener(this);
		panel.add(btSubmit);
		
		btCancel = new JButton("Cancel");
		btCancel.setBounds(250, 300, 100, 25);
		btCancel.setBackground(Color.BLACK);
		btCancel.setForeground(Color.WHITE);
		btCancel.addActionListener(this);
		panel.add(btCancel);
		
		setLayout(new BorderLayout());
		add(panel, "Center");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
		Image i1_2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
		ImageIcon i1_3 = new ImageIcon(i1_2);
		JLabel image = new JLabel(i1_3);
		add(image, "West");
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btSubmit) {
			String meter = cmeterNumber.getSelectedItem().trim();
			String unit = txtUnit.getText().trim();
			String moth = cMoth.getSelectedItem();
			
			int totalBill = 0;
			int unit_consumer =Integer.parseInt(unit);
			Connect con = new Connect();
			
			try {
				String query = "select * from tax";
				try {
					
					ResultSet rs = con.stmt.executeQuery(query);
					
					while(rs.next()) {
						totalBill += unit_consumer * Integer.parseInt(rs.getString("cost_per_unit"));
						totalBill += Integer.parseInt(rs.getString("meter_rent"));
						totalBill += Integer.parseInt(rs.getString("service_change"));
						totalBill += Integer.parseInt(rs.getString("service_tax"));
						totalBill += Integer.parseInt(rs.getString("cess"));
						totalBill += Integer.parseInt(rs.getString("fixed_tax"));
					}				
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				String query2 = "insert into bill values('"+meter+"','"+moth+"','"+unit+"','"+totalBill+"', 'Not Paid')";
				try {
					con.stmt.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Customer Updated Successfully");
					setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == btCancel) {
			setVisible(false);
			
		}
		
		
	}

	public static void main(String[] args) {
		new CalculationBill();
	}
	
}
