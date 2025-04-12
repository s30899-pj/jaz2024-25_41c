package pl.pjatk.MovieService.movie.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@NoArgsConstructor
@Getter
@Setter
public class Movie {
    private Integer id;
    private String title;
    private String category;
    private LocalDate releaseDate;
    private Integer duration;

    public Movie(String title, String category, LocalDate releaseDate, Integer duration) {
        this.id = new Random().nextInt(10000);
        this.title = title;
        this.category = category;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }
}
