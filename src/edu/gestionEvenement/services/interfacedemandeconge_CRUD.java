/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;


import edu.gestionEvenement.entities.Conge;
import java.util.List;

/**
 *
 * @author Mohamed cherif
 */
public interface interfacedemandeconge_CRUD {
    
    public void ajouterdemande_conge(Conge C) ;
    public void modifierdemande_conge(Conge C) ;
    public void supprimerdemande_conge(int id_conge) ;
    public List<Conge> Afficherdemande_conge() ; 
    
}
