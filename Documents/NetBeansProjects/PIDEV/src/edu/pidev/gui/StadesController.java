/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import edu.pidev.entities.Equipe;
import edu.pidev.entities.Stade;
import edu.pidev.services.EquipeService;
import edu.pidev.services.StadeService;
import java.io.File;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class StadesController implements Initializable {

    @FXML
    private TableColumn<?, ?> nomcol;
    @FXML
    private TableColumn<?, ?> villecol;
    @FXML
    private TableColumn<?, ?> capacitecol;
    @FXML
    private TableColumn<?, ?> descriptioncol;
    @FXML
    private TableColumn<?, ?> wificol;
    @FXML
    private TableColumn<?, ?> toitcol;
    @FXML
    private TableColumn<?, ?> adressecol;
    @FXML
    private TableColumn<?, ?> surfacecol;
    @FXML
    private TextField nom;
    @FXML
    private ChoiceBox<String> ville;
    @FXML
    private TextField capacite;
    @FXML
    private TextField description;
    @FXML
    private ChoiceBox<String> wifi;
    @FXML
    private ChoiceBox<String> toit;
    @FXML
    private TextField adresse;
    @FXML
    private ChoiceBox<String> surface;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TableView<Stade> stades;
        ObservableList<Stade> data;
    @FXML
    private Button parcourir;
    @FXML
    private TextField photostade;
    @FXML
    private TextField id;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshTable();
      ObservableList l=(FXCollections.observableArrayList("Ekaterinburg"
        ,"Kaliningrad"
      ,"Kazan",
        "Moscow",
       "Nizhniy Novgorod"
       ,"Rostov on Don",
        "Saint Petersburg",
        "Samara",
       "Saransk",
        "Sochi",
        "Volgograd"));
      ville.setItems(l);
       ObservableList ll=(FXCollections.observableArrayList("oui","non"));       
      toit.setItems(ll);
      wifi.setItems(ll);
             ObservableList lll=(FXCollections.observableArrayList("Synthetique","Traditionnel","Placage"));       
surface.setItems(lll);

    } 
     public void SetCellTable()
    {
         nomcol.setCellValueFactory(new PropertyValueFactory<>("Nom"));
      villecol.setCellValueFactory(new PropertyValueFactory<>("Ville"));

      capacitecol.setCellValueFactory(new PropertyValueFactory<>("Capacite"));
      descriptioncol.setCellValueFactory(new PropertyValueFactory<>("Description"));
      toitcol.setCellValueFactory(new PropertyValueFactory<>("Toit"));
      wificol.setCellValueFactory(new PropertyValueFactory<>("Wifi"));
      adressecol.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
      surfacecol.setCellValueFactory(new PropertyValueFactory<>("Surface"));

    }
     public void refreshTable()
     {
          SetCellTable();
                List e=new ArrayList();
        Stade s;
        try {     
            StadeService eq=new StadeService();
            e=eq.afficherStade();
         data=FXCollections.observableArrayList(e);
          
        } catch (SQLException ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       stades.setItems(data);
     }
    @FXML
     public void ajouterStade() throws SQLException
     {
         Stade s=new Stade();
         s.setNom(nom.getText());
         s.setCapacite(Integer.parseInt(capacite.getText()));
         s.setVille(ville.getValue());
         s.setDescription(description.getText());
         s.setSurface(surface.getValue());
         s.setToit(toit.getValue());
         s.setWifi(wifi.getValue());
         s.setPhotoStade(photostade.getText());
         s.setAdresse(adresse.getText());
         StadeService ss=new StadeService();
         ss.ajouterStade(s);
         Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Ajout de Stade");
alert.setHeaderText("Le Stade"+nom.getText()+"est ajouté avec succes");

alert.showAndWait();
refreshTable();
clearInputs();
     }
    @FXML
           public void image3Upload(ActionEvent event)
    {
         FileChooser fc=new FileChooser();
            File Selectedfile=fc.showOpenDialog(null);
            if (Selectedfile!=null)
            {
                photostade.setText(Selectedfile.getName());
            }
            else
            {
                               photostade.setText("pas d image");

            }
    }
    @FXML
           public void SupprimerStade() throws SQLException
           {
               Stade s=new Stade();
               StadeService gg=new StadeService();
               s=stades.getSelectionModel().getSelectedItem();
                         Alert alert = new Alert(AlertType.CONFIRMATION);

               alert.setTitle("Suppression  de stade");
alert.setHeaderText("est ce que vous voulez vraiment supprimer le stade "+s.getNom());
Optional<ButtonType> result = alert.showAndWait();
if (result.get()==ButtonType.OK)
{
                   gg.supprimerStade(s.getNom());
               refreshTable();

}
else
{
    alert.close();
}
               
           }
           public void clearInputs()
           {
               nom.clear();
               adresse.clear();
               capacite.clear();
               description.clear();
               photostade.clear();
               
           }
    @FXML
           public void modifierStade() throws SQLException
           {
               StadeService d=new StadeService();
               Stade v=new Stade();
               v=stades.getSelectionModel().getSelectedItem();
               v=d.rechercherStadeParNom(v.getNom());
               nom.setText(v.getNom());
               adresse.setText(v.getAdresse());
               capacite.setText(Integer.toString(v.getCapacite()));
               toit.setValue(v.getToit());
               wifi.setValue(v.getWifi());
               photostade.setText(v.getPhotoStade());
               description.setText(v.getDescription());
               surface.setValue(v.getSurface());
               id.setText(Integer.toString(v.getIdStade()));
               
           }
    @FXML
           public void modifierStade2() throws SQLException
           {
                  Stade s=new Stade();
                  s.setIdStade(Integer.parseInt(id.getText()));
         s.setNom(nom.getText());
         s.setCapacite(Integer.parseInt(capacite.getText()));
         s.setVille(ville.getValue());
         s.setDescription(description.getText());
         s.setSurface(surface.getValue());
         s.setToit(toit.getValue());
         s.setWifi(wifi.getValue());
         s.setPhotoStade(photostade.getText());
         s.setAdresse(adresse.getText());
         StadeService ss=new StadeService();
         ss.modifierStade(s);
         Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Modification de Stade");
alert.setHeaderText("Le Stade"+nom.getText()+"est Modifié avec succes");

alert.showAndWait();
refreshTable();
clearInputs(); 
           }
           
    
}
