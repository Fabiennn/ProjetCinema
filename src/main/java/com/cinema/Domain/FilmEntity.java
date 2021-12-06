package com.cinema.Domain;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "film")
@DynamicUpdate
public class FilmEntity {

    private Integer id;
    private String titre;
    private Integer duree;
    private Date dateSortie;
    private Integer budget;
    private Integer recette;
    private Integer noRea;
    private String codeCat;
    private String image;
    private Float note;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Titre", nullable = false, length = 30)
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "Duree", nullable = false)
    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    @Basic
    @Column(name = "Datesortie", nullable = false)
    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Basic
    @Column(name = "Budget", nullable = false)
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "Recette", nullable = false)
    public Integer getRecette() {
        return recette;
    }

    public void setRecette(Integer recette) {
        this.recette = recette;
    }

    @Basic
    @Column(name = "Norea", nullable = false)
    public Integer getNoRea() {
        return noRea;
    }

    public void setNoRea(Integer noRea) {
        this.noRea = noRea;
    }

    @Basic
    @Column(name = "Catid", nullable = false, length = 2)
    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }

    @Basic
    @Column(name = "image", nullable = false, length = 100)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "note", nullable = false, precision = 0)
    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

}
