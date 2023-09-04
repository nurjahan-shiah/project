package employeeManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;  
public class Login extends JFrame implements ActionListener{
	
	JTextField nameFld, passFld;
	
	Login(){
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel adminTitle = new JLabel ("Admin Login");
		adminTitle.setBounds(120,15,300,40);
		adminTitle.setFont(new Font("serif", Font.PLAIN, 30));
		adminTitle.setForeground(Color.BLUE);
		add(adminTitle);
				
		JLabel userName = new JLabel("Username");
		userName.setBounds(40, 65, 100, 30);
		add(userName);
		
		nameFld = new JTextField();
		nameFld.setBounds(150, 65, 150, 30);
		add(nameFld);
		
		JLabel userPass = new JLabel("Password");
		userPass.setBounds(40, 105, 100, 30);
		add(userPass);
		
		passFld = new JTextField();
		passFld.setBounds(150, 105, 150, 30);
		add(passFld);
		
		JButton login = new JButton("LOGIN");
		login.setBounds(100, 165, 150, 30);
		login.addActionListener(this);
		add(login);
		
		JLabel msg = new JLabel ("New admin? Please contact the department to sign up.");
		msg.setBounds(200,220,1000,30);
		msg.setFont(new Font("serif", Font.ITALIC, 15));
		msg.setForeground(Color.DARK_GRAY);
		add(msg);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo-1.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 10, 200, 200);
		add(image);
	
		setSize (600, 300);
		setLocation(450, 200);
		setVisible(true);
	}
	



@Override
public void actionPerformed(ActionEvent e) {
	try {
		String username = nameFld.getText();
		String password = passFld.getText();
		
		Conn c = new Conn(); 
		String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
		
		ResultSet result = c.s.executeQuery(query);
		if (result.next()) {
			setVisible (false);
			new Home();
			JOptionPane.showMessageDialog(null, "Logged in successfully!");
		}else {
			JOptionPane.showMessageDialog(null, "Invalid Username or Password");
			setVisible (false);
		}
	}catch (Exception ae){
		ae.printStackTrace();
	}
	
	
}

public static void main(String[] args) {
	
	 new Login();
	}



}
