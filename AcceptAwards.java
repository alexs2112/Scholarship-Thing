import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcceptAwards extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;


	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AcceptAwards(Data data, User applicant, int index) {
		
		//Design Elements
		setTitle("University of Calgary Scholarship Application System | Accept/Decline Awards");
		setBounds(100, 100, 691, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to the University of Calgary Scholarship Application System");
		lblNewLabel_1.setBounds(45, 6, 640, 22);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel_1);
	
		//Convert User applicant to Applicant applicant
		Applicant student = (Applicant)applicant;
		
		//Get data about all Scholarships from Data file and create new ArrayList of Scholarship Names Only		
		ArrayList<Scholarship> scholarships = student.awards();
		ArrayList<String> listOfNames = new ArrayList<String>();
		for (Scholarship award : scholarships) {
			listOfNames.add(award.getScholName());
		}
		
		//Display List of Scholarship names as a list
		JList scholList = new JList(listOfNames.toArray());
		scholList.setBounds(182, 55, 318, 279);
		contentPane.add(scholList);
		
		//Action Handler for Button "Accept Award"
		JButton btnNewButton = new JButton("Accept Award");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create new ArrayList of Scholarships that must be removed from applicants awarded list
				ArrayList<Scholarship> toRemove = new ArrayList<Scholarship>();
				
				//If the applicant accepts an annual award, remove all other annual awards they've been awarded, as well as all other term based awards
				if ( (scholarships.get(scholList.getSelectedIndex()).getAnnual()).equals("Annual") ) {
					for (Scholarship award : scholarships) {
						if (scholarships.get(scholList.getSelectedIndex()) != award) {
							toRemove.add(award);

						}
					}
				//if the applicant accepts a Fall term award, remove all annual awards they've been awarded as well as all other fall awards (only winter awards will be left)	
				} else if ((scholarships.get(scholList.getSelectedIndex()).getAnnual()).equals("Fall")){
					for (Scholarship award : scholarships) {
						if ( ((scholarships.get(scholList.getSelectedIndex()) != award) && ((award.getAnnual()).equals("Fall")) || (award.getAnnual()).equals("Annual"))  ) {
							toRemove.add(award);

						}
						
					}
				//If the applicant accepts a Winter term award, remove all annual awards they've been awarded as well as all other winter awards (only fall awards will be left)
				} else if ((scholarships.get(scholList.getSelectedIndex()).getAnnual()).equals("Winter")) {
					for (Scholarship award : scholarships) {
						if ( ((scholarships.get(scholList.getSelectedIndex()) != award) && ((award.getAnnual()).equals("Winter")) || (award.getAnnual()).equals("Annual"))  ) {
							toRemove.add(award);


						}
						
					}
				//if none of these apply, close the window
				} else  {
					dispose();
				}
				
				//remove all declined awards from the list of awards the student has been awarded, so only the awards they have accepted remain
				//add the awards the applicant has accepted to their "accepted" list, and remove any from that list that conflict with one another
				//save data and refresh page to display awards that are left
				student.awards().removeAll(toRemove);
				student.acceptedAwards().addAll(student.awards());
				student.acceptedAwards().removeAll(toRemove);
				data.saveData();
				dispose();
				AcceptAwards accAw = new AcceptAwards(data, applicant, index);
				accAw.setVisible(true);

			}
		});
		btnNewButton.setBounds(158, 358, 117, 29);
		contentPane.add(btnNewButton);
		
		//action handler for Decline Award
		JButton btnNewButton_1 = new JButton("Decline Award");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If the applicant delcines an award, get the selected scholarship and remove
				//it from the applicants list of awards, save data and refresh page
				student.awards().remove(scholarships.get(scholList.getSelectedIndex()));
				data.saveData();
				dispose();
				AcceptAwards accAw = new AcceptAwards(data, applicant, index);
				accAw.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(269, 358, 117, 29);
		contentPane.add(btnNewButton_1);
		
		//action handler for view award info
		//displays info on the selected scholarship (in a dialog box) 
		JButton btnNewButton_2 = new JButton("View Award Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,  "Award Name: " + scholarships.get(scholList.getSelectedIndex()).getScholName() + "\nDonor NameL " + scholarships.get(scholList.getSelectedIndex()).getDonorName() + "\nAward Amount: $" + scholarships.get(scholList.getSelectedIndex()).getScholValue() + "\nTerm: " + scholarships.get(scholList.getSelectedIndex()).getAnnual());
			}
		});
		btnNewButton_2.setBounds(379, 358, 150, 29);
		contentPane.add(btnNewButton_2);
		
		//brings user to previous page
		JButton btnNewButton_3 = new JButton("Cancel");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(553, 399, 117, 29);
		contentPane.add(btnNewButton_3);
		
		
				
	}
}
