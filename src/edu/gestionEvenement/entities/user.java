/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.entities;

import java.sql.Date;

/**
 *
 * @author medam
 */
public class user {
    private int id_user;
    private String nom_user;
    private String prenom_user;
    private String role;
    private String password;
    private String email;
    private String poste;
    private int num_carte_bancaire;
    private int tel;
    private String lieu_ns;
    private String civilité;
    private String date_ne;
    private String situation;

    public user(int id_user, String nom_user, String prenom_user, String role, String password, String email, String poste, int num_carte_bancaire, int tel, String lieu_ns, String civilité, String date_ne, String situation) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.role = role;
        this.password = password;
        this.email = email;
        this.poste = poste;
        this.num_carte_bancaire = num_carte_bancaire;
        this.tel = tel;
        this.lieu_ns = lieu_ns;
        this.civilité = civilité;
        this.date_ne = date_ne;
        this.situation = situation;
    }

    public user(String nom_user, String prenom_user, String role, String password, String email, String poste, int num_carte_bancaire, int tel, String lieu_ns, String civilité, String date_ne, String situation) {
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.role = role;
        this.password = password;
        this.email = email;
        this.poste = poste;
        this.num_carte_bancaire = num_carte_bancaire;
        this.tel = tel;
        this.lieu_ns = lieu_ns;
        this.civilité = civilité;
        this.date_ne = date_ne;
        this.situation = situation;
    }

    public int getId_user() {
        return id_user;
    }

    public String getNom_user() {
        return nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPoste() {
        return poste;
    }

    public int getNum_carte_bancaire() {
        return num_carte_bancaire;
    }

    public int getTel() {
        return tel;
    }

    public String getLieu_ns() {
        return lieu_ns;
    }

    public String getCivilité() {
        return civilité;
    }

    public String getDate_ne() {
        return date_ne;
    }

    public String getSituation() {
        return situation;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setNum_carte_bancaire(int num_carte_bancaire) {
        this.num_carte_bancaire = num_carte_bancaire;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setLieu_ns(String lieu_ns) {
        this.lieu_ns = lieu_ns;
    }

    public void setCivilité(String civilité) {
        this.civilité = civilité;
    }

    public void setDate_ne(String date_ne) {
        this.date_ne = date_ne;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        return "user{" + "id_user=" + id_user + ", nom_user=" + nom_user + ", prenom_user=" + prenom_user + ", role=" + role + ", password=" + password + ", email=" + email + ", poste=" + poste + ", num_carte_bancaire=" + num_carte_bancaire + ", tel=" + tel + ", lieu_ns=" + lieu_ns + ", civilit\u00e9=" + civilité + ", date_ne=" + date_ne + ", situation=" + situation + '}';
    }
    
    
}
