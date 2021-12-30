package com.cinema.Service;


import com.cinema.Domain.CategorieEntity;
import com.cinema.Domain.FilmEntity;
import com.cinema.Repository.ActeurRepository;
import com.cinema.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    private CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<CategorieEntity> getAllCategorie() { return this.categorieRepository.findAll();}


    public CategorieEntity getById(String id) {
        return this.categorieRepository.findById(id);
    }

    public CategorieEntity getByLibelle(String libelle) {
        return this.categorieRepository.findByLibelle(libelle);
    }


    public void ajouterCategorie(CategorieEntity categorieEntity) {
        this.categorieRepository.save(categorieEntity);
    }

}
