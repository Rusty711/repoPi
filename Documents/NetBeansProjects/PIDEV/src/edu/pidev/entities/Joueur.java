/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.entities;

import java.sql.Date;


/**
 *
 * @author Rusty
 */
public class Joueur {
    int idJoueur;
    String nom;
    String Prenom;
    int numero;
    Date dateNaissance;
    String lieuNaissance;
    int taille;
    int poids;
    String nationalite;
    String poste1;
    int cout;
    int buts;
    int selections;
    Equipe idEquipe;
    int participations;
    String pied;
    String imageJoueur1;
    String imageJoueur2;
    String imageJoueur3;
    int butsMarque;
    String description;

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getPoste1() {
        return poste1;
    }

    public void setIdEquipe(Equipe idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Equipe getIdEquipe() {
        return idEquipe;
    }

    public void setPoste1(String poste1) {
        this.poste1 = poste1;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public int getButs() {
        return buts;
    }

    public void setButs(int buts) {
        this.buts = buts;
    }

    public int getSelections() {
        return selections;
    }

    public void setSelections(int selections) {
        this.selections = selections;
    }

  


    public int getParticipations() {
        return participations;
    }

    public void setParticipations(int participations) {
        this.participations = participations;
    }

    public String getPied() {
        return pied;
    }

    public void setPied(String pied) {
        this.pied = pied;
    }

    public String getImageJoueur1() {
        return imageJoueur1;
    }

    public void setImageJoueur1(String imageJoueur1) {
        this.imageJoueur1 = imageJoueur1;
    }

    public String getImageJoueur2() {
        return imageJoueur2;
    }

    public void setImageJoueur2(String imageJoueur2) {
        this.imageJoueur2 = imageJoueur2;
    }

    public String getImageJoueur3() {
        return imageJoueur3;
    }

    public void setImageJoueur3(String imageJoueur3) {
        this.imageJoueur3 = imageJoueur3;
    }

    public int getButsMarque() {
        return butsMarque;
    }

    public void setButsMarque(int butsMarque) {
        this.butsMarque = butsMarque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getEquipeNom()
    {
        return this.idEquipe.getNom();
    }

    @Override
    public String toString() {
        return "Joueur{" + "idJoueur=" + idJoueur + ", nom=" + nom + ", Prenom=" + Prenom + ", numero=" + numero + ", dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance + ", taille=" + taille + ", poids=" + poids + ", nationalite=" + nationalite + ", poste1=" + poste1 + ", cout=" + cout + ", buts=" + buts + ", selections=" + selections + ", idEquipe=" + idEquipe + ", participations=" + participations + ", pied=" + pied + ", imageJoueur1=" + imageJoueur1 + ", imageJoueur2=" + imageJoueur2 + ", imageJoueur3=" + imageJoueur3 + ", butsMarque=" + butsMarque + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Joueur other = (Joueur) obj;
        if (this.idJoueur != other.idJoueur) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
