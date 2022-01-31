package com.cinema.Service;


import com.cinema.Domain.FilmEntity;
import com.cinema.Domain.PersonnageEntity;
import com.cinema.Repository.FilmRepository;
import com.cinema.Repository.PersonnageRepository;
import com.cinema.mesExceptions.MonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private PersonnageRepository personnageRepository;


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
        this.filmRepository.updateFilm(filmEntity.getId(), filmEntity.getTitre(),filmEntity.getDuree(),filmEntity.getDateSortie(),filmEntity.getBudget()
                ,filmEntity.getRecette(),filmEntity.getNoRea(),filmEntity.getCodeCat(),filmEntity.getImage(),filmEntity.getNote(),filmEntity.getDescription());
    }

    public void delete(int id) {
        FilmEntity filmEntity = this.getFilmById(id);
        this.filmRepository.delete(filmEntity);
    }

    public void ajouterFilm(FilmEntity filmEntity) {
        this.filmRepository.save(filmEntity);
    }

    public List<FilmEntity> getFilmsByActeur(int id) {
        List<FilmEntity> filmEntities = new ArrayList<>();
        List<PersonnageEntity> personnageEntities = this.personnageRepository.findByNoAct(id);
        for (PersonnageEntity personnageEntity : personnageEntities) {
            FilmEntity filmEntity = this.getFilmById(personnageEntity.getNoFilm());
            filmEntities.add(filmEntity);
        }
        return filmEntities;
    }


}