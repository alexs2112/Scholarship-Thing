import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(204, 83, 130, 26);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(204, 121, 130, 26);
		frmLogin.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			try{
				LoginCheck loginCheck = new LoginCheck();
				String userLogin = textField.getText();
				char[] c = passwordField.getPassword();
				String userPassword = new String(c);
				String cond = loginCheck.login(userLogin, userPassword);
				System.out.println(cond);

				if (cond.equals("sc")) {
				frmLogin.dispose();
				ScholarCoordLogin schoCoor = new ScholarCoordLogin();
				schoCoor.setVisible(true);

			}	else if (cond.equals("prof")) {
				frmLogin.dispose();
				ProfessorLogin profLog = new ProfessorLogin();
				profLog.setVisible(true);

			}	else if (cond.equals("admin")) {
				frmLogin.dispose();
				AdminLogin adminLog = new AdminLogin();
				adminLog.setVisible(true);

			} else if (cond.equals("student")){
				frmLogin.dispose();
				ApplicantLogin appLog = new ApplicantLogin();
				appLog.setVisible(true);
			}
		} catch (IOException g) {
			g.printStackTrace();
			}
		}
	});

		btnNewButton.setBounds(97, 182, 117, 29);
		frmLogin.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(111, 88, 61, 16);
		frmLogin.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(99, 126, 61, 16);
		frmLogin.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
				Register regPage = new Register();
				regPage.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(241, 182, 117, 29);
		frmLogin.getContentPane().add(btnNewButton_1);
	}
}
