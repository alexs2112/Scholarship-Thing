import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class ProfessorLogin extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private JPanel contentPane;
	Data data;

	/**
	 * Create the frame.
	 */
	public ProfessorLogin(Data data, User prof) {
		
		//design elements
		this.data = data;
		setTitle("University of Calgary Scholarship Application System | Professor Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//logs professor out of the system and brings the user to the login page
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login window = new Login(data);
				window.frmLogin().setVisible(true);
			}
		});
		btnNewButton.setBounds(327, 294, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to the University of Calgary Scholarship Application System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(81, 0, 636, 38);
		contentPane.add(lblNewLabel_1);
		
		//brings the user to a new window where they can nominate a student for a scholarship
		JButton btnNewButton_1 = new JButton("Nominate Student for Award");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NominateStudent nomStud = new NominateStudent(data, prof);
				nomStud.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(270, 68, 207, 29);
		contentPane.add(btnNewButton_1);
		
		//brings the user to a new window where they can submit reference letters for students
		JButton btnNewButton_2 = new JButton("Submit Reference Letter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubmitReference subRef = new SubmitReference(data);
				subRef.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(270, 110, 207, 29);
		contentPane.add(btnNewButton_2);
	}
}