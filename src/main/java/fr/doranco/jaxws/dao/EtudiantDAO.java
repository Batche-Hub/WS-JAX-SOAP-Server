/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.jaxws.dao;



import fr.doranco.jaxws.connexion.JaxwsDataSource;
import fr.doranco.entity.Etudiant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Boule
 */
public class EtudiantDAO implements IEtudiantDAO {

    //Constructeur
    public EtudiantDAO() {
    }
    
    //Méthodes de l'interface à redéfinir
    @Override
    public Etudiant getEtudiantById(int id) throws Exception{
        
        
        Etudiant etudiant = new Etudiant();
        Connection connexion = JaxwsDataSource.getInstance().getConnection();

        String requete = "SELECT * FROM etudiant WHERE id = ?";
        PreparedStatement ps = null;
        try {
            
            ps = connexion.prepareStatement(requete);
            ps.setInt(1, id);
            
            
            ResultSet rs = ps.executeQuery();
            

            if (rs.next()) {
                
                etudiant.setId(rs.getInt("id"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setAge(rs.getInt("age"));
                etudiant.setSpecialite(rs.getString("specialite"));
            }else{
                System.err.println("L'étudiant n'existe pas !");
            }
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e);
            return null;
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    System.err.println("Une erreur Sql est survenue : " + ex);
                    
                }

            }

        }
        return etudiant;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) throws Exception{
        
        Connection connexion = JaxwsDataSource.getInstance().getConnection();

        String requete = "INSERT INTO etudiant(nom, prenom, age, specialite) VALUE(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            
            ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setInt(3, etudiant.getAge());
            ps.setString(4, etudiant.getSpecialite());

            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();

            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                etudiant.setId(id);
            }

        } catch (Exception e) {
            System.err.println("Une erreur de connexion est survenue." + e);
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ex) {
                   System.err.println("Une erreur SQL est survenue : "+ex);
                }
            }

        }
        return etudiant;
    }

    

    @Override
    public List<Etudiant> getListeEtudiant() throws Exception{
        
        
        List<Etudiant> listeEtudiants = new ArrayList<>();
       
        Connection connexion = JaxwsDataSource.getInstance().getConnection();
       
        String requete = "SELECT * FROM etudiant";
        PreparedStatement ps = null;
        try {
            ps = connexion.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next()) {
               
                Etudiant etudiant = new Etudiant();
               
                etudiant.setId(rs.getInt("id"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setAge(rs.getInt("age"));
                etudiant.setSpecialite(rs.getString("specialite"));
                listeEtudiants.add(etudiant);
                
            }
           
        } catch (SQLException e) {
            System.err.println("Une erreur SQL est survenue : "+e);
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    System.err.println("Erreur de connexion SQL : " + ex);
                }
            }
        }
        
        
        return listeEtudiants;
    }



}
