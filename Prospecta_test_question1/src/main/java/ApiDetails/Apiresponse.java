package ApiDetails;

import java.time.LocalDateTime;

public class Apiresponse {
	
	private LocalDateTime timestamp;

    private String message;

    private boolean status;

    private Object responseObject;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	// all getter setter are there //

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

	public Apiresponse(LocalDateTime timestamp, String message, boolean status, Object responseObject) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.responseObject = responseObject;
	}

	public Apiresponse() {
		super();
		// TODO Auto-generated constructor stub
	}



}
