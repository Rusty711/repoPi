/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahwissa.desktop.boutique;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Rusty
 */
public class BoutiqueController implements Initializable {

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
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private StackPane paneSponsorise;
    @FXML
    private ImageView closeBtn;
    @FXML
    private ImageView imgSponsorise;
    @FXML
    private Label libelleSponsorise;
    @FXML
    private Label prixSponsorise;
    @FXML
    private Text descriptionSponsorise;
    @FXML
    private Label etatSponsorise;
    @FXML
    private Label venduSponsorise;
    @FXML
    private JFXButton acheterSponsorise;
    @FXML
    private StackPane paymentPane;
    @FXML
    private JFXDialogLayout paymentLayout;
    @FXML
    private JFXTextField cardNumberInput;
    @FXML
    private JFXTextField yearInput;
    @FXML
    private JFXTextField monthInput;
    @FXML
    private JFXButton payStripe;
    @FXML
    private JFXButton cancelStripe;
    @FXML
    private StackPane CompteDialog;
    @FXML
    private JFXDialogLayout CompteDialogLay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
