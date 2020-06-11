/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws.main;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.EtudiantService;
import fr.doranco.jaxws.IEtudiantService;
import fr.doranco.jaxws.dao.EtudiantDAO;
import fr.doranco.jaxws.dao.IEtudiantDAO;
import java.util.List;

/**
 *
 * @author Boule
 */
public class Test {
    public static void main(String[] args) throws Exception{

        IEtudiantService etudiantService = new EtudiantService();
//        
//        Etudiant etudiant1 = new Etudiant("BADAD", "Cherif",29, "Sociologie");        
//        System.out.println("Test d'ajout de l'étudiant : "+etudiant1);
//        Etudiant etudiantAjoute = etudiantService.addEtudiant(etudiant1);
//        
//        if(etudiantAjoute.getId()!= 0){
//            System.err.println("L'étudiant a bien été ajouté :" + etudiantAjoute);
//        }else{
//            System.err.println("Une erreur est survenue. L'étudiant n'a pas été ajouté.: Veuillez recommencer.");
//        }
//        
//        
        Etudiant etudiant2 = new Etudiant("LAMOUR", "Jeanne",28, "Architecture");
        System.out.println("Test d'ajout de l'étudiant : "+etudiant2);
        Etudiant etudiantAjoute2 = etudiantService.addEtudiant(etudiant2);
        
        if(etudiantAjoute2.getId()!= 0){
            System.err.println("L'étudiant a bien été ajouté :" + etudiantAjoute2);
        }else{
            System.err.println("Une erreur est survenue. L'étudiant n'a pas été ajouté.: Veuillez recommencer.");
        }
        etudiantService.getEtudiantById(7);
        System.err.println("Test de récupération de la liste des étudiants...");
        List<Etudiant> listeEtudiants = etudiantService.getListeEtudiant();
        
        for(Etudiant etudiantsAjoutes : listeEtudiants){
            System.err.println("Voici les étudiants : "+etudiantsAjoutes);
        }
    }
}
