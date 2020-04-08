import java.util.ArrayList;
import javax.swing.JFrame;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ApplicantLogin extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	
	/**
	 * Create the frame.
	 */
	public ApplicantLogin(Data data, User applicant, int index) {
		Applicant student = (Applicant)applicant;
		setTitle("Applicant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 754);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scholarship Application");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(28, 29, 600, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1. Your Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(28, 94, 547, 35);
		contentPane.add(lblNewLabel_1);
		
		int column1Start = 25;		//Name
		int column2Start = 110;		//Info
		int column3Start = 280;
		int column4Start = 355;
		int column5Start = 535;
		int column6Start = 610;
		
		int row1Start = 140;
		int row2Start = 180;
		int row3Start = 220;
		
		//Set up a label and autopopulate the text field for the first name
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(column1Start, row1Start, 80, 20);
		JTextField txtFirstName = new JTextField();
		txtFirstName.setText(student.firstName());
		txtFirstName.setBounds(column2Start, row1Start - 1, 130, 22);
		contentPane.add(lblFirstName);
		contentPane.add(txtFirstName);

		//Set up a label and autopopulate the text field for the last name
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(column3Start, row1Start, 80, 20);
		JTextField txtLastName = new JTextField();
		txtLastName.setText(student.lastName());
		txtLastName.setBounds(column4Start,row1Start-1, 130, 22);
		contentPane.add(lblLastName);
		contentPane.add(txtLastName);
		
		//Do the same for the students ID
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setBounds(column5Start, row1Start, 80, 20);
		JTextField txtStudentId = new JTextField();
		txtStudentId.setText(student.id());
		txtStudentId.setBounds(column6Start,row1Start-1, 130, 22);
		contentPane.add(lblStudentId);
		contentPane.add(txtStudentId);
		
		//Student Type
		JLabel lblStudentType = new JLabel("Student Type:");
		lblStudentType.setBounds(column1Start, row2Start, 80, 20);
		contentPane.add(lblStudentType);
		JComboBox<String> typeBox = new JComboBox<String>();
		typeBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Undergraduate", "Graduate", "Post-Graduate"}));
		typeBox.setSelectedItem(student.getStudentType());
		typeBox.setBounds(column2Start, row2Start-2, 130, 24);
		contentPane.add(typeBox);
		
		//Faculty
		JLabel lblFaculty = new JLabel("Faculty:");
		lblFaculty.setBounds(column3Start, row2Start, 80, 20);
		contentPane.add(lblFaculty);
		JComboBox<String> facultyBox = new JComboBox<String>();
		facultyBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Arts", "Law", "Nursing", "Kinesiology", "Science", "Social Work", "Veterinary Medicine", "Medicine", "Business", "Engineering", "Education"}));
		facultyBox.setSelectedItem(student.getFaculty());
		facultyBox.setBounds(column4Start, row2Start-2, 130, 24);
		contentPane.add(facultyBox);
		
		//Department
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(column5Start, row2Start, 80, 20);
		JTextField txtDepartment = new JTextField();
		txtDepartment.setText(student.getDepartment());
		txtDepartment.setBounds(column6Start,row2Start-1, 130, 22);
		contentPane.add(lblDepartment);
		contentPane.add(txtDepartment);	
		
		
		JLabel lblGPA = new JLabel("GPA:");
		lblGPA.setBounds(column1Start, row3Start, 80, 20);
		JTextField txtGPA = new JTextField();
		txtGPA.setText(String.valueOf(student.getGPA()));
		txtGPA.setBounds(column2Start,row3Start-1, 130, 22);
		contentPane.add(lblGPA);
		contentPane.add(txtGPA);
		
		JLabel lblEmailAddress = new JLabel("Email:");
		lblEmailAddress.setBounds(column3Start, row3Start, 80, 20);
		JTextField txtEmailAddress = new JTextField();
		txtEmailAddress.setText(student.getEmail());
		txtEmailAddress.setBounds(column4Start,row3Start-1, 130, 22);
		contentPane.add(lblEmailAddress);
		contentPane.add(txtEmailAddress);
		
		JButton btnNewButton = new JButton("Update Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Updated Information Successful");
				//Update student info
				student.update(txtFirstName.getText(), txtLastName.getText(), txtStudentId.getText(),
						typeBox.getSelectedItem().toString(), facultyBox.getSelectedItem().toString(), 
						txtDepartment.getText(), Double.valueOf(txtGPA.getText()), txtEmailAddress.getText());
				//Reset the screen
				dispose();
				ApplicantLogin appLog = new ApplicantLogin(data, student, index);
				appLog.setVisible(true);
				data.saveData();
			}
		});
		btnNewButton.setBounds(column5Start, row3Start-1, 130, 22);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("2. Choose Scholarship:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(28, 278, 300, 16);
		contentPane.add(lblNewLabel_4);
		
		//Get a list of all available awards
		ArrayList<Scholarship> awards = data.awards();
		
		String[] names = new String[awards.size()];
		for (int i = 0; i < awards.size(); i++) {
			names[i] = awards.get(i).getScholName();
		}
		int column1 = 280;
		int row1 = 320;
		int row2 = 340;
		int row3 = 360;
		int row4 = 380;
		int row5 = 400;
		int row6 = 420;

		JLabel lblName = new JLabel();
		lblName.setBounds(column1, row1, 300, 20);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblName);
		
		JLabel lblDonor = new JLabel();
		lblDonor.setBounds(column1, row2, 300, 20);
		lblDonor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblDonor);
		
		JLabel lblValue = new JLabel();
		lblValue.setBounds(column1, row3, 300, 20);
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblValue);
		
		JLabel lblReq = new JLabel();
		lblReq.setBounds(column1, row4, 300, 20);
		lblReq.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblReq);
		
		JLabel lblAmount = new JLabel();
		lblAmount.setBounds(column1, row5, 300, 20);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblAmount);

		JLabel lblApplied = new JLabel();
		lblApplied.setBounds(column1, row6, 300, 20);
		lblApplied.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblApplied);

		JComboBox awardBox = new JComboBox();
		awardBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Updates existing JLabels for award info
				updateFields(awards.get(awardBox.getSelectedIndex()), contentPane, student, lblName, lblDonor, lblValue, lblReq, lblAmount, lblApplied);
			}
		});
		awardBox.setModel(new DefaultComboBoxModel(names));
		awardBox.setBounds(column1Start + 10, 300, 220, 24);
		awardBox.setSelectedIndex(index);
		contentPane.add(awardBox);
		updateFields(awards.get(awardBox.getSelectedIndex()), contentPane, student, lblName, lblDonor, lblValue, lblReq, lblAmount, lblApplied);
		
		JLabel lblNewLabel_5 = new JLabel("3. Upload Transcript(s)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(28, 457, 250, 22);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Add(...)");
		btnNewButton_1.setBounds(38, 492, 97, 25);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("4. Submit");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(28, 543, 250, 24);
		contentPane.add(lblNewLabel_6);
		
		JCheckBox checkBox = new JCheckBox("I agree to the terms and condition and declare that all infomation provided is correct");
		checkBox.setBounds(28, 569, 1031, 35);
		contentPane.add(checkBox);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					//Add the submission to the students applications
					//Add the student to the scholarships applicants
					//Reload the page
					JOptionPane.showMessageDialog(null, "Submission Successful");
					awards.get(awardBox.getSelectedIndex()).addApplicant(student);
					student.addApplication(awards.get(awardBox.getSelectedIndex()));
					data.saveData();
					dispose();
					ApplicantLogin appLog = new ApplicantLogin(data, student, awardBox.getSelectedIndex());
					appLog.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Check the Terms and Conditions");
				}
			}
		});
		btnNewButton_2.setBounds(28, 613, 97, 25);
		contentPane.add(btnNewButton_2);
	}
	
	//Updates JLabels for award info
	public void updateFields(Scholarship award, JPanel contentPane, Applicant student, JLabel lblName, JLabel lblDonor, JLabel lblValue, JLabel lblReq, JLabel lblAmount, JLabel lblApplied) {
		int column1 = 280;
		int row1 = 320;
		int row2 = 340;
		int row3 = 360;
		int row4 = 380;
		int row5 = 400;
		int row6 = 420;
		final DecimalFormat df2= new DecimalFormat("#.##");
		String name = award.getScholName();
		String donor = "Donor: " + award.getDonorName();
		String value = "Value: $" + Integer.toString(award.getScholValue());
		String req = "GPA Requirement: " + (df2.format(award.getReq()));
		String amount = "Amount of Awards: " + Integer.toString(award.getTotalAmount());
		String applied = "You have already applied for this award";
		
		lblName.setText(name);
		lblDonor.setText(donor);
		lblValue.setText(value);
		lblReq.setText(req);
		lblAmount.setText(amount);
		
		if (award.getApplicants().contains(student)) {
			lblApplied.setText(applied);
		}
		else {
			lblApplied.setText("");
		}
	}
}
