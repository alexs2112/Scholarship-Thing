
public class Recommendations {

	
	private User prof;
	private Scholarship schol;

	public Recommendations(User profes, Scholarship scholar) {
		this.prof = profes;
		this.schol = scholar;
		
	}
	
	public User getNominator() {
		return prof;
	}

	public Scholarship getScholNom() {
		return schol;
	}
}
