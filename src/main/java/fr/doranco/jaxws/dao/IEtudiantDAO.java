/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws.dao;

import fr.doranco.entity.Etudiant;
import java.util.List;

/**
 *
 * @author Boule
 */
public interface IEtudiantDAO {    
    public Etudiant getEtudiantById(int id) throws Exception;
    public Etudiant addEtudiant(Etudiant etudiant) throws Exception;
    public List<Etudiant> getListeEtudiant() throws Exception;
}
