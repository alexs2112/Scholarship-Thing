import java.util.ArrayList;
import java.util.Collections;

public class AwardScholarships {
	private Data data;

	public AwardScholarships(Data data) {
		this.data = data;
	}
	
	public void awardAllScholarships() {
		for (int i = 0; i < data.awards().size(); i++) {
			awardScholarship(data.awards().get(i));
		}
	}
	
	public void awardScholarship(Scholarship award) {
		//Search through the awards arraylist of applicants
		//For each applicant, if their GPA meets the requirement, add them to a new arraylist
		//If the new arraylist has length less than the total number of awards, award them all
		//Otherwise, sort the arraylist by GPA and award the top x applicants
		ArrayList<Applicant> candidates = new ArrayList<Applicant>();
		for (int i = 0; i < award.getNumberApplicants(); i++) {
			if (award.getApplicants().get(i).getGPA() >= award.getReq())
				candidates.add(award.getApplicants().get(i));
		}
		if (candidates.size() <= award.getTotalAmount()) {
			//If there are less than or equal number of candidates to the number of awards, award them all
			for (Applicant user : candidates) {
				user.addAward(award);
			}
		}
		
		else {
			//Comparable implemented in Applicants to allow us to sort this
			Collections.sort(candidates);
			for (int x = 0; x < award.getTotalAmount(); x++)
				candidates.get(x).addAward(award);
		}
		
		//Then clear the applicants arraylist for this award
		award.clearApplicants();	
	}

}
