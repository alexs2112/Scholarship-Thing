import java.util.ArrayList;
import java.io.*;

public class Applicant extends User implements Comparable {
	private static final long serialVersionUID = 1060623638149583738L;
	private String studentType;
	private String faculty;
	private String department;
	private double GPA;
	private Integer level;
	private String id;
	private ArrayList<Recommendations> recommendations;
	private ArrayList<Scholarship> applications;
	private ArrayList<File> studentFiles;
	private ArrayList<Scholarship> awards;
	private ArrayList<Scholarship> accepted;

	
	//The awards the applicant has been approved for
	public ArrayList<Scholarship> awards() { 
		return awards; 
		
		}
	
	public ArrayList<Scholarship> acceptedAwards() {
		return accepted;
	}
	
	public void addAward(Scholarship award) { 
		awards.add(award);
		
		}
	

	public Applicant(String name, String id, String studenttype, String fac, String dep, double gpa, String username, String password, String role) {
		super(name, role, username, password);
		this.id = id;
		this.studentType = studenttype;
		this.faculty = fac;
		this.department = dep;
		this.GPA = gpa;
		this.applications = new ArrayList<Scholarship>();
		this.studentFiles = new ArrayList<File>();
		this.recommendations = new ArrayList<Recommendations>();
		this.awards = new ArrayList<Scholarship>();
		this.accepted = new ArrayList<Scholarship>();
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
	
	public String getEmail() { 
		return email; 
		
		}
	
	public Integer getLevel() {
		return level;
		
	}
	
	public String id() {
		return id; 
		
		}
	
	public ArrayList<Scholarship> applications() { 
		return applications; 
		
		}
	
	public void addApplication(Scholarship x) { 
		applications.add(x); 
		
		}
	
	public void addStudentFile(File file) {
		
		studentFiles.add(file);
	}

	public void addProfRec(Recommendations recom) {
		recommendations.add(recom);
		
	}
	
	public ArrayList<Recommendations> getRecs() { 
		return recommendations; 
		
		}	
	
	
	
	@Override
	public int compareTo(Object user) {
		//A method to use collections.sort() on applicants
		double compare = ((Applicant)user).getGPA();
		//Done in descending order, each professor that recommends this student adds a virtual
		//4 to this students GPA, after sorting students that are eligible for the award
		//So first every applicant that surpasses the GPA req gets added to a list, then
		//it sorts the arraylist by this logic here, before awarding the top x students
		return (int)(compare - this.getGPA() - (this.recommendations.size() * 4));
    }

}
