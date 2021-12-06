package com.cinema.Repository;


import com.cinema.Domain.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {


    public FilmEntity findByTitreLike(String titre);

    public List<FilmEntity> findByCodeCat(String codeCat);

    public List<FilmEntity> findByNoRea(Integer noReal);

    public List<FilmEntity> findByNoteGreaterThanEqual(Float note);

    @Query("SELECT film FROM FilmEntity film WHERE film.note = :note")
    public List<FilmEntity> findByNoteEquals(float note);


}
