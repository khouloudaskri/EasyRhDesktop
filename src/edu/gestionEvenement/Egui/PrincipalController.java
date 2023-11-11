/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;


import edu.gestionEvenement.entities.Salaire;
import edu.gestionEvenement.services.SalaireCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author KHOULOUD
 */
public class PrincipalController implements Initializable {

      @FXML
    private TextField txtnom;
    @FXML
    private Label id_employe;
    @FXML
    private Label mois;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label montant;
    @FXML
    private Label heuresdetravail;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtheures_travail;
    @FXML
    private TextField txtmontant;
    @FXML
    private TextField txtid_employe;
    @FXML
    private Button ajouter;
    @FXML
    private ChoiceBox txtmois;
    @FXML
    private Label date_salaire;
    @FXML
    private DatePicker txtdate_salaire;
    @FXML
    private TableView<Salaire> table;
    @FXML
    private TableColumn<Salaire, String> table_nom;
    @FXML
    private TableColumn<Salaire, String> table_prenom;
    @FXML
    private TableColumn<Salaire, Double> table_idemploye;
    @FXML
    private TableColumn<Salaire, String> table_montant;
    @FXML
    private TableColumn<Salaire, String> table_mois;
    @FXML
    private TableColumn<Salaire, String> table_heuretravail;
    @FXML
    private Button supprimer;
    @FXML
    private Button afficher;
    @FXML
    private Button consulter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   txtmois.getItems().addAll("Janvier" , "Fevrier","Mars" , "Avril", "Mai", "juin", "juillet", "aout", "Septembre", "Octobre", "Novembre", "Decembre");
     table.setEditable(true);
     table_nom.setCellFactory(TextFieldTableCell.forTableColumn());
     table.setEditable(true);
     table_montant.setCellFactory(TextFieldTableCell.forTableColumn());
     table.setEditable(true);
     table_mois.setCellFactory(TextFieldTableCell.forTableColumn());
     table_heuretravail.setCellFactory(TextFieldTableCell.forTableColumn());
     table_prenom.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    @FXML
    private void ajouterS(ActionEvent event) {
        String nom_employe,prenom_employe,date_salaire,mois,heures_travail,montant;
        String id_employe ;
        nom_employe=txtnom.getText();
        prenom_employe=txtprenom.getText();
        date_salaire=txtdate_salaire.getValue().toString();
        mois =txtmois.getSelectionModel().getSelectedItem().toString();
        id_employe = txtid_employe.getText();
        montant = txtmontant.getText();
        heures_travail = txtheures_travail.getText();
        
       if (txtnom.getText().isEmpty() || txtprenom.getText().isEmpty()|| txtheures_travail.getText().isEmpty()|| txtmontant.getText().isEmpty()  )
      {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setHeaderText("Veuillez remplir tous les champs");
                     alert.showAndWait();}
       else {if (txtmontant.getText().matches(".*[a-zA-Z].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Veuillez saisir des chiffres au niveau du champs montant");
            alert.showAndWait();}
       else {if (txtheures_travail.getText().matches(".*[a-zA-Z].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Veuillez saisir des chiffres au niveau du champs heure du travail");
            alert.showAndWait();}
       else{
        Salaire s1 = new Salaire( id_employe, nom_employe, prenom_employe,  date_salaire,mois, montant, heures_travail);
        SalaireCRUD cc=new  SalaireCRUD ();
        cc.ajoutersalaire(s1);
        JOptionPane.showMessageDialog(null,"Salaire ajouté avec succes");
        
       
    
        SalaireCRUD c=new  SalaireCRUD ();
       
        ArrayList<Salaire> Salaires;
        Salaires = (ArrayList<Salaire>) c.affichersalaire();
        ObservableList obs = FXCollections.observableArrayList(Salaires);
        table.setItems(obs);
        table_nom.setCellValueFactory(new PropertyValueFactory<>("nom_employe"));
        table_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_employe"));
        table_idemploye.setCellValueFactory(new PropertyValueFactory<>("id_employe"));
        table_montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
        table_mois.setCellValueFactory(new PropertyValueFactory<>("mois"));
        table_heuretravail.setCellValueFactory(new PropertyValueFactory<>("heures_travail"));
                
    
       }
    }
    }
    }
    @FXML
    private void supprimerS(ActionEvent event) {
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        Salaire se = table.getSelectionModel().getSelectedItem();
        SalaireCRUD srec = new SalaireCRUD();
        srec.supprimersalaire(se.getId_employe());
    }

    @FXML
   private void Editnom(TableColumn.CellEditEvent edittedCell) {
    
        if(table_nom.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
        else {
        Salaire se = table.getSelectionModel().getSelectedItem();
        se.setNom_employe(edittedCell.getNewValue().toString());
        SalaireCRUD srec = new SalaireCRUD();
        srec.modifiersalaire(se);
        JOptionPane.showMessageDialog(null, "Success !!");}  
      
    
    }
    @FXML
    private void Editmontant(TableColumn.CellEditEvent edittedCell) {
           if(table_montant.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
        else {
        Salaire se = table.getSelectionModel().getSelectedItem();
        se.setMontant(edittedCell.getNewValue().toString());
        SalaireCRUD srec = new SalaireCRUD();
        srec.modifiersalaire(se);
        JOptionPane.showMessageDialog(null, "Success !!");}  
      
       
    }
    
    @FXML
    private void afficherS(ActionEvent event) {
        
        SalaireCRUD c=new  SalaireCRUD ();
        ArrayList<Salaire> Salaires;
        Salaires = (ArrayList<Salaire>) c.affichersalaire();
        ObservableList obs = FXCollections.observableArrayList(Salaires);
        table.setItems(obs);
        table_nom.setCellValueFactory(new PropertyValueFactory<>("nom_employe"));
        table_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_employe"));
        table_idemploye.setCellValueFactory(new PropertyValueFactory<>("id_employe"));
        table_montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
        table_mois.setCellValueFactory(new PropertyValueFactory<>("mois"));
        table_heuretravail.setCellValueFactory(new PropertyValueFactory<>("heures_travail"));
    }

    @FXML
    private void afficherS(MouseEvent event) {
    }

    @FXML
    private void Editmois(TableColumn.CellEditEvent edittedCell) {
          if(table_montant.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
        else {
        Salaire se = table.getSelectionModel().getSelectedItem();
        se.setMois(edittedCell.getNewValue().toString());
        SalaireCRUD srec = new SalaireCRUD();
        srec.modifiersalaire(se);
        JOptionPane.showMessageDialog(null, "Success !!");}  
      
       
    }

    @FXML
    private void Editprenom(TableColumn.CellEditEvent edittedCell) {
         if(table_prenom.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
        else {
        Salaire se = table.getSelectionModel().getSelectedItem();
        se.setPrenom_employe(edittedCell.getNewValue().toString());
        SalaireCRUD srec = new SalaireCRUD();
        srec.modifiersalaire(se);
        JOptionPane.showMessageDialog(null, "Success !!");} 
    }

    @FXML
    private void editheure(TableColumn.CellEditEvent edittedCell) {
         if(table_heuretravail.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
        else {
        Salaire se = table.getSelectionModel().getSelectedItem();
        se.setHeures_travail(edittedCell.getNewValue().toString());
        SalaireCRUD srec = new SalaireCRUD();
        srec.modifiersalaire(se);
        JOptionPane.showMessageDialog(null, "Success !!");} 
    }

    @FXML
    private void consulterPapier(ActionEvent event) throws IOException {
       
       FXMLLoader loader= new FXMLLoader(getClass().getResource("Papier.fxml"));
        Parent root= loader.load();
       consulter.getScene().setRoot(root);
    }
        
    }

