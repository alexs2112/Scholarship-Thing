

public class Applicant extends User{
	
	public String firstName;
	public String lastName;
	public String studentType;
	public String faculty;
	public String department;
	public Float GPA;
	public Integer level;
	float GPA;
	
	public Applicant(String firstname, String lastname, String studenttype, String fac, String dep, Float gpa) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.studentType = studenttype;
		this.faculty = fac;
		this.department = dep;
		this.GPA = gpa;
		this.level = 0;
		//Default is administration level 0
	}
	
	//getters and setters
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
	
	public void setStudentType(String studenttype) {
		this.studentType = studenttype;
	}
	
	public String getStudentType() {
		return studentType;
	}
	
	public void setFaculty(String fac) {
		this.faculty = fac;
	}
	
	public String getFaculty() {
		return faculty;
	}
	
	public void setDepartment(String dep) {
		this.department = dep;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setGPA(Float gpa) {
		this.GPA = gpa;
	}
	
	public Float getGPA() {
		return GPA;
	}
	
	public void setLevel(Integer lev) {
		this.level = lev;
	}
	
	public Integer getLevel() {
		return level;
	}	
}
