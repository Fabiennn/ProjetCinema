package com.cinema.Repository;


import com.cinema.Domain.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE FilmEntity f SET f.budget= :budget ," +
            " f.codeCat = :codeCat ," +
            " f.dateSortie = :dateSortie ," +
            " f.description = :description ," +
            " f.titre = :titre ," +
            " f.duree = :duree ," +
            " f.image = :image ," +
            " f.noRea = :noRea ," +
            " f.note = :note ," +
            " f.recette = :recette " +
            " WHERE f.id = :id")

    public int  updateFilm(@Param("id") int id,
                           @Param("titre") String titre,
                           @Param("duree") int duree,
                           @Param("dateSortie") Date dateSortie,
                           @Param("budget") int budget,
                           @Param("recette") int recette,
                           @Param("noRea") int noRea,
                           @Param("codeCat") String codeCat,
                           @Param("image") String image,
                           @Param("note") float note,
                           @Param("description") String description);

    public FilmEntity findByTitreLike(String titre);

    public List<FilmEntity> findByCodeCat(String codeCat);

    public List<FilmEntity> findByNoRea(Integer noReal);

    public List<FilmEntity> findByNoteGreaterThanEqual(Float note);

    @Query("SELECT film FROM FilmEntity film WHERE film.note = :note")
    public List<FilmEntity> findByNoteEquals(float note);
}