package com.cinema.Controller;


import com.cinema.Domain.CategorieEntity;
import com.cinema.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categorie")
public class CategorieController {


    @Autowired
    private CategorieService categorieService;


    @GetMapping("/getCategories")
    public List<CategorieEntity> getAllCategories() {
        return this.categorieService.getAllCategorie();
    }

    @GetMapping("/getUneCategorieById/{id}")
    public CategorieEntity getCategorieById(@PathVariable(value = "id") String id) {
        return this.categorieService.getById(id);
    }

    @GetMapping("/getUneCategorieByLibelle/{libelle}")
    public CategorieEntity getCategorieByLibelle(@PathVariable(value = "libelle") String libelle) {
        return this.categorieService.getByLibelle(libelle);
    }
}
