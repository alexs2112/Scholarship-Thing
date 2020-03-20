import java.util.ArrayList;

public class Scholarship {

	public String name; //Name of the Scholarship
	public String donor; //Name of the donor
	public Integer value; //Dollar value of the scholarship
	public Boolean annual; //boolean value that evaluates to true if  the scholarship is for the full academic year
	public Float requirement; //minimum GPA required to be eligible for the scholarship
	public Integer totalAmount; //Number of awards that will be given out
	public ArrayList<Applicant> applicants; //the current list of students who have applied for the award

	public Scholarship(String scholName, String donorName, Integer dolVal, Boolean ann, Float req, Integer totAmount, ArrayList<Applicant> applicantList) {
		this.name = scholName;
		this.donor = donorName;
		this.value = dolVal;
		this.annual = ann;
		this.requirement = req;
		this.totalAmount = totAmount;
		this.applicants = applicantList;
		// TODO Auto-generated constructor stub
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

	public Float getReq() {
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

	public Integer getNumberApplicants() {
		return (this.applicants).size();
	}

}
