import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyAwards extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MyAwards(Data data, User applicant) {
		setTitle("University of Calgary Scholarship Application System | My Awards");
		setBounds(100, 100, 691, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
	}

}
	
