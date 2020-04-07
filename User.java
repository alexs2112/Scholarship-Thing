


public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1060623638149583738L;
	protected String name;
	protected String role;
	protected String username;
	protected String password;
	
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