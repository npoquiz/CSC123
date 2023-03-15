 //Nathan Poquiz (npoquiz1@toromail.csudh.edu)

public class Person {
	
	//Fields
	private String firstName;
	private String lastName;
	private String SSN;
	
	//Constructors
	public Person(String fName, String lName, String SSN) {
		firstName=fName;
		lastName=lName;
		this.SSN=SSN;
	}

	//Methods

	public  String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSSN() {
		return SSN;
	}



	@Override
	public String toString() {
		return firstName+":"+lastName+":"+SSN;
	}
}
