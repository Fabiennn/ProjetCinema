package com.cinema.Controller;


import com.cinema.Domain.ActeurEntity;
import com.cinema.Repository.ActeurRepository;
import com.cinema.Service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/acteur")
public class ActeurController {


    @Autowired
    private ActeurService acteurService;

    @GetMapping("/getActeurs")
    public List<ActeurEntity> getAllActeurs() {
        return this.acteurService.getAllActeur();
    }

    @GetMapping("/getUnActeurById/{id}")
    public ActeurEntity getUnActeur(@PathVariable(value = "id") int id) {
        return this.acteurService.getUnActeur(id);
    }

    @GetMapping("/getUnActeurByNom/{nom}")
    public ActeurEntity getUnActeurParNom(@PathVariable(value = "nom") String nom) {
        return this.acteurService.getUnActeurByNom(nom);
    }

    @GetMapping("/getUnActeurByPrenom/{prenom}")
    public ActeurEntity getUnActeurParPrenom(@PathVariable(value = "prenom") String prenom) {
        return this.acteurService.getUnActeurByPrenom(prenom);
    }

    @PostMapping("/modification")
    public void updateClient(@RequestBody ActeurEntity acteurEntity) {
        this.acteurService.modifierActeur(acteurEntity);
    }

    @GetMapping("/getActeurByFilm/{id}")
    public List<ActeurEntity> getActeurParFilm(@PathVariable int id) {
        return this.acteurService.getActeursParFilm(id);

    }

    @PostMapping("/ajout")
    @ResponseBody
    public void ajoutClient(@RequestBody ActeurEntity acteurEntity) {
        this.acteurService.ajouterActeur(acteurEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerClient(@PathVariable(value = "id") int id) {
        this.acteurService.supprimerActeur(id);
    }




}
