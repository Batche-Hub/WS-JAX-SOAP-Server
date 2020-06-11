/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.dao.EtudiantDAO;
import java.util.List;
import java.util.regex.Pattern;
import javax.jws.*;

/**
 *
 * @author Boule
 */
@WebService(endpointInterface = "fr.doranco.jaxws.EtudiantService",
        serviceName = "EtudiantService",
        portName = "EtudiantPort")
public class EtudiantService implements IEtudiantService {

    @Override
    public Etudiant getEtudiantById(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("L'identifiant ne doit pas être nul et doit être composé uniquement d'un chiffre rond supérieur à 0.");
        } else if (id <= 0) {
            throw new Exception("L'identifiant ne peut être égal ou inférieur 0 et doit être un chiffre rond.");
        } else {
            EtudiantDAO etudiant = new EtudiantDAO();
            Etudiant etudiantAjoute = etudiant.getEtudiantById(id);
            if (etudiantAjoute.getId() == null) {
                throw new Exception("Cet étudiant n'existe pas.");
            } else {
                return etudiantAjoute;
            }
        }
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) throws Exception {
        if (etudiant == null) {
            throw new Exception("BVous devez remplir tous les champs svp.");
        } else if (etudiant.getAge() == null || etudiant.getAge() <= 0) {
            throw new Exception("L'âge doit être supérieur ou égale à 0.");
        } else if (etudiant.getNom() == null || etudiant.getPrenom() == null || etudiant.getSpecialite() == null) {
            throw new Exception("Vous devez remplir TOUS les champs correctement. L'âge doit être un chiffre rond supérieur à 0, les nom ,prénom et spécialité doivent être des lettres.");
        } else if (Pattern.matches("[a-zA-Z]+[\\-]+[a-zA-Z]+", etudiant.getNom()) == false && Pattern.matches("[a-zA-Z]+", etudiant.getNom()) == false || etudiant.getNom().length() == 0) {
            throw new Exception("Vous devez mettre des lettres.");
        } else {
            EtudiantDAO etudiantDAO = new EtudiantDAO();
            etudiant = etudiantDAO.addEtudiant(etudiant);
            return etudiant;
        }
    }

    @Override
    public List<Etudiant> getListeEtudiant() throws Exception {
        EtudiantDAO etudiantDAO = new EtudiantDAO();
        List<Etudiant> listeEtudiants = etudiantDAO.getListeEtudiant();
        if (listeEtudiants.isEmpty() || listeEtudiants == null) {
            throw new Exception("La liste est vide !");
        } else {
            return listeEtudiants;
        }
    }

}
