package electricity;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class MeterInfo extends JFrame implements ActionListener{
	
	
	JButton btSubmit;
	JLabel lblMeterNo;
	Choice cMeterLocation, cMeterType, cPhaseCode, cBillType;
	String meterNumer;
	MeterInfo(String meterNumer) {
		super("Meter Infomation");
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		this.meterNumer = meterNumer;
		setSize(700, 500);
		setResizable(false);
		setLocation(400, 200);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(172, 216, 230));
		add(panel);
		
		JLabel lblHeading = new JLabel("Meter Infomation");
		lblHeading.setBounds(180, 10,200,20);
		lblHeading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblHeading);
		
		JLabel lblMeterNum = new JLabel("Meter Number"); 
		lblMeterNum.setBounds(100, 80, 140, 20);
		panel.add(lblMeterNum);
		
		lblMeterNo = new JLabel(meterNumer);
		lblMeterNo.setBounds(240, 80, 200, 20);
		panel.add(lblMeterNo);
		
		JLabel lblMeterLocation = new JLabel("Meter Location"); 
		lblMeterLocation.setBounds(100, 120, 100, 20);
		panel.add(lblMeterLocation);
		
		cMeterLocation = new Choice(); 
		cMeterLocation.add("Outside");
		cMeterLocation.add("Inside");
		cMeterLocation.setBounds(240, 120, 200, 20);
		panel.add(cMeterLocation);
		
		JLabel lblMeterType = new JLabel("Meter Type"); 
		lblMeterType.setBounds(100, 160, 140, 20);
		panel.add(lblMeterType);
		
		cMeterType = new Choice(); 
		cMeterType.add("Electric Meter");
		cMeterType.add("Solar Meter");
		cMeterType.setBounds(240, 160, 200, 20);
		panel.add(cMeterType);
		
		JLabel lblPhase = new JLabel("Phase Code"); 
		lblPhase.setBounds(100, 200, 140, 20);
		panel.add(lblPhase);
		
		cPhaseCode = new Choice(); 
		cPhaseCode.add("011");
		cPhaseCode.add("022");
		cPhaseCode.add("033");
		cPhaseCode.add("044");
		cPhaseCode.add("055");
		cPhaseCode.add("066");
		cPhaseCode.add("077");
		cPhaseCode.add("088");
		cPhaseCode.add("099");
		cPhaseCode.setBounds(240, 200, 200, 20);
		panel.add(cPhaseCode);
		
		
		
		
		JLabel lblBillTp = new JLabel("Bill Type"); 
		lblBillTp.setBounds(100, 240, 140, 20);
		panel.add(lblBillTp);
		
		cBillType = new Choice(); 
		cBillType.add("Nomal");
		cBillType.add("Industrial");
		cBillType.setBounds(240, 240, 200, 20);
		panel.add(cBillType);
		
		
		JLabel lblDayU = new JLabel("Days Using"); 
		lblDayU.setBounds(100, 280, 140, 20);
		panel.add(lblDayU);
		
		JLabel lblDays = new JLabel("30 Days"); 
		lblDays.setBounds(240, 280, 140, 20);
		panel.add(lblDays);
		
		JLabel lblNote = new JLabel("Note"); 
		lblNote.setBounds(100, 320, 140, 20);
		panel.add(lblNote);
		
		
		JLabel lblNote2 = new JLabel("By Default Bill is calculated for 30 days only"); 
		lblNote2.setBounds(240, 320, 300, 20);
		panel.add(lblNote2); 
		

		
		btSubmit = new JButton("Submit");
		btSubmit.setBounds(120, 390, 100, 25);
		btSubmit.setBackground(Color.BLACK);
		btSubmit.setForeground(Color.WHITE);
		btSubmit.addActionListener(this);
		panel.add(btSubmit);

		
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
		if(ae.getSource() == btSubmit) {
			String meter = meterNumer;
			String location = cMeterLocation.getSelectedItem();
			String type = cMeterType.getSelectedItem();
			String phaseCode = cPhaseCode.getSelectedItem();
			String billType = cBillType.getSelectedItem();
			String days = "30";
			
			
			try {
				Connect con = new Connect();
				String query = "insert into meter_info values('"+meter+"', '"+location+"','"+type+"','"+phaseCode+"','"+billType+"','"+days+"')";
				con.stmt.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Meter Infomation Added Successfully");
				setVisible(false);
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			
		}
		
	}

	public static void main(String[] args) {
		new MeterInfo("");

	}
	
}
