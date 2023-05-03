package exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalException {
	
	//GlobalException are written here //
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyError> ExceptionHandler(Exception se, WebRequest req) {

        MyError error = new MyError();
        error.setTimestamp(LocalDateTime.now());
        error.setMessage(se.getMessage());
        error.setDescription(req.getDescription(false));

        return new ResponseEntity<MyError>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    
    
    
    // To Validation Exception written here //
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e,
                                                                                      WebRequest req) {

        Map<String, String> valid_Errors = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((error) -> {

            String field = (((FieldError) error).getField());
            String mess= error.getDefaultMessage();
            valid_Errors.put(field, mess);

        });

        return new ResponseEntity<Map<String, String>>(valid_Errors, HttpStatus.BAD_REQUEST);

    }
    
    

    // DataNotFound Exception are written here//
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<MyError> ResourceNotFoundExceptionHandler(Exception se, WebRequest req) {

        MyError error = new MyError();
        error.setTimestamp(LocalDateTime.now());
        error.setMessage(se.getMessage());
        error.setDescription(req.getDescription(false));

        return new ResponseEntity<MyError>(error, HttpStatus.NOT_FOUND);

    }

   

}
