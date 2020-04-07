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

public class ExistingAward extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private JPanel contentPane;
	private Data data;

	/**
	 * Create the frame.
	 */
	public ExistingAward(Data data) {
		this.data = data;
		setBounds(100, 100, 300, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//An arraylist of all the scholarships and their associated data
		ArrayList<Scholarship> scholarships = data.awards();
		ArrayList<String> listOfNames = new ArrayList<String>();
		
		for (Scholarship award : scholarships) {
			listOfNames.add(award.getScholName());
		}

		JList list = new JList(listOfNames.toArray());
		list.setBounds(20, 29, 258, 383);
		contentPane.add(list);

		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = list.getSelectedValue().toString();
				EditAward editThisAward = new EditAward(data);
				editThisAward.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 424, 93, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Save and Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				data.saveData();
			}
		});
		btnNewButton_1.setBounds(190, 424, 93, 29);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(105, 424, 93, 29);
		contentPane.add(btnNewButton_2);
	}
}
