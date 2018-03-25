/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import edu.pidev.entities.Equipe;
import edu.pidev.services.EquipeService;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class ModifierEquipeController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField capital;
    @FXML
    private TextField participations;
    @FXML
    private TextField continent;
    @FXML
    private TextField victoires;
    @FXML
    private TextField entraineur;
    @FXML
    private TextField classement;
    @FXML
    private TextField matchescm;
    @FXML
    private TextField butscm;
    @FXML
    private TextField wins;
    @FXML
    private TextField losses;
    @FXML
    private TextField draws;
    @FXML
    private Button drapeau;
    @FXML
    private Button photoequipe;
    @FXML
    private Button logo;
    @FXML
    private ChoiceBox<String> groupe;
    @FXML
    private TextField image1;
    @FXML
    private TextField image2;
    @FXML
    private TextField image3;
    @FXML
    private TextArea description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void modifierEquipe() throws SQLException
{
       Equipe e=new Equipe();

        
        EquipeService s=new EquipeService();
        e=s.rechercherparNom(e.getNom());
       e.setNom(nom.getText());
            e.setCapital(capital.getText());
            e.setParticipations(Integer.parseInt(participations.getText()));
           e.setContinent(continent.getText());
           e.setVictoires(Integer.parseInt(victoires.getText()));
           e.setEntraineur(entraineur.getText());
           e.setClassementFifa(Integer.parseInt(classement.getText()));
           e.setMatchesCM(Integer.parseInt(matchescm.getText()));
           e.setButsCM(Integer.parseInt(butscm.getText()));
           e.setMatchVictoires(Integer.parseInt(wins.getText()));
           e.setMatchDefaites(Integer.parseInt(losses.getText()));
           e.setMatchNulles(Integer.parseInt(draws.getText()));
           
           e.setDrapeau(image1.getText());
           e.setPhotoEquipe(image2.getText());
           e.setLogoFederation(image3.getText());
           e.setGroupe((String) groupe.getValue());
           e.setDescription(description.getText());
           s.modifierEquipe(e);
        
        
}
 @FXML
    public void image1Upload(ActionEvent event)
    {
         FileChooser fc=new FileChooser();
            File Selectedfile=fc.showOpenDialog(null);
            if (Selectedfile!=null)
            {
                image1.setText(Selectedfile.getName());
            }
            else
            {
                                image1.setText("pas d image");

            }
    }
    @FXML
      public void image2Upload(ActionEvent event)
    {
         FileChooser fc=new FileChooser();
            File Selectedfile=fc.showOpenDialog(null);
            if (Selectedfile!=null)
            {
                image2.setText(Selectedfile.getName());
            }
            else
            {
                                image2.setText("pas d image");

            }
    }
    @FXML
       public void image3Upload(ActionEvent event)
    {
         FileChooser fc=new FileChooser();
            File Selectedfile=fc.showOpenDialog(null);
            if (Selectedfile!=null)
            {
                image3.setText(Selectedfile.getName());
            }
            else
            {
                                image3.setText("pas d image");

            }
    }

    public String getNom() {
        return nom.getText();
    }

    public void setNom(String nom) {
        this.nom.setText(nom);
    }

    public TextField getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital.setText(capital);
    }

    public TextField getParticipations() {
        return participations;
    }

    public void setParticipations(String participations) {
        this.participations.setText(participations);
    }

    public TextField getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
          this.continent.setText(continent);
    }

    public TextField getVictoires() {
        return victoires;
    }

    public void setVictoires(String victoires) {
  this.victoires.setText(victoires);    }

    public TextField getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(String entraineur) {
         this.entraineur.setText(entraineur);
    }

    public TextField getClassement() {
        return classement;
    }

    public void setClassement(String classement) {
  this.classement.setText(classement);
    }

    public TextField getMatchescm() {
        return matchescm;
    }

    public void setMatchescm(String matchescm) {
          this.matchescm.setText(matchescm);
    }

    public TextField getButscm() {
        return butscm;
    }

    public void setButscm(String butscm) {
         this.butscm.setText(butscm);
    }

    public TextField getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins.setText(wins);
    }

    public TextField getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
         this.losses.setText(losses);
    }

    public TextField getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
          this.draws.setText(draws);
    }

    public Button getDrapeau() {
        return drapeau;
    }

    public void setDrapeau(String drapeau) {
  this.drapeau.setText(drapeau);    }

    public Button getPhotoequipe() {
        return photoequipe;
    }

    public void setPhotoequipe(String photoequipe) {
  this.photoequipe.setText(photoequipe);    }

    public Button getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
  this.logo.setText(logo);    }

    public ChoiceBox<?> getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
  this.groupe.setValue(groupe);
    }

    public TextField getImage1() {
        return image1;
    }

    public void setImage1(TextField image1) {
        this.image1 = image1;
    }

    public TextField getImage2() {
        return image2;
    }

    public void setImage2(TextField image2) {
        this.image2 = image2;
    }

    public TextField getImage3() {
        return image3;
    }

    public void setImage3(TextField image3) {
        this.image3 = image3;
    }

    public TextArea getDescription() {
        return description;
    }

    public void setDescription(String description) {
  this.description.setText(description);    }
       
}
