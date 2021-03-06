import java.util.ArrayList;

public class Scholarship implements java.io.Serializable {
	private static final long serialVersionUID = 1060623638149583738L;
	private String name; //Name of the Scholarship
	private String donor; //Name of the donor
	private Integer value; //Dollar value of the scholarship
	private String term; //annual award of semester based
	private double requirement; //minimum GPA required to be eligible for the scholarship
	private Integer totalAmount; //Number of awards that will be given out
	private ArrayList<Applicant> applicants; //the current list of students who have applied for the award
	private String faculty;		//faculty scholarship belonds to 
	private String department;	// 3 Strings for faculty/department/type specific scholarships
	private String studentType;	//undergrad, grad, postgrad

	//constructor for scholarship
	public Scholarship(String scholName, String donorName, Integer dolVal, String sem, double req, Integer totAmount, String faculty, String department, String type) {
		this.name = scholName;
		this.donor = donorName;
		this.value = dolVal;
		this.term = sem;
		this.requirement = req;
		this.totalAmount = totAmount;
		this.applicants = new ArrayList<Applicant>();
		this.faculty = faculty;
		this.department = department;
		this.studentType = type;
	}
	
	//method to update scholarship information
	public void update(String scholName, String donorName, Integer dolVal, String sem, double req, Integer totAmount, String faculty, String department, String type) {
		this.name = scholName;
		this.donor = donorName;
		this.value = dolVal;
		this.term = sem;
		this.requirement = req;
		this.totalAmount = totAmount;
		this.faculty = faculty;
		this.department = department;
		this.studentType = type;
	}


	//getters and setters
	public void setScholName(String scholName) {
		this.name = scholName;
	}

	public String getScholName() {
		return name;
	}

	public void setDonorName(String donorName) {
		this.donor = donorName;
	}

	public String getDonorName() {
		return donor;
	}

	public void setScholValue(Integer val) {
		this.value = val;
	}

	public Integer getScholValue() {
		return value;
	}

	public void setAnnual(String sem) {
		this.term = sem;
	}

	public String getAnnual() {
		return term;
	}

	public void setReq(Float req) {
		this.requirement = req;
	}

	public double getReq() {
		return requirement;
	}

	public void setTotalAmount(Integer totAmount) {
		this.totalAmount = totAmount;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setApplicants(ArrayList<Applicant> applicantList) {
		this.applicants = applicantList;
	}

	public ArrayList<Applicant> getApplicants() {
		return applicants;
	}
	public void addApplicant(Applicant applicant) { 
		applicants.add(applicant); 
		
		}
	
	public void clearApplicants() { 
		applicants.clear();
		
		}
	
	public Integer getNumberApplicants() {
		return (this.applicants).size();
		
	}

	public String department() { 
		return department; 
		
		}
	public String faculty() { 
		return faculty; 
		
		}
	public String studentType() { 
		return studentType; 
		
		}
}

