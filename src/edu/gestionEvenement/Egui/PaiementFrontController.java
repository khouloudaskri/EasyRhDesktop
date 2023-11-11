/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;


import edu.gestionEvenement.entities.Salaire;
import edu.gestionEvenement.entities.papier;
import edu.gestionEvenement.services.PapierCRUD;
import edu.gestionEvenement.services.SalaireCRUD;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class PaiementFrontController implements Initializable {

    @FXML
    private Button rechercher;
   
    @FXML
    private Label txt;
    @FXML
    private TextField txtrechercher;
 
    
     @FXML
    private TableView<Salaire> table;
    @FXML
    private TableColumn<Salaire, String> table_nom;
    @FXML
    private TableColumn<Salaire, String> table_prenom;
    @FXML
    private TableColumn<Salaire, String> table_idemploye;
    @FXML
    private TableColumn<Salaire, String> table_montant;
    @FXML
    private TableColumn<Salaire, String> table_mois;
    @FXML
    private TableColumn<Salaire, String> table_heuretravail;
    @FXML
    private Button demander;
    @FXML
    private TextField txt_type;
    @FXML
    private TextField txt_nometprenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
    private void chercher(ActionEvent event) {
        SalaireCRUD c=new  SalaireCRUD ();
        ArrayList<Salaire> Salaires;
        Salaires = (ArrayList<Salaire>) c.RechercheNom(txtrechercher.getText().toString());
        ObservableList obs = FXCollections.observableArrayList(Salaires);
        table.setItems(obs);
        table_nom.setCellValueFactory(new PropertyValueFactory<>("nom_employe"));
        table_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_employe"));
        table_montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
        table_mois.setCellValueFactory(new PropertyValueFactory<>("mois"));
        table_heuretravail.setCellValueFactory(new PropertyValueFactory<>("heures_travail"));
        table_idemploye.setCellValueFactory(new PropertyValueFactory<>("id_employe"));
    }

   

    @FXML
    private void demandePapier(ActionEvent event) { String nomE,typeP;
        nomE=txt_nometprenom.getText();
        typeP=txt_type.getText();
        papier p = new papier(nomE,typeP );
       PapierCRUD cc=new  PapierCRUD ();
        cc.ajouterpapier(p);
        JOptionPane.showMessageDialog(null," ajout avec succes");
    }


  
}
