/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.entities;

/**
 *
 * @author Mohamed cherif
 */
public class SoldeConge {
    
    public String Nom_employe ;
    private int id_solde ;
    private String solde_annuel;
    private String solde_compensation ;
    private String solde_maladie ;
    private String solde_exception ;

    public SoldeConge(String Nom_employe) {
        this.Nom_employe = Nom_employe;
    }
    

    public SoldeConge(String Nom_employe, String solde_annuel, String solde_compensation, String solde_maladie, String solde_exception) {
        
        this.Nom_employe = Nom_employe;
        this.solde_annuel = solde_annuel;
        this.solde_compensation = solde_compensation;
        this.solde_maladie = solde_maladie;
        this.solde_exception = solde_exception;
    }

    public SoldeConge(int id_solde, String solde_annuel, String solde_compensation, String solde_maladie, String solde_exception) {
        this.id_solde = id_solde;
        this.solde_annuel = solde_annuel;
        this.solde_compensation = solde_compensation;
        this.solde_maladie = solde_maladie;
        this.solde_exception = solde_exception;
    }

    public SoldeConge() {
    }

    public SoldeConge(String Nom_employe,int id_solde, String solde_compensation, String solde_maladie, String solde_exception, String solde_annuel) {
        this.Nom_employe = Nom_employe;
        this.id_solde = id_solde;    
        this.solde_compensation = solde_compensation;
        this.solde_maladie = solde_maladie;
        this.solde_exception = solde_exception;
        this.solde_annuel = solde_annuel;
        
    }

    public String getNom_employe() {
        return Nom_employe;
    }

    public void setNom_employe(String Nom_employe) {
        this.Nom_employe = Nom_employe;
    }
    
  
    public int getId_solde() {
        return id_solde;
    }

    public void setId_solde(int id_solde) {
        this.id_solde = id_solde;
    }

    public String getSolde_annuel() {
        return solde_annuel;
    }

    public void setSolde_annuel(String solde_annuel) {
        this.solde_annuel = solde_annuel;
    }

    public String getSolde_compensation() {
        return solde_compensation;
    }

    public void setSolde_compensation(String solde_compensation) {
        this.solde_compensation = solde_compensation;
    }

    public String getSolde_maladie() {
        return solde_maladie;
    }

    public void setSolde_maladie(String solde_maladie) {
        this.solde_maladie = solde_maladie;
    }

    public String getSolde_exception() {
        return solde_exception;
    }

    public void setSolde_exception(String solde_exception) {
        this.solde_exception = solde_exception;
    }
    
    @Override
    public String toString() {
       return "solde" + "id" + "solde annuel" +"solde compensation" + "solde maladie" +"solde exception" ;
    }
}
