/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws;

import fr.doranco.entity.Etudiant;
import java.util.List;
import javax.jws.*;


/**
 *
 * @author Boule
 */
@WebService(name="EudiantService", targetNamespace = "http://jaxws.doranco.fr")
public interface IEtudiantService {
    @WebMethod
    public Etudiant getEtudiantById(@WebParam Integer id) throws Exception;
    @WebMethod
    public Etudiant addEtudiant(@WebParam Etudiant etudiant) throws Exception;
    @WebMethod
    public List<Etudiant> getListeEtudiant() throws Exception;
}
