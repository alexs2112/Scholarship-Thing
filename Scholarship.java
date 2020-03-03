import java.util.ArrayList;

public class Scholarship {
	String name;		//Name of the scholarship
	String donor;		//Name of the donor
	int value;			//How much the award is worth
	boolean annual; 	//if true: annual, if false: term based
	//A way to check extra restrictions
	float requirement; //GPA requirement
	//Deadline
	int totalAmount; 	//Number of awards that can be given out
	ArrayList<Applicant> applicants; //The current list of people who have applied
	
	public Scholarship(String name, String donor, int value, boolean annual, float requirement, int totalAmount, ArrayList<Applicant> applicants) {
		this.name = name;
		this.donor = donor;
		this.value = value;
		this.annual = annual;
		this.requirement = requirement;
		this.totalAmount = totalAmount;
		this.applicants = applicants;
	}
}