import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.AbstractListModel;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Scrollbar;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Checkbox;
import java.awt.Button;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;

public class ApplicantLogin extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private JPanel contentPane;
	private JTextField txtConnor;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private Data data;

	/**
	 * Create the frame.
	 */
	public ApplicantLogin(Data data) {
		this.data = data;
		setTitle("Applicant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1358, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apply a scholarship");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(28, 29, 215, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1. Basic info. Please check the correctness. if not correct , edit and update");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(28, 94, 547, 35);
		contentPane.add(lblNewLabel_1);
		
		txtConnor = new JTextField();
		txtConnor.setText("Connor");
		txtConnor.setToolTipText("");
		txtConnor.setBounds(95, 139, 116, 22);
		contentPane.add(txtConnor);
		txtConnor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("first name");
		lblNewLabel_2.setBounds(25, 142, 77, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblStudentId = new JLabel("student ID");
		lblStudentId.setBounds(459, 142, 82, 16);
		contentPane.add(lblStudentId);
		
		JLabel lblDepartment = new JLabel("department");
		lblDepartment.setBounds(544, 177, 77, 16);
		contentPane.add(lblDepartment);
		
		JLabel lblLastname = new JLabel("lastname");
		lblLastname.setBounds(253, 142, 56, 16);
		contentPane.add(lblLastname);
		
		JLabel lblFaculty = new JLabel("faculty");
		lblFaculty.setBounds(290, 177, 56, 16);
		contentPane.add(lblFaculty);
		
		JLabel lblStudentType = new JLabel("student type");
		lblStudentType.setBounds(25, 171, 77, 16);
		contentPane.add(lblStudentType);
		
		textField = new JTextField();
		textField.setBounds(321, 139, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"undergraduate", "graduate", "post-graduate"}));
		comboBox.setBounds(105, 174, 125, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Arts", "Law", "Nursing", "Kinesiology", "Science", "Social Work", "Veterinary Medicine", "Medicine", "Business", "Engineering", "Education"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(343, 174, 156, 22);
		contentPane.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(633, 174, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(536, 139, 116, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(91, 200, 116, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(371, 200, 116, 22);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_3 = new JLabel("GPA");
		lblNewLabel_3.setBounds(28, 203, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblEmailAddress = new JLabel("email address");
		lblEmailAddress.setBounds(266, 203, 93, 16);
		contentPane.add(lblEmailAddress);
		
		JLabel lblNewLabel_4 = new JLabel("2. Choose scholarship");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(28, 278, 168, 16);
		contentPane.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(95, 356, 36, 25);
		contentPane.add(chckbxNewCheckBox_1);
		
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"checkbox", "index", "scholar name", "donor", "value", "annualbool", "requrement", "totalamount", "applicants"},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"checkbox", "index", "scholar name", "donor", "value", "annualbool", "requirement", "totalamount", "applicants"
			}
		));
			
		
		table.setBounds(139, 320, 781, 120);
		table.setRowHeight(30);
		
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "personal info update successful");
				
			}
		});
		btnNewButton.setBounds(821, 186, 133, 22);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("3. upload file(s)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(28, 457, 150, 22);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Add(...)");
		btnNewButton_1.setBounds(38, 492, 97, 25);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("4. submit");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(28, 543, 103, 24);
		contentPane.add(lblNewLabel_6);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I agree terms and condition and all infomation provided are correct and concise. I will take the responsibility of any type of information error and misunderstanding");
		chckbxNewCheckBox.setBounds(28, 569, 1031, 35);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//update scholarship info and link applicant to scholarship
				JOptionPane.showMessageDialog(null, "submit successful");
				
			}
		});
		btnNewButton_2.setBounds(28, 613, 97, 25);
		contentPane.add(btnNewButton_2);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(95, 386, 36, 25);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(95, 416, 36, 25);
		contentPane.add(checkBox_1);
		


	}
}
