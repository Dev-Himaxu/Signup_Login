package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dbconnection.Getconnection;

public class Login extends JFrame {

	JLabel userLabel , passLabel;
	JTextField userField , passField;
	JButton submitButton,resetButton;
	
	public Login() {
	setLayout(new FlowLayout());
	setTitle("Login");
	
	userLabel = new JLabel("Username");
	userField = new JTextField(20);
	passLabel = new JLabel("Password");
	passField = new JTextField(20);
	
	submitButton = new JButton("Submit");
	submitButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ResultSet rs = Getconnection.getConnection()
						.prepareStatement("select * from login").executeQuery();
				rs.next();
				
			String u = rs.getString(1);
			String p =  rs.getString(2);
			
			if (userField.getText().equals(u) && passField.getText().equals(p)) {
				new Signup();
				System.out.println("logged in succesfully...");
			}else {
				System.out.println("username or password wrong");
			}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	});
	resetButton = new JButton("Reset");
	resetButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			userField.setText("");
			passField.setText("");
			
		}
	});
	
	add(userLabel);
	add(userField);
	add(passLabel);
	add(passField);
	add(submitButton);
	add(resetButton);
	
	setVisible(true);
	setSize(500,500);
	}
	public static void main(String[] args) {
		new Login();
	}
}
