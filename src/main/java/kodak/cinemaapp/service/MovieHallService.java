package kodak.cinemaapp.service;

import kodak.cinemaapp.DTO.MovieDTO;
import kodak.cinemaapp.DTO.MovieHallDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.MovieHall;
import kodak.cinemaapp.repo.MovieHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class MovieHallService {
    @Autowired
    MovieHallRepository movieHallRepository;


    public MovieHallDTO getMoviehallDto(int id){
        MovieHall movieHall = movieHallRepository.findById(id).orElseThrow();
        return new MovieHallDTO(movieHall);
    }


  public Set<Integer> populatateSeat(int number){
        Set<Integer> seatSet = new HashSet<>();
        for(int i= 0;i<=number;i++){
            seatSet.add(i);

        }
        return seatSet;
    }
    Set<Integer> bookedseat = new HashSet<>();

}
