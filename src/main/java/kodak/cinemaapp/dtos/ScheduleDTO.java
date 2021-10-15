package kodak.cinemaapp.dtos;

import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.MovieHall;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.entities.Slot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

public class ScheduleDTO {

    private int id;
    private Movie movie;
    private MovieHall hall;
    private Slot slot;
    private LocalDate date;


    public ScheduleDTO(Schedule schedule){
        this.id = schedule.getId();
        this.movie = schedule.getMovie();
        this.hall = schedule.getMovieHall();
        this.slot = schedule.getSlot();
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
        return new Schedule(scheduleDTO.getId(),scheduleDTO.getDate(),scheduleDTO.getHall(),scheduleDTO.getMovie(),scheduleDTO.getSlot());
    }
}


//////////////

/*public class ScheduleDTO {

    private int id;
    private String movie;
    private char hall;
    private String slot;
    private LocalDate date;

    public ScheduleDTO(LocalDate date, char hall, String movie, String slot) {
        this.movie = movie;
        this.hall = hall;
        this.slot = slot;
        this.date = date;
    }
    public ScheduleDTO(Schedule schedule){
        this.id = schedule.getId();
        this.movie = schedule.getMovie().getTitle();
        this.hall = schedule.getMovieHall().getHallName();
        this.slot = schedule.getSlot().getName();
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
        return new Schedule(scheduleDTO.getDate(),scheduleDTO.getHall(),scheduleDTO.getMovie(),scheduleDTO.getSlot());
    }
}*/
