package pl.pjatk.MovieService.movieService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieServiceAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleIllegalArgumentException (IllegalArgumentException movie){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occurred on request. Exception message: " + movie.getMessage());
    }
}
