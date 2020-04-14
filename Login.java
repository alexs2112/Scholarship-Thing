import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;

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
		frmLogin.getContentPane().setForeground(new Color(0, 0, 0));
		frmLogin.getContentPane().setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 45));
		frmLogin.getContentPane().setBackground(new Color(255, 200, 0));
		frmLogin.setResizable(false);
		frmLogin.setTitle("University of Calgary Scholarship Application System | Login");
		frmLogin.setBounds(100, 100, 750, 500);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(330, 193, 130, 26);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(330, 225, 130, 26);
		frmLogin.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			LoginCheck loginCheck = new LoginCheck(data);
			String userLogin = textField.getText();
			char[] c = passwordField.getPassword();
			String userPassword = new String(c);
			
			//Applies the login check to see if this user exists, returns the user
			User user = loginCheck.login(userLogin, userPassword);
			if (user == null)
				return;
			
			if (user != null) {
				System.out.println(user.name());
				//Uses the users type to call the next screen
				if (user.role().equals("sc")) {
				frmLogin.dispose();
				ScholarCoordLogin schoCoor = new ScholarCoordLogin(data, user);
				schoCoor.setVisible(true);
	
				} else if (user.role().equals("prof")) {
				frmLogin.dispose();
				ProfessorLogin profLog = new ProfessorLogin(data, user);
				profLog.setVisible(true);
	
				} else if (user.role().equals("admin")) {
				frmLogin.dispose();
				AdminLogin adminLog = new AdminLogin(data, user);
				adminLog.setVisible(true);
	
				} else if (user.role().equals("student")) {
				frmLogin.dispose();
				ApplicantLogin appLog = new ApplicantLogin(data, user, 0);
				appLog.setVisible(true);
				}
			}
		}
	});

		btnNewButton.setBounds(258, 327, 117, 29);
		frmLogin.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(221, 198, 85, 16);
		frmLogin.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(221, 230, 85, 16);
		frmLogin.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
				Register regPage = new Register(data);
				regPage.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(415, 327, 117, 29);
		frmLogin.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to the University of Calgary Scholarship Application System");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_2.setBounds(65, 29, 750, 30);
		frmLogin.getContentPane().add(lblNewLabel_2);
		
		//ImageIcon logo = new ImageIcon("UofClogo.png");
		//Image image1 = logo.getImage();
		//Image newimage = image1.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		//logo = new ImageIcon(newimage);
		
		//Image logo = new Image("UofClogo.png");
		
		
	}
}
