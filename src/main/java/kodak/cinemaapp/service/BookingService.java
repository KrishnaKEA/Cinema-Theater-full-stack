package kodak.cinemaapp.service;

import kodak.cinemaapp.entities.*;
import kodak.cinemaapp.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {


    MovieRepository movieRepository;
    MovieHallRepository movieHallRepository;
    SlotRepository slotRepository;
    ScheduleRepository scheduleRepository;
    BookingRepository bookingRepository;

    public BookingService(MovieRepository movieRepository, MovieHallRepository movieHallRepository, SlotRepository slotRepository, ScheduleRepository scheduleRepository, BookingRepository bookingRepository) {
        this.movieRepository = movieRepository;
        this.movieHallRepository = movieHallRepository;
        this.slotRepository = slotRepository;
        this.scheduleRepository = scheduleRepository;
        this.bookingRepository = bookingRepository;
    }


    public Booking findBookingByScheduleAndUser(Schedule schedule,User user){
        return bookingRepository.findBookingByScheduleAndUser(schedule,user);
    }



    public Schedule findScheduleByMovieMovieHallSlot(String movie, char movieHall, String slot){
        return scheduleRepository.findScheduleByMovie_TitleAndMovieHall_HallNameAndSlot_Name(movie,movieHall,slot);
    }

    public boolean bookingAlreadyExists(Schedule schedule, User user){
        if(bookingRepository.findBookingByScheduleAndUser(schedule,user) == null){
            return false;
        }
        return true;
    }


    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }


}
