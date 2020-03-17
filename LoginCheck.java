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
                int i = 0;
                while (i <= 3){
                    if (i == 0) {
                        uNList.add(cLine[0]);
                    }
                    else if (i == 1){
                        pWList.add(cLine[1]);
                    }
                    else if (i == 2){
                        type.add(cLine[2]);
                    }
                    i++;
                }
                line = read.readLine();
            }
            if (username.length() != 0 && password.length() != 0) {
                int index = uNList.indexOf(username);

                if (uNList.contains(username) & password == pWList.get(index)){
                JOptionPane.showMessageDialog(null, "You have sucessfully logged in!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please register instead.");
            }

            read.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Account file not found.");
        }
        
        if (uNList.contains(username) == false || pWList.contains(password) == false) {
            String userType = "null";
            return userType;
        }
        else {
            String userType = type.get(uNList.indexOf(username));
            return userType;
        }
    }
}
