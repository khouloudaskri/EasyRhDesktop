/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;

import edu.gestionEvenement.entities.Conge;
import edu.gestionEvenement.entities.SoldeConge;
import edu.gestionEvenement.services.Solde_CRUD;
import edu.gestionEvenement.services.demandeconge_CRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
public class EspaceEmployeController implements Initializable {
 @FXML
    private TextField cause;
    
     @FXML
    private TableView<SoldeConge> tvsoldeem;
    
    @FXML
    private TableColumn<SoldeConge, String> colnomem1;
    
    @FXML
    private TableColumn<SoldeConge, Integer> colannuel1;
    
    @FXML
    private TableColumn<SoldeConge, Integer> colmaladie1;
        
    @FXML
    private TableColumn<SoldeConge, Integer> colcompensation1;

    @FXML
    private TableColumn<Conge, String> coldepart;

    @FXML
    private TableColumn<SoldeConge, Integer> colexception1;
    
    @FXML
    private TableColumn<SoldeConge, Integer> colidsolde1;
    
    

    @FXML
    private TableView<Conge> tvhistorique;
    
    @FXML
    private TableColumn<Conge, Integer> colid; 
   
    @FXML
    private TableColumn<Conge, String> colmotif;

    @FXML
    private TableColumn<Conge, String> colnbjr;

    @FXML
    private TableColumn<Conge, String> colretour;

    @FXML
    private TableColumn<Conge, String> colnomem;
    
    @FXML
    private TableColumn<Conge, String> coltype;
    
    @FXML
    private DatePicker date_de_depart;

    @FXML
    private DatePicker date_de_retour;

    @FXML
    private TextField nb_jour;

    @FXML
    private Button supprimerdemande;

    @FXML
    private ComboBox type_congé;
    
    @FXML
    private Button refreche;
    
    @FXML
    private Label labelnom;
    
    @FXML
    private TextField txtnomp;
    
    @FXML
    private Button modifierdemande;
    
    @FXML
    private Button bt_envoyer;
    @FXML
    private TextField nameuser;
    
    
    /**
     * Initializes the controller class.
     */
   @FXML
    void choix(ActionEvent event) {
       
    }
    
    
    @FXML
    void getdatedep(ActionEvent event) {
        LocalDate datedep = date_de_depart.getValue() ;
    }
    

    @FXML
    void getdateretour(ActionEvent event) {
        LocalDate dateretour = date_de_retour.getValue() ;
    }
    
    @FXML
    void supprimerdemande1(ActionEvent event) {
       
       Conge css = tvhistorique.getSelectionModel().getSelectedItem() ; 
       tvhistorique.getItems().removeAll(tvhistorique.getSelectionModel().getSelectedItems() );
       demandeconge_CRUD kj = new demandeconge_CRUD (); 
       kj.supprimerdemande_conge(css.getId_conge());
    }

    @FXML
    private void envoyer_formulaire(ActionEvent event) {
        String Nom_employe ;
        String datedep ;
        String dateretour ;
        String nb_jours  ;
        String type  ;
        String motif ;
        
        
        Nom_employe=txtnomp.getText() ;
        datedep=date_de_depart.getValue().toString() ;
        dateretour=date_de_retour .getValue().toString() ;
        nb_jours=nb_jour.getText() ;
        type = type_congé.getSelectionModel().getSelectedItem().toString() ; 
        motif=cause.getText() ;
        
        if (!txtnomp.getText().equals(nameuser.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("Veuillez verifier votre Nom");
             alert.showAndWait();}
        
       else if (nb_jour.getText().isEmpty()||txtnomp.getText().isEmpty()||date_de_depart.getValue().toString().isEmpty() ||date_de_retour .getValue().toString().isEmpty() || cause.getText().isEmpty())
             {
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("Veuillez remplir tous les champs");
             alert.showAndWait();}
        
        else
        {
        Conge c1 = new Conge (Nom_employe,datedep ,dateretour,nb_jours,type,motif) ;
        demandeconge_CRUD dc = new demandeconge_CRUD () ;
        dc.ajouterdemande_conge(c1);
        
        JOptionPane.showMessageDialog(null,"Demande de congé ajoutée avec succés");
                }
  
        } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> list = FXCollections.observableArrayList("Maladie" , "Compensation","Annuel" , "Exception") ;
    type_congé.setItems(list);
     
         tvhistorique.setEditable(true) ;
         coldepart.setCellFactory(TextFieldTableCell.forTableColumn());
         tvhistorique.setEditable(true);
         colretour.setCellFactory(TextFieldTableCell.forTableColumn());
         tvhistorique.setEditable(true);
         colnbjr.setCellFactory(TextFieldTableCell.forTableColumn());
         tvhistorique.setEditable(true);
         coltype.setCellFactory(TextFieldTableCell.forTableColumn());
         tvhistorique.setEditable(true);
         colmotif.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }
    
    @FXML
        private void editdepart(TableColumn.CellEditEvent edittedCell) {
           if(coldepart.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
        else {
        Conge edep = tvhistorique.getSelectionModel().getSelectedItem() ;
        edep.setDatedep(edittedCell.getNewValue().toString());
        demandeconge_CRUD dcs = new demandeconge_CRUD();
        dcs.modifierdemande_conge(edep);
        JOptionPane.showMessageDialog(null, "Success !!");}
        }

    @FXML
    private void refresh(ActionEvent event) {
        
        demandeconge_CRUD ps = new demandeconge_CRUD();
        ArrayList<Conge> demandes;
        try {
            demandes = (ArrayList<Conge>) ps.getalldemande_conge(nameuser.getText());
            ObservableList obs = FXCollections.observableArrayList(demandes);
         tvhistorique.setItems(obs);
         colid.setCellValueFactory(new PropertyValueFactory<>("id_conge"));
         colnomem.setCellValueFactory(new PropertyValueFactory<>("datedemande"));
         coldepart.setCellValueFactory(new PropertyValueFactory<>("datedep"));
         colretour.setCellValueFactory(new PropertyValueFactory<>("dateretour"));
         colnbjr.setCellValueFactory(new PropertyValueFactory<>("nb_jours"));
         coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
         colmotif.setCellValueFactory(new PropertyValueFactory<>("motif"));
         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void modifierdemande(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("resultatdemande.fxml"));
        Parent root= loader.load();
        modifierdemande.getScene().setRoot(root);
    }


    @FXML
    private void affichedem(ActionEvent event) {
        //affichage de la liste des demandes
        demandeconge_CRUD ps = new demandeconge_CRUD();
        ArrayList<Conge> mesdemandes;
        try {
            mesdemandes = (ArrayList<Conge>) ps.getalldemande_conge(nameuser.getText());
            ObservableList obs = FXCollections.observableArrayList(mesdemandes);
         tvhistorique.setItems(obs);         
         colid.setCellValueFactory(new PropertyValueFactory<>("id_conge"));
         colnomem.setCellValueFactory(new PropertyValueFactory<>("datedemande")); 
         coldepart.setCellValueFactory(new PropertyValueFactory<>("datedep"));
         colretour.setCellValueFactory(new PropertyValueFactory<>("dateretour"));  
         colnbjr.setCellValueFactory(new PropertyValueFactory<>("nb_jours"));   
         coltype.setCellValueFactory(new PropertyValueFactory<>("type"));  
         colmotif.setCellValueFactory(new PropertyValueFactory<>("motif"));  
        

         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //affichage de la liste des soldes
        
        Solde_CRUD sc = new Solde_CRUD();
        ArrayList<SoldeConge> soldes;
        try {
            soldes = (ArrayList<SoldeConge>) sc.getallsolde(nameuser.getText());
            ObservableList ocs = FXCollections.observableArrayList(soldes);
         tvsoldeem.setItems(ocs);
         colnomem1.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
         colidsolde1.setCellValueFactory(new PropertyValueFactory<>("id_solde"));      
         colcompensation1.setCellValueFactory(new PropertyValueFactory<>("solde_compensation"));
         colmaladie1.setCellValueFactory(new PropertyValueFactory<>("solde_maladie"));
         colexception1.setCellValueFactory(new PropertyValueFactory<>("solde_exception"));
         colannuel1.setCellValueFactory(new PropertyValueFactory<>("solde_annuel"));
         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

     @FXML
    private void editretour(TableColumn.CellEditEvent edittedCell) {
           if(colretour.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
        else {
        Conge edep = tvhistorique.getSelectionModel().getSelectedItem() ;
        edep.setDatedep(edittedCell.getNewValue().toString());
        demandeconge_CRUD dcs = new demandeconge_CRUD();
        dcs.modifierdemande_conge(edep);
        JOptionPane.showMessageDialog(null, "Success !!");}
    }

    @FXML
        private void editnbjr(TableColumn.CellEditEvent edittedCell) {
           if(colnbjr.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
        else {
        Conge edep = tvhistorique.getSelectionModel().getSelectedItem() ;
        edep.setDatedep(edittedCell.getNewValue().toString());
        demandeconge_CRUD dcs = new demandeconge_CRUD();
        dcs.modifierdemande_conge(edep);
        JOptionPane.showMessageDialog(null, "Success !!");}
    }

    @FXML
    
         private void edittype(TableColumn.CellEditEvent edittedCell) {
           if(coltype.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
        else {
        Conge edep = tvhistorique.getSelectionModel().getSelectedItem() ;
        edep.setDatedep(edittedCell.getNewValue().toString());
        demandeconge_CRUD dcs = new demandeconge_CRUD();
        dcs.modifierdemande_conge(edep);
        JOptionPane.showMessageDialog(null, "Success !!");}
    }

    @FXML  
      private void editmotif(TableColumn.CellEditEvent edittedCell) {
       if(colmotif.getText().isEmpty()){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText(null);
        a.setContentText("Please fill in the empty field");
        a.showAndWait();
        }
        else {
        Conge edep = tvhistorique.getSelectionModel().getSelectedItem() ;
        edep.setDatedep(edittedCell.getNewValue().toString());
        demandeconge_CRUD dcs = new demandeconge_CRUD();
        dcs.modifierdemande_conge(edep);
        JOptionPane.showMessageDialog(null, "Success !!");}
    }
   
}
