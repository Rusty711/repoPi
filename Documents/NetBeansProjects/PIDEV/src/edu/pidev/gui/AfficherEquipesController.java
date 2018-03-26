/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import edu.pidev.entities.Equipe;
import edu.pidev.services.EquipeService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class AfficherEquipesController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Pane joueur;
    @FXML
    private Pane div11;
    @FXML
    private Pane div111;
    @FXML
    private Pane div112;
    @FXML
    private Pane div113;
    @FXML
    private StackPane paneSponsorise;
    @FXML
    private ImageView closeBtn;
    @FXML
    private ImageView imgSponsorise;
    @FXML
    private ChoiceBox<String> Groupe;
    @FXML
    private ImageView eq1img;
    @FXML
    private Label nomeq1;
    @FXML
    private ImageView drapeq1;
    @FXML
    private ImageView eq4img;
    @FXML
    private Label nomeq4;
    @FXML
    private ImageView drapeq4;
    @FXML
    private ImageView eq2img;
    @FXML
    private Label nomeq2;
    @FXML
    private ImageView drapeq2;
    @FXML
    private ImageView eq3img;
    @FXML
    private Label nomeq3;
    @FXML
    private ImageView drapeq3;
    @FXML
    private Button but1;
 
  
  


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
      ObservableList l=(FXCollections.observableArrayList("A", "B", "C","D", "E", "F","G", "H"));
       Groupe.setItems(l);
       Groupe.setValue("A");
        try {
            ChangedValue("A");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficherEquipesController.class.getName()).log(Level.SEVERE, null, ex);
        }
  Groupe.valueProperty().addListener(new ChangeListener<String>() {
           

                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    try {
                        ChangedValue(newValue);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(AfficherEquipesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
        } 

        
          
    public void ChangedValue(String Groupe) throws FileNotFoundException
    {
    EquipeService eq=null;
        try {
          eq=new EquipeService();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEquipesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Equipe> list=new ArrayList();
        try {
            list=eq.EquipeParGroupe(Groupe);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEquipesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Image im1=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(0).getPhotoEquipe()));
            Image im2=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(0).getDrapeau()));
                    eq1img.setImage(im1);
                                    but1.setStyle("-fx-background-image: url(C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(0).getDrapeau()+")");

                    nomeq1.setText(list.get(0).getNom());
                    drapeq1.setImage(im2);
                          Image im3=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(1).getPhotoEquipe()));
            Image im4=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(1).getDrapeau()));
                    eq2img.setImage(im3);
                    nomeq2.setText(list.get(1).getNom());
                    drapeq2.setImage(im4);
                          Image im5=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(2).getPhotoEquipe()));
            Image im6=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(2).getDrapeau()));
                    eq3img.setImage(im5);
                    nomeq3.setText(list.get(2).getNom());
                    drapeq3.setImage(im6);
                          Image im7=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(3).getPhotoEquipe()));
            Image im8=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(3).getDrapeau()));
                    eq4img.setImage(im7);
                    nomeq4.setText(list.get(3).getNom());
                    drapeq4.setImage(im8);
    }
        catch (FileNotFoundException ex) {
            Logger.getLogger(AfficherEquipesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
