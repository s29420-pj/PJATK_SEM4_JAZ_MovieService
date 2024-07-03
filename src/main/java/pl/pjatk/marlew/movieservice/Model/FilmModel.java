package pl.pjatk.marlew.movieservice.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Schema(description = "FilmModel reprezentuje model filmu w serwisie")
@Table(name = "film_repository")
public class FilmModel {
    @Id
    @Schema(description = "Unikalny ID filmu", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "Tytuł filmu", example = "Batman")
    private String name;

    @Schema(description = "Kategoria filmu zdefiniowanwa w FilmModelCategories - HORROR, COMEDY, KIDS, ACTION", example = "ACTION")
    @Enumerated(EnumType.STRING)
    private FilmModelCategories category;

    @Schema(description = "Informacja, czy film jest dostępny do wypożyczenia", example = "true")
    private boolean isAvailable;

    public FilmModel() {

    }
}
