/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.ultils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author flami
 */
public class DBUtils {
    public static Connection getConnection1() throws ClassNotFoundException, SQLException{
        Connection conn=null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=SE1740SP23";
        conn = DriverManager.getConnection(url, "sa", "12345");
        return conn;
    }
    
    public static Connection getConnection() throws NamingException, SQLException{
        Connection conn=null;
        Context context = new InitialContext();
        Context end = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource)end.lookup("DBCon");
        conn = ds.getConnection();
        return conn;
    }
}
