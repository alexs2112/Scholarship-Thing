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
	
		Applicant student = (Applicant)applicant;
				
		ArrayList<Scholarship> scholarships = student.awards();
		ArrayList<String> listOfNames = new ArrayList<String>();
		for (Scholarship award : scholarships) {
			listOfNames.add(award.getScholName());
		}
		
		JList scholList = new JList(listOfNames.toArray());
		scholList.setBounds(181, 40, 318, 279);
		contentPane.add(scholList);
		
		JButton btnNewButton = new JButton("Accept Award");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				ArrayList<Scholarship> toRemove = new ArrayList<Scholarship>();
				
				if ( (scholarships.get(scholList.getSelectedIndex()).getAnnual()).equals("Annual") ) {
					for (Scholarship award : scholarships) {
						if (scholarships.get(scholList.getSelectedIndex()) != award) {
							toRemove.add(award);

						}
					}
				} else if ((scholarships.get(scholList.getSelectedIndex()).getAnnual()).equals("Fall")){
					for (Scholarship award : scholarships) {
						if ( ((scholarships.get(scholList.getSelectedIndex()) != award) && ((award.getAnnual()).equals("Fall")) || (award.getAnnual()).equals("Annual"))  ) {
							toRemove.add(award);

						}
						
					}
					
				} else if ((scholarships.get(scholList.getSelectedIndex()).getAnnual()).equals("Winter")) {
					for (Scholarship award : scholarships) {
						if ( ((scholarships.get(scholList.getSelectedIndex()) != award) && ((award.getAnnual()).equals("Winter")) || (award.getAnnual()).equals("Annual"))  ) {
							toRemove.add(award);


						}
						
					}
					
				} else  {
					dispose();
				}
				
				student.awards().removeAll(toRemove);
				student.acceptedAwards().addAll(student.awards());
				data.saveData();
				dispose();
				AcceptAwards accAw = new AcceptAwards(data, applicant, index);
				accAw.setVisible(true);

			}
		});
		btnNewButton.setBounds(158, 358, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decline Award");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.awards().remove(scholarships.get(scholList.getSelectedIndex()));
				data.saveData();
				dispose();
				AcceptAwards accAw = new AcceptAwards(data, applicant, index);
				accAw.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(269, 358, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Award Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,  "Award Name: " + scholarships.get(scholList.getSelectedIndex()).getScholName() + "\nDonor NameL " + scholarships.get(scholList.getSelectedIndex()).getDonorName() + "\nAward Amount: $" + scholarships.get(scholList.getSelectedIndex()).getScholValue() + "\nTerm: " + scholarships.get(scholList.getSelectedIndex()).getAnnual());
			}
		});
		btnNewButton_2.setBounds(379, 358, 150, 29);
		contentPane.add(btnNewButton_2);
		
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
