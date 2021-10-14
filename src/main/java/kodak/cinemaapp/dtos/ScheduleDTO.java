package kodak.cinemaapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleDTO {

    int id;
    LocalDate date;

    public ScheduleDTO(LocalDate date) {
        this.date = date;
    }

    public ScheduleDTO(Schedule schedule){
        this.date = schedule.getDate();
        this.id = schedule.getId();
    }

    public static List<ScheduleDTO> scheduleDTOSfromSchedule(Iterable<Schedule> schedules){
        List<ScheduleDTO> dtos = StreamSupport.stream(schedules.spliterator(), false)
                .map(schedule -> new ScheduleDTO(schedule))
                .collect(Collectors.toList());
        return dtos;
    }

    public static Schedule scheduleFromScheduleDTO(ScheduleDTO schedule) {
        return new Schedule(schedule.getDate());
    }

}
