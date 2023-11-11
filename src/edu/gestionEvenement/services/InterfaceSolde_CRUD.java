/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;


import edu.gestionEvenement.entities.SoldeConge;
import java.util.List;

/**
 *
 * @author Mohamed cherif
 */
public interface InterfaceSolde_CRUD {
    
    public void AjouterSolde_conge (SoldeConge S) ;
    public void ModifierSolde_Conge(SoldeConge S) ;
    public void SupprimerSolde_Conge(String Nom_employe) ;
    public List<SoldeConge> AfficherSolde_Conge(String Nom_employe);
}
