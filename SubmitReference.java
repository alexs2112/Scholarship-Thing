import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class SubmitReference extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;


	private JPanel contentPane;
	private String filename = null;
	private File reference;


	/**
	 * Create the frame.
	 */
	public SubmitReference(Data data) {
		
		//design elements
		setTitle("University of Calgary Scholarship Application System | Submit References");
		setBounds(100, 100, 772, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//An arraylist of all the students in the system and their associated data
		ArrayList<User> users = data.users();
		ArrayList<Applicant> allApplicants = new ArrayList<Applicant>();
			for (User user : users) {
				if (user.role().contentEquals("student")) {
					allApplicants.add((Applicant)user);
				}
			}
		
		//An arrayList of the names of all students in the database
		ArrayList<String> studentNames = new ArrayList<String>();
			for (Applicant applicant : allApplicants) {
				studentNames.add(applicant.firstName() + " " + applicant.lastName());
			}
		
		//display list of all applicant names to a JList
		JList studList = new JList(studentNames.toArray());
		studList.setBounds(240, 41, 318, 306);
		contentPane.add(studList);
		
		JLabel messageLabel = new JLabel("");
		messageLabel.setBounds(408, 359, 347, 16);
		contentPane.add(messageLabel);
		
		//action handler for choose file
		JButton btnNewButton = new JButton("Choose File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//allows user to select a file and saves that file to the selected applicants account as a reference
				JFileChooser chooser = new JFileChooser();
				chooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png"));
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				filename = f.getAbsolutePath();
				messageLabel.setText(filename);
				reference = chooser.getSelectedFile();
				
			}
		});
		
		btnNewButton.setBounds(243, 359, 153, 29);
		contentPane.add(btnNewButton);
		
		//action handler for submit
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (studentNames.size() >= 1) {
				
					//save selected file from above to the students account as a file
					//saves data and closes
					if (studList.isSelectionEmpty()) {
						return;
					} else {
						String selectedStudent = studList.getSelectedValue().toString();
						Applicant appli = allApplicants.get(studList.getSelectedIndex());
						users.remove(appli);
						appli.addStudentFile(reference);
						users.add(appli);
						data.saveData();
						dispose();
					}
					
				}
			}
		});
		btnNewButton_1.setBounds(638, 429, 117, 29);
		contentPane.add(btnNewButton_1);
		
		//brings user back to previous window
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(509, 429, 117, 29);
		contentPane.add(btnNewButton_2);
	}
}
