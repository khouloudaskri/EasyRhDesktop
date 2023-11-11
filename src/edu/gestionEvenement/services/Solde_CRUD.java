/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;



import edu.gestionEvenement.entities.SoldeConge;
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
 * @author Mohamed cherif
 */
public class Solde_CRUD implements InterfaceSolde_CRUD {
    Connection conx = myConnexion.getinstance().getConnection(); 
    
     // @Override
        
    @Override
    public void AjouterSolde_conge (SoldeConge S) {
        String req = "INSERT INTO `SoldeConge`( `Nom_employe`, `solde_compensation`,`solde_maladie`,`solde_exception`,`solde_annuel`) "
                + "VALUES ('" +S.getNom_employe()+ "','" +S.getSolde_compensation()+ "','" +S.getSolde_maladie()+ "','" +S.getSolde_exception()+"','" +S.getSolde_annuel()+ "') " ;
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    } 
    
     //@Override
    
     @Override
    public void ModifierSolde_Conge(SoldeConge S) {
       String req = "UPDATE `Conge` SET `Nom_employe`='"+S.getNom_employe()+"',`solde_compensation`='"+S.getSolde_compensation()+"',`solde_maladie`='"+S.getSolde_maladie()+"',`solde_exception`='" +S.getSolde_exception()+",'solde_annuel`='"+S.getSolde_annuel();
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;
        System.out.println("Solde modifié avec succés ");}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public void SupprimerSolde_Conge(String Nom_employe) {

    try {
        String req=" DELETE FROM SoldeConge WHERE Nom_employe='"+ Nom_employe+"' ";

        PreparedStatement St = conx.prepareStatement(req);
        St.executeUpdate();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    }
    
    
    @Override
    public List<SoldeConge> AfficherSolde_Conge(String Nom_employe) {

    List <SoldeConge> list = new ArrayList<>();
        try {
    String req = "SELECT * FROM  SoldeConge WHERE Nom_employe='"+Nom_employe+"'";        
    Statement st;
    st =conx.createStatement();
    ResultSet rs = st.executeQuery(req);
    while(rs.next()){
    SoldeConge s = new SoldeConge (rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) );
    list.add(s);
              }
        }
        catch (SQLException ex){
    System.err.println(ex.getMessage());
}
    return list;
    } 
    
     public List <SoldeConge> getallsolde(String Nom_employe) throws SQLException {
   
    List <SoldeConge> listdemande = new ArrayList();  
    String affiche= "SELECT * FROM soldeconge WHERE Nom_employe='"+Nom_employe+"'" ;        
    Statement st = conx.createStatement() ;
    ResultSet rs = st.executeQuery(affiche) ;
        SoldeConge listsolde ;
    while(rs.next()){
         listsolde = new SoldeConge(rs.getString("Nom_employe"),rs.getInt("id_solde"),rs.getString("solde_compensation"),rs.getString("solde_maladie"),rs.getString("solde_exception"),rs.getString("solde_annuel"));
         listdemande.add(listsolde);
              }
        return listdemande ;
    
    } 
      public List <SoldeConge> getallsolde1() throws SQLException {
   
    List <SoldeConge> listdemande = new ArrayList();  
    String affiche= "SELECT * FROM soldeconge" ;        
    Statement st = conx.createStatement() ;
    ResultSet rs = st.executeQuery(affiche) ;
        SoldeConge listsolde ;
    while(rs.next()){
         listsolde = new SoldeConge(rs.getString("Nom_employe"),rs.getInt("id_solde"),rs.getString("solde_compensation"),rs.getString("solde_maladie"),rs.getString("solde_exception"),rs.getString("solde_annuel"));
         listdemande.add(listsolde);
              }
        return listdemande ;
    
    } 
     
     public ArrayList<SoldeConge> RechercheNom(String Nom_employe) {
        
        ArrayList<SoldeConge> solde = new ArrayList<>();
        String requete = "select * from SoldeConge where Nom_Employe ='"+Nom_employe+"' " ;
        try {
            PreparedStatement pst = conx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                solde.add(new SoldeConge (rs.getString("Nom_employe"),rs.getInt("id_solde"),rs.getString("solde_compensation"),rs.getString("solde_maladie"),rs.getString("solde_exception"),rs.getString("solde_annuel")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
        }
        return solde;
    }
  
    
}
