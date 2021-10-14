package kodak.cinemaapp.DTO;

import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

public class ScheduleDTO {

    int id;
    int movieId;
    int hallId;
    private int slotId;
    private LocalDate date;

    public ScheduleDTO(int movieId, int hallId, int slotId, LocalDate date) {
        this.movieId = movieId;
        this.hallId = hallId;
        this.slotId = slotId;
        this.date = date;
    }
    public ScheduleDTO(Schedule schedule){
        this.movieId = schedule.getMovieId();
        this.hallId = schedule.getHallId();
        this.slotId = schedule.getSlotId();
        this.date = schedule.getDate();

    }

    public static List<ScheduleDTO> scheduleDTOSFromSchedule(Iterable<Schedule> schedules){
        List<ScheduleDTO> sDTOs = new ArrayList<>();
        for(Schedule sch: schedules){
            ScheduleDTO schD = new ScheduleDTO(sch);
            sDTOs.add(schD);
        }
        return sDTOs;
    }
    public static Schedule scheduleFromScheduleDTO(ScheduleDTO scheduleDTO){
        return new Schedule(scheduleDTO.getMovieId(),scheduleDTO.getHallId(),scheduleDTO.getSlotId(),scheduleDTO.getDate());
    }
}
