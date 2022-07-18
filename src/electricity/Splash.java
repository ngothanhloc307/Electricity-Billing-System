package electricity;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable {
	
	Thread t;
	public Splash() {
		
		ImageIcon img_icon = new ImageIcon(ClassLoader.getSystemResource("icon/ellect_icon.png"));
		setIconImage(img_icon.getImage());
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
		Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		setVisible(true);
	
		int x =  1;
		for(int i= 2; i< 600 ; i+=4) {
			setSize(i + x, i);
			setLocation(1100 -(i+ x/2),400 -(i/2));
			try {
				Thread.sleep(3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		t= new Thread(this);
		t.start();
		
		setVisible(true);
	}

	
	@Override
	public void run() {
		try {
			Thread.sleep(7000);
			setVisible(false);
			
			// login frame
			new Login();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Splash();
	}

}
