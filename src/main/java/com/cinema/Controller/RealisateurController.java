package com.cinema.Controller;


import com.cinema.Domain.RealisateurEntity;
import com.cinema.Service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/realisateur")
public class RealisateurController {

    @Autowired
    private RealisateurService realisateurService;


    @GetMapping("/getRealisateurs")
    public List<RealisateurEntity> getRealisateurs() {
        return this.realisateurService.getRealisateur();
    }

    @PostMapping("/modification")
    public void modifier(@RequestBody RealisateurEntity realisateurEntity) {
        this.realisateurService.update(realisateurEntity);
    }

    @PostMapping("/ajout")
    public void ajouter(@RequestBody RealisateurEntity realisateurEntity) {
        this.realisateurService.update(realisateurEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        this.realisateurService.delete(id);
    }

    @GetMapping("/getRealById/{id}")
    public RealisateurEntity getRealById(@PathVariable int id) {
        return this.realisateurService.getRealById(id);
    }

    @GetMapping("/getRealByName/{nom}")
    public RealisateurEntity getRealByName(@PathVariable String nom) {
        return this.realisateurService.getRealisateurByName(nom);
    }

    @GetMapping("/getRealByPrenom/{prenom}")
    public RealisateurEntity getRealByPrenom(@PathVariable String prenom) {
        return this.realisateurService.getRealisateurByPrenom(prenom);
    }

}
