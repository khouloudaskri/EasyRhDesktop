/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;

/**
 *
 * @author Mohamed cherif
 */
import edu.gestionEvenement.entities.Conge;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import  edu.gestionEvenement.utlis.myConnexion;

////////////


public class demandeconge_CRUD implements interfacedemandeconge_CRUD{
    
    Connection conx = myConnexion.getinstance().getConnection();
    
    @Override
    public void ajouterdemande_conge(Conge C) {

        String req = "INSERT INTO `congé`(`Nom_employe`, `datedep`, `dateretour`, `nb_jours`, `type`, `motif`) "
                + "VALUES ('"+C.getNom_employe()+"','"+C.getDatedep()+"','"+C.getDateretour()+"','"+C.getNb_jours()+"','"+C.getType()+"','"+C.getMotif()+"')" ;
        try { 
        Statement st= conx.createStatement()   ;
        st.executeUpdate(req) ;
            System.out.println("demande ajoutée avec succés");
        }catch (SQLException ex) {
            //System.err.println(ex.getMessage());
         Logger.getLogger(demandeconge_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
    public void accepterdemande(Conge D) {
         String req = "INSERT INTO `congé`(`Nom_employe`, `datedep`, `dateretour`, `nb_jours`, `type`, `motif`,`etat`) "
                + "VALUES ('"+D.getNom_employe()+"','"+D.getDatedep()+"','"+D.getDateretour()+"','"+D.getNb_jours()+"','"+D.getType()+"','"+D.getMotif()+"','"+"Accepté"+"')" ;
        try { 
        Statement st= conx.createStatement()   ;
        st.executeUpdate(req) ;
            System.out.println("demande Accepté");
        }catch (SQLException ex) {          
         Logger.getLogger(demandeconge_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
     public void refuserdemande(Conge D) {
         String req = "INSERT INTO `congé`(`Nom_employe`, `datedep`, `dateretour`, `nb_jours`, `type`, `motif`,`etat`) "
                + "VALUES ('"+D.getNom_employe()+"','"+D.getDatedep()+"','"+D.getDateretour()+"','"+D.getNb_jours()+"','"+D.getType()+"','"+D.getMotif()+"','"+"Refusé"+"')" ;
        try { 
        Statement st= conx.createStatement()   ;
        st.executeUpdate(req) ;
            System.out.println("demande refusé");
        }catch (SQLException ex) {
            //System.err.println(ex.getMessage());
         Logger.getLogger(demandeconge_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
  

     @Override
    public void modifierdemande_conge(Conge C ) {
        try {
       String update = "UPDATE `congé` SET datedep=?,dateretour=?,nb_jours=?,type=?,motif=? WHERE id_conge = ?" ;
        PreparedStatement st = conx.prepareStatement(update);
         
         st.setInt(6,C.getId_conge());
         st.setString(1,C.getDatedep());
         st.setString(2,C.getDateretour());
         st.setString(3,C.getNb_jours());
         st.setString(4,C.getType());
         st.setString(5,C.getMotif());
         
      
        st.executeUpdate() ;
        System.out.println("La demande est modifiée avec succés ");}
        catch (SQLException ex) {
           Logger.getLogger(demandeconge_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     @Override
    public void supprimerdemande_conge(int id_conge) {

    try {
        String delete=" DELETE FROM `congé` WHERE `id_conge` ='"+id_conge+"' " ;     
        PreparedStatement St = conx.prepareStatement(delete);
        St.executeUpdate();
        System.out.println("Demande supprimée");
    } catch (SQLException ex) {
           Logger.getLogger(demandeconge_CRUD.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
        

    @Override
    public List<Conge> Afficherdemande_conge() {

    List <Conge> list = new ArrayList<>();
        try {
    String affiche= "SELECT * FROM `congé` WHERE Nom_employe";        
    PreparedStatement st = conx.prepareStatement(affiche);
    ResultSet rs =st.executeQuery();
    while(rs.next()){
    list.add(new Conge(rs.getInt("id_conge"),rs.getString("Nom_employe"),rs.getDate("datedemande"),rs.getString("datedep"),rs.getString("dateretour"),rs.getString("nb_jours"),rs.getString("type"),rs.getString("motif"),rs.getString("etat")));

              }
        }catch (SQLException ex){
    Logger.getLogger(demandeconge_CRUD.class.getName()).log(Level.SEVERE, null, ex);
}
        
    return list;
    } 
    
     public List <Conge> getalldemande_conge(String Nom_employe) throws SQLException {
   
    List <Conge> listdemande = new ArrayList();  
    String affiche= "SELECT `id_conge`,`date de demande`, `datedep`, `dateretour`, `nb_jours`, `type`, `motif`,`etat` FROM `congé` WHERE Nom_employe='"+Nom_employe+"'";        
    Statement st = conx.createStatement() ;
    ResultSet rs = st.executeQuery(affiche) ;
        Conge mesdemandes ;
    while(rs.next()){
         mesdemandes = new Conge(rs.getInt("id_conge"),rs.getDate("date de demande"),rs.getString("datedep"),rs.getString("dateretour"),rs.getString("nb_jours"),rs.getString("type"),rs.getString("motif"),rs.getString("etat"));
         listdemande.add(mesdemandes);
              }
        return listdemande ;
    
    } 
     
     public List <Conge> getalldemande_conge2() throws SQLException {
   
    List <Conge> listdemande = new ArrayList();  
    String affiche= "SELECT * FROM `congé`";        
    Statement st = conx.createStatement() ;
    ResultSet rs = st.executeQuery(affiche) ;
        Conge mesdemandes ;
    while(rs.next()){
         mesdemandes = new Conge(rs.getInt("id_conge"),rs.getString("Nom_employe"),rs.getDate("Date de Demande"),rs.getString("datedep"),rs.getString("dateretour"),rs.getString("nb_jours"),rs.getString("type"),rs.getString("motif"),rs.getString("etat"));
         listdemande.add(mesdemandes);
              }
        return listdemande ;
    
    } 
     
     
      public ArrayList<Conge> RechercheNom2(String Nom_employe) {
        
        ArrayList<Conge> cng = new ArrayList<>();
        String requete = "select * from Congé where Nom_Employe ='"+Nom_employe+"' " ;
        try {
            PreparedStatement pst = conx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                cng.add(new Conge(rs.getInt("id_conge"),rs.getString("Nom_employe"),rs.getDate("Date de Demande"),rs.getString("datedep"),rs.getString("dateretour"),rs.getString("nb_jours"),rs.getString("type"),rs.getString("motif"),rs.getString("etat")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
        }
        return cng;
    }

}


