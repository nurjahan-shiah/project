package employeeManagementSystem;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import com.toedter.calendar.*;




public class AddEmployee extends JFrame implements ActionListener{

	Random random = new Random();
	int number = random.nextInt(999999);
	
	JLabel heading, labelName, id, ID, address, phoneNo, email, position, jD, salary, sin;
	JTextField naming, add, no, eml, slry, SIN;
	JDateChooser join;
	JComboBox pos;
	JButton details, back;
			
	public AddEmployee() {
		
		getContentPane().setBackground(Color.DARK_GRAY); //background color
		setLayout(null);
		
		heading = new JLabel ("Add Employee Details");
		heading.setBounds(320,30,500,50);
		heading.setFont(new Font("TAHOMA", Font.BOLD, 25));
		heading.setForeground(Color.white);
		add(heading);
		
		labelName = new JLabel ("Name");
		labelName.setBounds(50,150,150,30);
		labelName.setFont(new Font("serif", Font.PLAIN, 20));
		labelName.setForeground(Color.white);
		add(labelName);
		
		naming = new JTextField();
		naming.setBounds(200, 150, 150, 30);
		naming.setFont(new Font("serif", Font.BOLD, 20));
		naming.setForeground(Color.blue);
		add(naming);
		
		id = new JLabel ("Employee ID:");
		id.setBounds(400 ,150 ,150,30);
		id.setFont(new Font("serif", Font.PLAIN, 20));
		id.setForeground(Color.white);
		add(id);
		
		ID = new JLabel("" + number);
		ID.setBounds(600, 140, 150, 40);
		ID.setFont(new Font("TAHOMA",Font.PLAIN, 30));
		ID.setForeground(Color.GREEN);
		add(ID);
		
		address = new JLabel ("Current Address");
		address.setBounds(50 ,200 ,150,30);
		address.setFont(new Font("serif", Font.PLAIN, 20));
		address.setForeground(Color.white);
		add(address);
		
		add = new JTextField();
		add.setBounds(200, 200, 150, 30);
		add.setFont(new Font("serif", Font.BOLD, 20));
		add.setForeground(Color.blue);
		add(add);
		
		phoneNo = new JLabel ("Telephone No.");
		phoneNo.setBounds(400 ,200 ,150,30);
		phoneNo.setFont(new Font("serif", Font.PLAIN, 20));
		phoneNo.setForeground(Color.white);
		add(phoneNo);
		
		no = new JTextField();
		no.setBounds(600, 200, 150, 30);
		no.setFont(new Font("serif", Font.BOLD, 20));
		no.setForeground(Color.blue);
		add(no);
		
		email = new JLabel ("E-mail address");
		email.setBounds(50 ,250 ,150,30);
		email.setFont(new Font("serif", Font.PLAIN, 20));
		email.setForeground(Color.white);
		add(email);
		
		eml = new JTextField ();
		eml.setBounds(200, 250, 150, 30);
		eml.setFont(new Font("serif", Font.BOLD, 20));
		eml.setForeground(Color.blue);
		add(eml);
		
		position = new JLabel ("Position");
		position.setBounds(400 ,250 ,150,30);
		position.setFont(new Font("serif", Font.PLAIN, 20));
		position.setForeground(Color.white);
		add(position);
		
		String poses[] = {"Select One", "Internship", "Level-1", "Level-2", "Level-3"};
		pos = new JComboBox (poses);
		pos.setBounds(600, 250, 150, 30);
		add(pos);
		
		jD = new JLabel ("Joining Date");
		jD.setBounds(50 ,300 ,150,30);
		jD.setFont(new Font("serif", Font.PLAIN, 20));
		jD.setForeground(Color.white);
		add(jD);
		
		join = new JDateChooser ();
		join.setBounds(200, 300, 150, 30);
		add(join);
		
		salary = new JLabel ("Salary");
		salary.setBounds(400 ,300 ,150,30);
		salary.setFont(new Font("serif", Font.PLAIN, 20));
		salary.setForeground(Color.white);
		add(salary);
		
		slry = new JTextField();
		slry.setBounds(600, 300, 150, 30);
		slry.setFont(new Font("serif", Font.BOLD, 20));
		slry.setForeground(Color.blue);
		add(slry);
		
		sin = new JLabel ("Social Security Number");
		sin.setBounds(50 ,350 ,200,30);
		sin.setFont(new Font("serif", Font.PLAIN, 20));
		sin.setForeground(Color.white);
		add(sin);
		
		SIN = new JTextField();
		SIN.setBounds(260, 350, 150, 30);
		SIN.setFont(new Font("serif", Font.BOLD, 20));
		SIN.setForeground(Color.blue);
		add(SIN);
		
		details = new JButton("Add Employee");
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
		
			String name = naming.getText();
			String eID = ID.getText();
			String address = add.getText();
			String tel = no.getText();
			String email = eml.getText();
			String pstn = (String)pos.getSelectedItem();
			String joinn = ((JTextField) join.getDateEditor().getUiComponent()).getText();
			String slryy = slry.getText();
			String siin = SIN.getText();
			try {
				Conn conn = new Conn ();
				String query = "insert into employee values('"+name+"','"+eID+"','"+address+"','"+tel+"','"+email+"','"+pstn+"','"+joinn+"','"+slryy+"','"+siin+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee Added Successfully!");
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
		new AddEmployee ();

	}


}
