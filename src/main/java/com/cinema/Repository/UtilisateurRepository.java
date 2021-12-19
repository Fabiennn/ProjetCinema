package com.cinema.Repository;

import com.cinema.Domain.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer> {

    @Query("select ut from UtilisateurEntity  ut where ut.surname = ?1")
    public UtilisateurEntity rechercheNom(String login);

    public List<UtilisateurEntity> findByRole(String role);

    public UtilisateurEntity findById(Long id);

    public UtilisateurEntity findBySurname(String surname);
}
