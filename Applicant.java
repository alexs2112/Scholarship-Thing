

public class Applicant extends User{
	//Need flags and restrictions and stuff
	float GPA;
	
	public Applicant(String name, float GPA) {
		this.name = name;
		this.GPA = GPA;
		//Default is administration level 0
	}
	
}