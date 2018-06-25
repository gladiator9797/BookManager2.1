/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gladi
 */
public class ConnectionDB {

    private static Connection conn;

    public ConnectionDB(String URL, String userName, String pass) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, userName, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BookManager2";
        String user = "sa";
        String pass = "123456";
        if (conn != null) {
            return conn;
        } else {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); ////////////
                conn = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

    public ConnectionDB() {
        conn = getConnection();
    }

}
