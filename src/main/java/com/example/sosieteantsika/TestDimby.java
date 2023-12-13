package com.example.sosieteantsika;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Fournisseur;
import com.example.sosieteantsika.model.Login;

import java.sql.Connection;

public class TestDimby {
    public static void main(String[] args) {
        Login l = new Login();
        try {
//            Connect connect = new Connect();
//            Connection connection = connect.connecter();
            Login test = l.login("RH123");
            Fournisseur f = l.loginFournisseur("jumbo","1234");
            System.out.println(f.getNom());
//            System.out.println(test.getId_service());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
