/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import com.jfoenix.controls.JFXButton;
import edu.pidev.entities.Equipe;
import edu.pidev.services.EquipeService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class EquipeController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Button edit;
    @FXML
    private Button Update;
    @FXML
    private Button Supprimer;
    @FXML
    private TableView<Equipe> EquipesTable;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> capital;
    @FXML
    private TableColumn<?, ?> participations;
    @FXML
    private TableColumn<?, ?> continent;
    @FXML
    private TableColumn<?, ?> victoires;
    @FXML
    private TableColumn<?, ?> entraineur;
    @FXML
    private TableColumn<?, ?> classement;
    @FXML
    private TableColumn<?, ?> matchescm;
    @FXML
    private TableColumn<?, ?> butscm;
    @FXML
    private TableColumn<?, ?> matchesg;
    @FXML
    private TableColumn<?, ?> matchesn;
    @FXML
    private TableColumn<?, ?> matchesd;
    @FXML
    private TableColumn<?, ?> description;
    ObservableList<Equipe> data;
    

    /**
     * Initializes the controller class.
     */
    public void SetCellTable()
    {
         nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
      capital.setCellValueFactory(new PropertyValueFactory<>("Capital"));
      participations.setCellValueFactory(new PropertyValueFactory<>("Participations"));
      continent.setCellValueFactory(new PropertyValueFactory<>("Continent"));
      victoires.setCellValueFactory(new PropertyValueFactory<>("Victoires"));
      entraineur.setCellValueFactory(new PropertyValueFactory<>("Entraineur"));
      classement.setCellValueFactory(new PropertyValueFactory<>("ClassementFifa"));
      matchescm.setCellValueFactory(new PropertyValueFactory<>("MatchesCM"));
      butscm.setCellValueFactory(new PropertyValueFactory<>("ButsCM"));
      matchesg.setCellValueFactory(new PropertyValueFactory<>("MatchVictoires"));
      matchesd.setCellValueFactory(new PropertyValueFactory<>("MatchDefaites"));
      matchesn.setCellValueFactory(new PropertyValueFactory<>("MatchNulles"));
      description.setCellValueFactory(new PropertyValueFactory<>("Description"));
    }
    public void initialize(URL url, ResourceBundle rb) {
        SetCellTable();
        List e=new ArrayList();
        Equipe s;
        try {     
            EquipeService eq=new EquipeService();
            e=eq.afficherEquipe();
         data=FXCollections.observableArrayList(e);
          
        } catch (SQLException ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        EquipesTable.setItems(data);

    }    
    @FXML
    public void AjouterEquipe() throws IOException
    {
           
                                 FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutEquipe.fxml"));
        Parent root=loader.load();
       AjoutEquipeController dpc=new  AjoutEquipeController();
       Scene scene=new Scene(root);
Stage Stages = new Stage();
Stages.setScene(scene);
Stages.show();
                scene.getStylesheets().add(AjoutEquipeController.class.getResource("bootstrap3.css").toExternalForm());



    }
    @FXML
    public void supprimerEquipe() throws SQLException
    {
      
        Equipe e=new Equipe();
        e=EquipesTable.getSelectionModel().getSelectedItem();
        EquipeService s=new EquipeService();
          Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Suppression d'equipe");
alert.setHeaderText("est ce que vous voulez vraiment supprimer l'equipe "+e.getNom());
Optional<ButtonType> result = alert.showAndWait();
if (result.get()==ButtonType.OK)
{
         s.supprimerEquipe(e.getNom());
         refreshTable();

}
else
{
    alert.close();
}

     
    }
    @FXML
    public void modifierEquipe() throws IOException
    {
                 
                       Equipe e=new Equipe();
                
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierEquipe.fxml"));
                             Parent root=loader.load();
          Scene scene=new Scene(root);
          Stage Stages = new Stage();

                        e=EquipesTable.getSelectionModel().getSelectedItem();
                            ModifierEquipeController ss=new ModifierEquipeController();
               
                       ss.setNom(e.getNom());
                       ss.setCapital(e.getCapital());
                       ss.setParticipations(Integer.toString(e.getParticipations()));
                       ss.setContinent(e.getContinent());
                       ss.setVictoires(Integer.toString(e.getVictoires()));
                       ss.setEntraineur(e.getEntraineur());
                       ss.setClassement(Integer.toString(e.getClassementFifa()));
                       ss.setMatchescm(Integer.toString(e.getMatchesCM()));
                       ss.setButscm(Integer.toString(e.getButsCM()));
                       ss.setWins(Integer.toString(e.getMatchVictoires()));
                       ss.setLosses(Integer.toString(e.getMatchDefaites()));
                       ss.setDraws(Integer.toString(e.getMatchNulles()));
                       ss.setDescription(e.getDescription());
                       
                 
Stages.setScene(scene);
Stages.show();            
 
    }
    public void refreshTable()
    {
        SetCellTable();
                List e=new ArrayList();
        Equipe s;
        try {     
            EquipeService eq=new EquipeService();
            e=eq.afficherEquipe();
         data=FXCollections.observableArrayList(e);
          
        } catch (SQLException ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        EquipesTable.setItems(data);
    }

    public TableView<Equipe> getEquipesTable() {
        return EquipesTable;
    }
    
    
}
