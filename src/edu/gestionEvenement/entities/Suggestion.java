/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.entities;

import java.util.Objects;

/**
 *
 * @author KHOULOUD
 */
public class Suggestion {
     private String nom;
    private String suggestions;

    public Suggestion(String nom, String suggestions) {
        this.nom = nom;
        this.suggestions = suggestions;
    }

    public String getNom() {
        return nom;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return "Suggestion{" + "nom=" + nom + ", suggestions=" + suggestions + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nom);
        hash = 73 * hash + Objects.hashCode(this.suggestions);
        return hash;
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
        final Suggestion other = (Suggestion) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.suggestions, other.suggestions)) {
            return false;
        }
        return true;
    }
    
}
