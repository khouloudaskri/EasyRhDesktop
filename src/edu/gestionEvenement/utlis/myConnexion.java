/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.utlis;
    import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author KHOULOUD
 */
public class myConnexion {


    String url = "jdbc:mysql://localhost:3306/easyrh";
    String user = "root";
    String pwd = "";
private Connection conx;

   
  private static myConnexion instance ;
   private myConnexion(){
         try {
            conx = DriverManager.getConnection(url, user, pwd);
            System.out.print("Connextion etablie !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
   }
   public static myConnexion getinstance(){
       if(instance==null)
           instance= new myConnexion();
       return instance;
    }
   
    public Connection getConnection(){
    return conx;
}
    
}
