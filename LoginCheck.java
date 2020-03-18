import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class LoginCheck {

    public String login(String username, String password) throws IOException {
        ArrayList<String> uNList = new ArrayList<String>();
        ArrayList<String> pWList = new ArrayList<String>();
        ArrayList<String> type = new ArrayList<String>();

        try {
            BufferedReader read = new BufferedReader(new FileReader("Resources/login.txt"));
            String line = read.readLine();
            while (line != null){
                String cLine[] = line.split(" ");
                uNList.add(cLine[0]);
                pWList.add(cLine[1]);
                type.add(cLine[2]);
                line = read.readLine();
            }
            read.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Account file not found.");
        }
		
		if (uNList.contains(username)) {
			int index = uNList.indexOf(username);
			if (password.equals(pWList.get(index))) {
				JOptionPane.showMessageDialog(null, "You have sucessfully logged in!");
			}
			else
				JOptionPane.showMessageDialog(null, "Incorrect username or password.");
		}
        else
			JOptionPane.showMessageDialog(null, "Incorrect username or password.");
        
        if (uNList.contains(username) == false || pWList.contains(password) == false) {
            String userType = "null";
            return userType;
        }
        else {
            String userType = type.get(uNList.indexOf(username));
            return userType;
        }
    }

    public void addToFile(String username, String password) throws IOException{
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter("Resources/login.txt", true));
            write.append(username+" "+password+" student\n");
            write.close();
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Account file not found.");
        }
    }
}
