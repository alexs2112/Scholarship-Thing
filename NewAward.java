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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class NewAward extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblValueOfAward;
	private JComboBox comboBox;
	private JLabel lblTerm;
	private JLabel lblGpaRequirement;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblAwardsAvailable;
	private JButton btnNewButton;
	private ArrayList<Scholarship> allScholarships = new ArrayList<Scholarship>();
	private Data data;
	private JLabel lblNewLabel_2;

	public ArrayList<Scholarship> getAllSchol() {
		return allScholarships;
	}

	/**
	 * Create the frame.
	 */
	public NewAward(Data data) {
		setTitle("University of Calgary Scholarship Application System | New Award");
		this.data = data;
		setBounds(100, 100, 744, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(183, 70, 205, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Scholarship Name:");
		lblNewLabel.setBounds(29, 70, 139, 16);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Name of Donor:");
		lblNewLabel_1.setBounds(29, 117, 115, 16);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(183, 112, 205, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(183, 154, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		lblValueOfAward = new JLabel("Value of Award:");
		lblValueOfAward.setBounds(29, 159, 115, 16);
		contentPane.add(lblValueOfAward);

		String[] termBox = {"Annual", "Fall", "Winter"};
		comboBox = new JComboBox(termBox);
		comboBox.setBounds(183, 196, 130, 27);
		contentPane.add(comboBox);

		lblTerm = new JLabel("Term:");
		lblTerm.setBounds(29, 201, 115, 16);
		contentPane.add(lblTerm);

		lblGpaRequirement = new JLabel("GPA Requirement:");
		lblGpaRequirement.setBounds(29, 244, 139, 16);
		contentPane.add(lblGpaRequirement);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(183, 239, 130, 26);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(183, 285, 205, 26);
		contentPane.add(textField_4);

		lblAwardsAvailable = new JLabel("Awards Available:");
		lblAwardsAvailable.setBounds(29, 290, 139, 16);
		contentPane.add(lblAwardsAvailable);

		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please ensure all fields are complete");
				} else if ( Float.parseFloat(textField_3.getText()) > 4.0 || Float.parseFloat(textField_3.getText()) < 0.0 )  {
					JOptionPane.showMessageDialog(null, "Required GPA cannot be less than 0.0 or greater than 4.0");

				}else {
					String scholName = textField.getText();
					String donName = textField_1.getText();
					String valAw = textField_2.getText();
					int	valueOfAward = Integer.parseInt(valAw);
					String term = comboBox.getSelectedItem().toString();
					String gpa = textField_3.getText();
					float minGPA = Float.parseFloat(gpa);
					String avail = textField_4.getText();
					int awardsAvail = Integer.parseInt(avail);
					boolean fullTerm = term.equals("Annual");

					//Creates a new scholarship and adds it to data's award arrayList
					Scholarship newSchol = new Scholarship(scholName, donName, valueOfAward, fullTerm, minGPA, awardsAvail);
					data.addAward(newSchol);
					data.saveData();
					dispose();
				}
			}
		});
		btnNewButton.setBounds(15, 399, 117, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("University of Calgary Scholarship Application System ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(0, 0, 487, 34);
		contentPane.add(lblNewLabel_2);
	}

}
