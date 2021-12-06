package com.cinema.Service;


import com.cinema.Domain.ActeurEntity;
import com.cinema.Repository.ActeurRepository;
import com.cinema.mesExceptions.MonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActeurService {

    private ActeurRepository acteurRepository;

    @Autowired
    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public List<ActeurEntity> getAllActeur() {
        return this.acteurRepository.findAll();
    }

    public ActeurEntity getUnActeur(int id) {
        return this.acteurRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

    public ActeurEntity getUnActeurByPrenom(String prenom) {
        return this.acteurRepository.findByPrenom(prenom);
    }

    public ActeurEntity getUnActeurByNom(String nom) {
        return this.acteurRepository.findByNom(nom);
    }

    public void modifierActeur(ActeurEntity acteurEntity) {
        this.acteurRepository.updateClient(acteurEntity.getId(), acteurEntity.getPrenom(), acteurEntity.getNom(), acteurEntity.getNaissance(), acteurEntity.getDeces());
    }

    public void ajouterActeur(ActeurEntity acteurEntity) {
        try {
            this.acteurRepository.save(acteurEntity);
        } catch (Exception e) {
            new MonException("Insert", "Sql", e.getMessage());
        }
    }

    public void supprimerActeur(int id) {
        ActeurEntity acteurEntity = this.getUnActeur(id);
        this.acteurRepository.delete(acteurEntity);
    }
}
