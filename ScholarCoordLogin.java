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

public class ScholarCoordLogin extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	Data data;

	/**
	 * Create the frame.
	 */
	public ScholarCoordLogin(Data data) {
		this.data = data;
		setTitle("Scholarship Coordinator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Create New Award");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAward addAward = new NewAward(data);
				addAward.setVisible(true);
			}
		});
		btnNewButton.setBounds(17, 19, 178, 29);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Edit/Delete Existing Award");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExistingAward editAward = new ExistingAward(data);
				editAward.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(17, 53, 224, 29);
		getContentPane().add(btnNewButton_1);
	}
}
