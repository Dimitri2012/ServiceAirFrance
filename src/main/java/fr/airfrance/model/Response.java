package fr.airfrance.model;

import java.util.List;


public class Response {
	
	private String message;
	
	private String code;

	public String getMessage() {
		return message;
	}

	
	public String toString() {
		return "code " + code + " " + " message :" + message;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Response(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub

	
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			
			return false;
		}

		if (getClass() != obj.getClass()) {
		
			return false;
		}
		Response other = (Response) obj;
		if (message != other.message) {
			
			return false;
		}
		if (!(code.equals(other.code))) {
			
			return false;
		}

		return true;
	}


}
