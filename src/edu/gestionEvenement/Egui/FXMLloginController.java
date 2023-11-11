/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.Egui;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import edu.gestionEvenement.utlis.myConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * FXML Controller class
 *
 * @author KHOULOUD
 */
public class FXMLloginController implements Initializable {

    @FXML
    private TextField emailt;
    @FXML
    private PasswordField passwordt;
    @FXML
    private Button log;
    @FXML
    private Button forgetmpsword;
    @FXML
    private Label setlabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
               PreparedStatement pst = null;

               PreparedStatement ps = null;
       Connection cnx = myConnexion.getinstance().getConnection();
       ResultSet rs = null,rss = null;
       try {
                        ps = cnx.prepareStatement("SELECT email FROM user WHERE email=? AND password =? AND role like '"+"Responsable"+"' ");
                        ps.setString(1, emailt.getText());
                        ps.setString(2, passwordt.getText());
                        rs = ps.executeQuery();
                        pst = cnx.prepareStatement("SELECT email FROM user WHERE email=? AND password =? AND role like '"+"Employee"+"' ");
                        pst.setString(1, emailt.getText());
                        pst.setString(2, passwordt.getText());
                        rss = pst.executeQuery();
     if (rs.next()) { 
   try {

Parent page1 =
FXMLLoader.load(getClass().getResource("FXMLaccc.fxml"));

Scene scene = new Scene(page1);

Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

stage.setScene(scene);

stage.show();

} catch (IOException ex) {

Logger.getLogger(FXMLacccController.class.getName()).log(Level.SEVERE,
null, ex);

}}
     else if(rss.next()){
            try {

Parent page1 =
FXMLLoader.load(getClass().getResource("FXMLemployee.fxml"));

Scene scene = new Scene(page1);

Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

stage.setScene(scene);

stage.show();

} catch (IOException ex) {

Logger.getLogger(FXMLacccController.class.getName()).log(Level.SEVERE,
null, ex);

}
           
           
           
           }
else {
   Alert alert = new Alert(Alert.AlertType.ERROR);
   alert.setTitle("Failed");
   alert.setHeaderText("Attention !!");
  alert.setContentText("Can not connect to EasyRH");
   alert.show();
   }
 
                    } catch (SQLException e) {
                        e.printStackTrace();
    }
     
  
       
    }

    @FXML
    private void passwordforget(ActionEvent event) throws SQLException, MessagingException {
        String myAccountEmail = "gannouni.mohamedamine@esprit.tn";
        String password="213JMT4722";
        String pass;
        
       Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
       
        
         Connection cnx = myConnexion.getinstance().getConnection();
                     PreparedStatement ps = null;
   ResultSet rs = null;   
    ps = cnx.prepareStatement("SELECT password FROM user WHERE email= '"+ emailt.getText() +"'");
 rs=ps.executeQuery();
   if(rs.next()){
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
           
        } );
         
        Message message = prepareMessage(session,myAccountEmail,emailt.getText(),rs.getString("password"));
        Transport.send(message);
        System.out.println("message sent successfully");
       // return true;
       Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText(null);
            a.setContentText("Go check you email you password send there");
            a.showAndWait();
       
    }}
   private static Message prepareMessage(Session session, String myAccountEmail, String recepient,String pass){
        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(recepient));
           
            message.setSubject("your password  ");
            message.setText(" your password is  "+pass);
            return message;
        } catch (Exception ex) {
            System.out.println(ex);   }
        return null;
    }

    }
    
