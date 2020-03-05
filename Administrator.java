


public class Administrator extends User {
	
	public String firstName;
	public String lastName;
	public Integer level;

	public Administrator(String firstname, String lastname) {
		// TODO Auto-generated constructor stub
		this.firstName = firstname;
		this.lastName = lastname;
		this.level = 2;
	}
	
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLevel(Integer lev) {
		this.level = lev;
	}

	public Integer getLevel() {
		return level;
	}


}
