/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Miquel Ginés Borràs
 * @mail ginesborrasm@gmail.com
 */
public class MySQLConnection {

    private final String url = "jdbc:mysql://localhost:3306/javatest_01";
    private final String usr = "java_admin";
    private final String pwd = "123456789";
    private final Connection connection;

    public MySQLConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(url, usr, pwd);
    }

    public Connection getConnection() {
        return this.connection;
    }
}
