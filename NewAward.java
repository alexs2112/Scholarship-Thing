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

public class NewAward extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label;
	private JComboBox comboBox;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel label_3;
	private JButton btnNewButton;
	private ArrayList<Scholarship> allScholarships = new ArrayList<Scholarship>();
	private Data data;

	public ArrayList<Scholarship> getAllSchol() {
		return allScholarships;
	}

	/**
	 * Create the frame.
	 */
	public NewAward(Data data) {
		this.data = data;
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(156, 21, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Scholarship Name");
		lblNewLabel.setBounds(29, 26, 115, 16);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Donor Name");
		lblNewLabel_1.setBounds(29, 54, 115, 16);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(156, 49, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(156, 77, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		label = new JLabel("Value of Award");
		label.setBounds(29, 82, 115, 16);
		contentPane.add(label);

		String[] termBox = {"Annual", "Fall", "Winter"};
		comboBox = new JComboBox(termBox);
		comboBox.setBounds(156, 108, 130, 27);
		contentPane.add(comboBox);

		label_1 = new JLabel("Term");
		label_1.setBounds(29, 110, 115, 16);
		contentPane.add(label_1);

		label_2 = new JLabel("GPA Requirement");
		label_2.setBounds(29, 144, 115, 16);
		contentPane.add(label_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(156, 139, 130, 26);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(156, 171, 130, 26);
		contentPane.add(textField_4);

		label_3 = new JLabel("Awards Available");
		label_3.setBounds(29, 176, 115, 16);
		contentPane.add(label_3);

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

				dispose();
			}
				}
		});
		btnNewButton.setBounds(166, 219, 117, 29);
		contentPane.add(btnNewButton);
	}

}
