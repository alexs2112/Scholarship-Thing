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
		
		//Design elements
		setTitle("University of Calgary Scholarship Application System | Existing Award");
		setBounds(100, 100, 772, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//An arraylist of all the scholarships and their associated data
		ArrayList<Scholarship> scholarships = data.awards();
		
		//An arraylist of just the names of each scholarship
		ArrayList<String> listOfNames = new ArrayList<String>();
		for (Scholarship award : scholarships) {
			listOfNames.add(award.getScholName());
		}

		//create JList that displayst the names of all scholarships
		JList list = new JList(listOfNames.toArray());
		list.setBounds(215, 78, 318, 279);
		contentPane.add(list);

		//gets info about selected scholarship from Jlist and brings user to the EditAward window where they can edit the selected award
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = list.getSelectedValue().toString();
				EditAward editThisAward = new EditAward(data, scholarships.get(list.getSelectedIndex()));
				editThisAward.setVisible(true);
			}
		});
		btnNewButton.setBounds(215, 369, 108, 29);
		contentPane.add(btnNewButton);

		//brings user back to previous window
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				data.saveData();
			}
		});
		btnNewButton_1.setBounds(330, 369, 93, 29);
		contentPane.add(btnNewButton_1);

		//gets scholarshhp from Jlist and deletes that Scholarship from the system
		//saves the data and refreshes the window
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scholarships.remove(list.getSelectedIndex());
				data.saveData();
				dispose();
				ExistingAward exAw = new ExistingAward(data);
				exAw.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(425, 369, 108, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("University of Calgary Scholarship Application System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(138, 6, 489, 29);
		contentPane.add(lblNewLabel);
	}
}
