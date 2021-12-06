package com.cinema.Domain;


import javax.persistence.*;

@Entity
@Table(name = "personnage")
@IdClass(PersonnageEntityPK.class)
public class PersonnageEntity {
    private Integer noFilm;
    private Integer noAct;
    private String nomPers;

    @Id
    @Column(name = "Idfilm", nullable = false)
    public Integer getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(Integer noFilm) {
        this.noFilm = noFilm;
    }

    @Id
    @Column(name = "Idact", nullable = false)
    public Integer getNoAct() {
        return noAct;
    }

    public void setNoAct(Integer noAct) {
        this.noAct = noAct;
    }

    @Basic
    @Column(name = "Personnagenom", nullable = false, length = 30)
    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

}
