import java.util.ArrayList;

public class Applicant extends User{
	private static final long serialVersionUID = 1060623638149583738L;
	private String studentType;
	private String faculty;
	private String department;
	private Float GPA;
	private Integer level;
	//private ArrayList<Professor> recommendations;

	public Applicant(String name, String studenttype, String fac, String dep, Float gpa, String username, String password, String role) {
		super(name, role, username, password);
		this.studentType = studenttype;
		this.faculty = fac;
		this.department = dep;
		this.GPA = gpa;
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
