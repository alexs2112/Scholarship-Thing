import java.util.ArrayList;

public class Applicant extends User{
	private static final long serialVersionUID = 1060623638149583738L;
	private String studentType;
	private String faculty;
	private String department;
	private double GPA;
	private Integer level;
	private String id;
	//private ArrayList<Professor> recommendations;
	private ArrayList<Scholarship> applications;

	public Applicant(String name, String id, String studenttype, String fac, String dep, double gpa, String username, String password, String role) {
		super(name, role, username, password);
		this.id = id;
		this.studentType = studenttype;
		this.faculty = fac;
		this.department = dep;
		this.GPA = gpa;
		this.applications = new ArrayList<Scholarship>();
	}
	
	public void update(String firstName, String lastName, String id, String type, String faculty, 
			String department, double gpa, String email) {
		this.name = firstName + " " + lastName;
		this.id = id;
		this.studentType = type;
		this.faculty = faculty;
		this.department = department;
		this.GPA = gpa;
		this.email = email;
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
	
	public void setGPA(double gpa) {
		this.GPA = gpa;
	}
	
	public double getGPA() {
		return GPA;
	}
	
	public void setLevel(Integer lev) {
		this.level = lev;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() { return email; }
	
	public Integer getLevel() {
		return level;
	}
	public String id() { return id; }
	public ArrayList<Scholarship> applications() { return applications; }
	public void addApplication(Scholarship x) { applications.add(x); }

	
}
