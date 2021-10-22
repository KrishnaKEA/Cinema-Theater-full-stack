package kodak.cinemaapp.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;



@Data @NoArgsConstructor
public class ErrorMapper {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	private String message;
	private String path;



	public ErrorMapper(LocalDateTime timestamp, String message, String path ) {
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;


	}



}
