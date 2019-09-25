package application;


public class Mail {
	private String to;
	private String from;
	private String subject;
	private String text;
	private Object Attachmenet;
	private String Date;
	private String Priority;
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Object getAttachmenet() {
		return Attachmenet;
	}
	public void setAttachmenet(Object attachmenet) {
		Attachmenet = attachmenet;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}

}
