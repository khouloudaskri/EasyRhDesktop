/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.gestionEvenement.services;
import edu.gestionEvenement.entities.Suggestion;
import java.util.List;
/**
 *
 * @author KHOULOUD
 *  @param <Suggestion>
 */
public interface interfaceSuggestion <Suggestion> {
    public void ajouterS(Suggestion S); 
   public List<Suggestion> afficherS();

}
