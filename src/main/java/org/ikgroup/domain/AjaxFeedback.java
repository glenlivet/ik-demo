package org.ikgroup.domain;

public class AjaxFeedback {
	
	public static final int ERROR = -1;
	public static final int SUCCESS = 1;
	
	private int type;
	
	private String message;
	
	public AjaxFeedback(int type, String message){
		this.type = type;
		this.message = message;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
