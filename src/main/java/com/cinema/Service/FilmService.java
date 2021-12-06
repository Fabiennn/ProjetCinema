package com.cinema.Service;


import com.cinema.Domain.FilmEntity;
import com.cinema.Repository.FilmRepository;
import com.cinema.mesExceptions.MonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;


    public List<FilmEntity> getFilms() {
        return this.filmRepository.findAll();
    }

    public FilmEntity getFilmById(int id) {
        return this.filmRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

    public List<FilmEntity> getFilmsByIdRealisateur(int id) {
        return this.filmRepository.findByNoRea(id);
    }

    public List<FilmEntity> getFilmsByCategorie(String codeCat) {
        return this.filmRepository.findByCodeCat(codeCat);
    }

    public List<FilmEntity> getFilmByNoteEqual(float note) {
        return this.filmRepository.findByNoteEquals(note);
    }

    public List<FilmEntity> getFilmByNoteGreaterOrEqual(float note) {
        return this.filmRepository.findByNoteGreaterThanEqual(note);
    }

    public FilmEntity getFilmByName(String titre) {
        return this.filmRepository.findByTitreLike(titre);
    }

    public void update(FilmEntity filmEntity) {
        this.filmRepository.save(filmEntity);
    }

    public void delete(int id) {
        FilmEntity filmEntity = this.getFilmById(id);
        this.filmRepository.delete(filmEntity);
    }

    public void ajouterFilm(FilmEntity filmEntity) {
        this.filmRepository.save(filmEntity);
    }


}
