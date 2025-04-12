package pl.pjatk.patsza3.sandbox.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SandboxAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception ocurred on request. Exception message: " + exception.getLocalizedMessage());
    }
}
