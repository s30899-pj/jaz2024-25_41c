package pl.pjatk.MovieService.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.MovieService.movie.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

//    @Override
//    Optional<Movie> findById(Integer integer);
//
//    @Override
//    List<Movie> findAll();
//
//    @Override
//    <S extends Movie> S save(S entity);
//
//    @Override
//    void delete(Movie entity);
}
