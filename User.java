public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1060623638149583738L;
	protected String name; //name of user
	protected String role; //the role the user has (prof, admin, coordinator, applicant)
	protected String username; //the users username
	protected String password; //the users password
	protected String email; ///the users email
	
	//constructor for user
	public User(String name, String role, String username, String password) {
		this.name = name;
		this.role = role;
		this.username = username;
		this.password = password;
	}
	
	//getters and setters
	public String name() { 
		return name;
		
		}
	
	public String role() { 
		return role;
		
	}
	
	public String username() { 
		return username;
		
		}
	
	public String password() {
		return password;
		
		}
	
	public String email() { 
		return email; 
		
		}
	
	public void setEmail(String email) { 
		this.email = email;
		
		}
	
	public String firstName() {
		return (name.split(" "))[0];
		
	}
	
	public String lastName() {
		String[] last = name.split(" ");
		if (last.length > 1)
			return last[1];
		else
			return " ";
	}
}