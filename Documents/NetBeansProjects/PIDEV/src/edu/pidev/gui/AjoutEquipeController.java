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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private ChoiceBox<String> capital;
    @FXML
    private TextField participations;
    @FXML
    private ChoiceBox<String> continent;
    @FXML
    private TextField victoires;
    @FXML
    private TextField entraineur;
    @FXML
    private TextField classement;
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
    @FXML
    private Label id;
    @FXML
    private ImageView Drapeauimg;
    @FXML
    private ImageView photoimg;
    @FXML
    private ImageView Logoimg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 ObservableList lll=(FXCollections.observableArrayList("Abou Dhabi","Abuja","Accra","Achgabat","Addis","Abeba","Alger","Amman","Amsterdam","Andorre-la-Vieille","Ankara","Antananarivo","Apia","Asmara","Astana","Asunción","Athènes","Bagdad","Bakou","Bamako","Bangkok","Bangui","Banjul","Belgrade","Belmopa",
"Berlin","Berne","Beyrouth","Bichkek","Bissau","Bogota","Brasilia","Bratislava","Bridgetown","Bruxelles","Bucarest","Budapest","Buenos Aires","Bujumbura","Canberra","Caracas","Chisinau","Colombo","Conakry","Copenhague","Daccan","Dakar","DamasDar es Salam","Delhi","Djibouti","Doha","Douchanbé","Dublin","Erevan","Freetown","Funafuti","Gaborone","Georgetown","Guatemala","Hanoï",
"Harare","Helsinki","Islamabad","Jakarta","Jérusalem","Kaboul","Kampala","Katmandou","Khartoum","Kiev","Kigali","Kingston","Kinshasa","Koweït","Kuala Lumpur","La Havane","La Paz","La Valette","Le Caire","Libreville","Lilongwe","Lima","Lisbonne","Ljubljana","Lomé","Londres","Lusaka","Luxembourg","Madrid","Malabo","Malé","Managua","Manama","Manille","Maputo","Mascate","Mbabane","Mexico","Minsk","Mogadiscio","Monaco","Monrovia","Montevideo","Moroni","Moscou","Nairobi","Nassau","Ndjamena","Niamey","Nicosie","Nouakchott","Nuku'alofa","Oslo","Ottawa","Ouagadougou","Oulan-Bator","Panama","Paramaribo","Paris","Pékin","Phnom Penh","Podgorica","Port"," MoresbyPort of Spain","Port-au-Prince","Port-Vila","Porto-Novo","PraguePretoria","Pyongyang","Quito","Rabat","Rangoun","Reykjavik","Riga","Riyad","Rome","Saint-Domingue","San José","San Salvador","Sanaa","Santiago","Sao Tomé","Sarajevo","Séoul","Singapour","Skopje","Sofia","Stockholm","Suva","Tachkent","Tallinn","Tbilissi","Tegucigalpa","Téhéran","Tirana","Tokyo","Tripoli","Tunis","Vaduz","Varsovie","Vatican","Victoria","Vienne","Vientiane","Vilnius","Washington","Wellington","Windhoek","Yamoussoukro","Yaoundé","Zagreb"));
        capital.setItems(lll);
                 ObservableList l=(FXCollections.observableArrayList("A", "B", "C","D", "E", "F","G", "H"));
       groupe.setItems(l);
                ObservableList ll=(FXCollections.observableArrayList("Afrique", "Asie", "Amerique Du Sud","Amerique Du Nord", "Europe", "Oceania"));
continent.setItems(ll);
    }  
    @FXML
    public void ajouterEquipe() throws SQLException
    {
        Equipe e=new Equipe();
        EquipeService es=new EquipeService();
         e.setNom(nom.getText());
            e.setCapital(capital.getValue());
            e.setParticipations(Integer.parseInt(participations.getText()));
           e.setContinent(continent.getValue());
           e.setVictoires(Integer.parseInt(victoires.getText()));
           e.setEntraineur(entraineur.getText());
           e.setClassementFifa(Integer.parseInt(classement.getText()));
           e.setMatchesCM(Integer.parseInt(wins.getText())+Integer.parseInt(losses.getText())+Integer.parseInt(draws.getText()));
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
           if (e.getParticipations()<22)
           {
               if (!es.EntraineurExiste(e.getEntraineur()))
               {
                   if (!es.NomExiste(e.getNom()))
                   {
                       if (!es.classementExiste(e.getClassementFifa()))
                       {
                   
               
                  s.AjouterEquipe(e); 
               }
                       else
                       {
                           Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("ATTENTION!!!");
alert.setHeaderText("Erreur Classement");
alert.setContentText("Classement deja existant!");

alert.showAndWait();
                       }
                   
                         
                   }
                     else
                       {
                           Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("ATTENTION!!!");
alert.setHeaderText("Erreur Nom");
alert.setContentText("Nom deja existant!");

alert.showAndWait();
                       }
                   
            
           }
                else
                       {
                           Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("ATTENTION!!!");
alert.setHeaderText("Erreur Entraineur");
alert.setContentText("Entraineur deja Existant!");

alert.showAndWait();
                       }
               
           }
               else
                       {
                           Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("ATTENTION!!!");
alert.setHeaderText("Erreur Participation");
alert.setContentText("Participation doit étre inferieur a 22");

alert.showAndWait();
                       }
      
         

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
        Drapeauimg.setImage(new Image(new FileInputStream(Selectedfile.getAbsolutePath())));
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
        File file3 = new File("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+nom.getText()+"Equipe.jpg");
        ImageIO.write(imgb3, "jpg", file3);
                photoimg.setImage(new Image(new FileInputStream(Selectedfile.getAbsolutePath())));

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
        File file3 = new File("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+nom.getText()+"Logo.jpg");
        ImageIO.write(imgb3, "jpg", file3);
                        Logoimg.setImage(new Image(new FileInputStream(Selectedfile.getAbsolutePath())));

                image3.setText(file3.getName());
            }
            else
            {
                                image3.setText("pas d image");

            }
    }

   

   
 
     
}
