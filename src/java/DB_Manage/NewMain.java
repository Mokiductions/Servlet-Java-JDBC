/**
 * File: NewMain.java
 * Created 19-oct-2016 at 18:03:38
 */

package DB_Manage;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miquel Ginés Borràs
 * @mail ginesborrasm@gmail.com
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String code = "1";
            String url = "jdbc:mysql://localhost:3306/javatest_01";
            String usr = "java_admin";
            String pwd = "123456789";
            MySQLConnection mysql = new MySQLConnection(url, usr, pwd);
            Connection conn = mysql.getConnection();
            Alumnes alumne = new Alumnes();
            DbDataHandler dbHandler = new DbDataHandler();
            alumne = dbHandler.getAlumneInfo(conn, Integer.parseInt(code));
            System.out.println(alumne.getAssignatures());
            Gson gson = new Gson();
            //JsonElement jsonElmnt;
            JsonArray jsonArr;
            String jsonObj = gson.toJson(alumne);
            //jsonArr = jsonObj.getAsJsonArray();
            System.out.println(jsonObj);
            //response.setContentType("application/json");
            //response.getWriter().print(jsonObj);
    }

}
