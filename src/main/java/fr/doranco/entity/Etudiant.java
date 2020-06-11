/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.entity;

import javax.xml.bind.annotation.*;



/**
 *
 * @author Boule
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="etudiant", propOrder = {
    "id",
    "nom",
    "prenom",
    "age",
    "specialite",
})
public class Etudiant {
    @XmlElement(required = false)
    private Integer id;
    
    @XmlElement(required = true)
    private String nom;
    
    @XmlElement(required = true)
    private String prenom;
    
    @XmlElement(required = true)
    private Integer age;
    
    @XmlElement(required = true)
    private String specialite;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom,Integer age, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.age=age;
        this.specialite = specialite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }



    @Override
    public String toString() {
        return "Etudiant{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", specialite=" + specialite + '}';
    }

    
    
}
