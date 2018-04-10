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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class ModifierEquipeController implements Initializable {

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
    public void modifierEquipe() throws SQLException
{
       Equipe e=new Equipe();

        
        EquipeService s=new EquipeService();
        e=s.rechercherparId(Integer.parseInt(id.getText()));
        e.setIdEquipe(Integer.parseInt(id.getText()));
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
           e.setPhotoEquipe(image2.getText());
           e.setLogoFederation(image3.getText());
           e.setGroupe((String) groupe.getValue());
           e.setDescription(description.getText());
           if (e.getParticipations()<23)
           {
           s.modifierEquipe(e);
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

                image1.setText(Selectedfile.getName());
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
        File file3 = new File("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+nom.getText()+"Logo.jpg");
        ImageIO.write(imgb3, "jpg", file3);
                Logoimg.setImage(new Image(new FileInputStream(Selectedfile.getAbsolutePath())));

                image3.setText(file3.getName());
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

    public ChoiceBox<String> getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital.setValue(capital);
    }

   

    public TextField getParticipations() {
        return participations;
    }

    public void setParticipations(String participations) {
        this.participations.setText(participations);
    }

    public String getContinent() {
        return continent.getValue();
    }

    public void setContinent(String continent) {
        this.continent.setValue(continent);
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

    public void setImage1(String image1) {
        this.image1.setText(image1);
    }

    public TextField getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2.setText(image2);
    }

    public TextField getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3.setText(image3);
    }

    public TextArea getDescription() {
        return description;
    }

    public void setDescription(String description) {
  this.description.setText(description);    }

    public Label getId() {
        return id;
    }

    public void setId(String id) {
        this.id.setText(id);
    }

    public ImageView getDrapeauimg() {
        return Drapeauimg;
    }

    public void setDrapeauimg(Image Drapeauimg) {
        this.Drapeauimg.setImage(Drapeauimg);
    }

    public ImageView getPhotoimg() {
        return photoimg;
    }

    public void setPhotoimg(Image photoimg) {
        this.photoimg.setImage(photoimg);
    }

    public ImageView getLogoimg() {
        return Logoimg;
    }

    public void setLogoimg(Image Logoimg) {
        this.Logoimg.setImage(Logoimg);
    }

 
       
}
