import java.util.ArrayList;

public class Scholarship implements java.io.Serializable {
	private static final long serialVersionUID = 1060623638149583738L;
	private String name; //Name of the Scholarship
	private String donor; //Name of the donor
	private Integer value; //Dollar value of the scholarship
	private Boolean annual; //boolean value that evaluates to true if  the scholarship is for the full academic year
	private double requirement; //minimum GPA required to be eligible for the scholarship
	private Integer totalAmount; //Number of awards that will be given out
	private ArrayList<Applicant> applicants; //the current list of students who have applied for the award

	public Scholarship(String scholName, String donorName, Integer dolVal, Boolean ann, double req, Integer totAmount) {
		this.name = scholName;
		this.donor = donorName;
		this.value = dolVal;
		this.annual = ann;
		this.requirement = req;
		this.totalAmount = totAmount;
		this.applicants = new ArrayList<Applicant>();
	}


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

	public void setAnnual(Boolean ann) {
		this.annual = ann;
	}

	public Boolean getAnnual() {
		return annual;
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

	public ArrayList getApplicants() {
		return applicants;
	}
	public void addApplicant(Applicant applicant) { applicants.add(applicant); }

	public Integer getNumberApplicants() {
		return (this.applicants).size();
	}

}
