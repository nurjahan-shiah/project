package employeeManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
	
	JButton add, remove, edit, view; 
	Home(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/3 (1).png"));
		Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1120, 630);
		add(image);
		
		// add a black background
		JLabel titl = new JLabel ("Admin Profile");
		titl.setBounds(10,-30,4000,80);
		titl.setFont(new Font("TAHOMA", Font.PLAIN, 10));
		titl.setForeground(Color.black);
		image.add(titl);
		
		
		JLabel title = new JLabel ("Manage Your Employees");
		title.setBounds(447,5,4000,80);
		title.setFont(new Font("TAHOMA", Font.BOLD, 52));
		title.setForeground(Color.red);
		image.add(title);
		
		add = new JButton ("Add New Employee");
		add.setBounds(730, 390, 150, 40);
		add.addActionListener(this);
		image.add(add);
		
		remove = new JButton ("Remove Employee");
		remove.setBounds(730, 440, 150, 40);
		remove.addActionListener(this);
		image.add(remove);
		
		edit = new JButton ("Update Employee");
		edit.setBounds(730, 490, 150, 40);
		edit.addActionListener(this);
		image.add(edit);
		
		view = new JButton ("Employee List");
		view.setBounds(730, 540, 150, 40);
		view.addActionListener(this);
		image.add(view);
		
		
		
		setSize (1120, 630);
		setLocation(250, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Home();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			setVisible(false);
			new AddEmployee();
		}else if (e.getSource() == remove) {
			setVisible(false);
			new RemoveEmployee();	
		}else if (e.getSource() == edit) {
			setVisible(false);
			new ViewEmployee();
		}else {
			setVisible(false);
			new ViewEmployee();
		}
		
	}

}
