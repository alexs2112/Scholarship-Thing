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

public class AdminLogin extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;

	/**
	 * Create the frame.
	 */
	public AdminLogin(Data data, User user) {
		setTitle("Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 240);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome " + user.name());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(17, 15, 483, 30);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Create New Award");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAward addAward = new NewAward(data);
				addAward.setVisible(true);
			}
		});
		btnNewButton.setBounds(17, 40, 225, 30);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Edit/Delete Existing Award");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExistingAward editAward = new ExistingAward(data);
				editAward.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(17, 70, 225, 30);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Add Another User");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser newUser = new NewUser(data);
				newUser.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(17, 100, 225, 30);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login window = new Login(data);
				window.frmLogin().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(177, 143, 117, 30);
		getContentPane().add(btnNewButton_2);
	}
}



