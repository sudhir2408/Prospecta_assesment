package exceptions;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class MyError {
	
	    private LocalDateTime timestamp;
	    private String message;
	    private String description;
	    
	    
	    /*  theTimestamp to get */
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		
		/*  the dateTime to set */
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
		
		/*  the message to get */
		public String getMessage() {
			return message;
		}
		
		/*  the message to set */
		public void setMessage(String message) {
			this.message = message;
		}
		
		/*  the description to get */
		public String getDescription() {
			return description;
		}
		
		/*  the description to set */
		public void setDescription(String description) {
			this.description = description;
		}
		
		
		/*  toString */
		@Override
		public String toString() {
			return "MyError [timestamp=" + timestamp + ", message=" + message + ", description=" + description + "]";
		}
		
		
		/*  the @param constructor */
		public MyError(LocalDateTime timestamp, String message, String description) {
			super();
			this.timestamp = timestamp;
			this.message = message;
			this.description = description;
		}
		
		/*  zero argument constructor */
		public MyError() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

}
