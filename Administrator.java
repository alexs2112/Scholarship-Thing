
public class Administrator extends User{
	private static final long serialVersionUID = 1060623638149583738L;

	//constructor for administrator
	public Administrator(String name, String username, String password) {
		super(name, "admin", username, password);
	}

}

