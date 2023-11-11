/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;
import java.util.List;
import edu.gestionEvenement.entities.Suggestion;
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
public class suggestionCrud implements interfaceSuggestion <Suggestion> {
 Connection cnx = myConnexion.getinstance().getConnection();
    @Override
    public void ajouterS(Suggestion S) {
          System.out.println(S);
            try {
            String requete = "INSERT INTO suggestion VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, S.getNom());
            pst.setString(2, S.getSuggestions());
              
            pst.executeUpdate();
            System.out.println("Merci pour votre Suggestion !");

        }  catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Suggestion> afficherS() {
            ArrayList<Suggestion> list = new ArrayList<>(); 
        String requete = "Select * from suggestion";

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Suggestion S = new Suggestion ( rs.getString(1), rs.getString(2));
                list.add(S);
            }
        } 
        catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
        }
        return list;

    }
    
}
