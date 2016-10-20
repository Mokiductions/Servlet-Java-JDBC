/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

/**
 *
 * @author Miquel Ginés Borràs
 * @mail ginesborrasm@gmail.com
 */
public class Alumnes {

    private int codi;
    private String nom;
    private String assignatures, tutories;

    public Alumnes() {

    }

    public Alumnes(int codi, String nom) {
        this.codi = codi;
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

        public String getAssignatures() {
        return assignatures;
    }

    public void setAssignatures(String assignatures) {
        this.assignatures = assignatures;
    }

    public String getTutories() {
        return tutories;
    }

    public void setTutories(String tutories) {
        this.tutories = tutories;
    }
    
}
