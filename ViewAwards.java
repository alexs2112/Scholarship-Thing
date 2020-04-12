import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ViewAwards extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ViewAwards(Data data, User applicant) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Get a list of all available awards
		ArrayList<Scholarship> awards = data.awards();
	
		
		String[] names = new String[awards.size()];
		for (int i = 0; i < awards.size(); i++) {
			names[i] = awards.get(i).getScholName();
		}
		
		JComboBox awardBox = new JComboBox();
		awardBox.setBounds(58, 69, 302, 27);
		contentPane.add(awardBox);
		awardBox.setModel(new DefaultComboBoxModel(names));
		
		JButton btnNewButton = new JButton("Get Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scholarship award =  awards.get(awardBox.getSelectedIndex());
				final DecimalFormat df2= new DecimalFormat("#.##");
				JOptionPane.showMessageDialog(null, "Award Name: " + award.getScholName() + "\nDonor Name: " + award.getDonorName() + "\nValue: $" + Integer.toString(award.getScholValue()) + 
						"\nGPA Requirement: " + (df2.format(award.getReq())) + "\nAmount of Awards: " + Integer.toString(award.getTotalAmount()));
			}
		});
				
		btnNewButton.setBounds(91, 108, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnNewButton_1.setBounds(220, 108, 117, 29);
		contentPane.add(btnNewButton_1);
	
		
	}
}