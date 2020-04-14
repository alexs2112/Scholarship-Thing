import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class GiveAward extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GiveAward(Data data) {
		setTitle("University of Calgary Scholarship Application System | Award Scholarships");
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

		JList list = new JList(listOfNames.toArray());
		list.setBounds(405, 79, 318, 279);
		contentPane.add(list);
		
	
		
		JButton btnNewButton_3 = new JButton("Award Selection");
		//Awards the scholarship that is selected
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.awardScholarship(scholarships.get(list.getSelectedIndex()));
				JOptionPane.showMessageDialog(null, scholarships.get(list.getSelectedIndex()).getScholName() + " has been awarded");
				data.saveData();
			}
		});
		btnNewButton_3.setBounds(44, 386, 147, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Award All");
		//Awards all available scholarships
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.awardAllScholarships();
				JOptionPane.showMessageDialog(null, "All scholarships have been awarded");
				data.saveData();
			}
		});
		btnNewButton_4.setBounds(203, 386, 156, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnExitButton = new JButton("Exit");
		//Awards all available scholarships
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExitButton.setBounds(619, 443, 147, 29);
		contentPane.add(btnExitButton);
		
		JLabel label = new JLabel("University of Calgary Scholarship Application System");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(136, 6, 489, 29);
		contentPane.add(label);
		
		DefaultListModel listModel = new DefaultListModel();
		JList list_1 = new JList(listModel);
		list_1.setBounds(41, 79, 318, 279);
		contentPane.add(list_1);
	
		
		JButton btnNewButton = new JButton("View Applicants");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Applicant> applicants = new ArrayList<Applicant>();
				ArrayList<String> applicantNames = new ArrayList<String>();
				applicants.addAll( scholarships.get(list.getSelectedIndex()).getApplicants() );
				for (Applicant applicant : applicants) {
					applicantNames.add(applicant.name());
				}
				listModel.removeAllElements();
				for (String names : applicantNames) {
					listModel.addElement(names);
				}
				
			}
		});
		btnNewButton.setBounds(405, 386, 318, 29);
		contentPane.add(btnNewButton);
	}
}