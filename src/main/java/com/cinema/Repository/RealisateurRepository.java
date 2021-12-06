package com.cinema.Repository;


import com.cinema.Domain.RealisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends JpaRepository<RealisateurEntity, Integer> {

    public RealisateurEntity findByPrenom(String prenom);
    public RealisateurEntity findByNom(String nom);
}
