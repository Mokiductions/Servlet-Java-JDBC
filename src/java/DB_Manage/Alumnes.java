/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miquel Ginés Borràs
 * @mail ginesborrasm@gmail.com
 */
public class Alumnes {

    private int codi;
    private String nom;
    private List<String> assignatures, tutories;

    public Alumnes() {
        initializeLists();
    }

    public Alumnes(int codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        initializeLists();
    }
    
    private void initializeLists() {
        assignatures = new ArrayList<String>();
        tutories = new ArrayList<String>();
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

    public void addAssignatura(String assignatura) {
        assignatures.add(assignatura);
    }
    
    public List<String> getAssignatures() {
        return assignatures;
    }

    public void setAssignatures(List<String> assignatures) {
        this.assignatures = assignatures;
    }

    public void addTutoria(String tutoria) {
        tutories.add(tutoria);
    }
    
    public List<String> getTutories() {
        return tutories;
    }

    public void setTutories(List<String> tutories) {
        this.tutories = tutories;
    }

    
    
}
