/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;
import edu.gestionEvenement.entities.user;
        import java.util.List;

import edu.gestionEvenement.utlis.myConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author medam
 */
public class crud implements Interfaceuser<user>{
Connection cnx = myConnexion.getinstance().getConnection();

    @Override
    public void ajouteruser(user p) {
System.out.println(p);
    try {
        String req="INSERT INTO `user` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
PreparedStatement pst= cnx.prepareStatement(req);
       pst.setInt(1,p.getId_user());
        pst.setString(2, p.getNom_user());
                pst.setString(3, p.getPrenom_user());
                        pst.setString(4, p.getRole());
            pst.setString(5, p.getPassword());
        pst.setString(6, p.getEmail());
                pst.setString(7, p.getPoste());
         pst.setInt(8, p.getNum_carte_bancaire());
            pst.setInt(9, p.getTel());
               pst.setString(10, p.getLieu_ns());
                   pst.setString(11,p.getCivilité());
                    pst.setString(12, p.getDate_ne());
  pst.setString(13, p.getSituation());

        pst.executeUpdate();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }

    }

    @Override
    public void modifieruser(user p) {

    try {
        String reqq="UPDATE `user` SET nom_user=?,prenom_user=?,role=?,"
                + "password=?,email=?,poste=?,num_carte_bancaire=?,tel=?,lieu_ns=?,"
                + "civilité=?,date_ne=?,situation=? WHERE id_user =?";

  PreparedStatement pst= cnx.prepareStatement(reqq);
       pst.setInt(13,p.getId_user());
       pst.setString(1, p.getNom_user());
       pst.setString(2, p.getPrenom_user());
       pst.setString(3, p.getRole());
       pst.setString(4, p.getPassword());
       pst.setString(5, p.getEmail());
       pst.setString(6, p.getPoste());
       pst.setInt(7, p.getNum_carte_bancaire());
       pst.setInt(8, p.getTel());
       pst.setString(9, p.getLieu_ns());
       pst.setString(10,p.getCivilité());
       pst.setString(11, p.getDate_ne());
       pst.setString(12, p.getSituation());
       pst.executeUpdate();
       
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    }

    @Override
    public void supprimeruser(int id) {
  try {
        String req=" DELETE FROM `user` WHERE id_user="+ id ;

        PreparedStatement St = cnx.prepareStatement(req);
        St.executeUpdate();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }    }

    @Override
    public List<user> aficheruser() {
  
List <user> list = new ArrayList<>();
 try {
String req = "SELECT * from user";        
Statement st;
st =cnx.createStatement();
ResultSet rs = st.executeQuery(req);
while(rs.next()){
user e = new user (rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getInt(8),rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
list.add(e);
}
}
catch (SQLException ex){
    System.err.println(ex.getMessage());
}
return list;
    }
    public ArrayList<user> RechercheNom2(String nom_user) {
        
        ArrayList<user> user = new ArrayList<>();
        String requete = "select * from user where nom_user ='"+nom_user+"' " ;
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
user e = new user (rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getInt(8),rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
user.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
        }
        return user ;
    }
}

