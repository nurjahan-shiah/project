package employeeManagementSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Splash extends JFrame implements ActionListener{
	
	Splash () {

		getContentPane().setBackground(Color.DARK_GRAY); //background color
		setLayout(null);
		
		JLabel heading = new JLabel ("Employee Management System");
		heading.setBounds(80,30,1200,60);
		heading.setFont(new Font("serif", Font.PLAIN, 60));
		heading.setForeground(Color.cyan);
		add(heading);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/4 copy.png"));
		Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(50, 100, 1050, 500);
		add(image);
		 
		JButton clickage = new JButton("Admin login");
		clickage.setBounds(400, 400, 300, 70);
		clickage.addActionListener(this); //button clicked
		image.add(clickage);
		
		setSize (1170,650); //frame size
		setLocation(200, 50);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
	 new Splash();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible (false);
		new Login();
		
	}

}
