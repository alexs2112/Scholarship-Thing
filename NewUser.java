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

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label;
	private JComboBox comboBox;
	/*
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel label_3;
	*/
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAward frame = new NewAward();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewUser() {
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(156, 21, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(29, 26, 115, 16);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(29, 54, 115, 16);
		contentPane.add(lblNewLabel_1);

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
					
					try {
						//create file
						FileWriter fstream = new FileWriter("Resources\\login.txt", true);
							BufferedWriter out = new BufferedWriter(fstream);
							out.write(newUser.username() + " " + newUser.password() + " " + newUser.role() + "\n");
							//close the output stream
							out.close();
					} catch (Exception ex) {
						System.err.println("Error: " + ex.getMessage());
					}
				dispose();
			}
				}
		});
		btnNewButton.setBounds(166, 219, 117, 29);
		contentPane.add(btnNewButton);
	}

}
