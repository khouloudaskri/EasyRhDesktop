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
public class papier {
     private  String nomE ; 
    private  String  typeP; 

    public papier(String nomE, String typeP) {
        this.nomE = nomE;
        this.typeP = typeP;
    }

    public String getNomE() {
        return nomE;
    }

    public String getTypeP() {
        return typeP;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public void setTypeP(String typeP) {
        this.typeP = typeP;
    }

    @Override
    public String toString() {
        return "papier{" + "nomE=" + nomE + ", typeP=" + typeP + '}';
    }
    
    
}
