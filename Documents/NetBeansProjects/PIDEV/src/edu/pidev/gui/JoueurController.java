/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import edu.pidev.entities.Equipe;
import edu.pidev.entities.Joueur;
import edu.pidev.services.EquipeService;
import edu.pidev.services.JoueurService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.imageio.ImageIO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class JoueurController implements Initializable {

    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> prenom;
    @FXML
    private TableColumn<?, ?> datenaissance;
    @FXML
    private TableColumn<?, ?> lieunaissance;
    @FXML
    private TableColumn<?, ?> numero;
    @FXML
    private TableColumn<?, ?> taille;
    @FXML
    private TableColumn<?, ?> poids;
    @FXML
    private TableColumn<?, ?> nationalite;
    @FXML
    private TableColumn<?, ?> poste;
    @FXML
    private TableColumn<?, ?> cout;
    @FXML
    private TableColumn<?, ?> buts;
    @FXML
    private TableColumn<?, ?> selections;
    @FXML
    private TableColumn<Joueur, String> equipe;
    @FXML
    private Button refresh;
    @FXML
    private TableView<Joueur> joueurs;
    ObservableList<Joueur> data;
    @FXML
    private TableColumn<?, ?> participation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SetCellTable();
        refreshTable();
    }    
    public void refreshTable()
    {
            SetCellTable();
                List e=new ArrayList();
       Joueur s;
        try {     
            JoueurService eq=new JoueurService();
            e=eq.afficherJoueurs();
         data=FXCollections.observableArrayList(e);
          
        } catch (SQLException ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        joueurs.setItems(data);
    }
   public void SetCellTable()
    {
        nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
      prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
      numero.setCellValueFactory(new PropertyValueFactory<>("Numero"));
      lieunaissance.setCellValueFactory(new PropertyValueFactory<>("LieuNaissance"));
      datenaissance.setCellValueFactory(new PropertyValueFactory<>("DateNaissance"));
      taille.setCellValueFactory(new PropertyValueFactory<>("Taille"));
      poids.setCellValueFactory(new PropertyValueFactory<>("Poids"));
      nationalite.setCellValueFactory(new PropertyValueFactory<>("Nationalite"));
      poste.setCellValueFactory(new PropertyValueFactory<>("Poste"));
      cout.setCellValueFactory(new PropertyValueFactory<>("Cout"));
      buts.setCellValueFactory(new PropertyValueFactory<>("Buts"));
      selections.setCellValueFactory(new PropertyValueFactory<>("Selections"));
     participation.setCellValueFactory(new PropertyValueFactory<>("Participations"));
     equipe.setCellValueFactory(new PropertyValueFactory<>("EquipeNom"));
     
    }
    @FXML
  public void scrappingPlayers() throws IOException, ParseException, SQLException
  {
      EquipeService eqq=new EquipeService();
      List<Equipe> leq=new ArrayList();
      leq=eqq.afficherEquipe();
      Joueur e=new Joueur();
      EquipeService p=new EquipeService();
            String url="https://www.transfermarkt.co.uk/weltmeisterschaft-2018/startseite/pokalwettbewerb/WM18";
        Document docc=Jsoup.connect(url).get();
        Element doc=docc.getElementsByClass("items").first();
       Elements links=doc.select("a[href]");
       for (Equipe d:leq)
                   {
       for (Element link : links)
        {
                   String ss=link.text();
                   
                   if (ss.equalsIgnoreCase(d.getNom()))
                   {
                if (p.countJoueurs(d.getIdEquipe())==0)   
                {
                       String eq=link.attr("href");
                       String france="https://www.transfermarkt.co.uk"+eq;
                        Document frr=Jsoup.connect(france).get();
                              Element fr=frr.getElementsByTag("tbody").get(3);
                               
                              
                                   Elements f=fr.getElementsByClass("spielprofil_tooltip");
                                   String joueur="";
                                   List l=new ArrayList();
                                   l.add("ee");
                                   int s=0;
                                   for (Element v:f)
                                   {
                                       if (s<24)
                                       {
                                     if (l.stream().anyMatch(w->v.attr("href").equals(w)))
                                     {
                                     }
                                     else
                                     {
                                      joueur= v.attr("href");
                                      l.add(joueur);
                                      String jo="https://www.transfermarkt.co.uk";
                              Document dos=Jsoup.connect(jo+v.attr("href")).get();
Document name=Jsoup.parse(dos.getElementsByClass("dataName").html());

String nom=(dos.getElementsByAttributeValue("itemprop","name").text());

String nom1="";
String prenom="";
if (nom.contains(" "))
{
String[] parts=nom.split(" ");
prenom=parts[0];
nom1=parts[1];
e.setPrenom(prenom);
e.setNom(nom1);
}
else
{
    nom1=nom;
    e.setNom(nom1);
}
String date=(dos.getElementsByAttributeValue("itemprop","birthDate").text());
date=date.substring(0,date.length()-4);


DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
java.sql.Date datee= new java.sql.Date(format.parse(date).getTime());
e.setDateNaissance(datee);

String nationality=dos.getElementsByAttributeValue("itemprop","nationality").text();
e.setNationalite(nationality);
String height=(dos.getElementsByAttributeValue("itemprop","height").text());
if (height.equals(""))
{
    height="1,80";
}
System.out.println(Integer.parseInt(height.substring(0,height.length()-2).replace(",","")));
e.setTaille((Integer.parseInt(height.substring(0,height.length()-2).replace(",",""))));
String lieuNaissance=(dos.getElementsByAttributeValue("itemprop","birthPlace").text());
System.out.println(lieuNaissance);
e.setLieuNaissance(lieuNaissance);
e.setIdEquipe(d);
System.out.println("id"+d.getIdEquipe());
String selections="";
String buts="";
Elements dd=dos.getElementsByClass("zentriert");
int h=0;
for (Element b:dd)
{
  if (h==8)
  {
      selections=b.text();
  }
  h++;
}
if (selections.equals("-"))
{
    selections="0";
}
System.out.println(Integer.parseInt(selections));
e.setSelections((Integer.parseInt(selections)));
h=0;
for (Element b:dd)
{
  if (h==9)
  {
      buts=b.text();
  }
  h++;
}
if (buts.equals("-"))
{
    buts="0";
}
System.out.println(Integer.parseInt(buts));
e.setButs(Integer.parseInt(buts));

Elements el=dos.getElementsByAttributeValue("name","SubNavi");
int c=0;
String Profi="";
String Poste="";
for (Element ee:el)
{
    if (c==1)
    {
       Profi=ee.attr("href");
        
    }
    
    
    c++;
}
Document Profile=Jsoup.connect("https://www.transfermarkt.co.uk"+Profi).get();
Document tag=Jsoup.parse(Profile.getElementsByClass("hauptposition-center").html());
Poste=tag.text().replace("Main position : ","");
if (Poste.equals(""))
{
  tag=Jsoup.parse(Profile.getElementsByClass("hauptposition-left").html());  
    Poste=tag.text().replace("Main position :","");

}

System.out.println(Poste);
if (Poste.equals("Keeper"))
{
    Poste="GK";
}
else if (Poste.equals("Centre-Back"))
{
    Poste="Centre-Back";
}
else if (Poste.equals("Left-Back"))
{
    Poste="DG";
}
else if (Poste.equals("Right-Back"))
{
    Poste="DD";
}
else if (Poste.equals("Defensive Midfield"))
{
    Poste="MDE";
}
else if (Poste.equals("Central Midfield") || Poste.equals("Attacking Midfield"))
{
    Poste="MC";
}
else if (Poste.equals("Left Wing"))
{
    Poste="MG";
}
else if (Poste.equals("Right Wing"))
{
    Poste="MD";
}
else if (Poste.equals("Centre-Forward"))
{
    Poste="ATT";
}
e.setPoste1(Poste);
String numero;

numero=Profile.getElementsByClass("dataRN").text();
int num;
if (numero.contains("#"))
{
num=Integer.parseInt(numero.substring(1,numero.length()));
}
else
{
    numero=Profile.getElementsByClass("zentriert bg_gruen_20").text();

   if (numero.equals("-"))
    {
        Random rand = new Random();

       num = rand.nextInt(20) + 1;
    }
   else
   {
   num=Integer.parseInt(numero);
   }
}
e.setNumero(num);

int coutt=0;
if (nom1.equals("Ezenwa") || nom1.equals("Eze") ||nom1.equals("González") || nom1.equals("Kim") || nom1.equals("Calderón") ||nom1.equals("Ávila") ||nom1.equals("Bárcenas") || nom1.equals("Nurse"))
{
    coutt=5;
}
else
{
    Element cout=Profile.getElementsByClass("right-td").get(0);
String cout1=cout.text();
System.out.println(cout1.substring(cout1.length()-1,cout1.length()));
if (cout1.substring(cout1.length()-1,cout1.length()).equals("m"))
{
   coutt=Integer.parseInt(cout1.substring(0,cout1.length()-1).replace(".","").substring(1,cout1.length()-2))/100;
   
  
  if (coutt<=5)
  {
  
      coutt=coutt*16;
  }
  else if (coutt>5 && coutt<=10)
  {
      coutt=coutt*4;
  }
  else 
  {
      coutt=coutt*2;
  }
  
      

   
}
else
{
       coutt=Integer.parseInt(cout1.substring(0,cout1.length()-1).replace(".","").substring(1,cout1.length()-2));
       coutt=coutt/7;
}
}
e.setCout(coutt);
Element dataBild=Jsoup.parse(Profile.getElementsByClass("dataBild").html());
String img1=dataBild.getElementsByTag("img").attr("src");
System.out.println(img1);
  URL urll = new URL(img1);
        BufferedImage img = ImageIO.read(urll);
        File file = new File("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+nom1+""+prenom+"1.jpg");
        ImageIO.write(img, "jpg", file);
                                           e.setImageJoueur1(nom1+""+prenom+"1.jpg");
Document vv=null;
if (prenom!="")
{
vv=Jsoup.connect("https://www.bing.com/images/search?q="+prenom+"%20"+nom1+"&qs=n&form=QBIR&sp=-1&pq="+prenom+"%20"+nom1+"&sc=0-13&sk=&cvid=58BCBD57661D43FF9A898FBD914F7698").get();
}
else
{
    vv=Jsoup.connect("https://www.bing.com/images/search?q="+nom1+"&qs=n&form=QBIR&sp=-1&pq="+nom1+"&sc=0-0&sk=&cvid=54AEAA15AAC84475895EECCE1B500EC7").get();

}
String img2="";
String img3="";

img2=vv.getElementsByClass("mimg").get(1).attr("src");
 img3=vv.getElementsByClass("mimg").get(2).attr("src");


if (img2!=null && img3!=null && img2.startsWith("h") && img3.startsWith("h"))
{

System.out.println(img2);
  URL url2 = new URL(img2);
        BufferedImage imgb2 = ImageIO.read(url2);
        File file2 = new File("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+nom1+""+prenom+"2.jpg");
        ImageIO.write(imgb2, "jpg", file2);
        e.setImageJoueur2(nom1+prenom+"2.jpg");
System.out.println(img3);
URL url3 = new URL(img3);
        BufferedImage imgb3 = ImageIO.read(url3);
        File file3 = new File("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+nom1+""+prenom+"3.jpg");
        ImageIO.write(imgb3, "jpg", file3);
        e.setImageJoueur3(nom1+prenom+"3.jpg");
}

e.setDescription(Profile.getElementsByClass("auflistung").text()
);
JoueurService jj=new JoueurService();


jj.ajouterJoueur(e);
                                       System.out.println(v.attr("href"));
                                       s++;
}
                                     }
                                       
                                       else
                                       {
                                           break;
                                       }
                                   }
                                  
                               
                       
                   }

        }
  }
    refreshTable();
}}}
