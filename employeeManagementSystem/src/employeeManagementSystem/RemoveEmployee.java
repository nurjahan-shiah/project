package employeeManagementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.*;
public class RemoveEmployee extends JFrame implements ActionListener{
	
	Choice eID;
	JButton delete, back;

	 RemoveEmployee() {
			getContentPane().setBackground(Color.WHITE); //background color
			setLayout(null);
			
			JLabel labelID = new JLabel ("Employee ID");
			labelID.setFont(new Font("serif", Font.PLAIN, 20));
			labelID.setBounds(50, 50, 150, 30);
			add(labelID);
			
			eID = new Choice();
			eID.setBounds(200, 50, 150, 30);
			eID.setFont(new Font("serif", Font.PLAIN, 20));
			add(eID);
			
			try {
				Conn c = new Conn();
				String query = "select * from employee";
				ResultSet rs = c.s.executeQuery(query);
				while (rs.next()) {
					eID.add(rs.getString("ID")); /////////////////////////////
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			JLabel labelname = new JLabel("Name");
			labelname.setFont(new Font("serif", Font.PLAIN, 20));
	        labelname.setBounds(50, 100, 100, 30);
	        add(labelname);
	        
	        JLabel lblname = new JLabel();
	        lblname.setFont(new Font("serif", Font.PLAIN, 20));
	        lblname.setForeground(Color.blue);
	        lblname.setBounds(200, 100, 100, 30);
	        add(lblname);
	        
	        JLabel labelphone = new JLabel("Phone");
	        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
	        labelphone.setBounds(50, 150, 100, 30);
	        add(labelphone);
	        
	        JLabel lblphone = new JLabel();
	        lblphone.setFont(new Font("serif", Font.PLAIN, 20));
	        lblphone.setForeground(Color.blue);
	        lblphone.setBounds(200, 150, 200, 30);
	        add(lblphone);
	        
	        JLabel labelemail = new JLabel("Email");
	        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
	        labelemail.setBounds(50, 200, 100, 30);
	        add(labelemail);
	        
	        JLabel lblemail = new JLabel();
	        lblemail.setFont(new Font("serif", Font.PLAIN, 15));
	        lblemail.setForeground(Color.blue);
	        lblemail.setBounds(200, 200, 200, 30);
	        add(lblemail);
	        
	        try {
	            Conn c = new Conn();
	            String query = "select * from employee where ID = '"+eID.getSelectedItem()+"'";
	            ResultSet rs = c.s.executeQuery(query);
	            while(rs.next()) {
	                lblname.setText(rs.getString("Name"));
	                lblphone.setText(rs.getString("Tel"));
	                lblemail.setText(rs.getString("email"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        eID.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent ie) {
	                try {
	                    Conn c = new Conn();
	                    String query = "select * from employee where ID = '"+eID.getSelectedItem()+"'";
	                    ResultSet rs = c.s.executeQuery(query);
	                    while(rs.next()) {
	                        lblname.setText(rs.getString("Name"));
	                        lblphone.setText(rs.getString("Tel"));
	                        lblemail.setText(rs.getString("email"));
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	        
	        delete = new JButton("Delete");
	        delete.setBounds(80, 300, 100,30);
	        delete.setBackground(Color.BLACK);
	        delete.setForeground(Color.WHITE);
	        delete.addActionListener(this);
	        add(delete);
	        
	        back = new JButton("Back");
	        back.setBounds(220, 300, 100,30);
	        back.setBackground(Color.BLACK);
	        back.setForeground(Color.WHITE);
	        back.addActionListener(this);
	        add(back);
	        
	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/4.png"));
	        Image i2 = i1.getImage().getScaledInstance(650, 400, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(360, 0, 650, 400);
	        add(image);
	        
			
		setSize(1000, 400);
		setLocation (300,150);
		setVisible(true);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from employee where ID = '"+eID.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
                setVisible(false);
                new ViewEmployee();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
	}
		public static void main(String[] args) {
			new RemoveEmployee();

		

		
	}

}
