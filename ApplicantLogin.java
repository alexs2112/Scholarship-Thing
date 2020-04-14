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


public class ApplicantLogin extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;


	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ApplicantLogin(Data data, User applicant, int index) {
		setTitle("University of Calgary Scholarship Application System | Applicant Login");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("View Awards");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAwards viewAw = new ViewAwards(data, applicant);
				viewAw.setVisible(true);
			}
		});
		btnNewButton.setBounds(235, 156, 234, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Apply for Awards");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplyForAward applyAward = new ApplyForAward(data, applicant, index);
				applyAward.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(235, 200, 234, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Accept/Decline Awards");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcceptAwards accAw = new AcceptAwards(data, applicant, index);
				accAw.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(235, 243, 234, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login window = new Login(data);
				window.frmLogin().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(298, 328, 117, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("University of Calgary Scholarship Application System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(146, 6, 574, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("My Awards");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyAwards myAw = new MyAwards(data, applicant);
				myAw.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(235, 284, 234, 29);
		contentPane.add(btnNewButton_4);
	}
}