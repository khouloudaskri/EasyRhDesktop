/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;

import edu.gestionEvenement.entities.Conge;
import edu.gestionEvenement.services.demandeconge_CRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author KHOULOUD
 */
public class ResultatdemandeController implements Initializable {
 @FXML
    private TableView<?> tvhistorique1;
    @FXML
    private TableColumn<Conge, Integer> colid1;
    @FXML
    private TableColumn<Conge, String> colnomem2;
    @FXML
    private TableColumn<Conge, String> coldepart1;
    @FXML
    private TableColumn<Conge, String> colretour1;
    @FXML
    private TableColumn<Conge, String> colnbjr1;
    @FXML
    private TableColumn<Conge, String> coltype1;
    @FXML
    private TableColumn<Conge, String> colmotif1;
    @FXML
    private TableColumn<Conge, String> coletat2;
    @FXML
    private Button retour1;
    @FXML
    private TextField nameuserR;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void affichedemR(ActionEvent event) {
         demandeconge_CRUD ps = new demandeconge_CRUD();
        ArrayList<Conge> mesdemandes;
        try {
            mesdemandes = (ArrayList<Conge>) ps.getalldemande_conge(nameuserR.getText());
            ObservableList obs = FXCollections.observableArrayList(mesdemandes);
         tvhistorique1.setItems(obs);
        
         colid1.setCellValueFactory(new PropertyValueFactory<>("id_conge"));
         
         colnomem2.setCellValueFactory(new PropertyValueFactory<>("datedemande"));
                 
         coldepart1.setCellValueFactory(new PropertyValueFactory<>("datedep"));
         
         colretour1.setCellValueFactory(new PropertyValueFactory<>("dateretour"));  

         colnbjr1.setCellValueFactory(new PropertyValueFactory<>("nb_jours"));   

         coltype1.setCellValueFactory(new PropertyValueFactory<>("type"));  

         colmotif1.setCellValueFactory(new PropertyValueFactory<>("motif"));  

         coletat2.setCellValueFactory(new PropertyValueFactory<>("etat"));
         
         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void bt_retour1(ActionEvent event) throws IOException {
           FXMLLoader loader= new FXMLLoader(getClass().getResource("EspaceEmploye.fxml"));
        Parent root= loader.load();
        retour1.getScene().setRoot(root);
    }
    
}
