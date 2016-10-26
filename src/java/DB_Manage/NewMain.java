/**
 * File: NewMain.java
 * Created 26-oct-2016 at 18:27:28
 */

package DB_Manage;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Miquel Ginés Borràs
 * @mail ginesborrasm@gmail.com
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //String code = request.getParameter("code");
            MySQLConnection mysql = new MySQLConnection();
            Connection conn = mysql.getConnection();
            Alumnes alumne = new Alumnes();
            DbDataHandler dbHandler = new DbDataHandler();
            alumne = dbHandler.getAlumneInfo(conn, Integer.parseInt("1"));
            System.out.println(alumne.getAssignatures());
            Gson gson = new Gson();
            String jsonObj = gson.toJson(alumne);
            System.out.println(jsonObj);
    }

}
