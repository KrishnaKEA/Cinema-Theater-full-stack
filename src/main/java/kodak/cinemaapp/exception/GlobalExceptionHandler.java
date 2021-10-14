package kodak.cinemaapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * @author omar
 */

@ControllerAdvice
public class GlobalExceptionHandler {

        // Handle Movie exception specifically
        @ExceptionHandler(MovieNotFoundException.class)
        public ResponseEntity<ErrorMapper> resourceAlreadyExists(MovieNotFoundException ex) {
            ErrorMapper response = new ErrorMapper();
            response.setPath("NOT_FOUND");
            response.setMessage(ex.getMessage());
            response.setTimestamp(LocalDateTime.now());

            return new ResponseEntity<ErrorMapper>(response, HttpStatus.NOT_FOUND);
        }

        // Handle Movie exception globally
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorMapper> resourceAlreadyExists(Exception ex) {
            ErrorMapper response = new ErrorMapper();
            response.setPath("Internal Server Error");
            response.setMessage(ex.getMessage());
            response.setTimestamp(LocalDateTime.now());

            return new ResponseEntity<ErrorMapper>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
