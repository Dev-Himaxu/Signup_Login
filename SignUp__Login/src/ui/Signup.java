package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dbconnection.Getconnection;
import operation.OperationSignup;

public class Signup extends JFrame {

	JLabel nameLabel ,contactLabel,genderJLabel,commentLabel,cityLabel;
	JTextField nField , contactField,genderField, commentField,cityField;
	JButton submiButton, resetButton;
	
	public Signup() {
		setLayout( new FlowLayout());
		
		setTitle("Sign Up");
		
		nameLabel = new JLabel("Name");
		nField = new JTextField(20);
		contactLabel = new JLabel("Contact");
		contactField = new JTextField(20);
		genderJLabel = new JLabel("Gender");
		genderField = new JTextField(20);
		commentLabel = new JLabel("Comment");
		commentField = new JTextField(20);
		cityLabel = new  JLabel("City");
		cityField = new JTextField(20);
		
		CredPojo obj = new CredPojo();
		submiButton = new JButton("Submit");
		submiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				obj.setName(nField.getText());
				obj.setContact(contactField.getText());
				obj.setComment(commentField.getText());
				obj.setGender(genderField.getText());
				obj.setCity(cityField.getText());
				
				new OperationSignup().Submit(obj);
								
			}
		});
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nField.setText("");
				contactField.setText("");
				commentField.setText("");
				genderField.setText("");
				cityField.setText("");
				
				
			}
		});
		
		
		add(nameLabel);
		add(nField);
		add(commentLabel);
		add(commentField);
		add(contactLabel);
		add(contactField);
		add(genderJLabel);
		add(genderField);
		add(cityLabel);
		add(cityField);
		add(submiButton);
		add(resetButton);
		setVisible(true);
		setSize(342,400);
		
	}
}
