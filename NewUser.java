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

public class NewUser extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label;
	private JComboBox comboBox;
	private JButton btnNewButton;
	//private Data data;

	/**
	 * Create the frame.
	 */
	public NewUser(Data data) {
		//this.data = data;
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(156, 21, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(29, 26, 115, 16);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(29, 54, 115, 16);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("Password");
		label.setBounds(29, 82, 115, 16);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setBounds(156, 49, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(156, 77, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		String[] roleBox = {"Administrator", "Coordinator", "Professor"};
		comboBox = new JComboBox(roleBox);
		comboBox.setBounds(156, 108, 130, 27);
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
		btnNewButton.setBounds(166, 219, 117, 29);
		contentPane.add(btnNewButton);
	}

}
