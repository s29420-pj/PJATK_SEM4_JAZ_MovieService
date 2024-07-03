package pl.pjatk.marlew.movieservice.Exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(String message) {
        super(message);
    }

    public FilmNotFoundException() {
        super("Movie Not Found");
    }
}
