package electricity;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class CustomerDetails extends JFrame implements ActionListener {

	Choice cmeterNumber, cmoth;
	JTable table;
	JButton btSearch,btPrint;
	CustomerDetails() {
		super("Customer Details");
		setSize(1200, 650);
		setResizable(false);
		setLocation(150, 100);
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		
		
		table = new JTable();
		try {
			Connect con = new Connect();
			ResultSet rs = con.stmt.executeQuery("select * from customer");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		JScrollPane scroPanel = new JScrollPane(table);
		add(scroPanel);
		
		
		btPrint = new JButton("Print");
		btPrint.addActionListener(this);
		add(btPrint, "South");
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	
			try {
				table.print();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	public static void main(String[] args) {
		
		new CustomerDetails();
	}

}
