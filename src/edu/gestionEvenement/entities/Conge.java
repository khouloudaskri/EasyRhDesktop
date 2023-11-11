
package edu.gestionEvenement.entities;

import java.util.Date;

/**
 *
 * @author Mohamed cherif
 */
        
public class Conge {
    
    private int id_conge ;
    private String Nom_employe ;
    private String nb_jours ;
    private String datedep ;
    private String dateretour ;
    private Date datedemande ;
    private String type ;
    private String motif ;
    private String typedoc ;
    public String etat ;

    public Conge() {
    }

    public Conge( String Nom_employe, String datedep, String dateretour,String nb_jours, String type, String motif, String etat) {
        this.Nom_employe = Nom_employe;
        this.nb_jours = nb_jours;
        this.datedep = datedep;
        this.dateretour = dateretour;
       // this.datedemande = datedemande;
        this.type = type;
        this.motif = motif;
        this.etat = etat;
       
    }
    
       public Conge(int id_conge,String Nom_employe,Date datedemande, String datedep, String dateretour,String nb_jours, String type, String motif, String etat) {
        this.id_conge = id_conge ;
        this.Nom_employe = Nom_employe;
        this.nb_jours = nb_jours;
        this.datedep = datedep;
        this.dateretour = dateretour;
        this.datedemande = datedemande;
        this.type = type;
        this.motif = motif;
        this.etat = etat;
       
    }
    

    public Conge(int id_conge, String Nom_employe , String nb_jours, String type, String motif, String typedoc) {
        this.id_conge = id_conge;
        this.Nom_employe  = Nom_employe ;
        this.nb_jours = nb_jours;
        this.type = type;
        this.motif = motif;
        this.typedoc = typedoc;
    }

    public Conge(int id_conge, Date datedemande, String datedep, String dateretour,String nb_jours, String type ,String motif,String etat) {
        this.id_conge = id_conge; 
        this.datedemande= datedemande ;
        this.datedep = datedep;
        this.dateretour = dateretour;
        this.nb_jours = nb_jours;
        this.type = type;
        this.motif = motif;
        this.etat = etat;
        
    }    

    public Conge(String Nom_employe,String datedep, String dateretour, String nb_jours, String type ,String motif) {
        this.Nom_employe = Nom_employe;
        this.nb_jours = nb_jours;
        this.datedep = datedep;
        this.dateretour = dateretour;
        this.type = type;
        this.motif = motif;
         
    }

    public Conge( String Nom_employe,int id_conge, String datedep, String dateretour,String nb_jours, String type, String motif) {
        this.Nom_employe = Nom_employe;
        this.id_conge = id_conge;     
        this.datedep = datedep;
        this.dateretour = dateretour;
        this.nb_jours = nb_jours;
        this.type = type;
        this.motif = motif;
    }



    public int getId_conge() {
        return id_conge;
    }

    public void setId_conge(int id_conge) {
        this.id_conge = id_conge;
    }

    public String getNom_employe() {
        return Nom_employe;
    }

    public void setNom_employe(String Nom_employe) {
        this.Nom_employe = Nom_employe;
    }

    public String getNb_jours() {
        return nb_jours;
    }

    public void setNb_jours(String nb_jours) {
        this.nb_jours = nb_jours;
    }

    public String getDatedep() {
        return datedep;
    }

    public void setDatedep(String datedep) {
        this.datedep = datedep;
    }

    public String getDateretour() {
        return dateretour;
    }

    public void setDateretour(String dateretour) {
        this.dateretour = dateretour;
    }

    public Date getDatedemande() {
        return datedemande;
    }

    public void setDatedemande(Date datedemande) {
        this.datedemande = datedemande;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getTypedoc() {
        return typedoc;
    }

    public void setTypedoc(String typedoc) {
        this.typedoc = typedoc;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    
  
    
    
    
    @Override
    public String toString() {
       return "congé : "+id_conge+"--"+datedep+"--"+datedep+"--"+dateretour+"--"+nb_jours+"--"+type+"--"+motif+".";

    }
    
    
    
    
    
    
    
    
}
