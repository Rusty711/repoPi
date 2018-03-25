/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.entities;

/**
 *
 * @author Rusty
 */
public class Equipe {
    int idEquipe;
    String nom;
    String capital;
    int participations;
    String continent;
    int victoires;
    String entraineur;
    int classementFifa;
    int matchesCM;
    int ButsCM;
    int matchVictoires;
    int matchDefaites;
    int matchNulles;
    String drapeau;
    String photoEquipe;
    String logoFederation;
    String groupe;
    int nbr_points;
    int nbr_buts;
    String description;
    int mGagnées;
    int mNul;
    int mPerdues;

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getParticipations() {
        return participations;
    }

    public void setParticipations(int participations) {
        this.participations = participations;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getVictoires() {
        return victoires;
    }

    public void setVictoires(int victoires) {
        this.victoires = victoires;
    }

    public String getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(String entraineur) {
        this.entraineur = entraineur;
    }

    public int getClassementFifa() {
        return classementFifa;
    }

    public void setClassementFifa(int classementFifa) {
        this.classementFifa = classementFifa;
    }

    public int getMatchesCM() {
        return matchesCM;
    }

    public void setMatchesCM(int matchesCM) {
        this.matchesCM = matchesCM;
    }

    public int getButsCM() {
        return ButsCM;
    }

    public void setButsCM(int ButsCM) {
        this.ButsCM = ButsCM;
    }

    public int getMatchVictoires() {
        return matchVictoires;
    }

    public void setMatchVictoires(int matchVictoires) {
        this.matchVictoires = matchVictoires;
    }

    public int getMatchDefaites() {
        return matchDefaites;
    }

    public void setMatchDefaites(int matchDefaites) {
        this.matchDefaites = matchDefaites;
    }

    public int getMatchNulles() {
        return matchNulles;
    }

    public void setMatchNulles(int matchNulles) {
        this.matchNulles = matchNulles;
    }

    public String getDrapeau() {
        return drapeau;
    }

    public void setDrapeau(String drapeau) {
        this.drapeau = drapeau;
    }

    public String getPhotoEquipe() {
        return photoEquipe;
    }

    public void setPhotoEquipe(String photoEquipe) {
        this.photoEquipe = photoEquipe;
    }

    public String getLogoFederation() {
        return logoFederation;
    }

    public void setLogoFederation(String logoFederation) {
        this.logoFederation = logoFederation;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public int getNbr_points() {
        return nbr_points;
    }

    public void setNbr_points(int nbr_points) {
        this.nbr_points = nbr_points;
    }

    public int getNbr_buts() {
        return nbr_buts;
    }

    public void setNbr_buts(int nbr_buts) {
        this.nbr_buts = nbr_buts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getmGagnées() {
        return mGagnées;
    }

    public void setmGagnées(int mGagnées) {
        this.mGagnées = mGagnées;
    }

    public int getmNul() {
        return mNul;
    }

    public void setmNul(int mNul) {
        this.mNul = mNul;
    }

    public int getmPerdues() {
        return mPerdues;
    }

    public void setmPerdues(int mPerdues) {
        this.mPerdues = mPerdues;
    }

    @Override
    public String toString() {
        return "Equipe{" + "idEquipe=" + idEquipe + ", nom=" + nom + ", capital=" + capital + ", participations=" + participations + ", continent=" + continent + ", victoires=" + victoires + ", entraineur=" + entraineur + ", classementFifa=" + classementFifa + ", matchesCM=" + matchesCM + ", ButsCM=" + ButsCM + ", matchVictoires=" + matchVictoires + ", matchDefaites=" + matchDefaites + ", matchNulles=" + matchNulles + ", drapeau=" + drapeau + ", photoEquipe=" + photoEquipe + ", logoFederation=" + logoFederation + ", groupe=" + groupe + ", nbr_points=" + nbr_points + ", nbr_buts=" + nbr_buts + ", description=" + description + ", mGagn\u00e9es=" + mGagnées + ", mNul=" + mNul + ", mPerdues=" + mPerdues + '}';
    }
    
    
    
}
