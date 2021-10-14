package kodak.cinemaapp.exception;

import lombok.Data;
import java.util.Date;

@Data
public class ErrorMapper {
	private Date timestamp;
	private String message;
	private String path;



	public ErrorMapper(Date timestamp, String message, String path ) {
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;


	}



}
