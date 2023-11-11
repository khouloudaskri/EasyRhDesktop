/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Mohamed cherif
 */
public class JavaMailUtil {
    
        public static void sendMailaccepter(String recepient) throws Exception{
        System.out.println("Envoi des emails en cours de traitement");
        Properties properties= new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String myAccountEmail="cherif.mohamed@esprit.tn";
        String password="211JMT4039";
        
        Session session=Session.getInstance(properties, new Authenticator(){
            @Override
           protected PasswordAuthentication getPasswordAuthentication(){
           return new PasswordAuthentication(myAccountEmail,password);
           }
        });
        javax.mail.Message message= prepareMessageA(session,myAccountEmail,recepient);

          Transport.send(message);
        System.out.println("Message envoyée");
                 
        }

    private static javax.mail.Message prepareMessageA(Session session, String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            javax.mail.Message message= new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Resultat traitement conge");
            message.setText("Bonjour [Nom_employe],\n" +
    "\n" +
    "la direction vous informe que votre demande de congé à été acceptée.\n" +
    "\n" +
    "[Votre signature] ");
            return message;
  
    }
    
    public static void sendMailrefuser(String recepient) throws Exception{
        System.out.println("Envoi des emails en cours de traitement");
        Properties properties= new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String myAccountEmail="cherif.mohamed@esprit.tn";
        String password="211JMT4039";
        
        Session session=Session.getInstance(properties, new Authenticator(){
            @Override
           protected PasswordAuthentication getPasswordAuthentication(){
           return new PasswordAuthentication(myAccountEmail,password);
           }
        });
        javax.mail.Message message= prepareMessageR(session,myAccountEmail,recepient);

          Transport.send(message);
        System.out.println("Message envoyée");
                 
        }

    private static javax.mail.Message prepareMessageR(Session session, String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            javax.mail.Message message= new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Resultat traitement conge");
            message.setText("Bonjour [Nom_employe],\n" +
    "\n" +
    "la direction vous informe que votre demande de congé à été acceptée.\n" +
    "\n" +
    "[Votre signature] ");
            return message;
  
    }
  
  
    }
    

