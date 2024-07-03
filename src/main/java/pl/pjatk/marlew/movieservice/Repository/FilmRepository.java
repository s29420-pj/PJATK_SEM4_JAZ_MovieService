package pl.pjatk.marlew.movieservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.marlew.movieservice.Model.FilmModel;

public interface FilmRepository extends JpaRepository<FilmModel, Long> {

}
