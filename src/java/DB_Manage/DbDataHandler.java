/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Miquel Ginés Borràs
 * @mail ginesborrasm@gmail.com
 */
public class DbDataHandler {

    public DbDataHandler() {

    }

    public ArrayList<Alumnes> getAlumnesList(Connection conn) throws SQLException {
        ArrayList<Alumnes> alumnes = new ArrayList<Alumnes>();
        Statement st;
        ResultSet rs;
        st = conn.createStatement();
        rs = st.executeQuery("select * from alumne;");
        while (rs.next()) {
            Alumnes a = new Alumnes(rs.getInt("codi"), rs.getString("nom"));
            alumnes.add(a);
        }
        return alumnes;
    }

    public ArrayList<Alumnes> getAlumneInfo(Connection conn, int alumnCode) throws SQLException {
        ArrayList<Alumnes> al = new ArrayList<Alumnes>();
        Statement st;
        ResultSet rs;
        String ass = "", tut = "", nom = "", query;
        st = conn.createStatement();
        query = "select * from alumne where codi=" + alumnCode + ";";
        rs = st.executeQuery(query);
        while (rs.next()) {
            nom = rs.getString("nom");
        }
        query = "select nom from tutoria left join tutoriaalumne on "
                + "tutoria.codi=tutoriaalumne.codiTutoria where "
                + "tutoriaalumne.codiAlumne=" + alumnCode + ";";
        rs = st.executeQuery(query);
        while (rs.next()) {
            tut += rs.getString("nom") + "<br>";
        }
        query = "select assignatura.codi, assignatura.nom from assignatura "
                + "inner join tutoria on assignatura.codi=tutoria.codiAssignatura "
                + "inner join tutoriaalumne on tutoriaalumne.codiTutoria=tutoria.codi "
                + "where tutoriaalumne.codiAlumne=" + alumnCode + ";";
        rs = st.executeQuery(query);
        while (rs.next()) {
            ass += rs.getString("nom") + "<br>";
        }
        al.add(new Alumnes(alumnCode, nom));
        al.get(0).setAssignatures(ass);
        al.get(0).setTutories(tut);
        return al;
    }

}
