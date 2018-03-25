/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rusty
 */
public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherJoueurs.fxml"));

                Parent root = FXMLLoader.load(getClass().getResource("AfficherJoueurs.fxml"));
                  Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
              scene.getStylesheets().add(EquipeController.class.getResource("bootstrap3.css").toExternalForm());


    }
       public static void main(String[] args) {
        launch(args);
    }
}
