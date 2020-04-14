import java.util.ArrayList;
import java.io.*;

public class Applicant extends User implements Comparable {
	private static final long serialVersionUID = 1060623638149583738L;
	private String studentType; //Student Type: Undergrad, Graduate, PostGrad
	private String faculty; //The faculty the applicant belongs to
	private String department; //The department the applicant belongs to
	private double GPA; //The applicants GPA
	private Integer level; //the access permission of the applicant
	private String id; //the applicants student id
	private ArrayList<Recommendations> recommendations; //a list of recommendations the student has (the professor who recommended them and the award they've been recommended for)
	private ArrayList<Scholarship> applications; //a list of scholarships the applicant has applied for
	private ArrayList<File> studentFiles; //a list of Files that have been saved to the applicant (Transcripts, references, etc)
	private ArrayList<Scholarship> awards; //a list of scholarships that the student has been awarded 
	private ArrayList<Scholarship> accepted;//a list of scholarships that the student has accepted to receive

	//returns the ArrayList of Scholarships the student has been selected to receive (before the accept or decline)
	public ArrayList<Scholarship> awards() { 
		return awards; 
		
		}
	//retuns the ArrayList of Scholarships the student has accepted and will receive
	public ArrayList<Scholarship> acceptedAwards() {
		return accepted;
	}
	
	//adds an award to the students ArrayList of awarded Scholarships
	public void addAward(Scholarship award) { 
		awards.add(award);
		
		}
	

	//Constructor for Applicant
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
	
	//Updates the applicants information
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
	
	//Getters and Setters for Applicant
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
