package com.example.sosieteantsika.connection;
import java.sql.*;
/**
 * Connect
 */
public class Connect {

    public Connection connecter()throws Exception,ClassNotFoundException{
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/syscom";
            Connection c=DriverManager.getConnection(url,"postgres","S3p152022");
            return c;
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
        return null;
    }
    
    
}