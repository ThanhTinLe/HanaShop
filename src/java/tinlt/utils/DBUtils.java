/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinlt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ray Khum
 */
public class DBUtils {
    public static Connection getConnection() throws SQLException{
        Connection conn=null;
        try {            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=LeThanhTin_Assignment1";
            conn=DriverManager.getConnection(url, "sa", "thanhtin123");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
