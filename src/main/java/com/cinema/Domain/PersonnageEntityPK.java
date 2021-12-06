package com.cinema.Domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PersonnageEntityPK implements Serializable {
    private Integer noFilm;
    private Integer noAct;

    @Column(name = "Idfilm", nullable = false)
    @Id
    public Integer getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(Integer noFilm) {
        this.noFilm = noFilm;
    }

    @Column(name = "Idact", nullable = false)
    @Id
    public Integer getNoAct() {
        return noAct;
    }

    public void setNoAct(Integer noAct) {
        this.noAct = noAct;
    }
}