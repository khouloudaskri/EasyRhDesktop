/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;
        import java.util.List;

/**
 *
 * @author medam
 * @param <user>
 */
public interface Interfaceuser <user> {
        public void ajouteruser(user p);
    public void modifieruser(user p);
    public void supprimeruser(int id);
    public List<user> aficheruser();
}
