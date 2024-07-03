package pl.pjatk.marlew.movieservice.ExceptionHandler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.pjatk.marlew.movieservice.Exceptions.FilmNotFoundException;

@RestControllerAdvice
public class FilmControllerException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleFilmNotFoundException(FilmNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatusCode.valueOf(404))
                .body("Exception occured on request. Exception message: " + ex.getLocalizedMessage());
    }
}
