package pl.pjatk.MovieService.movie.repository;

import org.springframework.stereotype.Repository;
import pl.pjatk.MovieService.movie.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class MovieRepository {
    private final List<Movie> movies;

    public MovieRepository() {
        this.movies = buildMoviesList();
    }

    public List<Movie> buildMoviesList() {
        Movie movie1 = new Movie("Scream", "horror", LocalDate.of(1996, 12, 18), 111);
        Movie movie2 = new Movie("Transformers", "science fiction", LocalDate.of(2007, 6, 12), 144);
        Movie movie3 = new Movie("Back to the Future", " science fiction", LocalDate.of(1985, 7, 3), 116);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        return movies;
    }

    public Optional<Movie> getMovieById(int id) {
        return movies.stream().filter(f -> f.getId() == id).findFirst();
    }

    public List<Movie> getListMovies() {
        return movies;
    }

    public void save(Movie movie) {
        if (movie.getId() == null) {
            movie.setId(new Random().nextInt(10000));
            movies.add(movie);
        } else {
            movies.removeIf(f -> f.getId() == movie.getId());
            movies.add(movie);
        }
    }

    public void delete(Movie movie) {
        movies.remove(movie);
    }
}
