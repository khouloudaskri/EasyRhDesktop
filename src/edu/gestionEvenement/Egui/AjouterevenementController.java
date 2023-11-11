/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;

import edu.gestionEvenement.entities.Evenement;
import edu.gestionEvenement.services.evenementCrud;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class AjouterevenementController implements Initializable {

  @FXML
    private TextField txttitre;
    @FXML
    private ComboBox txttype;
    @FXML
    private TextField txtemplacement;
    @FXML
    private TextField txttheme;
    @FXML
    private DatePicker txtdateD;
    @FXML
    private DatePicker txtdateF;
    @FXML
    private Button txtajouter;
    @FXML
    private Button txtsupprimer;
    @FXML
    private Button txtmodifier;
    @FXML
    private TableColumn<Evenement,Integer > Cid;
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
    private TableColumn<Evenement, String>CdateF;
    @FXML
   private TableView<Evenement> table;
    @FXML
    private Button txtaffiche;
    @FXML
    private Button txtsuggestion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
          ObservableList<String> list  = FXCollections.observableArrayList("séminaire" , "Le team-building","Formation" , "Session Divertissement") ;
        txttype.setItems(list);
       table.setEditable(true);
        Ctitre.setCellFactory(TextFieldTableCell.forTableColumn());
        table.setEditable(true);
        Ctype.setCellFactory(TextFieldTableCell.forTableColumn());
        table.setEditable(true);
       Cemplacement.setCellFactory(TextFieldTableCell.forTableColumn());
       table.setEditable(true);
      Ctheme.setCellFactory(TextFieldTableCell.forTableColumn());
      table.setEditable(true);
      CdateD.setCellFactory(TextFieldTableCell.forTableColumn());
      table.setEditable(true);
      CdateF.setCellFactory(TextFieldTableCell.forTableColumn());
       
    }    

    @FXML
    private void ajouterE(ActionEvent event) {
             String titre_Ev,type_Ev,emplacement_Ev,theme_Ev,dateD_Ev,dateF_Ev;
        titre_Ev= txttitre.getText();
        type_Ev= txttype.getSelectionModel().getSelectedItem().toString();
         emplacement_Ev= txtemplacement.getText();
          theme_Ev= txttheme.getText();
           dateD_Ev= txtdateD.getValue().toString();
             dateF_Ev= txtdateF.getValue().toString();
               if (txttitre.getText().isEmpty() || txtemplacement.getText().isEmpty()|| txttheme.getText().isEmpty())
   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setHeaderText("Veuillez remplir tous les champs");
                     alert.showAndWait();}
       
               else {
       Evenement E =new Evenement(titre_Ev,type_Ev,emplacement_Ev,theme_Ev,dateD_Ev,dateF_Ev);
         evenementCrud ps = new evenementCrud();
         ps.ajouterEv(E);
         JOptionPane.showMessageDialog(null,"evenement ajouté");
               }
  evenementCrud ps = new evenementCrud();
        ArrayList<Evenement> Evenements;

            Evenements = (ArrayList<Evenement>) ps.afficherEv();
            ObservableList obs = FXCollections.observableArrayList(Evenements);
            table.setItems(obs);
            Cid.setCellValueFactory(new PropertyValueFactory<>("id_Ev"));
           Ctitre.setCellValueFactory(new PropertyValueFactory<>("titre_Ev"));
           Ctype.setCellValueFactory(new PropertyValueFactory<>("type_Ev"));
          Cemplacement.setCellValueFactory(new PropertyValueFactory<>("emplacement_Ev"));
          Ctheme.setCellValueFactory(new PropertyValueFactory<>("theme_Ev"));
           CdateD.setCellValueFactory(new PropertyValueFactory<>("dateD_Ev"));
           CdateF.setCellValueFactory(new PropertyValueFactory<>("dateF_Ev")); 
  
    
    }

    @FXML
    private void supprimerE(ActionEvent event) {
            table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
              Evenement E  = table.getSelectionModel().getSelectedItem();
        
        evenementCrud cr = new evenementCrud();
        cr.supprimerEv(E.getId_Ev());
    }

    @FXML
    private void modifierE(ActionEvent event) {
    }

    @FXML
    private void editTitre(TableColumn.CellEditEvent edittedCell) {
          if(Ctitre.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
          
          else{
        Evenement E  = table.getSelectionModel().getSelectedItem();
        E.setTitre_Ev(edittedCell.getNewValue().toString());
        evenementCrud cr = new evenementCrud();
        cr.modifierEv(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!"); 
    }
    
}

    @FXML
    private void editEmplacement(TableColumn.CellEditEvent edittedCell) {
           if(Cemplacement.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
          
          else{
        Evenement E  = table.getSelectionModel().getSelectedItem();
        E.setEmplacement_Ev(edittedCell.getNewValue().toString());
        evenementCrud cr = new evenementCrud();
        cr.modifierEv(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!"); 
    }
    }

    @FXML
    private void editTheme(TableColumn.CellEditEvent edittedCell) {
            if(Ctheme.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
          
          else{
        Evenement E  = table.getSelectionModel().getSelectedItem();
        E.setTheme_Ev(edittedCell.getNewValue().toString());
        evenementCrud cr = new evenementCrud();
        cr.modifierEv(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!"); 
    }
    }
    @FXML
    private void EditDateD(TableColumn.CellEditEvent edittedCell) {
                  if(CdateD.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
          
          else{
        Evenement E  = table.getSelectionModel().getSelectedItem();
        E.setDateD_Ev(edittedCell.getNewValue().toString());
        evenementCrud cr = new evenementCrud();
        cr.modifierEv(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!"); 
    }
    }

    @FXML
    private void editDateF(TableColumn.CellEditEvent edittedCell) {
                       if(CdateF.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
          
          else{
        Evenement E  = table.getSelectionModel().getSelectedItem();
        E.setDateF_Ev(edittedCell.getNewValue().toString());
        evenementCrud cr = new evenementCrud();
        cr.modifierEv(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!"); 
    }
    }

    @FXML
    private void afficherE(ActionEvent event) {
          evenementCrud ps = new evenementCrud();
        ArrayList<Evenement> Evenements;

            Evenements = (ArrayList<Evenement>) ps.afficherEv();
            ObservableList obs = FXCollections.observableArrayList(Evenements);
            table.setItems(obs);
            Cid.setCellValueFactory(new PropertyValueFactory<>("id_Ev"));
           Ctitre.setCellValueFactory(new PropertyValueFactory<>("titre_Ev"));
           Ctype.setCellValueFactory(new PropertyValueFactory<>("type_Ev"));
          Cemplacement.setCellValueFactory(new PropertyValueFactory<>("emplacement_Ev"));
          Ctheme.setCellValueFactory(new PropertyValueFactory<>("theme_Ev"));
           CdateD.setCellValueFactory(new PropertyValueFactory<>("dateD_Ev"));
           CdateF.setCellValueFactory(new PropertyValueFactory<>("dateF_Ev")); 
  
        
    }

    @FXML
    private void suggestionE(ActionEvent event) throws IOException {
       
      FXMLLoader loader= new FXMLLoader(getClass().getResource("FXMLafficheSuggestion.fxml"));
        Parent root= loader.load();
        txtsuggestion.getScene().setRoot(root);
     
    }
}