import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import java.awt.Color;
import java.awt.Font;

public class Register extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
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
	private Data data;
	public Data data() { return data; }
	private final JFileChooser openFileChooser;
	private BufferedImage originalBI;
	private String filename = null;
	private File transcript;
	
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
	public Register(Data data) {
		this.openFileChooser = new JFileChooser();
		this.data = data;
	
		
		setTitle("University of Calgary Scholarship Application System | New Student Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1052, 754);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(319, 391, 183, -218);
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setBounds(148, 126, 153, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setBounds(40, 131, 85, 16);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 168, 153, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setBounds(40, 173, 85, 16);
		contentPane.add(lblNewLabel_1);
		
		String[] applicantType = { "Undergraduate", "Graduate", "Post-Graduate" };
		JComboBox comboBox = new JComboBox(applicantType);
		comboBox.setToolTipText("");
		comboBox.setBounds(148, 211, 153, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Student Type:");
		lblNewLabel_2.setBounds(38, 216, 109, 16);
		contentPane.add(lblNewLabel_2);
		
		String[] facultyList = {"Arts", "Law", "Nursing", "Kinesiology", "Science", "Social Work", "Veterinary Medicine", "Medicine", "Business", "Engineering", "Education", "Open Studies"};
		JComboBox comboBox_1 = new JComboBox(facultyList);
		comboBox_1.setModel(new DefaultComboBoxModel(facultyList));
		comboBox_1.setBounds(148, 255, 153, 27);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty:");
		lblNewLabel_3.setBounds(40, 260, 85, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department:");
		lblNewLabel_4.setBounds(40, 303, 93, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 298, 153, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(148, 340, 153, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Student ID:");
		lblNewLabel_5.setBounds(40, 345, 85, 16);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(148, 381, 153, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Current GPA:");
		lblNewLabel_6.setBounds(38, 386, 95, 16);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(634, 126, 130, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(634, 211, 130, 26);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(634, 255, 130, 26);
		contentPane.add(passwordField_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(634, 168, 130, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("E-mail Address:");
		lblNewLabel_7.setBounds(452, 131, 140, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Username:");
		lblNewLabel_8.setBounds(452, 173, 109, 16);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Password:");
		lblNewLabel_9.setBounds(451, 216, 94, 16);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Confirm password:");
		lblNewLabel_10.setBounds(452, 260, 140, 16);
		contentPane.add(lblNewLabel_10);
		
		JLabel messageLabel = new JLabel("");
		messageLabel.setBounds(319, 429, 445, 16);
		contentPane.add(messageLabel);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png"));
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				filename = f.getAbsolutePath();
				messageLabel.setText(filename);
				transcript = chooser.getSelectedFile();
				
			}
		});
		btnNewButton.setBounds(148, 424, 153, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_11 = new JLabel("Transcripts:");
		lblNewLabel_11.setBounds(40, 430, 119, 16);
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
					JOptionPane.showMessageDialog(null, "Account created.");
				}
				catch(IOException e3){
					e3.printStackTrace();
				}

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
					String username = textField_6.getText();
					String studentID = textField_3.getText();
					
					String name = studentFirstName + " " + studentLastName;
					Applicant newStudent = new Applicant(name, studentID, studentType, studentFaculty, studentDepartment, studentGpa, username, password, "student");
					newStudent.setEmail(textField_5.getText());
					newStudent.addStudentFile(transcript);
					
					//Creates the student, adds it to Data user arraylist
					data.addUser(newStudent);
					data.saveData();
					
					//Clear the Screen
					dispose();
					ApplicantLogin appLog = new ApplicantLogin(data, newStudent, 0);
					appLog.setVisible(true);
				
				
			}}}
		);
		btnNewButton_1.setBounds(462, 526, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login window = new Login(data);
				window.frmLogin().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(307, 526, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_12 = new JLabel("University of Calgary Scholarship Application System");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_12.setBounds(0, 0, 519, 36);
		contentPane.add(lblNewLabel_12);
		
		
		}
	
	
}
			