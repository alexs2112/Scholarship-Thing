import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ApplicantLogin extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;


	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ApplicantLogin(Data data, User applicant, int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
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
		btnNewButton.setBounds(6, 16, 191, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Apply for Awards");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplyForAward applyAward = new ApplyForAward(data, applicant, index);
				applyAward.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(6, 57, 191, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Accept/Decline Awards");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcceptAwards accAw = new AcceptAwards(data, applicant, index);
				accAw.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(6, 97, 191, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login window = new Login(data);
				window.frmLogin().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(327, 243, 117, 29);
		contentPane.add(btnNewButton_3);
	}
}
