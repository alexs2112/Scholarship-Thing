import java.awt.EventQueue;
import java.util.ArrayList;

public class Main implements java.io.Serializable {
	private static final long serialVersionUID = 1060623638149583738L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Initializes the data class
		Data newData = new Data();
		Data data = newData.loadData();
		//It doesnt work any other way and idk why
		//First we load an empty data object, then use that object to load any existing data into a new object
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Creates a login window, using the data class
					Login window = new Login(data);
					window.frmLogin().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
