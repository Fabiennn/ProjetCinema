package com.cinema.Repository;

import com.cinema.Domain.PersonnageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnageRepository extends JpaRepository<PersonnageEntity, Integer> {


    public List<PersonnageEntity> findByNoAct(int noAct);

    public List<PersonnageEntity> findByNoFilm(int noFilm);

}
