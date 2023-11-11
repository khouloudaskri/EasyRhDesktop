/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionevenement;
import edu.gestionEvenement.entities.Evenement;
import edu.gestionEvenement.utlis.myConnexion;
import edu.gestionEvenement.services.evenementCrud;
import java.util.Formatter;
/**
 *
 * @author KHOULOUD
 */
public class GestionEvenement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        myConnexion c= myConnexion.getinstance();
        //Evenement e1 = new Evenement("a", "b", "c", "d","12/10/2022","13/10/2022");
        Evenement e2 = new Evenement(2,"kk", "tt", "cc", "dd","15/10/2022","18/10/2022");
         Evenement e3 = new Evenement(3,"aa", "bb", "cc", "dd","15/10/2022","18/10/2022");
        evenementCrud cc = new evenementCrud();
        //cc.ajouterEv(e2);
        //cc.ajouterEv(e1);
       //cc.ajouterEv(e3);
        //cc.supprimerEv(1);
         //cc.supprimerEv(1);
         cc.modifierEv(e2);
         System.out.println( cc.afficherEv());
    }
    
}
