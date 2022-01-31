package com.cinema.Service;


import com.cinema.Domain.PersonnageEntity;
import com.cinema.Repository.PersonnageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnageService {

    @Autowired
    private PersonnageRepository personnageRepository;


    public List<PersonnageEntity> getAllPersonnages() {
        return this.personnageRepository.findAll();
    }

    public void update(PersonnageEntity personnageEntity) {
        this.personnageRepository.save(personnageEntity);
    }

    public List<PersonnageEntity> getPersonnageByFilm(int noFilm) {
        return this.personnageRepository.findByNoFilm(noFilm);
    }

    public List<PersonnageEntity> getPersonnageByActeur(int noRea) {
        return this.personnageRepository.findByNoAct(noRea);
    }

    public void delete(int idFilm, int idAct) {
        PersonnageEntity personnageEntity = this.personnageRepository.findByNoFilmAndNoAct(idFilm, idAct);
        this.personnageRepository.delete(personnageEntity);
    }
}
