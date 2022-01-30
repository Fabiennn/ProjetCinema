package com.cinema.Service;


import com.cinema.Domain.RealisateurEntity;
import com.cinema.Repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {

    @Autowired
    private RealisateurRepository realisateurRepository;


    public List<RealisateurEntity> getRealisateur() {
        return this.realisateurRepository.findAll();
    }

    public RealisateurEntity getRealisateurByName(String nom) {
        return this.realisateurRepository.findByNom(nom);
    }

    public RealisateurEntity getRealisateurByPrenom(String prenom) {
        return this.realisateurRepository.findByPrenom(prenom);
    }

    public void update(RealisateurEntity realisateurEntity) {
        this.realisateurRepository.updateRea(realisateurEntity.getNoRea(),realisateurEntity.getNom(),realisateurEntity.getPrenom());
    }

    public RealisateurEntity getRealById(int id) {
        return this.realisateurRepository.findById(id);
    }

    public void delete(int id) {
        RealisateurEntity realisateurEntity = this.getRealById(id);
        this.realisateurRepository.delete(realisateurEntity);
    }
}
