/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;

import edu.gestionEvenement.entities.SoldeConge;
import edu.gestionEvenement.services.Solde_CRUD;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author KHOULOUD
 */
public class AjoutSoldeController implements Initializable {
    @FXML
    private TextField annuel;

    @FXML
    private TextField barrederecherche2;

    @FXML
    private Button bt_ajouter2;


    @FXML
    private TableColumn<SoldeConge, String> colannuel;

    @FXML
    private TableColumn<SoldeConge, String> colcompensation;

    @FXML
    private TableColumn<SoldeConge, String> colexception;

    @FXML
    private TableColumn<SoldeConge, String> colidsolde;

    @FXML
    private TableColumn<SoldeConge, String>colmaladie;

    @FXML
    private TableColumn<SoldeConge, String> colnom;

    @FXML
    private TextField compensation;

    @FXML
    private TextField exceptionnel;

    @FXML
    private TextField maladie;

    @FXML
    private Button refresh2;

    @FXML
    private Button searchim;

    @FXML
    private TableView<SoldeConge> tvsolde;

    @FXML
    private TextField txtnom;
    
    @FXML
    private Button retour;
    @FXML
    private Button bt_sup;
    
    
    @FXML
    void bt_retour(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("TraitementDemande_Conge.fxml"));
        Parent root= loader.load();
        retour.getScene().setRoot(root);

    }
    
    public void findname(){
         Solde_CRUD c =new  Solde_CRUD ();
        ArrayList<SoldeConge> soldes;
        soldes = (ArrayList<SoldeConge>) c.RechercheNom(txtnom.getText());
        
    }

    @FXML
    void ajouterSolde2(ActionEvent event) {
        
     
        String solde_annuel;
        String solde_compensation ;
        String solde_maladie ;
        String solde_exception ;
        String Nom_employe;
   
        Nom_employe=txtnom.getText();
        solde_annuel =annuel.getText();
        solde_compensation =compensation.getText();
        solde_maladie =maladie.getText();
        solde_exception =exceptionnel.getText();
        
        Solde_CRUD c =new  Solde_CRUD ();

        if  (txtnom.getText().isEmpty()||annuel.getText().isEmpty()|| compensation.getText().isEmpty()
                ||maladie.getText().isEmpty()||exceptionnel.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Veuillez remplir tous les champs avec des entiers ");
            alert.showAndWait();}
       
        else
        {
            SoldeConge c1 = new SoldeConge (Nom_employe,solde_annuel,solde_compensation,solde_maladie,solde_exception) ;
           Solde_CRUD dc = new Solde_CRUD () ;
            dc.SupprimerSolde_Conge(txtnom.getText());
            dc.AjouterSolde_conge(c1);
            
            
            JOptionPane.showMessageDialog(null,"Solde ajouté avec succés");
        }
        
    }
    @FXML
    void bt_chercher(ActionEvent event) {
    Solde_CRUD c =new  Solde_CRUD ();
        ArrayList<SoldeConge> soldes;
        soldes = (ArrayList<SoldeConge>) c.RechercheNom(barrederecherche2.getText());
        ObservableList obs = FXCollections.observableArrayList(soldes);
        tvsolde.setItems(obs);
        colidsolde.setCellValueFactory(new PropertyValueFactory<>("id_solde"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
        colcompensation.setCellValueFactory(new PropertyValueFactory<>("solde_compensation"));
        colmaladie.setCellValueFactory(new PropertyValueFactory<>("solde_maladie"));
        colexception.setCellValueFactory(new PropertyValueFactory<>("solde_exception")); 
        colannuel.setCellValueFactory(new PropertyValueFactory<>("solde_annuel")); 
        

    }

    @FXML
    void bt_update2(ActionEvent event) {
        Solde_CRUD sc = new Solde_CRUD();
        ArrayList<SoldeConge> demandes;
        try {
            demandes = (ArrayList<SoldeConge>) sc.getallsolde1();
            ObservableList ocs = FXCollections.observableArrayList(demandes);
         tvsolde.setItems(ocs);
         colidsolde.setCellValueFactory(new PropertyValueFactory<>("id_solde"));
         colnom.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
         colannuel.setCellValueFactory(new PropertyValueFactory<>("solde_annuel"));
         colcompensation.setCellValueFactory(new PropertyValueFactory<>("solde_compensation"));
         colmaladie.setCellValueFactory(new PropertyValueFactory<>("solde_maladie"));
         colexception.setCellValueFactory(new PropertyValueFactory<>("solde_exception"));
         
         
         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     Solde_CRUD sc = new Solde_CRUD();
        ArrayList<SoldeConge> demandes;
        try {
            demandes = (ArrayList<SoldeConge>) sc.getallsolde1();
            ObservableList ocs = FXCollections.observableArrayList(demandes);
         tvsolde.setEditable(true);   
         tvsolde.setItems(ocs);
         colidsolde.setCellValueFactory(new PropertyValueFactory<>("id_solde"));
         
         colnom.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
         colnom.setCellFactory(TextFieldTableCell.forTableColumn());
         
         colannuel.setCellValueFactory(new PropertyValueFactory<>("solde_annuel"));
         colannuel.setCellFactory(TextFieldTableCell.forTableColumn());
         
         colcompensation.setCellValueFactory(new PropertyValueFactory<>("solde_compensation"));
         colcompensation.setCellFactory(TextFieldTableCell.forTableColumn());
         
         colmaladie.setCellValueFactory(new PropertyValueFactory<>("solde_maladie"));
         colmaladie.setCellFactory(TextFieldTableCell.forTableColumn());
         
         colexception.setCellValueFactory(new PropertyValueFactory<>("solde_exception"));
         colexception.setCellFactory(TextFieldTableCell.forTableColumn());
         
         
         
         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    @FXML
    private void editTitre(TableColumn.CellEditEvent<SoldeConge,String> sStringCellEvent) {
        
        SoldeConge S  = (SoldeConge) tvsolde.getSelectionModel().getSelectedItem();
        S.setNom_employe(sStringCellEvent.getNewValue());
       
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!"); 
    }

    

    @FXML
    private void supprimersolde(ActionEvent event) {
        
       SoldeConge ssc = (SoldeConge) tvsolde.getSelectionModel().getSelectedItem() ; 
       tvsolde.getItems().removeAll(tvsolde.getSelectionModel().getSelectedItems() );
       Solde_CRUD kj = new Solde_CRUD (); 
       kj.SupprimerSolde_Conge(ssc.getNom_employe());
        
    }
    
    
    
}
