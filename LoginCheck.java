import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class LoginCheck implements Serializable {
	private static final long serialVersionUID = 1060623638149583738L;
	private Data data;
	
	public LoginCheck(Data data) {
		this.data = data;
	}
	
	public User login(String username, String password) {
		User user = null;
		
		//First search the array for the same username, store those users in a new array and then check the
		//passwords
		ArrayList<User> users = data.users();
		ArrayList<User> sameUsername = new ArrayList<User>();
		
		for (int i = 0; i < users.size(); i++) {
			//For every user in users, if the username is the same as the input username, add the user to sameUsername
			if (users.get(i).username().equals(username)) {
				sameUsername.add(users.get(i));
			}
		}
		
		for (int x = 0; x < sameUsername.size(); x++) {
			//Now do the same with the password, searching the subset sameUsername
			if (sameUsername.get(x).password().equals(password)) {
				//Set the type as the users role
				user = sameUsername.get(x);	//Return the user with the same username and password
			}
		}
		
		//If the type has changed, that means it is equal to a users role, so tell them they logged in
		if (user != null) {
			JOptionPane.showMessageDialog(null, "You have sucessfully logged in!");
			return user;
		}
		else {
			JOptionPane.showMessageDialog(null, "Incorrect username or password.");
			return null;
		}
		
	}
}