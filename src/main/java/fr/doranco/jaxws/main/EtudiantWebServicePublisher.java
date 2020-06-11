/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws.main;

import fr.doranco.jaxws.EtudiantService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Boule
 */
public class EtudiantWebServicePublisher {
    public static void main(String[] args) throws Exception{
        try{
            System.err.println("Service Web Etudiant en cours");
            Endpoint.publish("http://localhost:9991/ws/etudiant-service", new EtudiantService());
            System.err.println("Le service web a bien été publié.");
        }catch(Exception e){
            System.err.println("Une erreur de publication est survenue");
            System.err.println(e.getMessage());
        }
        
    }
    
}
