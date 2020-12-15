package com.knowmebetter.business.dto;

public class PoliticDTO extends PersistableElementDTO {
    private String nom;
    private String prenom;
    private String twitteraccount;
    private String politicalparty;

    public PoliticDTO() {
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
