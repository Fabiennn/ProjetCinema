package com.cinema.Repository;


import com.cinema.Domain.RealisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface RealisateurRepository extends JpaRepository<RealisateurEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE RealisateurEntity r SET r.nom = :nom ," +
            " r.prenom = :prenom " +
            " WHERE r.noRea = :noRea")

    public int  updateRea(@Param("noRea") int noRea,
                          @Param("nom") String nom,
                          @Param("prenom") String prenom);

    public RealisateurEntity findByPrenom(String prenom);
    public RealisateurEntity findByNom(String nom);

    RealisateurEntity findById(int id);
}