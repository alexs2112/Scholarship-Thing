import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class EditAward extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Scholarship award;

	/**
	 * Create the frame.
	 */
	public EditAward(Data data, Scholarship award) {
		setTitle("University of Calgary Scholarship Application System | Edit An Award");
		this.award = award;
		setBounds(100, 100, 800, 499);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(186, 66, 277, 26);
		textField.setText(award.getScholName());
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(186, 108, 277, 26);
		textField_1.setText(award.getDonorName());
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(186, 150, 178, 26);
		textField_2.setText(award.getScholValue().toString());
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		final DecimalFormat df2= new DecimalFormat("#.##");
		textField_3 = new JTextField();
		textField_3.setBounds(186, 235, 74, 26);
		textField_3.setText((df2.format(award.getReq())));
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(186, 280, 178, 26);
		textField_4.setText(award.getTotalAmount().toString());
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		String[] termBox = {"Annual", "Fall", "Winter"};
		JComboBox comboBox = new JComboBox(termBox);
		comboBox.setBounds(186, 192, 178, 27);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Scholarship Name:");
		lblNewLabel.setBounds(29, 71, 145, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name of Donor:");
		lblNewLabel_1.setBounds(29, 113, 115, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Value of Award:");
		lblNewLabel_2.setBounds(29, 155, 115, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Term:");
		lblNewLabel_3.setBounds(29, 197, 115, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("GPA Requirement:");
		lblNewLabel_4.setBounds(29, 240, 142, 16);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Awards Available:");
		lblNewLabel_5.setBounds(29, 285, 142, 16);
		contentPane.add(lblNewLabel_5);

		JButton btnNewButton = new JButton("Save");
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

					award.update(scholName, donName, valueOfAward, fullTerm, minGPA, awardsAvail);
					data.saveData();
					
					dispose();
				}
			}
		});
		btnNewButton.setBounds(185, 352, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("University of Calgary Scholarship Application System");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_6.setBounds(155, 0, 574, 35);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(314, 352, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}