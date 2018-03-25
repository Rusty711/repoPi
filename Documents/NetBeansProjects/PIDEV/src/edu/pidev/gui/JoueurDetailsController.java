/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class JoueurDetailsController implements Initializable {

    @FXML
    private ImageView image1;
    @FXML
    private Label pays;
    @FXML
    private Label date;
    @FXML
    private Label selections;
    @FXML
    private ImageView image2;
    @FXML
    private Label numero;
    @FXML
    private Label Nom;
    @FXML
    private Label poste1;
    @FXML
    private Label buts;
    @FXML
    private Label poids;
    @FXML
    private Label tailles;
    @FXML
    private Label lieu;
    @FXML
    private Label nationalite;
    @FXML
    private Label poste;
    @FXML
    private ImageView img3;
    @FXML
    private Label description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        description.setWrapText(true);
    }    

    public ImageView getImage1() {
        return image1;
    }

    public void setImage1(Image image1) {
        this.image1.setImage(image1);
    }

    public Label getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays.setText(pays);
    }

    public Label getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public Label getSelections() {
        return selections;
    }

    public void setSelections(String selections) {
        this.selections.setText(selections);
    }

    public ImageView getImage2() {
        return image2;
    }

    public void setImage2(Image image2) {
        this.image2.setImage(image2);
    }

    public Label getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero.setText(numero);
    }

    public Label getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom.setText(Nom);
    }

    public Label getPoste1() {
        return poste1;
    }

    public void setPoste1(String poste1) {
        this.poste1.setText(poste1);
    }

    public Label getButs() {
        return buts;
    }

    public void setButs(String buts) {
        this.buts.setText(buts);
    }

    public Label getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids.setText(poids);
    }

    public Label getTailles() {
        return tailles;
    }

    public void setTailles(String tailles) {
        this.tailles.setText(tailles);
    }

    public Label getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu.setText(lieu);
    }

    public Label getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite.setText(nationalite); 
    }

    public Label getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste.setText(poste);
    }

    public ImageView getImg3() {
        return img3;
    }

    public void setImg3(Image img3) {
        this.img3.setImage(img3);
    }

    public Label getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }
    
}
