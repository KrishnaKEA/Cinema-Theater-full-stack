package kodak.cinemaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "kodak.cinemaapp")
public class CinemaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaAppApplication.class, args);
    }

}
