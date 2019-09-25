package application;

public class Contact {
	private String FirstName;
	private String LastName;
	private String EmailName;
	private String Gendre;
	private String Profilepicture;
	public String getProfilePicture() {
		return Profilepicture;
	}
	public void setProfilePicture(String profilePicture) {
		Profilepicture = profilePicture;
	}
	public String getGendre() {
		return Gendre;
	}
	public void setGendre(String gendre) {
		Gendre = gendre;
	}
	public String getEmailName() {
		return EmailName;
	}
	public void setEmailName(String emailName) {
		EmailName = emailName;
	}
	private String Password;
	private String DateOfBirth;
	private String Gender;
	
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
