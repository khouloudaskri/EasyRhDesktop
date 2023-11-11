/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;

import edu.gestionEvenement.entities.Suggestion;
import edu.gestionEvenement.services.suggestionCrud;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author KHOULOUD
 */
public class FXMLafficheSuggestionController implements Initializable {

    @FXML
    private TableColumn<Suggestion,String> tnom;
    @FXML
    private TableColumn<Suggestion,String> tsuggestions;
    @FXML
    private TableView<Suggestion> tabl;
    @FXML
    private Button iretour;
    @FXML
    private TextField destad;
    @FXML
    private TextField myad;
    @FXML
    private PasswordField password;
    @FXML
    private TextField obj;
    @FXML
    private TextArea msg;
    @FXML
    private Button send;
    @FXML
    private Label sent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   suggestionCrud ps = new suggestionCrud();
            ArrayList<Suggestion> Sug;

            Sug = (ArrayList<Suggestion>) ps.afficherS();
            ObservableList obs = FXCollections.observableArrayList(Sug);
            tabl.setItems(obs);
            tnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
           tsuggestions.setCellValueFactory(new PropertyValueFactory<>("suggestions"));
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
           FXMLLoader loader= new FXMLLoader(getClass().getResource("ajouterEvenement.fxml"));
        Parent root= loader.load();
        iretour.getScene().setRoot(root);
    }

    @FXML
    private void SendEmail(ActionEvent event) {
        if(destad.getText().isEmpty() | myad.getText().isEmpty() | password.getText().isEmpty() | obj.getText().isEmpty() |  msg.getText().isEmpty()){
            Alert ops = new Alert(Alert.AlertType.ERROR);
            ops.setHeaderText(null);
            ops.setContentText("Please fill in the empty fields");
            ops.showAndWait();
        }
        else if (!myad.getText().matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$") && !destad.getText().matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$") )
        {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Veuillez une adresse mail valide ! ");
            a2.showAndWait();
        }
     
           
            
            String destination = destad.getText();
            String myaddress = myad.getText();
            
            String username = myad.getText();
            String passwd = password.getText();
        
        
        //Mail server
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, passwd);
            }
        });
        
        try{
            //Create mail
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(myaddress));
            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(destination));
            m.setSubject(obj.getText());
            m.setText(msg.getText());

            //Send mail
            Transport.send(m);
            System.out.println("mail envoyer");
            sent.setVisible(true);
            System.out.println("Done !");
            Notifications notificationBuilder = Notifications.create()
            .title("Succes").text("Your mail has been sent !!").graphic(null).hideAfter(javafx.util.Duration.seconds(10))
               .position(Pos.CENTER_LEFT)
               .onAction(new EventHandler<ActionEvent>(){
                   public void handle(ActionEvent event)
                   {
                       System.out.println("clicked ON ");
               }});
       notificationBuilder.darkStyle();
       notificationBuilder.show();

        }   catch (MessagingException e){
            e.printStackTrace();
        }  
        
    }
    
}

