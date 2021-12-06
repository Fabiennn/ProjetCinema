package com.cinema.Domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "realisateur")
public class RealisateurEntity {
    private Integer noRea;
    private String nom;
    private String prenom;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    public Integer getNoRea() {
        return noRea;
    }

    public void setNoRea(Integer noRea) {
        this.noRea = noRea;
    }

    @Basic
    @Column(name = "Nom", nullable = false, length = 20)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "Prenom", nullable = false, length = 20)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenRea) {
        this.prenom = prenRea;
    }
}
