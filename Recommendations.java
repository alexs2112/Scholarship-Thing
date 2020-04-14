import java.io.Serializable;

public class Recommendations implements Serializable {
	private static final long serialVersionUID = 1060623638149583738L;


	
	private User prof; //the user who has recommended the student
	private Scholarship schol; //the scholarship the student has been recommended for

	//constructor for recommendation
	public Recommendations(User profs, Scholarship scholar) {
		this.prof = profs;
		this.schol = scholar;
		
	}
	
	//getters
	public User getNominator() {
		return prof;
	}

	public Scholarship getScholNom() {
		return schol;
	}
}
