import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
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

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScholarCoordLogin frame = new ScholarCoordLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setTitle("Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Create New Award");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAward addAward = new NewAward();
				addAward.setVisible(true);
			}
		});
		btnNewButton.setBounds(17, 19, 300, 29);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Edit/Delete Existing Award");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExistingAward editAward = new ExistingAward();
				editAward.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(17, 53, 300, 29);
		getContentPane().add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Add Another User");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser newUser = new NewUser();
				newUser.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(17, 87, 300, 29);
		getContentPane().add(btnNewButton_2);
	}

}
