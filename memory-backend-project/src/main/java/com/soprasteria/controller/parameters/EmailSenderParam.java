package com.soprasteria.controller.parameters;

import java.util.List;

public class EmailSenderParam {

	private List<String> mailList;
	private List<String> linkList;
	
	
	
	public List<String> getMailList() {
		return mailList;
	}

	public void setMailList(List<String> mailList) {
		this.mailList = mailList;
	}

	public List<String> getLinkList() {
		return linkList;
	}

	public void setLinkList(List<String> linkList) {
		this.linkList = linkList;
	}
	
}
