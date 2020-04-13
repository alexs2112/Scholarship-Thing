import java.awt.BorderLayout;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ExistingAward extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ExistingAward(Data data) {
		setTitle("University of Calgary Scholarship Application System | Existing Award");
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
		list.setBounds(15, 41, 318, 279);
		contentPane.add(list);

		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = list.getSelectedValue().toString();
				EditAward editThisAward = new EditAward(data, scholarships.get(list.getSelectedIndex()));
				editThisAward.setVisible(true);
			}
		});
		btnNewButton.setBounds(15, 336, 108, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				data.saveData();
			}
		});
		btnNewButton_1.setBounds(127, 336, 93, 29);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scholarships.remove(list.getSelectedIndex());
				data.saveData();
			}
		});
		btnNewButton_2.setBounds(225, 336, 108, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Award Selection");
		//Awards the scholarship that is selected
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.awardScholarship(scholarships.get(list.getSelectedIndex()));
			}
		});
		btnNewButton_3.setBounds(15, 386, 147, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Award All");
		//Awards all available scholarships
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				function.awardAllScholarships();
			}
		});
		btnNewButton_4.setBounds(177, 386, 156, 29);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("University of Calgary Scholarship Application System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(0, 8, 489, 29);
		contentPane.add(lblNewLabel);
	}
}
