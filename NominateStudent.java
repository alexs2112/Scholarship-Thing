  
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NominateStudent extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;


	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public NominateStudent(Data data, User user) {
		
		//design elements
		setTitle("University of Calgary Scholarship Application System | Nominate a Student");
		setBounds(100, 100, 772, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//An arraylist of all the scholarships and their associated data
		ArrayList<Scholarship> scholarships = data.awards();
		
		//An arrayList of the names of all the scholarships in the database
		ArrayList<String> listOfNames = new ArrayList<String>();
		AwardScholarships function = new AwardScholarships(data);
		for (Scholarship award : scholarships) {
			listOfNames.add(award.getScholName());
		}
		
		//An arraylist of all the students in the system and their associated data
		ArrayList<User> users = data.users();
		ArrayList<Applicant> allApplicants = new ArrayList<Applicant>();
		for (User user1 : users) {
			if (user1.role().contentEquals("student")) {
				allApplicants.add((Applicant)user1);
			}
		}
		
		//An arrayList of the names of all the students in the database
		ArrayList<String> studentNames = new ArrayList<String>();
		for (Applicant applicant : allApplicants) {
			studentNames.add(applicant.firstName() + " " + applicant.lastName());
		}
		
		//An arrayList of the student IDs of all the students in the database
		ArrayList<String> studentNumbers = new ArrayList<String>();
		for (Applicant applicant : allApplicants) {
			studentNumbers.add(applicant.id());
		}	
		
		//display the names of all scholarships in a JList
		JList scholList = new JList(listOfNames.toArray());
		scholList.setBounds(414, 41, 318, 360);
		contentPane.add(scholList);
		
		//display the names of all the students in the system in a JList
		JList studList = new JList(studentNames.toArray());
		studList.setBounds(38, 41, 318, 360);
		contentPane.add(studList);
		
		//action handler for submit button
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create new recommendation for selected student, of selected scholarship and current user
				//save that recommendation to the applicants account
				//save and close
				String selectedStudent = studList.getSelectedValue().toString();
				String selectedSchol = scholList.getSelectedValue().toString();
				Recommendations recom = new Recommendations(user, scholarships.get(scholList.getSelectedIndex()));
				Applicant appli = allApplicants.get(studList.getSelectedIndex());
				users.remove(appli);
				appli.addProfRec(recom);
				users.add(appli);
				data.saveData();
				dispose();
				
			}
		});
		btnNewButton.setBounds(615, 431, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Please select a student: ");
		lblNewLabel.setBounds(38, 6, 156, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select an award to nominate them for: ");
		lblNewLabel_1.setBounds(414, 13, 318, 16);
		contentPane.add(lblNewLabel_1);
		
		//brings user to the previous window
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(486, 431, 117, 29);
		contentPane.add(btnNewButton_1);
		
		
	}

}
;