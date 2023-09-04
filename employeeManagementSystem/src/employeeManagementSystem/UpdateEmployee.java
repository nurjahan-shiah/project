package employeeManagementSystem;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import com.toedter.calendar.*;
import java.sql.*;



public class UpdateEmployee extends JFrame implements ActionListener{

	JLabel heading, labelName, id, ID, address, phoneNo, email, position, jD, salary, sin, join, SIN;
	
	JTextField newName, naming, add, no, eml, slry;

	JComboBox pos;
	JButton details, back;
	String cID;
	

	String eID;
	
	public UpdateEmployee(String eID) {
		
		this.eID = eID;
		getContentPane().setBackground(Color.LIGHT_GRAY); //background color
		setLayout(null);
		
		heading = new JLabel ("Update Employee Details");
		heading.setBounds(320,30,500,50);
		heading.setFont(new Font("TAHOMA", Font.BOLD, 25));
		heading.setForeground(Color.black);
		add(heading);
		
		JLabel subHeading = new JLabel ("Need to update EMPLOYEE NAME? Please contact the HR.");
		subHeading.setBounds(320,70,500,50);
		subHeading.setFont(new Font("serif", Font.ITALIC, 15));
		subHeading.setForeground(Color.black);
		add(subHeading);
		
		labelName = new JLabel ("Name");
		labelName.setBounds(50,150,150,30);
		labelName.setFont(new Font("serif", Font.PLAIN, 20));
		labelName.setForeground(Color.black);
		add(labelName);
		
		newName = new JTextField();
		newName.setBounds(200, 150, 150, 30);
		newName.setFont(new Font("serif", Font.BOLD, 20));
		newName.setForeground(Color.red);
		add(newName);
		
		id = new JLabel ("Employee ID:");
		id.setBounds(400 ,150 ,150,30);
		id.setFont(new Font("serif", Font.PLAIN, 20));
		id.setForeground(Color.black);
		add(id);
		
		ID = new JLabel();
		ID.setBounds(600, 140, 150, 40);
		ID.setFont(new Font("TAHOMA",Font.PLAIN, 30));
		ID.setForeground(Color.red);
		add(ID);
		
		address = new JLabel ("Current Address");
		address.setBounds(50 ,200 ,150,30);
		address.setFont(new Font("serif", Font.PLAIN, 20));
		address.setForeground(Color.black);
		add(address);
		
		add = new JTextField();
		add.setBounds(200, 200, 150, 30);
		add.setFont(new Font("serif", Font.BOLD, 20));
		add.setForeground(Color.blue);
		add(add);
		
		phoneNo = new JLabel ("Telephone No.");
		phoneNo.setBounds(400 ,200 ,150,30);
		phoneNo.setFont(new Font("serif", Font.PLAIN, 20));
		phoneNo.setForeground(Color.black);
		add(phoneNo);
		
		no = new JTextField();
		no.setBounds(600, 200, 150, 30);
		no.setFont(new Font("serif", Font.BOLD, 20));
		no.setForeground(Color.blue);
		add(no);
		
		email = new JLabel ("E-mail address");
		email.setBounds(50 ,250 ,150,30);
		email.setFont(new Font("serif", Font.PLAIN, 20));
		email.setForeground(Color.black);
		add(email);
		
		eml = new JTextField ();
		eml.setBounds(200, 250, 150, 30);
		eml.setFont(new Font("serif", Font.BOLD, 20));
		eml.setForeground(Color.blue);
		add(eml);
		
		position = new JLabel ("Position");
		position.setBounds(400 ,250 ,150,30);
		position.setFont(new Font("serif", Font.PLAIN, 20));
		position.setForeground(Color.black);
		add(position);
		
		String poses[] = {"Select One", "Internship", "Level-1", "Level-2", "Level-3"};
		pos = new JComboBox(poses);
		//pos = new JTextField();
		pos.setBounds(600, 250, 150, 30);
		add(pos);
		
		jD = new JLabel ("Joining Date");
		jD.setBounds(50 ,300 ,150,30);
		jD.setFont(new Font("serif", Font.PLAIN, 20));
		jD.setForeground(Color.black);
		add(jD);
		
		join = new JLabel();
		join.setBounds(200, 300, 150, 30);
		join.setFont(new Font("serif", Font.BOLD, 20));
		add(join);
		
		salary = new JLabel ("Salary");
		salary.setBounds(400 ,300 ,150,30);
		salary.setFont(new Font("serif", Font.PLAIN, 20));
		salary.setForeground(Color.black);
		add(salary);
		
		slry = new JTextField();
		slry.setBounds(600, 300, 150, 30);
		slry.setFont(new Font("serif", Font.BOLD, 20));
		slry.setForeground(Color.blue);
		add(slry);
		
		sin = new JLabel ("Social Security Number");
		sin.setBounds(50 ,350 ,200,30);
		sin.setFont(new Font("serif", Font.PLAIN, 20));
		sin.setForeground(Color.black);
		add(sin);
		
		SIN = new JLabel();
		SIN.setBounds(260, 350, 150, 30);
		SIN.setFont(new Font("serif", Font.BOLD, 20));
		SIN.setForeground(Color.red);
		add(SIN);
		
		try {
			Conn c = new Conn ();
			ResultSet result = c.s.executeQuery("select * from employee where ID='"+eID+"'");
			
			while (result.next()) {
				newName.setText(result.getString("Name"));
				ID.setText(result.getString("id"));
				add.setText(result.getString("address"));
				no.setText(result.getString("tel"));
				eml.setText(result.getString("email"));
				//pos.setToolTipText(result.getString("position"));
			
				String positionValue = result.getString("position");
				if (positionValue != null) {
				    pos.setSelectedItem(positionValue);
				}

				join.setText(result.getString("joining"));
				slry.setText(result.getString("salary"));
				SIN.setText(result.getString("SIN"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		details = new JButton("Update details");
		details.setBounds(250, 450, 150, 40);
		details.addActionListener(this);
		add(details);
		
		back = new JButton("Previous");
		back.setBounds(450, 450, 150, 40);
		back.addActionListener(this);
		add(back);
		
		setSize (900, 600);
		setLocation(300, 50);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == details) {
		
			String name = newName.getText();
			String address = add.getText();
			String tel = no.getText();
			String email = eml.getText();
			String pstn = pos.getSelectedItem().toString();
			String slryy = slry.getText();
			
			try {
				Conn conn = new Conn ();
				String query = "update employee set Name='"+name+"',address='"+address+"', Tel= '"+tel+"',email = '"+email+"', position = '"+pstn+"', salary = '"+slryy+"' where ID='"+eID+"'";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee Updated Successfully!");
				setVisible (false);
				new ViewEmployee();
			
			}catch (Exception ae) {
				ae.printStackTrace();
			}
			
		}else {
			setVisible (false);
			new Home();
		}
		
	}
	public static void main(String[] args) {
		new UpdateEmployee("");
		

	}


}
