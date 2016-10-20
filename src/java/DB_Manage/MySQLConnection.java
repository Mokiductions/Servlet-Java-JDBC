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

    private Connection connection;
	
	public MySQLConnection(String url, String usr, String pwd) 
                throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(url, usr, pwd);
	}
	
	public Connection getConnection(){
		return this.connection;
	}
}
