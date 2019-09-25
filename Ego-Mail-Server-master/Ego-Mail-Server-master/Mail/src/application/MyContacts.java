package application;

public class MyContacts {
	private String firstName;
	private String lastName;
	private LinkedList emails;
	private String relation;
	private String index;
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LinkedList getEmails() {
		return emails;
	}
	public void setEmails(LinkedList emails) {
		this.emails = emails;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
}
