/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;


import edu.gestionEvenement.entities.user;
import edu.gestionEvenement.services.crud;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author KHOULOUD
 */
public class FXMLacccController implements Initializable {
@FXML
    private Button ajout;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField poste;
    @FXML
    private TextField password;
    @FXML
    private DatePicker daten;
    @FXML
    private ComboBox role;
    @FXML
    private TextField tel;
    @FXML
    private TextField numcarte;
    @FXML
    private TextField situation;
    @FXML
    private TextField civilite;
    @FXML
    private TextField lieuxn;
    @FXML
    private TableView<user> view;
    @FXML
    private TableColumn<user, Integer> idt;
    @FXML
    private TableColumn<user, String> nomt;
    @FXML
    private TableColumn<user, String> prenomt;
    @FXML
    private TableColumn<user, String> Rolet;
    @FXML
    private TableColumn<user, String> Passt;
    @FXML
    private TableColumn<user, String> emailt;
    @FXML
    private TableColumn<user, String> postet;
    @FXML
    private TableColumn<user, Integer> cartet;
    @FXML
    private TableColumn<user, Integer> telt;
    @FXML
    private TableColumn<user, String> lieut;
    @FXML
    private TableColumn<user, String> civt;
    @FXML
    private TableColumn<user, String> datet;
    @FXML
    private TableColumn<user, String> sitt;
    @FXML
    private Button affii;
    @FXML
    private Button supp;
    @FXML
    private Button ret;
    @FXML
    private TextField cher;
    @FXML
    private Button search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     ObservableList<String> list  = FXCollections.observableArrayList("Responsable" , "Employee","Candidat") ;
       role.setItems(list);
        view.setEditable(true);
      nomt.setCellFactory(TextFieldTableCell.forTableColumn());
       view.setEditable(true);
               prenomt.setCellFactory(TextFieldTableCell.forTableColumn());
       view.setEditable(true);
               Rolet.setCellFactory(TextFieldTableCell.forTableColumn());
        view.setEditable(true);
               Passt.setCellFactory(TextFieldTableCell.forTableColumn());
       view.setEditable(true);
              emailt.setCellFactory(TextFieldTableCell.forTableColumn());
        view.setEditable(true);
            postet.setCellFactory(TextFieldTableCell.forTableColumn());
        view.setEditable(true);
       //      cartet.setCellFactory(TextFieldTableCell.forTableColumn());
        view.setEditable(true);
      //          telt.setCellFactory(TextFieldTableCell.forTableColumn());
      //  view.setEditable(true);
                  lieut.setCellFactory(TextFieldTableCell.forTableColumn());
       // view.setEditable(true);
                   civt.setCellFactory(TextFieldTableCell.forTableColumn());
       // view.setEditable(true);
                 datet.setCellFactory(TextFieldTableCell.forTableColumn());
       // view.setEditable(true);
                   sitt.setCellFactory(TextFieldTableCell.forTableColumn());
      //  view.setEditable(true);
        
    }    
    

      

   @FXML
   private void supU(ActionEvent event) {
          view.getItems().removeAll(view.getSelectionModel().getSelectedItems());
              user E  = view.getSelectionModel().getSelectedItem();
       
        crud cr = new crud();
        cr.supprimeruser(E.getId_user());
    }
    @FXML
     void AfichU(ActionEvent event) {
        crud ps = new crud();
        ArrayList<user> users;

            users = (ArrayList<user>) ps.aficheruser();
            ObservableList obs = FXCollections.observableArrayList(users);
            view.setItems(obs);
            idt.setCellValueFactory(new PropertyValueFactory<>("id_user"));
           nomt.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
           prenomt.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
          Rolet.setCellValueFactory(new PropertyValueFactory<>("role"));
          Passt.setCellValueFactory(new PropertyValueFactory<>("password"));
           emailt.setCellValueFactory(new PropertyValueFactory<>("email"));
           postet.setCellValueFactory(new PropertyValueFactory<>("poste"));
            cartet.setCellValueFactory(new PropertyValueFactory<>("num_carte_bancaire"));
           telt.setCellValueFactory(new PropertyValueFactory<>("tel"));
           lieut.setCellValueFactory(new PropertyValueFactory<>("lieu_ns"));
           civt.setCellValueFactory(new PropertyValueFactory<>("civilité"));
           datet.setCellValueFactory(new PropertyValueFactory<>("date_ne"));
           sitt.setCellValueFactory(new PropertyValueFactory<>("situation"));

   
     }
     
         @FXML
    private void AjoutUu (ActionEvent event) throws ParseException  {
    
       String nomu,prenomu,emailu,posteu,roleu,passwordu,telu,numcarteu,situationu,civiliteu,lieuxnu;
       String datenu;
      
       nomu= nom.getText();
       prenomu= prenom.getText();
       roleu= role.getSelectionModel().getSelectedItem().toString();
       passwordu= password.getText();
       emailu= email.getText();
       posteu= poste.getText();
       numcarteu=numcarte.getText();
       telu=tel.getText();
       lieuxnu= lieuxn.getText();
       civiliteu= civilite.getText();
       datenu= daten.getValue().toString();      
       situationu= situation.getText();

               if (nom.getText().isEmpty() || prenom.getText().isEmpty()||password.getText().isEmpty()|| email.getText().isEmpty()
                       || poste.getText().isEmpty()|| numcarte.getText().isEmpty()|| tel.getText().isEmpty()||
                        lieuxn.getText().isEmpty()|| civilite.getText().isEmpty()|| situation.getText().isEmpty()||daten.getValue().toString().isEmpty()||role.getSelectionModel().getSelectedItem().toString().isEmpty())
   {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setHeaderText("Veuillez remplir tous les champs");
                     alert.showAndWait();}
       
               else {
       user E =new user(nomu,prenomu,roleu,passwordu,emailu,posteu,Integer.parseInt(numcarteu),Integer.parseInt(telu),lieuxnu,civiliteu,datenu,situationu);
         crud ps = new crud();
         ps.ajouteruser(E);
         JOptionPane.showMessageDialog(null,"Utilisateur ajouté");
               }
  
    }

    @FXML
    private void Editnom(TableColumn.CellEditEvent edittedCell) {
         if(nomt.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
         
          else{
        user E  = view.getSelectionModel().getSelectedItem();
        E.setNom_user(edittedCell.getNewValue().toString());
        crud cr = new crud();
        cr.modifieruser(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!");
    }
    }

    @FXML
    private void editprenom(TableColumn.CellEditEvent edittedCell) {
        if(prenomt.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
         
          else{
        user E  = view.getSelectionModel().getSelectedItem();
        E.setPrenom_user(edittedCell.getNewValue().toString());
        crud cr = new crud();
        cr.modifieruser(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!");
    }
    }

    @FXML
    private void editrole(TableColumn.CellEditEvent edittedCell) {
         if(Rolet.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
         
          else{
        user E  = view.getSelectionModel().getSelectedItem();
        E.setRole(edittedCell.getNewValue().toString());
        crud cr = new crud();
        cr.modifieruser(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!");
    }
    }

    @FXML
    private void editpass(TableColumn.CellEditEvent edittedCell) {
         if(Passt.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
         
          else{
        user E  = view.getSelectionModel().getSelectedItem();
        E.setPassword(edittedCell.getNewValue().toString());
        crud cr = new crud();
        cr.modifieruser(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!");
    }
    }

    @FXML
    private void editposte(TableColumn.CellEditEvent edittedCell) {
         if(postet.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
         
          else{
        user E  = view.getSelectionModel().getSelectedItem();
        E.setPoste(edittedCell.getNewValue().toString());
        crud cr = new crud();
        cr.modifieruser(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!");
    }
    }

    @FXML
    private void editlieu(TableColumn.CellEditEvent edittedCell) {
         if(lieut.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
         
          else{
        user E  = view.getSelectionModel().getSelectedItem();
        E.setLieu_ns(edittedCell.getNewValue().toString());
        crud cr = new crud();
        cr.modifieruser(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!");
    }
    }

    @FXML
    private void editciv(TableColumn.CellEditEvent edittedCell) {
                if(civt.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
         
          else{
        user E  = view.getSelectionModel().getSelectedItem();
        E.setCivilité(edittedCell.getNewValue().toString());
        crud cr = new crud();
        cr.modifieruser(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!");
    }
    }

    @FXML
    private void editdate(TableColumn.CellEditEvent edittedCell) {
                if(datet.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
         
          else{
        user E  = view.getSelectionModel().getSelectedItem();
        E.setDate_ne(edittedCell.getNewValue().toString());
        crud cr = new crud();
        cr.modifieruser(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!");
    }
    }

    @FXML
    private void editsit(TableColumn.CellEditEvent edittedCell) {
                if(sitt.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Please fill in the empty field");
            a.showAndWait();
        }
         
          else{
        user E  = view.getSelectionModel().getSelectedItem();
        E.setSituation(edittedCell.getNewValue().toString());
        crud cr = new crud();
        cr.modifieruser(E);
        JOptionPane.showMessageDialog(null, "Modifier avec succès !!");
    }
    }

    @FXML
    private void retourr(ActionEvent event) {
        try {

Parent page1 =
FXMLLoader.load(getClass().getResource("login.fxml"
));

Scene scene = new Scene(page1);

Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

stage.setScene(scene);

stage.show();

} catch (IOException ex) {

Logger.getLogger(FXMLacccController.class.getName()).log(Level.SEVERE,
null, ex);

}


    }

    @FXML
    private void cheru(ActionEvent event) {
            
         crud c =new  crud ();
        ArrayList<user> user;
        user = (ArrayList<user>) c.RechercheNom2(cher.getText());
        ObservableList obs = FXCollections.observableArrayList(user);
        view.setItems(obs);
         idt.setCellValueFactory(new PropertyValueFactory<>("id_user"));
           nomt.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
           prenomt.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
          Rolet.setCellValueFactory(new PropertyValueFactory<>("role"));
          Passt.setCellValueFactory(new PropertyValueFactory<>("password"));
           emailt.setCellValueFactory(new PropertyValueFactory<>("email"));
           postet.setCellValueFactory(new PropertyValueFactory<>("poste"));
            cartet.setCellValueFactory(new PropertyValueFactory<>("num_carte_bancaire"));
           telt.setCellValueFactory(new PropertyValueFactory<>("tel"));
           lieut.setCellValueFactory(new PropertyValueFactory<>("lieu_ns"));
           civt.setCellValueFactory(new PropertyValueFactory<>("civilité"));
           datet.setCellValueFactory(new PropertyValueFactory<>("date_ne"));
           sitt.setCellValueFactory(new PropertyValueFactory<>("situation"));

   
   
    }
    }