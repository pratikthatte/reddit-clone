package com.project.redditclone.model;

public class NotificationEmail {
	private String emailSubject;
	private String emailBody;
	private String emailRecepient;
	/**
	 * @return the emailSubject
	 */
	public NotificationEmail(String emailSubject, String emailBody, String emailRecepient) {
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
		this.emailRecepient = emailRecepient;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	/**
	 * @param emailSubject the emailSubject to set
	 */
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	/**
	 * @return the emailBody
	 */
	public String getEmailBody() {
		return emailBody;
	}
	/**
	 * @param emailBody the emailBody to set
	 */
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	/**
	 * @return the emailRecepient
	 */
	public String getEmailRecepient() {
		return emailRecepient;
	}
	/**
	 * @param emailRecepient the emailRecepient to set
	 */
	public void setEmailRecepient(String emailRecepient) {
		this.emailRecepient = emailRecepient;
	}
	
}
