/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;

import edu.gestionEvenement.entities.Conge;
import edu.gestionEvenement.entities.SoldeConge;
import edu.gestionEvenement.services.JavaMailUtil;
import edu.gestionEvenement.services.Solde_CRUD;
import edu.gestionEvenement.services.demandeconge_CRUD;
import edu.gestionEvenement.utlis.myConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author KHOULOUD
 */
public class TraitementDemande_CongeController implements Initializable {

    @FXML
    private Button accepter;

    @FXML
    private TextField barrederecherche;

    @FXML

    private TableColumn<Conge, Integer> coidconge;

    @FXML
    private TableColumn<SoldeConge, String> colannuel1;


    @FXML
    private TableColumn<SoldeConge, String> colcompensation1;

    @FXML
    private TableColumn<Conge, String> coldatedemande;

    @FXML
    private TableColumn<SoldeConge, String> coldatedep;

    @FXML
    private TableColumn<SoldeConge, String> coldateret;

    @FXML
    private TableColumn<Conge, String> coletatt;

    @FXML
    private TableColumn<SoldeConge, String> colexception1;

    @FXML
    private TableColumn<SoldeConge, Integer> colidsolde1;

    @FXML
    private TableColumn<SoldeConge, String> colmaladie1;

    @FXML
    private TableColumn<Conge, String> colmotiff;

    @FXML
    private TableColumn<Conge, String> colnbjr;

    @FXML
    private TableColumn<Conge, String> colnom;

    @FXML
    private TableColumn<SoldeConge, String> colnomem;

    @FXML
    private TableColumn<Conge, String> coltypee;

    @FXML
    private Button refresh;

    @FXML
    private Button refuser;

    @FXML
    private Button search;

    @FXML
    private Button soldjout;

    @FXML
    private TableView<?> tvsolde;

    @FXML
    private TableView<?> tvtraitement;

        Connection conx = myConnexion.getinstance().getConnection() ;
    @FXML
    private Button janvier;
    @FXML
    private Button fevrier;
    @FXML
    private Button mars;
    @FXML
    private Button avril;
    @FXML
    private Button mai;
    @FXML
    private Button juin;
    @FXML
    private Button juillet;
    @FXML
    private Button aout;
    @FXML
    private Button septembre;
    @FXML
    private Button octobre;
    @FXML
    private Button novembre;
    @FXML
    private Button decembre;
    
    @FXML
    private ImageView janvier1;
    javafx.scene.image.Image jan = new  javafx.scene.image.Image("/gestion_solde/Calendrier/janvier.jpg");
    
    @FXML
    private ImageView fevrier1;
    javafx.scene.image.Image fev = new  javafx.scene.image.Image("/gestion_solde/Calendrier/fevrier.jpg");
    
    @FXML
    private ImageView mars1;
    javafx.scene.image.Image mar = new  javafx.scene.image.Image("/gestion_solde/Calendrier/mars.jpg");

    @FXML
    private ImageView avril1;
    javafx.scene.image.Image avr = new  javafx.scene.image.Image("/gestion_solde/Calendrier/avril.jpg");

    @FXML
    private ImageView mai1;
    javafx.scene.image.Image ma = new  javafx.scene.image.Image("/gestion_solde/Calendrier/mai.jpg");

    @FXML
    private ImageView juin1;
    javafx.scene.image.Image jui = new  javafx.scene.image.Image("/gestion_solde/Calendrier/juin.jpg");

    @FXML
    private ImageView juillet1;
    javafx.scene.image.Image juil = new  javafx.scene.image.Image("/gestion_solde/Calendrier/juillet.jpg");

    @FXML
    private ImageView aout1;
    javafx.scene.image.Image aou = new  javafx.scene.image.Image("/gestion_solde/Calendrier/aout.jpg");

    @FXML
    private ImageView septembre1;
    javafx.scene.image.Image sep = new  javafx.scene.image.Image("/gestion_solde/Calendrier/septembre.jpg");

    @FXML
    private ImageView octobre1;
    javafx.scene.image.Image oct = new  javafx.scene.image.Image("/gestion_solde/Calendrier/octobre.jpg");

    @FXML
    private ImageView novembre1;
    javafx.scene.image.Image nov = new  javafx.scene.image.Image("/gestion_solde/Calendrier/novombre.jpg");

    @FXML
    private ImageView decembre1;
    javafx.scene.image.Image dec = new  javafx.scene.image.Image("/gestion_solde/Calendrier/dicembre.jpg");


    @FXML
    void bt_AccepterConge(ActionEvent event) {
       Conge C  = (Conge) tvtraitement.getSelectionModel().getSelectedItem() ; 
       demandeconge_CRUD dc = new demandeconge_CRUD (); 
       dc.accepterdemande(C);
       tvtraitement.getItems().removeAll(tvtraitement.getSelectionModel().getSelectedItems() );
       dc.supprimerdemande_conge(C.getId_conge());
       
        ArrayList<Conge> demandes;
        try {
            demandes = (ArrayList<Conge>) dc.getalldemande_conge2();
            ObservableList obs = FXCollections.observableArrayList(demandes);
         tvtraitement.setItems(obs);
         coidconge.setCellValueFactory(new PropertyValueFactory<>("id_conge"));
         colnom.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
         coldatedemande.setCellValueFactory(new PropertyValueFactory<>("datedemande"));
         coldatedep.setCellValueFactory(new PropertyValueFactory<>("datedep"));
         coldateret.setCellValueFactory(new PropertyValueFactory<>("dateretour"));
         colnbjr.setCellValueFactory(new PropertyValueFactory<>("nb_jour"));
         coltypee.setCellValueFactory(new PropertyValueFactory<>("type"));
         colmotiff.setCellValueFactory(new PropertyValueFactory<>("motif"));
         coletatt.setCellValueFactory(new PropertyValueFactory<>("etat"));

         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
          try {
              JavaMailUtil jm = new JavaMailUtil () ;
              JavaMailUtil.sendMailaccepter("cherif.mohamed@esprit.tn");
          } catch (Exception ex) {
              Logger.getLogger(TraitementDemande_CongeController.class.getName()).log(Level.SEVERE, null, ex);
          }
       
    }
  
    @FXML
    void bt_Ajoutrsold(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("AjoutSolde.fxml"));
        Parent root= loader.load();
        soldjout.getScene().setRoot(root);
     
    }

    @FXML
    void bt_RefuserConge(ActionEvent event) {
      Conge C  = (Conge) tvtraitement.getSelectionModel().getSelectedItem() ; 
       demandeconge_CRUD dr = new demandeconge_CRUD (); 
       dr.refuserdemande(C);
       tvtraitement.getItems().removeAll(tvtraitement.getSelectionModel().getSelectedItems() );
       dr.supprimerdemande_conge(C.getId_conge());
       
        ArrayList<Conge> demandes;
        try {
            demandes = (ArrayList<Conge>) dr.getalldemande_conge2();
            ObservableList obs = FXCollections.observableArrayList(demandes);
         tvtraitement.setItems(obs);
         coidconge.setCellValueFactory(new PropertyValueFactory<>("id_conge"));
         colnom.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
         coldatedemande.setCellValueFactory(new PropertyValueFactory<>("datedemande"));
         coldatedep.setCellValueFactory(new PropertyValueFactory<>("datedep"));
         coldateret.setCellValueFactory(new PropertyValueFactory<>("dateretour"));
         colnbjr.setCellValueFactory(new PropertyValueFactory<>("nb_jour"));
         coltypee.setCellValueFactory(new PropertyValueFactory<>("type"));
         colmotiff.setCellValueFactory(new PropertyValueFactory<>("motif"));
         coletatt.setCellValueFactory(new PropertyValueFactory<>("etat"));

         } catch (SQLException ex) {
            Logger.getLogger(TraitementDemande_CongeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
              JavaMailUtil jm = new JavaMailUtil () ;
              JavaMailUtil.sendMailrefuser("cherif.mohamed@esprit.tn");
          } catch (Exception ex) {
              Logger.getLogger(TraitementDemande_CongeController.class.getName()).log(Level.SEVERE, null, ex);
          }

    }

    @FXML
    void bt_chercher1(ActionEvent event) {
        Solde_CRUD c =new  Solde_CRUD ();
        ArrayList<SoldeConge> soldes;
        soldes = (ArrayList<SoldeConge>) c.RechercheNom(barrederecherche.getText());
        ObservableList obs = FXCollections.observableArrayList(soldes);
        tvsolde.setItems(obs);
        colidsolde1.setCellValueFactory(new PropertyValueFactory<>("id_solde"));
        colnomem.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
        colcompensation1.setCellValueFactory(new PropertyValueFactory<>("solde_compensation"));
        colmaladie1.setCellValueFactory(new PropertyValueFactory<>("solde_maladie"));
        colexception1.setCellValueFactory(new PropertyValueFactory<>("solde_exception")); 
        colannuel1.setCellValueFactory(new PropertyValueFactory<>("solde_annuel")); 
        
        demandeconge_CRUD dcc = new demandeconge_CRUD () ;
        ArrayList<Conge> congi ;
        congi = (ArrayList<Conge>) dcc.RechercheNom2(barrederecherche.getText());
        ObservableList obw = FXCollections.observableArrayList(congi);
         tvtraitement.setItems(obw);
         coidconge.setCellValueFactory(new PropertyValueFactory<>("id_conge"));
         colnom.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
         coldatedemande.setCellValueFactory(new PropertyValueFactory<>("datedemande"));
         coldatedep.setCellValueFactory(new PropertyValueFactory<>("datedep"));
         coldateret.setCellValueFactory(new PropertyValueFactory<>("dateretour"));
         colnbjr.setCellValueFactory(new PropertyValueFactory<>("nb_jour"));
         coltypee.setCellValueFactory(new PropertyValueFactory<>("type"));
         colmotiff.setCellValueFactory(new PropertyValueFactory<>("motif"));
         coletatt.setCellValueFactory(new PropertyValueFactory<>("etat"));
       
    }

    @FXML
    void bt_update(ActionEvent event) {
        Solde_CRUD sc = new Solde_CRUD();
        ArrayList<SoldeConge> soldes;
        try {
            soldes = (ArrayList<SoldeConge>) sc.getallsolde1();
            ObservableList ocs = FXCollections.observableArrayList(soldes);
         tvsolde.setItems(ocs);
         colnomem.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
         colidsolde1.setCellValueFactory(new PropertyValueFactory<>("id_solde"));      
         colcompensation1.setCellValueFactory(new PropertyValueFactory<>("solde_compensation"));
         colmaladie1.setCellValueFactory(new PropertyValueFactory<>("solde_maladie"));
         colexception1.setCellValueFactory(new PropertyValueFactory<>("solde_exception"));
         colannuel1.setCellValueFactory(new PropertyValueFactory<>("solde_annuel"));
         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        demandeconge_CRUD ps = new demandeconge_CRUD();
        ArrayList<Conge> demandes;
        try {
            demandes = (ArrayList<Conge>) ps.getalldemande_conge2();
            ObservableList obs = FXCollections.observableArrayList(demandes);
         tvtraitement.setItems(obs);
         coidconge.setCellValueFactory(new PropertyValueFactory<>("id_conge"));
         colnom.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
         coldatedemande.setCellValueFactory(new PropertyValueFactory<>("datedemande"));
         coldatedep.setCellValueFactory(new PropertyValueFactory<>("datedep"));
         coldateret.setCellValueFactory(new PropertyValueFactory<>("dateretour"));
         colnbjr.setCellValueFactory(new PropertyValueFactory<>("nb_jour"));
         coltypee.setCellValueFactory(new PropertyValueFactory<>("type"));
         colmotiff.setCellValueFactory(new PropertyValueFactory<>("motif"));
         coletatt.setCellValueFactory(new PropertyValueFactory<>("etat"));

         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void getSelected(MouseEvent event) {

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Solde_CRUD sc = new Solde_CRUD();
        ArrayList<SoldeConge> soldes;
        try {
            soldes = (ArrayList<SoldeConge>) sc.getallsolde1();
            ObservableList ocs = FXCollections.observableArrayList(soldes);
         tvsolde.setItems(ocs);
         colnomem.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
         colidsolde1.setCellValueFactory(new PropertyValueFactory<>("id_solde"));      
         colcompensation1.setCellValueFactory(new PropertyValueFactory<>("solde_compensation"));
         colmaladie1.setCellValueFactory(new PropertyValueFactory<>("solde_maladie"));
         colexception1.setCellValueFactory(new PropertyValueFactory<>("solde_exception"));
         colannuel1.setCellValueFactory(new PropertyValueFactory<>("solde_annuel"));
         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // affichage tableview demande congé
        
         demandeconge_CRUD ps = new demandeconge_CRUD();
        ArrayList<Conge> demandes;
        try {
            demandes = (ArrayList<Conge>) ps.getalldemande_conge2();
            ObservableList obs = FXCollections.observableArrayList(demandes);
         tvtraitement.setItems(obs);
         coidconge.setCellValueFactory(new PropertyValueFactory<>("id_conge"));
         colnom.setCellValueFactory(new PropertyValueFactory<>("Nom_employe"));
         coldatedemande.setCellValueFactory(new PropertyValueFactory<>("datedemande"));
         coldatedep.setCellValueFactory(new PropertyValueFactory<>("datedep"));
         coldateret.setCellValueFactory(new PropertyValueFactory<>("dateretour"));
         colnbjr.setCellValueFactory(new PropertyValueFactory<>("nb_jours"));
         coltypee.setCellValueFactory(new PropertyValueFactory<>("type"));
         colmotiff.setCellValueFactory(new PropertyValueFactory<>("motif"));
         coletatt.setCellValueFactory(new PropertyValueFactory<>("etat"));
         } catch (SQLException ex) {
            Logger.getLogger(EspaceEmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void bt_janvier(ActionEvent event) {
      //  janvier1.setImage(jan) ;
    }

    @FXML
    private void bt_fevrier(ActionEvent event) {
       // fevrier1.setImage(fev);
    }

    @FXML
    private void bt_mars(ActionEvent event) {
        //mars1.setImage(mar);
    }

    @FXML
    private void bt_avril(ActionEvent event) {
       // avril1.setImage(avr);
    }
   

    @FXML
    private void bt_mai(ActionEvent event) {
       // mai1.setImage(ma);
    }

    @FXML
    private void bt_juin(ActionEvent event) {
       // juin1.setImage(jui);
    }

    @FXML
    private void bt_juillet(ActionEvent event) {
      //  juillet1.setImage(juil);
    }

    @FXML
    private void bt_aout(ActionEvent event) {
      //  aout1.setImage(aou);
    }

    @FXML
    private void bt_septembre(ActionEvent event) {
       // septembre1.setImage(sep);
    }

    @FXML
    private void bt_octobre(ActionEvent event) {
       // octobre1.setImage(oct);
    }

    @FXML
    private void bt_novembre(ActionEvent event) {
       // novembre1.setImage(nov);
    }

    @FXML
    private void bt_decembre(ActionEvent event) {
       // decembre1.setImage(dec);
    }
      
}
