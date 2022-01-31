package com.cinema.Controller;


import com.cinema.Domain.PersonnageEntity;
import com.cinema.Service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personnage")
public class PersonnageController {


    @Autowired
    private PersonnageService personnageService;

    @GetMapping("/getPersonnages")
    public List<PersonnageEntity> getAllPersonnages() {
        return this.personnageService.getAllPersonnages();
    }

    @PostMapping("/modification")
    public void modifier(@RequestBody PersonnageEntity personnageEntity) {
        this.personnageService.update(personnageEntity);
    }

    @PostMapping("/ajout")
    public void ajouter(@RequestBody PersonnageEntity personnageEntity) {
        this.personnageService.update(personnageEntity);
    }

    @GetMapping("/getPersonnagesByFilm/{id}")
    public List<PersonnageEntity> getPersonnagesByFilm(@PathVariable int id) {
        return this.personnageService.getPersonnageByFilm(id);
    }

    @GetMapping("/getPersonnagesByAct/{id}")
    public List<PersonnageEntity> getPersonnagesByActeur(@PathVariable int id) {
        return this.personnageService.getPersonnageByActeur(id);
    }

    @DeleteMapping("/delete/{idFilm}/{idAct}")
    public void delete(@PathVariable int idFilm, @PathVariable int idAct) {
        this.personnageService.delete(idFilm, idAct);
    }
}
