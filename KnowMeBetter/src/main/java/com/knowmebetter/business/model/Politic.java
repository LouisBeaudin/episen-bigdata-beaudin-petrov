package com.knowmebetter.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="politic")
public class Politic extends PersistableElement {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "twitteraccount")
    private String twitteraccount;

    @Column(name = "politicalparty")
    private String politicalparty;

    public Politic() {
    }

    public Politic(String nom, String prenom, String twitteraccount, String politicalparty) {
        this.nom = nom;
        this.prenom = prenom;
        this.twitteraccount = twitteraccount;
        this.politicalparty = politicalparty;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTwitteraccount() {
        return twitteraccount;
    }

    public void setTwitteraccount(String twitteraccount) {
        this.twitteraccount = twitteraccount;
    }

    public String getPoliticalparty() {
        return politicalparty;
    }

    public void setPoliticalparty(String politicalparty) {
        this.politicalparty = politicalparty;
    }
}
