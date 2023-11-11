/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;

import edu.gestionEvenement.entities.Evenement;
import edu.gestionEvenement.entities.Suggestion;
import edu.gestionEvenement.services.evenementCrud;
import edu.gestionEvenement.services.suggestionCrud;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author KHOULOUD
 */
public class AjouterSuggestionController implements Initializable {

    @FXML
    private TableView<Evenement> tab;
    @FXML
    private TableColumn<Evenement, String> Ctitre;
    @FXML
    private TableColumn<Evenement, String> Ctype;
    @FXML
    private TableColumn<Evenement, String> Cemplacement;
    @FXML
    private TableColumn<Evenement, String> Ctheme;
    @FXML
    private TableColumn<Evenement, String> CdateD;
    @FXML
    private TableColumn<Evenement, String> CdateF;
    @FXML
    private Button iconsulter;
    @FXML
    private TextField isugg;
    @FXML
    private TextField inom;
    @FXML
    private Button iajouterSugg;
    @FXML
    private Button iterminer;
    @FXML
    private Button ichercher;
    @FXML
    private TextField txtcherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consulter(ActionEvent event) {
         evenementCrud ps = new evenementCrud();
        ArrayList<Evenement> Evenements;

            Evenements = (ArrayList<Evenement>) ps.afficherEv();
            ObservableList obs = FXCollections.observableArrayList(Evenements);
            tab.setItems(obs);
          
           Ctitre.setCellValueFactory(new PropertyValueFactory<>("titre_Ev"));
           Ctype.setCellValueFactory(new PropertyValueFactory<>("type_Ev"));
          Cemplacement.setCellValueFactory(new PropertyValueFactory<>("emplacement_Ev"));
          Ctheme.setCellValueFactory(new PropertyValueFactory<>("theme_Ev"));
           CdateD.setCellValueFactory(new PropertyValueFactory<>("dateD_Ev"));
           CdateF.setCellValueFactory(new PropertyValueFactory<>("dateF_Ev")); 
    
    }

    @FXML
    private void ajouterSugg(ActionEvent event) {
         String nom,suggestions;
        nom= inom.getText();
        suggestions= isugg.getText();
     
        if (!inom.getText().matches(".*[a-zA-Z].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setHeaderText("Veuillez saisir Votre nom&prenom");
    alert.showAndWait();
        }
        
               else {
      Suggestion S =new Suggestion (nom,suggestions);
         suggestionCrud ps = new suggestionCrud();
         ps.ajouterS(S);
         JOptionPane.showMessageDialog(null,"MERCI POUR VOTRE SUGGESTION");
               }
    
}

    @FXML
    private void terminer(ActionEvent event) {
             tab.getItems().removeAll(tab.getSelectionModel().getSelectedItems());
              Evenement E  = tab.getSelectionModel().getSelectedItem();
        
        evenementCrud cr = new evenementCrud();
        cr.supprimerEv(E.getId_Ev());
    }

    @FXML
    private void chercher(ActionEvent event) {
       
        evenementCrud c = new  evenementCrud();
        ArrayList<Evenement> Evenements;
        Evenements = (ArrayList<Evenement>) c.RechercheNom(txtcherche.getText().toString());
        ObservableList obs = FXCollections.observableArrayList(Evenements);
        tab.setItems(obs);
         Ctitre.setCellValueFactory(new PropertyValueFactory<>("titre_Ev"));
           Ctype.setCellValueFactory(new PropertyValueFactory<>("type_Ev"));
          Cemplacement.setCellValueFactory(new PropertyValueFactory<>("emplacement_Ev"));
          Ctheme.setCellValueFactory(new PropertyValueFactory<>("theme_Ev"));
           CdateD.setCellValueFactory(new PropertyValueFactory<>("dateD_Ev"));
           CdateF.setCellValueFactory(new PropertyValueFactory<>("dateF_Ev")); 
      
    }
    }

