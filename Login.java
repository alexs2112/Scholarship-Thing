import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login implements java.io.Serializable {
	private static final long serialVersionUID = 1060623638149583738L;
	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	public JFrame frmLogin() { return frmLogin; }
	private Data data;
	public Data data() { return data; }
	

	/**
	 * Create the application.
	 */
	public Login(Data data) {
		this.data = data;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
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
				
			LoginCheck loginCheck = new LoginCheck(data);
			String userLogin = textField.getText();
			char[] c = passwordField.getPassword();
			String userPassword = new String(c);
			//Applies the login check to see if this user exists, returns the users type
			String cond = loginCheck.login(userLogin, userPassword);
			System.out.println(cond);

			//Uses the users type to call the next screen
			if (cond.equals("sc")) {
			frmLogin.dispose();
			ScholarCoordLogin schoCoor = new ScholarCoordLogin(data);
			schoCoor.setVisible(true);

			} else if (cond.equals("prof")) {
			frmLogin.dispose();
			ProfessorLogin profLog = new ProfessorLogin(data);
			profLog.setVisible(true);

			} else if (cond.equals("admin")) {
			frmLogin.dispose();
			AdminLogin adminLog = new AdminLogin(data);
			adminLog.setVisible(true);

			} else if (cond.equals("student")) {
			frmLogin.dispose();
			ApplicantLogin appLog = new ApplicantLogin(data);
			appLog.setVisible(true);
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
				Register regPage = new Register(data);
				regPage.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(241, 182, 117, 29);
		frmLogin.getContentPane().add(btnNewButton_1);
	}
}
