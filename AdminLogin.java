import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import java.awt.Color;

public class AdminLogin extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;

	/**
	 * Create the frame.
	 */
	public AdminLogin(Data data, User user) {
		getContentPane().setBackground(Color.ORANGE);
		setTitle("University of Calgary Scholarship Application System | Administrator Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome " + user.name());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(29, 54, 483, 30);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Create New Award");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAward addAward = new NewAward(data);
				addAward.setVisible(true);
			}
		});
		btnNewButton.setBounds(160, 146, 225, 30);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Edit/Delete Existing Award");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExistingAward editAward = new ExistingAward(data);
				editAward.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(160, 188, 225, 30);
		getContentPane().add(btnNewButton_1);
		
		JButton btnAward = new JButton("Award Scholarships");
		btnAward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiveAward giveAw = new GiveAward(data);
				giveAw.setVisible(true);
			}
		});
		btnAward.setBounds(397, 146, 225, 30);
		getContentPane().add(btnAward);
		
		JButton btnNewButton_3 = new JButton("Add Another User");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser newUser = new NewUser(data);
				newUser.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(397, 188, 225, 30);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login window = new Login(data);
				window.frmLogin().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(339, 241, 117, 30);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to the University of Calgary Scholarship Application System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(105, 4, 636, 38);
		getContentPane().add(lblNewLabel_1);
	}
}


