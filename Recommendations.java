
public class Recommendations {

	
	private Professor prof;
	private Scholarship schol;

	public Recommendations(Professor profs, Scholarship scholar) {
		this.prof = profs;
		this.schol = scholar;
		
	}
	
	public Professor getNominator() {
		return prof;
	}

	public Scholarship getScholNom() {
		return schol;
	}
}
