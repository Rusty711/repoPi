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
public class AfficherEquipeController implements Initializable {

    @FXML
    private ImageView photoequipe;
    @FXML
    private ImageView logo;
    @FXML
    private Label fondation;
    @FXML
    private Label victoires;
    @FXML
    private Label continent;
    @FXML
    private Label capital;
    @FXML
    private Label entraineur;
    @FXML
    private ImageView photodesc;
    @FXML
    private Label description;
    @FXML
    private Label nom1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        description.setWrapText(true);
    }    

    public ImageView getPhotoequipe() {
        return photoequipe;
    }

    public void setPhotoequipe(Image photoequipe) {
        this.photoequipe.setImage(photoequipe);
    }

    public ImageView getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo.setImage(logo);
    }

    public Label getFondation() {
        return fondation;
    }

    public void setFondation(String fondation) {
        this.fondation.setText(fondation);
    }

    public Label getVictoires() {
        return victoires;
    }

    public void setVictoires(String victoires) {
        this.victoires.setText(victoires);
    }

    public Label getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent.setText(continent);
    }

    public Label getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital.setText(capital);
    }

    public Label getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(String entraineur) {
        this.entraineur.setText(entraineur);
    }

    public ImageView getPhotodesc() {
        return photodesc;
    }

    public void setPhotodesc(Image photodesc) {
        this.photodesc.setImage(photodesc);
    }

    public Label getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public Label getNoml() {
        return this.nom1;
    }

    public void setNoml(String nom) {
       this.nom1.setText(nom);
    }
    
}
