package employeeManagementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.*;

public class ViewEmployee extends JFrame implements ActionListener{

		JTable table, table1;
		Choice  cID;
		JButton search, print, update, remove, back, add;
	
	 ViewEmployee() {
		
		getContentPane().setBackground(Color.LIGHT_GRAY); //background color
		setLayout(null);
		
		
		//search by ID 
		
				JLabel searchID = new JLabel ("Search by Employee: ");
				searchID.setBounds(220, 20, 200, 30);
				searchID.setFont(new Font("serif", Font.BOLD, 20));
				searchID.setForeground(Color.black);
				add(searchID);
				
				cID = new Choice();
				cID.setBounds(430, 22, 150, 30);
				cID.setFont(new Font("serif", Font.PLAIN, 20));
				add(cID);
				
				try {
					Conn c = new Conn ();
					ResultSet result = c.s.executeQuery("select * from employee");
					
					while (result.next()) {
						cID.add(result.getString("ID"));
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				table = new JTable();
				
				try {
					Conn c = new Conn ();
					ResultSet result = c.s.executeQuery("select * from employee");
					table.setModel(DbUtils.resultSetToTableModel(result));
					
					
				}catch (Exception e) {
					e.printStackTrace();
				}
		 JScrollPane jsp = new JScrollPane(table);
		 jsp.setBounds(10, 120, 865, 640);
		 add(jsp);
		 
		search = new JButton ("Search");
		search.setBounds(20, 70, 80, 20);
		search.addActionListener(this);
		add(search);
		
		print = new JButton ("Print");
		print.setBounds(120, 70, 80, 20);
		print.addActionListener(this);
		add(print);
		
		add = new JButton ("Add");
		add.setBounds(220, 70, 80, 20);
		add.addActionListener(this);
		add(add);
		
		update = new JButton ("Update");
		update.setBounds(320, 70, 80, 20);
		update.addActionListener(this);
		add(update);
		
		remove = new JButton ("Remove");
		remove.setBounds(420, 70, 100, 20);
		remove.addActionListener(this);
		add(remove);
		
		back = new JButton ("Back");
		back.setBounds(540, 70, 80, 20);
		back.addActionListener(this);
		add(back);
		 
		setSize (900, 700);
		setLocation(300, 100);
		setVisible(true);

}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == search) {
			
		
			String query1 = "select * from employee where ID = '"+cID.getSelectedItem()+"'";
			try {
				Conn c = new Conn();
	
				
				ResultSet rs = c.s.executeQuery(query1);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (ae.getSource() == print) {
			try {
				table.print();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (ae.getSource() == update) {
			setVisible(false);
		
			new UpdateEmployee(cID.getSelectedItem());
			
		}else if (ae.getSource() == remove) {
			setVisible(false);
		
			new RemoveEmployee();
			
		}else if (ae.getSource() == add) {
			setVisible(false);
		
			new AddEmployee();
			
		}else {
			setVisible(false);
			new Home();
		}
		
	}
	
	public static void main(String[] args) {
		new ViewEmployee();

	}

}
