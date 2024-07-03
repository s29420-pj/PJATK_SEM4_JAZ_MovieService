package pl.pjatk.marlew.movieservice.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.marlew.movieservice.Model.FilmModel;
import pl.pjatk.marlew.movieservice.Service.FilmService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @Operation(summary = "Wyświetla listę wszystkich filmów")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pomyślnie wygenerowano listę dostępnych filmów"),
            @ApiResponse(responseCode = "500", description = "Wewnętrzny błąd serwera", content = @Content)
    })
    @GetMapping("/movies")
    public ResponseEntity<List<FilmModel>> getMovieList() {
        return ResponseEntity
                .ok(filmService.getAll());
    }

    @Operation(summary = "Wyświetla film o konkretnym id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pomyślnie znaleziono film od zadanym id i wyświetlono obiekt w formacie json"),
            @ApiResponse(responseCode = "404", description = "Nie znaleziono filmu o podanym ID", content = @Content),
            @ApiResponse(responseCode = "500", description = "Wewnętrzny błąd serwera", content = @Content)
    })
    @GetMapping("/movies/{id}")
    public ResponseEntity<FilmModel> getById(@PathVariable("id") @Parameter(name = "id", description = "Film ID", example = "1") Long id) {
        return ResponseEntity.ok(filmService.getById(id));
    }

    @Operation(summary = "Tworzy nowy film o zdefiniowym ciele")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pomyślnie utworzono film"),
            @ApiResponse(responseCode = "400", description = "Bad Request, błędnie zdefiniowane ciało", content = @Content),
    })
    @PostMapping("/movies")
    public ResponseEntity<FilmModel> newFilm(@RequestBody FilmModel newFilm) {

        return ResponseEntity
                .ok(filmService.newFilm(newFilm));
    }

    @Operation(summary = "Edytuje istniejący film o zdefinowanym ciele")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pomyślnie zaktualizowano film"),
            @ApiResponse(responseCode = "400", description = "Niepoprawne ciało żądania", content = @Content),
            @ApiResponse(responseCode = "404", description = "Nie znaleziono filmu o podanym ID", content = @Content),
            @ApiResponse(responseCode = "500", description = "Wewnętrzny błąd serwera", content = @Content)
    })
    @PutMapping("/movies/{id}")
    public ResponseEntity<FilmModel> updateFilm(@RequestBody FilmModel updateFilm) {
        return ResponseEntity
                .ok(filmService.updateFilm(updateFilm));
    }

    @Operation(summary = "Usuwa film o podanym ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pomyślnie usunięto film"),
            @ApiResponse(responseCode = "404", description = "Nie znaleziono filmu o podanym ID", content = @Content),
            @ApiResponse(responseCode = "500", description = "Wewnętrzny błąd serwera", content = @Content)
    })
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Zmienia status filmu na dostępny")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pomyślnie zmieniono status filmu na dostępny"),
            @ApiResponse(responseCode = "404", description = "Nie znaleziono filmu o podanym ID", content = @Content),
            @ApiResponse(responseCode = "500", description = "Wewnętrzny błąd serwera", content = @Content)
    })
    @PutMapping("/movies/{id}/setAvailableTrue")
    public ResponseEntity<FilmModel> setAvailableTrue(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.setAvailableTrue(id));
    }

    @Operation(summary = "Zmienia status filmu na niedostępny")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pomyślnie zmieniono status filmu na niedostępny"),
            @ApiResponse(responseCode = "404", description = "Nie znaleziono filmu o podanym ID", content = @Content),
            @ApiResponse(responseCode = "500", description = "Wewnętrzny błąd serwera", content = @Content)
    })
    @PutMapping("/movies/{id}/setAvailableFalse")
    public ResponseEntity<FilmModel> setAvailableFalse(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.setAvailableFalse(id));
    }
}
