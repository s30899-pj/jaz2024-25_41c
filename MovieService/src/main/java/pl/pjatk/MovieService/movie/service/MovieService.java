package pl.pjatk.MovieService.movie.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.movie.model.Movie;
import pl.pjatk.MovieService.movie.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {this.movieRepository = movieRepository;}

    public Optional<Movie> findMovieById(int id) {return movieRepository.getMovieById(id);}

    public List<Movie> getMovies(){
        return movieRepository.getListMovies();
    }

    public Movie addMovie(Movie movie) {
        if(movie.getId() == null)   {
            movieRepository.saveMovie(movie);
            return movie;
        } else {
            throw new IllegalArgumentException("Movie id must be null");
        }
    }
}
