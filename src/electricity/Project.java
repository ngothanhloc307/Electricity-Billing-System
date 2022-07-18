package electricity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.*;

public class Project extends JFrame implements ActionListener {

	String user, meter;
	Project(String user, String meter) {
		super("Project");
		this.meter = meter;
		this.user = user;  
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1400, 850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		JMenuBar mnBar = new JMenuBar();
		setJMenuBar(mnBar);
		
		JMenu mnMaster = new JMenu("Master");
		mnMaster.setForeground(Color.BLUE);
		
		
		JMenuItem mnNewCustomer = new JMenuItem("New Customer");
		mnNewCustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnNewCustomer.setBackground(Color.WHITE);
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
		Image icon1_1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnNewCustomer.setIcon(new ImageIcon(icon1_1));
		mnNewCustomer.setMnemonic('R');
		mnNewCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		mnNewCustomer.addActionListener(this);
		mnMaster.add(mnNewCustomer);
		
		JMenuItem mnCustomerDetails = new JMenuItem("Customer Details");
		mnCustomerDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnCustomerDetails.setBackground(Color.WHITE);
		ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
		Image icon2_1 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnCustomerDetails.setIcon(new ImageIcon(icon2_1));
		mnCustomerDetails.setMnemonic('M');
		mnCustomerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		mnCustomerDetails.addActionListener(this);
		mnMaster.add(mnCustomerDetails);
		
		JMenuItem mnDepositDetails = new JMenuItem("Deposit Details");
		mnDepositDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnDepositDetails.setBackground(Color.WHITE);
		ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
		Image icon3_1 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnDepositDetails.setIcon(new ImageIcon(icon3_1));
		mnDepositDetails.setMnemonic('D');
		mnDepositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		mnDepositDetails.addActionListener(this);
		mnMaster.add(mnDepositDetails);
		
		JMenuItem mnCaclBill = new JMenuItem("Calculate Bill");
		mnCaclBill.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnCaclBill.setBackground(Color.WHITE);
		ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
		Image icon4_1 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnCaclBill.setIcon(new ImageIcon(icon4_1));
		mnCaclBill.setMnemonic('E');
		mnCaclBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		mnCaclBill.addActionListener(this);
		mnMaster.add(mnCaclBill);
		
		
		
		JMenu mnInfor = new JMenu("Information");
		mnInfor.setForeground(Color.RED);
		

		JMenuItem mnUpdateInfo = new JMenuItem("Update Information");
		mnUpdateInfo.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnUpdateInfo.setBackground(Color.WHITE);
		ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
		Image icon5_1 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnUpdateInfo.setIcon(new ImageIcon(icon5_1));
		mnUpdateInfo.setMnemonic('U');
		mnUpdateInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
		mnUpdateInfo.addActionListener(this);
		mnInfor.add(mnUpdateInfo);
		
		JMenuItem mnViewInfo = new JMenuItem("View Information");
		mnViewInfo.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnViewInfo.setBackground(Color.WHITE);
		ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
		Image icon6_1 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnViewInfo.setIcon(new ImageIcon(icon6_1));
		mnViewInfo.setMnemonic('V');
		mnViewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		mnViewInfo.addActionListener(this);
		mnInfor.add(mnViewInfo);
		
		
		JMenu mnUser = new JMenu("User");
		mnUser.setForeground(Color.GREEN);
		
		
		JMenuItem mnPayBill = new JMenuItem("Pay Bill");
		mnPayBill.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnPayBill.setBackground(Color.WHITE);
		ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
		Image icon7_1 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnPayBill.setIcon(new ImageIcon(icon7_1));
		mnPayBill.setMnemonic('P');
		mnPayBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		mnPayBill.addActionListener(this);
		mnUser.add(mnPayBill);
		
		JMenuItem mnBillDetails = new JMenuItem("Bill Details");
		mnBillDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnBillDetails.setBackground(Color.WHITE);
		ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
		Image icon8_1 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnBillDetails.setIcon(new ImageIcon(icon8_1));
		mnBillDetails.setMnemonic('B');
		mnBillDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		mnBillDetails.addActionListener(this);
		mnUser.add(mnBillDetails);
		
		
		JMenu mnReport = new JMenu("Report");
		mnReport.setForeground(Color.ORANGE);
	
		
		JMenuItem mnGenBill = new JMenuItem("Generate Bill");
		mnGenBill.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnGenBill.setBackground(Color.WHITE);
		ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
		Image icon9_1 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnGenBill.setIcon(new ImageIcon(icon9_1));
		mnGenBill.setMnemonic('G');
		mnGenBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		mnGenBill.addActionListener(this);
		mnReport.add(mnGenBill);
		
		JMenu mnUtil = new JMenu("Utility");
		mnUtil.setForeground(Color.MAGENTA);
		
		
		JMenuItem mnNote = new JMenuItem("Notepad");
		mnNote.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnNote.setBackground(Color.WHITE);
		ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
		Image icon10_1 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnNote.setIcon(new ImageIcon(icon10_1));
		mnNote.setMnemonic('N');
		mnNote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		mnNote.addActionListener(this);
		mnUtil.add(mnNote);
		
		JMenuItem mnCal = new JMenuItem("Calculator");
		mnCal.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnCal.setBackground(Color.WHITE);
		ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
		Image icon11_1 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnCal.setIcon(new ImageIcon(icon11_1));
		mnCal.setMnemonic('C');
		mnCal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		mnCal.addActionListener(this);
		mnUtil.add(mnCal);
		
		JMenu mnExit = new JMenu("Exit");
		mnExit.setForeground(Color.RED);
		
		JMenuItem mnExit1 = new JMenuItem("Exit");
		mnExit1.setFont(new Font("monospaced", Font.PLAIN, 12));
		mnExit1.setBackground(Color.WHITE);
		ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
		Image icon12_1 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		mnExit1.setIcon(new ImageIcon(icon12_1));
		mnExit1.setMnemonic('X');
		mnExit1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		mnExit1.addActionListener(this);
		mnExit.add(mnExit1);
		
		if(user.equals("Admin")) {
			mnBar.add(mnMaster);
		}else {
			
			mnBar.add(mnInfor);
			mnBar.add(mnReport);
			mnBar.add(mnUser);
			
		}
		
		mnBar.add(mnUtil);
		mnBar.add(mnExit);
		
		
		
		setLayout(new FlowLayout());
		
		setVisible(true);
		
	}
		
	@Override
	public void actionPerformed(ActionEvent ae) {
		String msg =ae.getActionCommand();
		if(msg.equals("New Customer")) {
			new NewCustomer();
		}else if(msg.equals("Customer Details")) {
			new CustomerDetails();
		}else if(msg.equals("Deposit Details")) {
			new DepositDetails();
		}else if(msg.equals("Calculate Bill")) {
			new CalculationBill();
		}else if(msg.equals("View Information")) {
			new ViewInfomation(meter);
		}else if(msg.equals("Update Information")) {
			new UpdateInformation(meter);
		}else if(msg.equals("Bill Details")) {
			new BillDetails(meter);
		}else if(msg.equals("Pay Bill")) {
			new PayBill(meter);
		}else if(msg.equals("Notepad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(msg.equals("Calculator")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(msg.equals("Exit")) {
			setVisible(false);
			
			new Login();
		}else if(msg.equals("Generate Bill")) {
			new GenerateBill(meter);
		}
		
	}

	
	public static void main(String[] args) {
		new Project("","");

	}
	
}
