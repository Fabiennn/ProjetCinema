package com.cinema.Repository;


import com.cinema.Domain.ActeurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface ActeurRepository extends JpaRepository<ActeurEntity, Integer> {


    @Modifying
    @Transactional
    @Query("UPDATE ActeurEntity a SET a.deces= :deces ," +
            " a.prenom = :prenom ," +
            " a.nom = :nom ," +
            " a.naissance = :naissance" +
            " WHERE a.id = :id")

    public int  updateClient(@Param("id") int id,
                             @Param("prenom") String prenom,
                             @Param("nom") String nom,
                             @Param("naissance") Date naissance,
                             @Param("deces") Date deces);


    public ActeurEntity findByNom(String nom);
    public ActeurEntity findByPrenom(String prenom);
}
