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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class NewAward extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private ArrayList<Scholarship> allScholarships = new ArrayList<Scholarship>();

	public ArrayList<Scholarship> getAllSchol() {
		return allScholarships;
	}

	/**
	 * Create the frame.
	 */
	public NewAward(Data data) {
		
		//Design Elements
		setTitle("University of Calgary Scholarship Application System | New Award");
		setBounds(100, 100, 744, 500);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextField textField = new JTextField();
		textField.setBounds(155, 70, 195, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		//Scholarship Name
		JLabel lblNewLabel = new JLabel("Scholarship Name:");
		lblNewLabel.setBounds(29, 70, 139, 16);
		contentPane.add(lblNewLabel);
		
		//Scholarship Faculty
		JLabel lblFaculty = new JLabel("Faculty:");
		lblFaculty.setBounds(380, 70, 80, 16);
		contentPane.add(lblFaculty);
		
		//List of applicable faculties
		String[] facultyList = {"None", "Arts", "Law", "Nursing", "Kinesiology", "Science", "Social Work", "Veterinary Medicine", "Medicine", "Business", "Engineering", "Education", "Open Studies"};
		JComboBox facultyBox = new JComboBox(facultyList);
		facultyBox.setModel(new DefaultComboBoxModel(facultyList));
		facultyBox.setBounds(490, 70, 195, 27);
		contentPane.add(facultyBox);
		
		//Name of scholarship donor
		JLabel lblNewLabel_1 = new JLabel("Name of Donor:");
		lblNewLabel_1.setBounds(29, 117, 115, 16);
		contentPane.add(lblNewLabel_1);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(155, 112, 195, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		//Department for Scholarship (if applicable)
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(380, 117, 80, 16);
		contentPane.add(lblDepartment);
		
		JTextField textDepartment = new JTextField("None");
		textDepartment.setBounds(490, 112, 195, 26);
		contentPane.add(textDepartment);
		textDepartment.setColumns(10);

		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(155, 154, 195, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		//value of Scholarship
		JLabel lblValueOfAward = new JLabel("Value of Award:");
		lblValueOfAward.setBounds(29, 159, 115, 16);
		contentPane.add(lblValueOfAward);
		
		//Scholarship is for what type of student/applicant
		JLabel lblStudentType = new JLabel("Type of Student:");
		lblStudentType.setBounds(380, 159, 110, 16);
		contentPane.add(lblStudentType);
		
		//list of student types
		String[] studentType = { "None", "Undergraduate", "Graduate", "Post-Graduate" };
		JComboBox studentBox = new JComboBox(studentType);
		studentBox.setBounds(490, 155, 195, 27);
		contentPane.add(studentBox);

		//list of terms
		String[] termBox = {"Annual", "Fall", "Winter"};
		JComboBox comboBox = new JComboBox(termBox);
		comboBox.setBounds(155, 196, 195, 27);
		contentPane.add(comboBox);

		//term schoalrship is for
		JLabel lblTerm = new JLabel("Term:");
		lblTerm.setBounds(29, 201, 115, 16);
		contentPane.add(lblTerm);

		//Scholarships minimum GPA reqs
		JLabel lblGpaRequirement = new JLabel("GPA Requirement:");
		lblGpaRequirement.setBounds(29, 244, 139, 16);
		contentPane.add(lblGpaRequirement);

		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(155, 239, 195, 26);
		contentPane.add(textField_3);

		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(155, 285, 195, 26);
		contentPane.add(textField_4);

		//How many scholarships are available
		JLabel lblAwardsAvailable = new JLabel("Awards Available:");
		lblAwardsAvailable.setBounds(29, 290, 139, 16);
		contentPane.add(lblAwardsAvailable);

		//action handler for save button
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if any of the test fields are left blank, prompts use to make sure they are all complete
				if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please ensure all fields are complete");
				
				//if the GPA req is below 0.0 or above 4.0, prompts user to make sure GPA req are within range
				} else if ( Float.parseFloat(textField_3.getText()) > 4.0 || Float.parseFloat(textField_3.getText()) < 0.0 )  {
					JOptionPane.showMessageDialog(null, "Required GPA cannot be less than 0.0 or greater than 4.0");

				//otherwise, create new award with details provided in textfields
				}else {
					String scholName = textField.getText();
					String donName = textField_1.getText();
					String valAw = textField_2.getText();
					int	valueOfAward = Integer.parseInt(valAw);
					String term = comboBox.getSelectedItem().toString();
					String gpa = textField_3.getText();
					float minGPA = Float.parseFloat(gpa);
					String avail = textField_4.getText();
					int awardsAvail = Integer.parseInt(avail);
					String fullTerm = comboBox.getSelectedItem().toString();
					String faculty = facultyBox.getSelectedItem().toString();
					String department = textDepartment.getText();
					String type = studentBox.getSelectedItem().toString();

					//Creates a new scholarship and adds it to data's award arrayList
					//saves data and closes window
					Scholarship newSchol = new Scholarship(scholName, donName, valueOfAward, fullTerm, minGPA, awardsAvail, faculty, department, type);
					data.addAward(newSchol);
					data.saveData();
					dispose();
				}
			}
		});
		btnNewButton.setBounds(439, 285, 117, 29);
		contentPane.add(btnNewButton);
		
		//design elements
		JLabel lblNewLabel_2 = new JLabel("University of Calgary Scholarship Application System ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(131, 0, 487, 34);
		contentPane.add(lblNewLabel_2);
		
		//bings user to previous window
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(568, 285, 117, 29);
		contentPane.add(btnNewButton_1);
	}

}
