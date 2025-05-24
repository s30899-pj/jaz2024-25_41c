package pl.pjatk.MovieService.movie.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.movie.model.Movie;
import pl.pjatk.MovieService.movie.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Optional<Movie> findMovieById(int id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public boolean changeMovieStatus(int id, boolean status) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            Movie m = movie.get();
            if (status) {
                m.setAvailable(true);
            } else {
                m.setAvailable(false);
            }
            movieRepository.save(m);
            return m.isAvailable();
        } else {
            return false;
        }
    }

    public Movie addMovie(Movie movie) {
        if (movie.getId() == null) {
            movieRepository.save(movie);
            return movie;
        } else {
            throw new IllegalArgumentException("Movie id must be null");
        }
    }

    public Optional<Movie> updateMovie(int id, Movie movie) {
        Optional<Movie> existingMovie = findMovieById(id);
        if (existingMovie.isPresent()) {
            Movie updateMovie = existingMovie.get();
            updateMovie.setTitle(movie.getTitle());
            updateMovie.setCategory(movie.getCategory());
            updateMovie.setReleaseDate(movie.getReleaseDate());
            updateMovie.setDuration(movie.getDuration());
            movieRepository.save(updateMovie);
            return Optional.of(updateMovie);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteMovie(int id) {
        Optional<Movie> movieToDelete = findMovieById(id);
        movieToDelete.ifPresent(movieRepository::delete);
        return movieToDelete.isPresent();
    }

}