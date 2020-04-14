import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyAwards extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;


	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MyAwards(Data data, User applicant) {
		setTitle("University of Calgary Scholarship Application System | My Awards");
		setBounds(100, 100, 750, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Applicant student = (Applicant)applicant;
		ArrayList<Scholarship> scholarships = student.acceptedAwards();
		if (scholarships.size() >= 1) {
			for (Scholarship award : scholarships ) {
				if (award.getAnnual().equals("Annual")) {
					JLabel lblNewLabel_4 = new JLabel("Award Name: " + award.getScholName());
					lblNewLabel_4.setBounds(38, 107, 200, 16);
					contentPane.add(lblNewLabel_4);
					
					JLabel lblNewLabel_5 = new JLabel("Donor Name: " + award.getDonorName());
					lblNewLabel_5.setBounds(38, 135, 200, 16);
					contentPane.add(lblNewLabel_5);
					
					JLabel lblNewLabel_6 = new JLabel("Award Amount: $" + award.getScholValue());
					lblNewLabel_6.setBounds(38, 163, 200, 16);
					contentPane.add(lblNewLabel_6);
				} else if (award.getAnnual().equals("Fall")) {
					
					JLabel lblNewLabel_7 = new JLabel("Award Name: " + award.getScholName());
					lblNewLabel_7.setBounds(294, 107, 200, 16);
					contentPane.add(lblNewLabel_7);
					
					JLabel lblNewLabel_8 = new JLabel("Donor Name: " + award.getDonorName());
					lblNewLabel_8.setBounds(294, 135, 200, 16);
					contentPane.add(lblNewLabel_8);
					
					JLabel lblNewLabel_9 = new JLabel("Award Amount: $" + award.getScholValue());
					lblNewLabel_9.setBounds(294, 163, 200, 16);
					contentPane.add(lblNewLabel_9);
					
				} else if (award.getAnnual().equals("Winter")) {
					
	
					JLabel lblNewLabel_10 = new JLabel("Award Name: "  + award.getScholName());
					lblNewLabel_10.setBounds(525, 107, 200, 16);
					contentPane.add(lblNewLabel_10);
					
					JLabel lblNewLabel_11 = new JLabel("Donor Name: " + award.getDonorName());
					lblNewLabel_11.setBounds(525, 135, 200, 16);
					contentPane.add(lblNewLabel_11);
					
					JLabel lblNewLabel_12 = new JLabel("Award Amount: $" + award.getScholValue());
					lblNewLabel_12.setBounds(525, 163, 200, 16);
					contentPane.add(lblNewLabel_12);
					
				}
				
			}
		}
		
		JLabel lblNewLabel = new JLabel("My Awards");
		lblNewLabel.setBounds(294, 18, 78, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Annual Award");
		lblNewLabel_1.setBounds(38, 59, 104, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fall Award");
		lblNewLabel_2.setBounds(294, 59, 89, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Winter Award");
		lblNewLabel_3.setBounds(525, 59, 89, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(627, 423, 117, 29);
		contentPane.add(btnNewButton);
		
		
		
	
	
		
		
		
	}
}
	
