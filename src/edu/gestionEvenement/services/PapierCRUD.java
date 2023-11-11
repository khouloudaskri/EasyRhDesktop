/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;


import edu.gestionEvenement.entities.papier;
import edu.gestionEvenement.utlis.myConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win 10
 */
public class PapierCRUD implements InterfaceSalaire <papier > {
    Connection cnx;


    public PapierCRUD() {
        cnx = myConnexion.getinstance().getConnection();
    }
     
      public void ajouterpapier(papier p) {
         String req ;
        req = "INSERT INTO `papier`(`nomE`,`typeP` ) VALUES ('"+p.getNomE()+"','"+p.getTypeP()+"')";
        
        try {
           Statement st=cnx.createStatement();
            st.executeUpdate(req);}
        
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        
        }
       
    }
      
      
        public List<papier> afficherPapier() {

 List <papier> list = new ArrayList<>();
 try {
String req = "SELECT * FROM `papier`";        
Statement st;
st =cnx.createStatement();
ResultSet rs = st.executeQuery(req);
while(rs.next()){
papier p = new papier(rs.getString(1),rs.getString(2));
 list.add(p);}
}
catch (SQLException ex){
    System.err.println(ex.getMessage());
}
return list;
    }
   
      
    
}
