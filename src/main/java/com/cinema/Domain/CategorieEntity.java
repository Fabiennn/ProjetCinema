package com.cinema.Domain;


import javax.persistence.*;

@Entity
@Table(name = "categorie")
public class CategorieEntity {

    private String id;
    private String libelle;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, length = 2)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Libelle", nullable = false, length = 20)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
