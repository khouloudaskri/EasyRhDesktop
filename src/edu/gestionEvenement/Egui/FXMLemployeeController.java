/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;

import edu.gestionEvenement.utlis.myConnexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author KHOULOUD
 */
public class FXMLemployeeController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField mdp;
    @FXML
    private PasswordField rmdp;
    @FXML
    private Button conff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confff(ActionEvent event) throws SQLException {
         if(mdp.getText().equals(rmdp.getText())){
               PreparedStatement ps = null;
       Connection cnx = myConnexion.getinstance().getConnection();
       ResultSet rs = null;
   ps = cnx.prepareStatement("UPDATE `user` SET password=? where email ='"+ email.getText() +"' ");
   ps.setString(1,mdp.getText());
   ps.executeUpdate();
 Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText(null);
            a.setContentText("password is changed");
            a.showAndWait();
    }
        else{
        
          Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("password is not matched");
            a.showAndWait();
        }
    
    }
    
}
