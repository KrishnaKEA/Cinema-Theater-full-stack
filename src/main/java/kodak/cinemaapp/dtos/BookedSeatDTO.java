package kodak.cinemaapp.dtos;


import kodak.cinemaapp.entities.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

public class BookedSeatDTO {
    private int id;
    private int seatId;
    private int userId;
    private LocalDate date;
    private char hallName;
    private String timeSlot;
    private int movieId;




    public BookedSeatDTO(BookedSeat bookedSeat) {
        this.id = bookedSeat.getId();
        this.seatId = bookedSeat.getSeat().getId();
        this.userId = bookedSeat.getBooking().getUser().getId();
        this.date = bookedSeat.getDate();
        this.hallName = bookedSeat.getSeat().getMovieHall().getHallName();
        this.timeSlot = bookedSeat.getTimeSlot();
        this.movieId = bookedSeat.getBooking().getSchedule().getMovie().getId();



    }

    public static List<ScheduleDTO> scheduleDTOSFromSchedule(Iterable<Schedule> schedules){
        List<ScheduleDTO> sDTOs = new ArrayList<>();
        for(Schedule sch: schedules){
            ScheduleDTO schD = new ScheduleDTO(sch);
            sDTOs.add(schD);
        }
        return sDTOs;
    }

    public static List<BookedSeatDTO> bookedSeatDTOSFromBookedSeat(Iterable<BookedSeat> bookedSeats){
        List<BookedSeatDTO> bookedSeatDTOS = new ArrayList<>();
        for(BookedSeat bs : bookedSeats){
            BookedSeatDTO bookedSeatDTO = new BookedSeatDTO(bs);
            bookedSeatDTOS.add(bookedSeatDTO);
        }
        return bookedSeatDTOS;
    }


}
