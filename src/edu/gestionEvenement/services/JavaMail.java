/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionEvenement.services;

/**
 *
 * @author Mohamed cherif
 */
public class JavaMail {
    public static void main (String [] args) throws Exception{
         JavaMailUtil.sendMailaccepter("cherif.mohamed@esprit.tn");
        // JavaMailUtil.sendMailrefuser("cherif.mohamed@esprit.tn");
    }
    
}
