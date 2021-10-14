package kodak.cinemaapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@ControllerAdvice
public class GlobalExceptionHandler {

        // Handle Movie exception specifically
        @ExceptionHandler(MovieNotFoundException.class)
        public ResponseEntity<?> handleMovieNotFoundException(
                MovieNotFoundException exception, WebRequest request){
            ErrorMapper errorMapper = new ErrorMapper(new Date(), exception.getMessage(), request.getDescription(false));
            return new ResponseEntity(errorMapper, HttpStatus.NOT_FOUND);
        }

        // Handle Movie exception globally
        @ExceptionHandler(Exception.class)
        public ResponseEntity<?> Exception(
               Exception exception, WebRequest request){
            ErrorMapper errorMapper = new ErrorMapper(new Date(), exception.getMessage(), request.getDescription(false));
            return new ResponseEntity(errorMapper, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
