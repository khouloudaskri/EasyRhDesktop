/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;

import java.util.List;
import edu.gestionEvenement.entities.Evenement;
import edu.gestionEvenement.utlis.myConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KHOULOUD
 */
public  class evenementCrud implements interfaceEvenement<Evenement>{
    Connection cnx = myConnexion.getinstance().getConnection();
   
   public void supprimerEv(int id ) {
      
               try {
        String req=" DELETE FROM `evenement` WHERE id_Ev="+ id ;

        PreparedStatement St = cnx.prepareStatement(req);
        St.executeUpdate();
        System.out.println("Evénement supprimée avec succés  ! \n");
        
    } catch (SQLException ex) {
        System.err.println("erreur lors de la suppression \n" +ex.getMessage());
    }
        } 

    
public void ajouterEv(Evenement Ev) {
            System.out.println(Ev);
            try {
            String requete = "INSERT INTO evenement VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, Ev.getId_Ev());
            pst.setString(2, Ev.getTitre_Ev());
            pst.setString(3, Ev.getType_Ev());
            pst.setString(4, Ev.getEmplacement_Ev());
            pst.setString(5, Ev.getTheme_Ev());
            pst.setString(6, Ev.getDateD_Ev());
            pst.setString(7, Ev.getDateF_Ev());
            
        
           
            pst.executeUpdate();
            System.out.println("Evenement ajoutée !");

        }  catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
   public void modifierEv(Evenement Ev) {
       

try { 
            String requete = "UPDATE `evenement` SET titre_Ev=?, type_Ev=?,emplacement_Ev=?,theme_Ev=?,"
                    + " dateD_Ev=?, dateF_Ev =? WHERE id_Ev= ?";
             PreparedStatement pst = cnx.prepareStatement(requete);
            
       
            pst.setString(1, Ev.getTitre_Ev());
            pst.setString(2, Ev.getType_Ev());
            pst.setString(3, Ev.getEmplacement_Ev());
            pst.setString(4, Ev.getTheme_Ev());
            pst.setString(5,  Ev.getDateD_Ev());
            pst.setString(6, Ev.getDateF_Ev());
            pst.setInt(7, Ev.getId_Ev());

            pst.executeUpdate();
            System.out.println("Evenement modifié avec succés \n ");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la modification \n " + ex.getMessage());
        }
    }
       public ArrayList<Evenement> afficherEv() {
        ArrayList<Evenement> list = new ArrayList<>(); 
        String requete = "Select * from evenement";

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Evenement Ev = new Evenement( rs.getInt(1), rs.getString(2), rs.getString (3),rs.getString (4),rs.getString (5),rs.getString(6),rs.getString(7));
                list.add(Ev);
            }
        } 
        catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
        }
        return list;
    }
       public ArrayList<Evenement> RechercheNom(String x) {
        
        ArrayList<Evenement> evenements = new ArrayList<>();
        String requete = "select * from evenement where type_Ev ='"+x+"'";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                evenements.add(new Evenement( rs.getInt(1), rs.getString(2), rs.getString (3),rs.getString (4),rs.getString (5),rs.getString(6),rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
        }
        return evenements;
    }

}
