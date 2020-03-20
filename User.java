


public class User {
	private String name;
	private String role;
	private String username;
	private String password;
	
	public User(String name, String role, String username, String password) {
		this.name = name;
		this.role = role;
		this.username = username;
		this.password = password;
	}
	
	public String name() { return name; }
	public String role() { return role; }
	public String username() { return username; }
	public String password() { return password; }
}