/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import edu.pidev.entities.Equipe;
import edu.pidev.services.EquipeService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class AjoutEquipeController implements Initializable {

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
    private FileInputStream fl;
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
        ObservableList l=(FXCollections.observableArrayList("A", "B", "C","D", "E", "F","G", "H"));
        groupe.setItems(l);
    }  
    public void ajouterEquipe() throws SQLException
    {
        Equipe e=new Equipe();
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
           e.setPhotoEquipe(image3.getText());
           e.setLogoFederation(image2.getText());
           e.setGroupe((String) groupe.getValue());
           e.setDescription(description.getText());
           EquipeService s=new EquipeService();
          s.AjouterEquipe(e);
          EquipeController es=new EquipeController();
         es.refreshTable();

    }
    @FXML
    public void image1Upload(ActionEvent event) throws IOException
    {
         FileChooser fc=new FileChooser();
            File Selectedfile=fc.showOpenDialog(null);
            if (Selectedfile!=null)
            {
                  BufferedImage imgb3 = ImageIO.read(Selectedfile);
        File file3 = new File("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+nom.getText()+"Drapeau.jpg");
        ImageIO.write(imgb3, "jpg", file3);
                image1.setText(file3.getName());
            }
            else
            {
                                image1.setText("pas d image");

            }
    }
    @FXML
      public void image2Upload(ActionEvent event) throws IOException
    {
         FileChooser fc=new FileChooser();
            File Selectedfile=fc.showOpenDialog(null);
            if (Selectedfile!=null)
            {
                       BufferedImage imgb3 = ImageIO.read(Selectedfile);
        File file3 = new File("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+nom.getText()+"Logo.jpg");
        ImageIO.write(imgb3, "jpg", file3);
                image2.setText(file3.getName());
            }
            else
            {
                                image2.setText("pas d image");

            }
    }
    @FXML
       public void image3Upload(ActionEvent event) throws IOException
    {
         FileChooser fc=new FileChooser();
            File Selectedfile=fc.showOpenDialog(null);
            if (Selectedfile!=null)
            {
                  BufferedImage imgb3 = ImageIO.read(Selectedfile);
        File file3 = new File("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+nom.getText()+"Equipe.jpg");
        ImageIO.write(imgb3, "jpg", file3);
                image3.setText(file3.getName());
            }
            else
            {
                                image3.setText("pas d image");

            }
    }
     
}
