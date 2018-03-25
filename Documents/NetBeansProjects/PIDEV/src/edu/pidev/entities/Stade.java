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
public class Stade {
    int idStade;
    String nom;
    String ville;
    int capacite;
    String photoStade;
    String description;
    String wifi;
    String toit;
    String adresse;
    String surface;

    public int getIdStade() {
        return idStade;
    }

    public void setIdStade(int idStade) {
        this.idStade = idStade;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getPhotoStade() {
        return photoStade;
    }

    public void setPhotoStade(String photoStade) {
        this.photoStade = photoStade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getToit() {
        return toit;
    }

    public void setToit(String toit) {
        this.toit = toit;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "Stade{" + "idStade=" + idStade + ", nom=" + nom + ", ville=" + ville + ", capacite=" + capacite + ", photoStade=" + photoStade + ", description=" + description + ", wifi=" + wifi + ", toit=" + toit + ", adresse=" + adresse + ", surface=" + surface + '}';
    }
    
    
}
