package pl.pjatk.marlew.movieservice.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pjatk.marlew.movieservice.Exceptions.FilmNotFoundException;
import pl.pjatk.marlew.movieservice.Model.FilmModel;
import pl.pjatk.marlew.movieservice.Repository.FilmRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

//    private final List<FilmModel> filmList = new ArrayList<>();

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
//        generateList();
    }

//    public void generateList() {
//        filmList.add(new FilmModel(1, "Batman", FilmModelCategories.KIDS));
//        filmList.add(new FilmModel(2, "Superman", FilmModelCategories.ACTION));
//        filmList.add(new FilmModel(3, "Spiderman", FilmModelCategories.ACTION));
//        filmList.add(new FilmModel(4, "Toy Story", FilmModelCategories.KIDS));
//        filmList.add(new FilmModel(5, "Finding Nemo", FilmModelCategories.KIDS));
//        filmList.add(new FilmModel(6, "The Conjuring", FilmModelCategories.HORROR));
//        filmList.add(new FilmModel(7, "Insidious", FilmModelCategories.HORROR));
//        filmList.add(new FilmModel(8, "The Hangover", FilmModelCategories.COMEDY));
//        filmList.add(new FilmModel(9, "Superbad", FilmModelCategories.COMEDY));
//        filmList.add(new FilmModel(10, "Avengers", FilmModelCategories.ACTION));
//    }

    public List<FilmModel> getAll() {
//        return filmList;
        return filmRepository.findAll();
    }

    public FilmModel newFilm(FilmModel newFilm) {
//        newFilm.setId(filmList.size());
//        filmList.add(newFilm);
//
//        return newFilm;
        return filmRepository.save(newFilm);
    }

    public FilmModel updateFilm(FilmModel updateFilm) {
//        filmList.set(updateFilm.getId(), updateFilm);
//        return updateFilm;
        if (filmRepository.existsById(Long.valueOf(updateFilm.getId()))) {
            return filmRepository.save(updateFilm);
        } else {
            throw new FilmNotFoundException("No Resource");
        }
    }

    public void deleteFilm(Long id) {
//        FilmModel filmModel = getById(id);
//        filmList.remove(filmModel);
        filmRepository.deleteById(id);
    }

    public FilmModel getById(Long id) {
        return filmRepository
                .findById(id)
                .orElseThrow(FilmNotFoundException::new);
//        return filmList
//                .stream()
//                .filter(film -> film.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new FilmNotFoundException("No Resource with " + id + " not found"));
    }

    public FilmModel setAvailableTrue(Long id) {
        FilmModel filmModel = getById(id);

        if (filmRepository.existsById(Long.valueOf(filmModel.getId()))) {
            filmModel.setAvailable(true);
            return filmRepository.save(filmModel);
        } else {
            throw new FilmNotFoundException("No Resource");
        }
    }

    public FilmModel setAvailableFalse(Long id) {
        FilmModel filmModel = getById(id);

        if (filmRepository.existsById(Long.valueOf(filmModel.getId()))) {
            filmModel.setAvailable(false);
            return filmRepository.save(filmModel);
        } else {
            throw new FilmNotFoundException("No Resource");
        }
    }
}
