package pl.pjatk.RentalService.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Movie {
    private Integer id;
    private String title;
    private String category;
    private LocalDate releaseDate;
    private Integer duration;
    private boolean available = false;

}