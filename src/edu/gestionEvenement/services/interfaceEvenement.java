/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;
import edu.gestionEvenement.entities.Evenement;

import java.util.List;

import java.util.List;

/**
 *
 * @author KHOULOUD
 * @param <Evenement>
 */
public interface interfaceEvenement <Evenement>{
       public void ajouterEv(Evenement Ev);
    public void modifierEv(Evenement Ev);
   public void supprimerEv(int id);
  public List<Evenement> afficherEv();
}
