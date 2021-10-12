package kodak.cinemaapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieHall {
    @Id
    private int id;
    private char hallName;
    private int seat;
    private String showSlot;

}
