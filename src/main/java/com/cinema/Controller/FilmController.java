package com.cinema.Controller;


import com.cinema.Domain.FilmEntity;
import com.cinema.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/getFilms")
    public List<FilmEntity> getAllFilms() {
        return this.filmService.getFilms();
    }

    @GetMapping("/getUnFilmById/{id}")
    public FilmEntity getFilmById(@PathVariable int id) {
        return this.filmService.getFilmById(id);
    }

    @GetMapping("/getFilmsByIdRealisateur/{id}")
    public List<FilmEntity> getFilmsByIdRealisateur(@PathVariable int id) {
        return this.filmService.getFilmsByIdRealisateur(id);
    }

    @GetMapping("/getFilmByCategorie/{id}")
    public List<FilmEntity> getFilmsByIdCat(@PathVariable String id) {
        return this.filmService.getFilmsByCategorie(id);
    }

    @GetMapping("/getFilmByNote/{note}")
    public List<FilmEntity> getFilmByNoteEqual(@PathVariable float note) {
        return this.filmService.getFilmByNoteEqual(note);
    }

    @GetMapping("/getFilmByNoteGreater/{note}")
    public List<FilmEntity> getFilmByNoteGreaterOrEqual(@PathVariable float note) {
        return this.filmService.getFilmByNoteGreaterOrEqual(note);
    }

    @GetMapping("/getFilmByName/{titre}")
    public FilmEntity getFilmByTitre(@PathVariable String titre) {
        return this.filmService.getFilmByName(titre);
    }

    @PostMapping("/modification")
    public void updateFilm(@RequestBody FilmEntity filmEntity) {
        this.filmService.update(filmEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        this.filmService.delete(id);
    }

    @PostMapping("/ajout")
    @ResponseBody
    public void ajouterFilm(@RequestBody FilmEntity filmEntity) {
        this.filmService.ajouterFilm(filmEntity);
    }

}

