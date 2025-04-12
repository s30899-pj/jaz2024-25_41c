package pl.pjatk.MovieService.movieService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.movie.model.Movie;
import pl.pjatk.MovieService.movie.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class MovieServiceRestController {
    private final MovieService movieService;

    public MovieServiceRestController(MovieService movieService) {this.movieService = movieService;}

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        return movieService.findMovieById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }
}
