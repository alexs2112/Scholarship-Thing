import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Data implements Serializable {
	private static final long serialVersionUID = 1060623638149583738L;
	private ArrayList<User> users;
	private ArrayList<Scholarship> awards;

	public Data() {
		this.users = new ArrayList<User>();
		this.awards = new ArrayList<Scholarship>();
		
		//A test list of users to login as
		users.add(new Applicant("StudentTest", "000", "studentType", "Art", "Art", 3.0, "student", "student", "student"));
		users.add(new Professor("ProfTest", "professor", "professor"));
		users.add(new Coordinator("SCTest", "coordinator", "coordinator"));
		users.add(new Administrator("AdminTest", "administrator", "administrator"));
		awards.add(new Scholarship("TestScholarship1", "Donor One", 600, true, 3.4, 400));
		awards.add(new Scholarship("TestScholarship2", "Donor Two", 800, true, 3.6, 300));
		awards.add(new Scholarship("TestScholarship3", "Donor Three", 1000, true, 3.8, 200));
		saveData();
	}

	public void addUser(User user) {
		this.users.add(user);
	}
	public ArrayList<User> users() { return users; }
	public void addAward(Scholarship award) { this.awards.add(award); }
	public ArrayList<Scholarship> awards() { return awards; }

	public Data loadData() {
		//Load an already initialized Data from the file data.ser, if that file does not exist, return a newly
		//initialized object
		String filename = "data.ser";
		Data load;
		try
	    {    
	        // Reading the object from a file 
	        FileInputStream file = new FileInputStream(filename); 
	        ObjectInputStream in = new ObjectInputStream(file); 
	          
	        // Method for deserialization of object 
	        load = (Data)in.readObject(); 
	          
	        in.close(); 
	        file.close(); 
	        System.out.println("Data Available");
	        return load;
	    } 
	      
	    catch(IOException ex) 
	    { 
	        System.out.println("IOException is caught");
	        return new Data();
	    } 
	      
	    catch(ClassNotFoundException ex) 
	    { 
	        System.out.println("data.ser does not exist"); 
	        return new Data();
	    } 
	}
	public void saveData() {
		//Save execution state to the data.ser file, to be loaded in the future
		try {
			FileOutputStream file = new FileOutputStream("data.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this);
			out.close();
			file.close();
			System.out.println("Data Saved");
		} catch(NotSerializableException e) {
			//This should only happen if there is a relevant class that does not implement serializable (or JFrame)
			System.out.println("Not enough Serialization");
		} catch(IOException e) {
	        System.out.println("IOException is caught");
		}
	}
}