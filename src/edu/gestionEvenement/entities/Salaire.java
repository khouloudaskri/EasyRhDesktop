/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.entities;

/**
 *
 * @author win 10
 */
public class Salaire {
    private  Double id_Salaire ; 
    private  String id_employe ; 
    private  String  nom_employe; 
    private  String  prenom_employe; 
    private  String date_salaire; 
    private  String mois ;
    private String montant ;
    private  String heures_travail ;   

    public Salaire(String id_employe, String nom_employe, String prenom_employe, String date_salaire, String mois, String montant, String heures_travail) {
        this.id_employe = id_employe;
        this.nom_employe = nom_employe;
        this.prenom_employe = prenom_employe;
        this.date_salaire = date_salaire;
        this.mois = mois;
        this.montant = montant;
        this.heures_travail = heures_travail;
    }
    
    
   public Salaire(String nom_employe, String prenom_employe,String date_salaire , String mois,String montant, String heures_travail) {
        this.nom_employe = nom_employe;
        this.prenom_employe = prenom_employe;
        this.date_salaire = date_salaire;
        this.mois = mois;
        this.montant = montant;
        this.heures_travail = heures_travail;
        
   }

   public Salaire(String nom_employe, String prenom_employe, String date_salaire, String mois, String montant) {
        this.nom_employe = nom_employe;
        this.prenom_employe = prenom_employe;
        this.date_salaire = date_salaire;
        this.mois = mois;
        this.montant = montant;
    }

    

    public Salaire(Double id_Salaire, String id_employe, String nom_employe, String prenom_employe, String date_salaire, String mois, String montant, String heures_travail) {
        this.id_Salaire = id_Salaire;
        this.id_employe = id_employe;
        this.nom_employe = nom_employe;
        this.prenom_employe = prenom_employe;
        this.date_salaire = date_salaire;
        this.mois = mois;
        this.montant = montant;
        this.heures_travail = heures_travail;
    }

  
    
    
    

   



    

   

    public void setId_Salaire(Double id_Salaire) {
        this.id_Salaire = id_Salaire;
    }

    public Double getId_Salaire() {
        return id_Salaire;
    }
     public Salaire() {
      }

    

    public Salaire(String id_employe) {
        this.id_employe = id_employe;
    }

    public Salaire(String nom_employe, String prenom_employe) {
        this.nom_employe = nom_employe;
        this.prenom_employe = prenom_employe;
    }

    public Salaire(Double id_Salaire, String nom_employe, String prenom_employe) {
        this.id_Salaire = id_Salaire;
        this.nom_employe = nom_employe;
        this.prenom_employe = prenom_employe;
    }

  

    

    public String getId_employe() {
        return id_employe;
    }

    public String getNom_employe() {
        return nom_employe;
    }

    public String getPrenom_employe() {
        return prenom_employe;
    }

    public String getDate_salaire() {
        return date_salaire;
    }

    public String getMois() {
        return mois;
    }

    public String getMontant() {
        return montant;
    }

    public String getHeures_travail() {
        return heures_travail;
    }

    public void setId_employe(String id_employe) {
        this.id_employe = id_employe;
    }

    public void setNom_employe(String nom_employe) {
        this.nom_employe =new String(nom_employe);
    }

    public void setPrenom_employe(String prenom_employe) {
        this.prenom_employe = new String(prenom_employe);
    }

    public void setDate_salaire(String date_salaire) {
        this.date_salaire = date_salaire;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public void setHeures_travail(String heures_travail) {
        this.heures_travail = heures_travail;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salaire other = (Salaire) obj;
        if (this.id_employe != other.id_employe) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Salaire{" + "id_Salaire=" + id_Salaire + ", id_employe=" + id_employe + ", nom_employe=" + nom_employe + ", prenom_employe=" + prenom_employe + ", date_salaire=" + date_salaire + ", mois=" + mois + ", montant=" + montant + ", heures_travail=" + heures_travail + '}';
    }
    

    
    
    
    
}


