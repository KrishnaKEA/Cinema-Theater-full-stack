package kodak.cinemaapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleDTO {

    int id;
    Date date;

    public ScheduleDTO(Date date) {
        this.date = date;
    }

    public ScheduleDTO(Schedule schedule){
        this.date = schedule.getDate();
        this.id = schedule.getId();
    }

    public static List<ScheduleDTO> movieDTOSfromMovie(Iterable<Schedule> schedules){
        List<ScheduleDTO> dtos = StreamSupport.stream(schedules.spliterator(), false)
                .map(schedule -> new ScheduleDTO(schedule))
                .collect(Collectors.toList());
        return dtos;
    }

    public static Movie movieFromMovieDTO(MovieDTO movie) {
        return new Movie(movie.getTitle(), movie.getAgeGroup(), movie.getCast(), movie.description, movie.isRating());
    }

}
