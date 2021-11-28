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
    private LocalDate date;

  /*  private Movie movie;
    private Slot slot;
    private MovieHall movieHall;*/


    // customized json output
    private int movieId;
    private int hallId;
    private int slotId;


    public ScheduleDTO(Schedule schedule){
        this.id = schedule.getId();
        this.movieId = schedule.getMovie().getId();
        this.hallId = schedule.getMovieHall().getId();
        this.slotId = schedule.getSlot().getId();
        this.date = schedule.getDate();

    }

    /*public ScheduleDTO(Schedule schedule){
        this.id = schedule.getId();
        this.movie = schedule.getMovie();
        this.movieHall = schedule.getMovieHall();
        this.slot = schedule.getSlot();
        this.date = schedule.getDate();

    }*/


    public static List<ScheduleDTO> scheduleDTOSFromSchedule(Iterable<Schedule> schedules){
        List<ScheduleDTO> sDTOs = new ArrayList<>();
        for(Schedule sch: schedules){
            ScheduleDTO schD = new ScheduleDTO(sch);
            sDTOs.add(schD);
        }
        return sDTOs;
    }

    /*public static Schedule scheduleFromScheduleDTO(ScheduleDTO scheduleDTO){
        return new Schedule(scheduleDTO.getDate(),scheduleDTO.getHallId(),scheduleDTO.getMovieId(),scheduleDTO.getSlotId());
    }*/
}



