/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.entities;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;


/**
 *
 * @author KHOULOUD
 */
public class Evenement {
     private int id_Ev;
    private String titre_Ev;
    private String type_Ev;
    private String emplacement_Ev;
    private String theme_Ev;
    private String dateD_Ev;
    private String dateF_Ev;
    

    public Evenement(int id_Ev, String titre_Ev, String type_Ev, String emplacement_Ev, String theme_Ev, String dateD_Ev, String dateF_Ev) {
        this.id_Ev = id_Ev;
        this.titre_Ev = titre_Ev;
        this.type_Ev = type_Ev;
        this.emplacement_Ev = emplacement_Ev;
        this.theme_Ev = theme_Ev;
        this.dateD_Ev = dateD_Ev;
        this.dateF_Ev = dateF_Ev;
       
    }

    public Evenement(String titre_Ev, String type_Ev, String emplacement_Ev, String theme_Ev,String dateD_Ev,String dateF_Ev) {
        this.titre_Ev = titre_Ev;
        this.type_Ev = type_Ev;
        this.emplacement_Ev = emplacement_Ev;
        this.theme_Ev = theme_Ev;
        this.dateD_Ev = dateD_Ev;
        this.dateF_Ev = dateF_Ev;
       
    }

    public Evenement(int id_Ev, String titre_Ev, String type_Ev, String emplacement_Ev, String theme_Ev) {
        this.id_Ev = id_Ev;
        this.titre_Ev = titre_Ev;
        this.type_Ev = type_Ev;
        this.emplacement_Ev = emplacement_Ev;
        this.theme_Ev = theme_Ev;
    }

    public Evenement(String titre_Ev, String type_Ev, String emplacement_Ev, String theme_Ev) {
        this.titre_Ev = titre_Ev;
        this.type_Ev = type_Ev;
        this.emplacement_Ev = emplacement_Ev;
        this.theme_Ev = theme_Ev;
    }
    

    public int getId_Ev() {
        return id_Ev;
    }

    public String getTitre_Ev() {
        return titre_Ev;
    }

    public String getType_Ev() {
        return type_Ev;
    }

    public String getEmplacement_Ev() {
        return emplacement_Ev;
    }

    public String getTheme_Ev() {
        return theme_Ev;
    }

    public String getDateD_Ev() {
        return dateD_Ev;
    }

    public String getDateF_Ev() {
        return dateF_Ev;
    }

   

    public void setId_Ev(int id_Ev) {
        this.id_Ev = id_Ev;
    }

    public void setTitre_Ev(String titre_Ev) {
        this.titre_Ev = titre_Ev;
    }

    public void setType_Ev(String type_Ev) {
        this.type_Ev = type_Ev;
    }

    public void setEmplacement_Ev(String emplacement_Ev) {
        this.emplacement_Ev = emplacement_Ev;
    }

    public void setTheme_Ev(String theme_Ev) {
        this.theme_Ev = theme_Ev;
    }

    public void setDateD_Ev(String dateD_Ev) {
        this.dateD_Ev = dateD_Ev;
    }

    public void setDateF_Ev(String dateF_Ev) {
        this.dateF_Ev = dateF_Ev;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_Ev=" + id_Ev + ", titre_Ev=" + titre_Ev + ", type_Ev=" + type_Ev + ", emplacement_Ev=" + emplacement_Ev + ", theme_Ev=" + theme_Ev + ", dateD_Ev=" + dateD_Ev + ", dateF_Ev=" + dateF_Ev + '}';
    }

   

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id_Ev;
        hash = 97 * hash + Objects.hashCode(this.titre_Ev);
        hash = 97 * hash + Objects.hashCode(this.type_Ev);
        hash = 97 * hash + Objects.hashCode(this.emplacement_Ev);
        hash = 97 * hash + Objects.hashCode(this.theme_Ev);
        hash = 97 * hash + Objects.hashCode(this.dateD_Ev);
        hash = 97 * hash + Objects.hashCode(this.dateF_Ev);
       
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
        final Evenement other = (Evenement) obj;
        if (this.id_Ev != other.id_Ev) {
            return false;
        }
        if (!Objects.equals(this.titre_Ev, other.titre_Ev)) {
            return false;
        }
        if (!Objects.equals(this.type_Ev, other.type_Ev)) {
            return false;
        }
        if (!Objects.equals(this.emplacement_Ev, other.emplacement_Ev)) {
            return false;
        }
        if (!Objects.equals(this.theme_Ev, other.theme_Ev)) {
            return false;
        }
        if (!Objects.equals(this.dateD_Ev, other.dateD_Ev)) {
            return false;
        }
        if (!Objects.equals(this.dateF_Ev, other.dateF_Ev)) {
            return false;
        }

        return true;
    }

  
    
}
