package com.cinema.Repository;


import com.cinema.Domain.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieEntity, Integer> {


    public CategorieEntity findByLibelle(String libelle);
    public CategorieEntity findById(String id);
}
