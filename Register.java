import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Checks is a string is numerical
	 */
	public boolean isNum(String string){
        try {
            Float.parseFloat(string);
            return true;
        }
        catch(NumberFormatException nfe){
            return false;
        }
    }

	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("New Student Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(319, 391, 183, -218);
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setBounds(137, 22, 153, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(40, 27, 85, 16);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 60, 153, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(40, 65, 85, 16);
		contentPane.add(lblNewLabel_1);
		
		String[] applicantType = { "Undergraduate", "Graduate", "Post-Graduate" };
		JComboBox comboBox = new JComboBox(applicantType);
		comboBox.setToolTipText("");
		comboBox.setBounds(137, 98, 153, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Student Type");
		lblNewLabel_2.setBounds(40, 102, 85, 16);
		contentPane.add(lblNewLabel_2);
		
		String[] facultyList = {"Arts", "Law", "Nursing", "Kinesiology", "Science", "Social Work", "Veterinary Medicine", "Medicine", "Business", "Engineering", "Education", "Open Studies"};
		JComboBox comboBox_1 = new JComboBox(facultyList);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Arts", "Law", "Nursing", "Kinesiology", "Science", "Social Work", "Veterinary Medicine", "Medicine", "Business", "Engineering", "Education"}));
		comboBox_1.setBounds(137, 137, 153, 27);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty");
		lblNewLabel_3.setBounds(40, 141, 85, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setBounds(40, 183, 85, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 178, 153, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(137, 216, 153, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Student ID");
		lblNewLabel_5.setBounds(40, 221, 85, 16);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(137, 254, 153, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Current GPA");
		lblNewLabel_6.setBounds(40, 259, 85, 16);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(510, 71, 130, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(510, 147, 130, 26);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(510, 178, 130, 26);
		contentPane.add(passwordField_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(510, 109, 130, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("E-mail Address");
		lblNewLabel_7.setBounds(389, 76, 109, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Username");
		lblNewLabel_8.setBounds(389, 114, 109, 16);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Password");
		lblNewLabel_9.setBounds(389, 152, 94, 16);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Re-type Password");
		lblNewLabel_10.setBounds(389, 185, 130, 16);
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.setBounds(147, 292, 130, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_11 = new JLabel("Transcripts");
		lblNewLabel_11.setBounds(40, 297, 119, 16);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char[] pass = passwordField.getPassword();
				char[] pass1 = passwordField_1.getPassword();
				String password = String.valueOf(pass);
				String gpa = textField_4.getText();
				ArrayList<String> uNList = new ArrayList<String>();
				try{
					BufferedReader read = new BufferedReader(new FileReader("Resources/login.txt"));
					String line = read.readLine();
						while (line != null){
							String cLine[] = line.split(" ");
							uNList.add(cLine[0]);
							line = read.readLine();
						}
					read.close();
				}
				catch(FileNotFoundException fnfe){
					JOptionPane.showMessageDialog(null, "Account file not found.");
				}
				catch(IOException e3){
					e3.printStackTrace();
				}

				LoginCheck register = new LoginCheck();
				
				if (textField.getText().contentEquals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please ensure all fields are complete");
				
					
				} else if (!Arrays.equals(pass, pass1)) {
					JOptionPane.showMessageDialog(null, "Passwords do not match!");

				} else if(isNum(gpa) == false) {
					JOptionPane.showMessageDialog(null, "Please enter an integer value for GPA.");

				} else if(uNList.contains(textField_6.getText()) == true){
					JOptionPane.showMessageDialog(null, "Username already exists.");

				} else {
					String studentFirstName = textField.getText();
					String studentLastName = textField_1.getText();
					String studentType = comboBox.getSelectedItem().toString();
					String studentFaculty = comboBox_1.getSelectedItem().toString();
					String studentDepartment = textField_2.getText();
					Float studentGpa = Float.parseFloat(gpa);
					Integer studentLevel = 0;
					String username = textField_6.getText();
					try{
						register.addToFile(username, password);
					}
					catch (IOException e1){
						e1.printStackTrace();
					}
					Applicant newStudent = new Applicant(studentFirstName, studentLastName, studentType, studentFaculty, studentDepartment, studentGpa, username);
					newStudent.setLevel(0);
					// System.out.println(newStudent.getFirstName() + " " + newStudent.getLastName());
					//for testing
					dispose();
					ApplicantLogin appLog = new ApplicantLogin();
					appLog.setVisible(true);
				
				
			}}}
		);
		btnNewButton_1.setBounds(523, 292, 117, 29);
		contentPane.add(btnNewButton_1);
		}}
		
	

