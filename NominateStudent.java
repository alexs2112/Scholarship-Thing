  
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
		setTitle("University of Calgary Scholarship Application System | Nominate a Student");
		setBounds(100, 100, 772, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//An arraylist of all the scholarships and their associated data
		ArrayList<Scholarship> scholarships = data.awards();
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
		
		ArrayList<String> studentNames = new ArrayList<String>();
		for (Applicant applicant : allApplicants) {
			studentNames.add(applicant.firstName() + " " + applicant.lastName());
		}
		
		ArrayList<String> studentNumbers = new ArrayList<String>();
		for (Applicant applicant : allApplicants) {
			studentNumbers.add(applicant.id());
		}	
		
		JList scholList = new JList(listOfNames.toArray());
		scholList.setBounds(414, 41, 318, 279);
		contentPane.add(scholList);
		
		JList studList = new JList(studentNames.toArray());
		studList.setBounds(38, 41, 318, 279);
		contentPane.add(studList);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton.setBounds(615, 359, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Please select a student: ");
		lblNewLabel.setBounds(38, 6, 156, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select an award to nominate them for: ");
		lblNewLabel_1.setBounds(414, 13, 318, 16);
		contentPane.add(lblNewLabel_1);
		
		
	}

}
;