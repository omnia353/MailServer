package application;


public class MailNode {
	private String from;
	private String to;
	private String subject;
	private String date;
	private String attachment;
	private String index;
	private String firstName;
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	private String lastName;
	private LinkedList emails;
	private String relation;
	private String filterName ;
	private String filterPath;
	private String folderName;
	private String Priority;
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	private String newFolder;
	
	
	public String getnewFolder() {
		return newFolder;
	}
	public void setnewFolder(String newFolder) {
		this.newFolder = newFolder;
	}
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
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
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public String getFilterPath() {
		return filterPath;
	}
	public void setFilterPath(String filterPath) {
		this.filterPath = filterPath;
	}
	
	
}