/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class AdminController implements Initializable {

   @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    private AnchorPane AnchorPane;

    public static AnchorPane rootP;
    @FXML
    private JFXDrawer CrudDrawer;
    private JFXButton minimizeButton;
    private JFXButton maximizeButton;
    @FXML
    private AnchorPane anchoor;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {   
           VBox box = FXMLLoader.load(getClass().getResource("SideMenu.fxml"));
                     drawer.setSidePane(box);
for (Node node: box.getChildren())
{
    if (node.getAccessibleText()!=null)
    {
        node.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{
            if (node.getAccessibleText().equals("Joueur"))
            {
                try {
                    
  Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("Joueur.fxml"));
  anchoor.getChildren().clear();
  anchoor.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
                        

            }
            else if ((node.getAccessibleText().equals("Equipe")))
            {
                try {
  Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("Equipe.fxml"));
  anchoor.getChildren().clear();
  anchoor.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            else if ((node.getAccessibleText().equals("Stade")))
            {
                try {
  Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("Stades.fxml"));
  anchoor.getChildren().clear();
  anchoor.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
        });
    }
}
       } catch (IOException ex) {
           Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
       }
       HamburgerSlideCloseTransition task=new HamburgerSlideCloseTransition();
       task.setRate(-1);
       hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
           @Override
           public void handle(Event event) {
           
     
      
               task.setRate(task.getRate()*-1);
               task.play();
           
               if (drawer.isHidden())
               {
                   drawer.open();
               drawer.setMinWidth(200);
               }
           
           else
               {
                   drawer.close();
                                      drawer.setMinWidth(0);

               }
           }});
       
       
    
    }
    }
