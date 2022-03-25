package fr.airfrance.model;

import java.util.List;

public class Response {
	
	private String message;
	private String code;
	public String getMessage() {
		return message;
	}

	
	public Response() {
		super();
	}

	
	public String toString() {
		return "code "+code+" "+" message :"+message;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
	
		System.out.println(1);
		if (this == obj) {
		     return true;}
		if (obj == null) {
			System.out.println(2);
		      return false;}
		
		 if (getClass() != obj.getClass()) {
			 System.out.println(3);
		      return false;}
		   Response other = (Response) obj;
		   if (message != other.message) {
			   System.out.println(4);
		      return false;}
		   if (!(code.equals(other.code))) {
			   System.out.println(5);
			      return false;}
		   
		    return true;
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
	
	
	

}
