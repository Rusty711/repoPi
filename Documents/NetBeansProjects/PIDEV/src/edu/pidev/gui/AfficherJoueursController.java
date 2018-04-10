/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import edu.pidev.entities.Equipe;
import edu.pidev.entities.Joueur;
import edu.pidev.services.EquipeService;
import edu.pidev.services.JoueurService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class AfficherJoueursController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Pane joueur;
    @FXML
    private Pane div11;
    @FXML
    private ImageView eq1img;
    @FXML
    private Label nomeq1;
    @FXML
    private Label drapeq1;
    @FXML
    private Pane div111;
    @FXML
    private ImageView eq4img;
    @FXML
    private Label nomeq4;
    @FXML
    private Label drapeq4;
    @FXML
    private Pane div112;
    @FXML
    private ImageView eq2img;
    @FXML
    private Label nomeq2;
    @FXML
    private Label drapeq2;
    @FXML
    private Pane div113;
    @FXML
    private ImageView eq3img;
    @FXML
    private Label nomeq3;
    @FXML
    private Label drapeq3;
    @FXML
    private ChoiceBox<String> Equipes;
    @FXML
    private Pane div1111;
    @FXML
    private ImageView eq5img;
    @FXML
    private Label nomeq5;
    @FXML
    private Label drapeq5;
    @FXML
    private Pane div11111;
    @FXML
    private Label nomeq6;
    @FXML
    private Label drapeq6;
    @FXML
    private Pagination paginator;
    @FXML
    private ImageView eq6img;
    @FXML
    private TextField page;
    @FXML
    private Button butj1;
    @FXML
    private Button butj4;
    @FXML
    private Button butj2;
    @FXML
    private Button butj3;
    @FXML
    private Button butj5;
    @FXML
    private Button butj6;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        page.setText("0");
        try {
            EquipeService eq=new EquipeService();
            List<Equipe> ll=new ArrayList();
                  ObservableList l=(FXCollections.observableArrayList());
                  ll=eq.afficherEquipe();
                 for (Equipe s:ll)
                 {
                     l.add(s.getNom());
                 }
                 Equipes.setItems(l);
                 Equipes.setValue("Russia");
                  ChangedTeam(Equipes.getValue());
                   Equipes.valueProperty().addListener(new ChangeListener<String>() {
         

                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    try {
                        ChangedTeam(newValue);
                    } catch (SQLException ex) {
                        Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });

        } catch (SQLException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
public void ChangedTeam(String Nom) throws SQLException
{
    EquipeService es=new EquipeService();
    int sizee;
    sizee=es.countJoueur(Nom);
           paginator.setPageCount(sizee/6);
         
   paginator.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
              System.out.println(pageIndex);
              page.setText(Integer.toString(pageIndex));
                return new VBox();
            }
        });
   
           paginator=new Pagination(sizee/6,0);
        noChange();
           page.textProperty().addListener((observable, oldValue, newValue) -> {
                       List<Joueur> list=new ArrayList();
        

               if (Integer.parseInt(newValue)==0)
               {
                   try {
                       JoueurService eq=null;
                       try {
                          eq=new JoueurService();
                       } catch (SQLException ex) {
                           Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       try {
                           list=eq.afficherParEquipe(Nom);
                       } catch (SQLException ex) {
                           Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       showPlayers(list,0);
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               else if (Integer.parseInt(newValue)==1)
               {
                   try {
                          JoueurService eq=null;
                       try {
                          eq=new JoueurService();
                       } catch (SQLException ex) {
                           Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       try {
                           list=eq.afficherParEquipe(Nom);
                       } catch (SQLException ex) {
                           Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       showPlayers(list,6);
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               else if (Integer.parseInt(newValue)==2)
               {
                   try {
                          JoueurService eq=null;
                       try {
                          eq=new JoueurService();
                       } catch (SQLException ex) {
                           Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       try {
                           list=eq.afficherParEquipe(Nom);
                       } catch (SQLException ex) {
                           Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       showPlayers(list,12);
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               else if (Integer.parseInt(newValue)==3)
               {
                   try {
                          JoueurService eq=null;
                       try {
                          eq=new JoueurService();
                       } catch (SQLException ex) {
                           Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       try {
                           list=eq.afficherParEquipe(Nom);
                       } catch (SQLException ex) {
                           Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       showPlayers(list,18);
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               
               
           });
    
}
    public VBox createPage(int pageIndex) {
        VBox pageBox = new VBox();
    
        return pageBox;
    }
   public void showPlayers(List<Joueur> list,int min) throws FileNotFoundException
   {
    System.out.println("miin"+min);
        Image im1=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min).getImageJoueur1()),520,300,false,false);
       
                    eq1img.setImage(im1);
                    butj1.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
             
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("JoueurDetails.fxml"));
                             Parent root=null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Scene scene=new Scene(root);
          Stage Stages = new Stage();
          Stages.setScene(scene);
          JoueurDetailsController je=loader.getController();
          
          je.setButs(Integer.toString(list.get(min).getButs()));
          je.setDate(list.get(min).getDateNaissance().toString());
          je.setLieu(list.get(min).getLieuNaissance());
          je.setNationalite(list.get(min).getNationalite());
          je.setNumero(Integer.toString(list.get(min).getNumero()));
          je.setNom(list.get(min).getPrenom()+list.get(min).getNom());
          je.setPoids(Integer.toString(list.get(min).getPoids()));
          je.setPoste(list.get(min).getPoste1());
          je.setPoste1(list.get(min).getPoste1());
          je.setSelections(Integer.toString(list.get(min).getSelections()));
          je.setTailles(Integer.toString(list.get(min).getTaille()));
          je.setPays(list.get(min).getEquipeNom());
          je.setImage2(im1);
         je.setDescription(list.get(min).getDescription());
         System.out.println(list.get(min).getDescription());
        try {
            je.setImage1(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(min).getIdEquipe().getPhotoEquipe()),5000,1000,false,false));
            je.setImg3(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min).getImageJoueur3()),520,300,false,false));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Stages.show();
          
    }
});
                   
                    nomeq1.setText(list.get(min).getNom()+" "+list.get(min).getPrenom());
                    drapeq1.setText(Integer.toString(list.get(min).getNumero()));
                          Image im3=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min+1).getImageJoueur1()),520,300,false,false);
                    eq2img.setImage(im3);
                                 butj2.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
             
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("JoueurDetails.fxml"));
                             Parent root=null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Scene scene=new Scene(root);
          Stage Stages = new Stage();
          Stages.setScene(scene);
          JoueurDetailsController je=loader.getController();
          
          je.setButs(Integer.toString(list.get(min+1).getButs()));
          je.setDate(list.get(min+1).getDateNaissance().toString());
          je.setLieu(list.get(min+1).getLieuNaissance());
          je.setNationalite(list.get(min+1).getNationalite());
          je.setNumero(Integer.toString(list.get(min+1).getNumero()));
          je.setNom(list.get(min+1).getPrenom()+list.get(min+1).getNom());
          je.setPoids(Integer.toString(list.get(min+1).getPoids()));
          je.setPoste(list.get(min+1).getPoste1());
          je.setPoste1(list.get(min+1).getPoste1());
          je.setSelections(Integer.toString(list.get(min+1).getSelections()));
          je.setTailles(Integer.toString(list.get(min+1).getTaille()));
          je.setPays(list.get(min+1).getEquipeNom());
          je.setImage2(im3);
         je.setDescription(list.get(min+1).getDescription());
         System.out.println(list.get(min+1).getDescription());
        try {
            je.setImage1(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(min+1).getIdEquipe().getPhotoEquipe()),5000,1000,false,false));
            je.setImg3(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min+1).getImageJoueur3()),520,300,false,false));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Stages.show();
          
    }
});
                    nomeq2.setText(list.get(min+1).getNom()+" "+list.get(min+1).getPrenom());
                    drapeq2.setText(Integer.toString(list.get(min+1).getNumero()));
                          Image im5=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min+2).getImageJoueur1()),520,300,false,false);
                               butj3.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
             
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("JoueurDetails.fxml"));
                             Parent root=null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Scene scene=new Scene(root);
          Stage Stages = new Stage();
          Stages.setScene(scene);
          JoueurDetailsController je=loader.getController();
          
          je.setButs(Integer.toString(list.get(min+2).getButs()));
          je.setDate(list.get(min+2).getDateNaissance().toString());
          je.setLieu(list.get(min+2).getLieuNaissance());
          je.setNationalite(list.get(min+2).getNationalite());
          je.setNumero(Integer.toString(list.get(min+2).getNumero()));
          je.setNom(list.get(min+2).getPrenom()+list.get(min+2).getNom());
          je.setPoids(Integer.toString(list.get(min+2).getPoids()));
          je.setPoste(list.get(min+2).getPoste1());
          je.setPoste1(list.get(min+2).getPoste1());
          je.setSelections(Integer.toString(list.get(min+2).getSelections()));
          je.setTailles(Integer.toString(list.get(min+2).getTaille()));
          je.setPays(list.get(min+2).getEquipeNom());
          je.setImage2(im5);
         je.setDescription(list.get(min+2).getDescription());
         System.out.println(list.get(min+2).getDescription());
        try {
            je.setImage1(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(min+2).getIdEquipe().getPhotoEquipe()),5000,1000,false,false));
            je.setImg3(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min+2).getImageJoueur3()),520,300,false,false));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Stages.show();
          
    }
});
                          eq3img.setImage(im5);
                   
                    nomeq3.setText(list.get(min+2).getNom()+" "+list.get(min+2).getPrenom());
                    drapeq3.setText(Integer.toString(list.get(min+2).getNumero()));
                          Image im7=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min+3).getImageJoueur1()),520,300,false,false);
                                 butj4.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
             
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("JoueurDetails.fxml"));
                             Parent root=null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Scene scene=new Scene(root);
          Stage Stages = new Stage();
          Stages.setScene(scene);
          JoueurDetailsController je=loader.getController();
          
          je.setButs(Integer.toString(list.get(min+3).getButs()));
          je.setDate(list.get(min+3).getDateNaissance().toString());
          je.setLieu(list.get(min+3).getLieuNaissance());
          je.setNationalite(list.get(min+3).getNationalite());
          je.setNumero(Integer.toString(list.get(min+3).getNumero()));
          je.setNom(list.get(min).getPrenom()+list.get(min+3).getNom());
          je.setPoids(Integer.toString(list.get(min+3).getPoids()));
          je.setPoste(list.get(min+3).getPoste1());
          je.setPoste1(list.get(min+3).getPoste1());
          je.setSelections(Integer.toString(list.get(min+3).getSelections()));
          je.setTailles(Integer.toString(list.get(min+3).getTaille()));
          je.setPays(list.get(min+3).getEquipeNom());
          je.setImage2(im7);
         je.setDescription(list.get(min+3).getDescription());
         System.out.println(list.get(min+3).getDescription());
        try {
            je.setImage1(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(min+3).getIdEquipe().getPhotoEquipe()),5000,1000,false,false));
            je.setImg3(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min+3).getImageJoueur3()),520,300,false,false));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Stages.show();
          
    }
});
                          eq4img.setImage(im7);
                
                    nomeq4.setText(list.get(min+3).getNom()+" "+list.get(min+3).getPrenom());
                    drapeq4.setText(Integer.toString(list.get(min+3).getNumero()));
                    if (list.size()==22 && min==18)
                    {
                        div1111.setVisible(false);
                    }
                    else
                    {
                                                div1111.setVisible(true);

                    Image im8=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min+4).getImageJoueur1()),520,300,false,false);
                               
                    eq5img.setImage(im8);
                    
                    nomeq5.setText(list.get(min+4).getNom()+" "+list.get(min+4).getPrenom());
                    drapeq5.setText(Integer.toString(list.get(min+4).getNumero()));
                butj5.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
             
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("JoueurDetails.fxml"));
                             Parent root=null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Scene scene=new Scene(root);
          Stage Stages = new Stage();
          Stages.setScene(scene);
          JoueurDetailsController je=loader.getController();
          
          je.setButs(Integer.toString(list.get(min+4).getButs()));
          je.setDate(list.get(min+4).getDateNaissance().toString());
          je.setLieu(list.get(min+4).getLieuNaissance());
          je.setNationalite(list.get(min+4).getNationalite());
          je.setNumero(Integer.toString(list.get(min+4).getNumero()));
          je.setNom(list.get(min+4).getPrenom()+list.get(min+4).getNom());
          je.setPoids(Integer.toString(list.get(min+4).getPoids()));
          je.setPoste(list.get(min+4).getPoste1());
          je.setPoste1(list.get(min+4).getPoste1());
          je.setSelections(Integer.toString(list.get(min+4).getSelections()));
          je.setTailles(Integer.toString(list.get(min+4).getTaille()));
          je.setPays(list.get(min+4).getEquipeNom());
          je.setImage2(im8);
         je.setDescription(list.get(min+4).getDescription());
         System.out.println(list.get(min+4).getDescription());
        try {
            je.setImage1(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(min+4).getIdEquipe().getPhotoEquipe()),5000,1000,false,false));
            je.setImg3(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min+4).getImageJoueur3()),520,300,false,false));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Stages.show();
          
    }
});
                    }
                  if (((list.size()==23) ||(list.size()==22)) & min==18)
                  {
                      div11111.setVisible(false);
                  }
                  else
                  {
                                            div11111.setVisible(true);

                           Image im9=new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min+5).getImageJoueur1()),520,300,false,false);
   
                                
                    eq6img.setImage(im9);
             
                    nomeq6.setText(list.get(min+5).getNom()+" "+list.get(min+5).getPrenom());
                    drapeq6.setText(Integer.toString(list.get(min+5).getNumero()));
                                                 butj6.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
             
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("JoueurDetails.fxml"));
                             Parent root=null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Scene scene=new Scene(root);
          Stage Stages = new Stage();
          Stages.setScene(scene);
          JoueurDetailsController je=loader.getController();
          je.setButs(Integer.toString(list.get(min+5).getButs()));
          je.setDate(list.get(min+5).getDateNaissance().toString());
          je.setLieu(list.get(min+5).getLieuNaissance());
          je.setNationalite(list.get(min+5).getNationalite());
          je.setNumero(Integer.toString(list.get(min+5).getNumero()));
          je.setNom(list.get(min+5).getPrenom()+list.get(min+5).getNom());
          je.setPoids(Integer.toString(list.get(min+5).getPoids()));
          je.setPoste(list.get(min+5).getPoste1());
          je.setPoste1(list.get(min+5).getPoste1());
          je.setSelections(Integer.toString(list.get(min+5).getSelections()));
          je.setTailles(Integer.toString(list.get(min+5).getTaille()));
          je.setPays(list.get(min+5).getEquipeNom());
          je.setImage2(im9);
         je.setDescription(list.get(min+5).getDescription());
         System.out.println(list.get(min+5).getDescription());
        try {
            je.setImage1(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Equipes\\"+list.get(min+5).getIdEquipe().getPhotoEquipe()),6000,2000,false,false));
            je.setImg3(new Image(new FileInputStream("C:\\wamp64\\www\\PIDEV\\web\\uploads\\Joueurs\\"+list.get(min+5).getImageJoueur3()),520,300,false,false));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Stages.show();
          
    }
});
                                             
                                
                  }                       
       
   }
   public void noChange()
   {
              try {
                   JoueurService eqq=new JoueurService();
                   List<Joueur> j=new ArrayList();
                   j=eqq.afficherParEquipe(Equipes.getValue());
                           try {
                               showPlayers(j,Integer.parseInt(page.getText()));
                           } catch (FileNotFoundException ex) {
                               Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
                           }
               } catch (SQLException ex) {
                   Logger.getLogger(AfficherJoueursController.class.getName()).log(Level.SEVERE, null, ex);
               }
   }
   
}
    
    

