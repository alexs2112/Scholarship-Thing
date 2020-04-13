import java.awt.BorderLayout;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class NewUser extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblPassword;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	//private Data data;

	/**
	 * Create the frame.
	 */
	public NewUser(Data data) {
		setTitle("University of Calgary Scholarship Application System | New User");
		//this.data = data;
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(296, 83, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(156, 88, 115, 16);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setBounds(156, 135, 115, 16);
		contentPane.add(lblNewLabel_1);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(156, 182, 115, 16);
		contentPane.add(lblPassword);

		textField_1 = new JTextField();
		textField_1.setBounds(296, 130, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(296, 177, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		String[] roleBox = {"Administrator", "Coordinator", "Professor"};
		comboBox = new JComboBox(roleBox);
		comboBox.setBounds(296, 219, 130, 27);
		contentPane.add(comboBox);

		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please ensure all fields are complete");
				}else {
					String name = textField.getText();
					String username = textField_1.getText();
					String password = textField_2.getText();
					String role = comboBox.getSelectedItem().toString();
					String convertedRole;
					if (role == "Administrator")
						convertedRole = "admin";
					else if (role == "Coordinator")
						convertedRole = "sc";
					else if (role == "Professor")
						convertedRole = "prof";
					else
						convertedRole = "ERROR";
					
					User newUser = new User(name, convertedRole, username, password);
					data.addUser(newUser);
					data.saveData();
				dispose();
			}
				}
		});
		btnNewButton.setBounds(296, 319, 117, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("University of Calgary Scholarship Application System");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(0, 0, 477, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Role:");
		lblNewLabel_3.setBounds(156, 226, 92, 20);
		contentPane.add(lblNewLabel_3);
	}

}