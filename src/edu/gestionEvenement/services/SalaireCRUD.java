
package edu.gestionEvenement.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.gestionEvenement.entities.Salaire;
import edu.gestionEvenement.utlis.myConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win 10
 */
public class SalaireCRUD implements InterfaceSalaire <Salaire > {
    Connection cnx;


    public SalaireCRUD() {
        cnx = myConnexion.getinstance().getConnection();
    }
     
    
   

    public void ajoutersalaire(Salaire s) {
        
        String req ;
        req = "INSERT INTO `salaire`(`id_employe`,`nom_employe`,`prenom_employe`,`date_salaire`,`mois`,`montant`,`heures_travail` ) VALUES ('"+s.getId_employe()+"','"+s.getNom_employe()+"','"+s.getPrenom_employe()+"','"+s.getDate_salaire()+"','"+s.getMois()+"','"+s.getMontant()+"','"+s.getHeures_travail()+"')";
        
        try {
           Statement st=cnx.createStatement();
            st.executeUpdate(req);}
        
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        
        }
       
    }
    
    
    
    
   public List<Salaire> affichersalaire() {

 List <Salaire> list = new ArrayList<>();
 try {
String req = "SELECT * FROM `salaire`";        
Statement st;
st =cnx.createStatement();
ResultSet rs = st.executeQuery(req);
while(rs.next()){
Salaire s = new Salaire(rs.getDouble(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
 list.add(s);}
}
catch (SQLException ex){
    System.err.println(ex.getMessage());
}
return list;
    }
   
   public ArrayList<Salaire> RechercheNom(String x) {
        
        ArrayList<Salaire> Salaires = new ArrayList<>();
        String requete = "select * from Salaire where id_employe ='"+x+"'";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Salaires.add(new Salaire( rs.getDouble(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        } catch (SQLException ex) {
           System.out.println("Erreur lors d'extraction des données " + ex.getMessage());
        }
        return Salaires ;   
}
   
   
   
  
    
    
    
    
 
    public void supprimersalaire(String id_employe) {
          try {
        String req=" DELETE FROM salaire WHERE id_employe="+ id_employe ;

        PreparedStatement St = cnx.prepareStatement(req);
        St.executeUpdate();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    }   
    

 

   
    
    public void modifiersalaire(Salaire s) {
       

try { 
            String requete = "UPDATE `salaire` SET id_employe =?, nom_employe=?,prenom_employe=?,"
                    + " date_salaire=?, mois =? , montant =? ,heures_travail =? WHERE id_Salaire= ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
       
            pst.setDouble(8,s.getId_Salaire());
            pst.setString(1,s.getId_employe());
            pst.setString(2,s.getNom_employe());
            pst.setString(3,s.getPrenom_employe());
            pst.setString(4,s.getDate_salaire());
            pst.setString(5,s.getMois());
            pst.setString(6,s.getMontant());
            pst.setString(7,s.getHeures_travail());

            pst.executeUpdate();
            System.out.println("Evenement modifié avec succés \n ");
        } catch (SQLException ex) {
            System.err.println( "erreur lors de la modification " + ex.getMessage());
        }}
}