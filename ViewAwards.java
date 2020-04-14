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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ViewAwards extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;


	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ViewAwards(Data data, User applicant) {
		setBounds(100, 100, 743, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
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
		awardBox.setBounds(220, 175, 302, 27);
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
				
		btnNewButton.setBounds(246, 253, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnNewButton_1.setBounds(379, 253, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("University of Calgary Scholarship Application System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(122, 6, 496, 42);
		contentPane.add(lblNewLabel);
	
		
	}
}

