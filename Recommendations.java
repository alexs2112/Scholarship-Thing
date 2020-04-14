import java.io.Serializable;

public class Recommendations implements Serializable {
	private static final long serialVersionUID = 1060623638149583738L;


	
	private User prof;
	private Scholarship schol;

	public Recommendations(User profs, Scholarship scholar) {
		this.prof = profs;
		this.schol = scholar;
		
	}
	
	public User getNominator() {
		return prof;
	}

	public Scholarship getScholNom() {
		return schol;
	}
}
