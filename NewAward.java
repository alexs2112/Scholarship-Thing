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

		JLabel lblNewLabel = new JLabel("Scholarship Name:");
		lblNewLabel.setBounds(29, 70, 139, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblFaculty = new JLabel("Faculty:");
		lblFaculty.setBounds(380, 70, 80, 16);
		contentPane.add(lblFaculty);
		
		String[] facultyList = {"None", "Arts", "Law", "Nursing", "Kinesiology", "Science", "Social Work", "Veterinary Medicine", "Medicine", "Business", "Engineering", "Education", "Open Studies"};
		JComboBox facultyBox = new JComboBox(facultyList);
		facultyBox.setModel(new DefaultComboBoxModel(facultyList));
		facultyBox.setBounds(490, 70, 150, 27);
		contentPane.add(facultyBox);

		JLabel lblNewLabel_1 = new JLabel("Name of Donor:");
		lblNewLabel_1.setBounds(29, 117, 115, 16);
		contentPane.add(lblNewLabel_1);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(155, 112, 195, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
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

		JLabel lblValueOfAward = new JLabel("Value of Award:");
		lblValueOfAward.setBounds(29, 159, 115, 16);
		contentPane.add(lblValueOfAward);
		
		JLabel lblStudentType = new JLabel("Type of Students:");
		lblStudentType.setBounds(380, 159, 110, 16);
		contentPane.add(lblStudentType);
		
		String[] studentType = { "None", "Undergraduate", "Graduate", "Post-Graduate" };
		JComboBox studentBox = new JComboBox(studentType);
		studentBox.setBounds(490, 159, 153, 27);
		contentPane.add(studentBox);

		String[] termBox = {"Annual", "Fall", "Winter"};
		JComboBox comboBox = new JComboBox(termBox);
		comboBox.setBounds(155, 196, 130, 27);
		contentPane.add(comboBox);

		JLabel lblTerm = new JLabel("Term:");
		lblTerm.setBounds(29, 201, 115, 16);
		contentPane.add(lblTerm);

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

		JLabel lblAwardsAvailable = new JLabel("Awards Available:");
		lblAwardsAvailable.setBounds(29, 290, 139, 16);
		contentPane.add(lblAwardsAvailable);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please ensure all fields are complete");
				} else if ( Float.parseFloat(textField_3.getText()) > 4.0 || Float.parseFloat(textField_3.getText()) < 0.0 )  {
					JOptionPane.showMessageDialog(null, "Required GPA cannot be less than 0.0 or greater than 4.0");

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
					Scholarship newSchol = new Scholarship(scholName, donName, valueOfAward, fullTerm, minGPA, awardsAvail, faculty, department, type);
					data.addAward(newSchol);
					data.saveData();
					dispose();
				}
			}
		});
		btnNewButton.setBounds(15, 399, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("University of Calgary Scholarship Application System ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(131, 0, 487, 34);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(149, 399, 117, 29);
		contentPane.add(btnNewButton_1);
	}

}
