package com.cinema.Domain;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "acteur")
public class ActeurEntity {

    private Integer id;
    private String nom;
    private String prenom;
    private Date naissance;
    private Date deces;
    private String image;

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
    @Column(name = "Nom", nullable = false, length = 20)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "Prenom", nullable = true, length = 20)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenAct) {
        this.prenom = prenAct;
    }

    @Basic
    @Column(name = "Naissance", nullable = true)
    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date dateNaiss) {
        this.naissance = dateNaiss;
    }

    @Basic
    @Column(name = "Deces", nullable = true)
    public Date getDeces() {
        return deces;
    }

    public void setDeces(Date dateDeces) {
        this.deces = dateDeces;
    }

    @Basic
    @Column(name = "image", nullable = false, length = 100)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
