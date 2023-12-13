package com.example.sosieteantsika.model;

import com.example.sosieteantsika.connection.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    int id_login;
    int id_service;
    int id_poste;
    String password;
    
    public Login(int id_login, int id_service, int id_poste, String password) {
        this.id_login = id_login;
        this.id_service = id_service;
        this.id_poste = id_poste;
        this.password = password;
    }
    public Login() {
    }
    public int getId_login() {
        return id_login;
    }
    public void setId_login(int id_login) {
        this.id_login = id_login;
    }
    public int getId_service() {
        return id_service;
    }
    public void setId_service(int id_service) {
        this.id_service = id_service;
    }
    public int getId_poste() {
        return id_poste;
    }
    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Login login(String mdp) throws Exception {
        Connect connect = new Connect();
        Connection connection = null;
        Login valiny = new Login();
        try {
            connection = connect.connecter();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from login where password = '"+mdp+"'");
            while (resultSet.next()) {
                valiny.setId_login(resultSet.getInt("id_login"));
                valiny.setId_poste(resultSet.getInt("id_poste"));
                valiny.setId_service(resultSet.getInt("id_service"));
                valiny.setPassword(resultSet.getString("password"));
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("erreur dans login "+e.getMessage());
        }
        finally {
            connection.close();
        }

        return valiny;
    }

    public Fournisseur loginFournisseur(String nom, String mdp) throws Exception {
        Fournisseur valiny = null;

        Connection connection = null;
        try {
            connection = new Connect().connecter();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from fournisseur where nom ='"+nom+"' and mdp = '"+mdp+"'");
            resultSet.next();
            valiny = new Fournisseur();
            valiny.setId_fournisseur(resultSet.getInt("id_fournisseur"));
            valiny.setNom(resultSet.getString("nom"));
            valiny.setMdp(resultSet.getString("mdp"));
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("pas fournisseur dans ce nom");
        }
        finally {
            connection.close();
        }

        return valiny;
    }
    public String getLien(Integer id_poste) {
        switch (id_poste) {
            case 1:
                return "PageInsertServlet";
            case 2:
                return "AccueilServlet";
            case 3:
                return "";
            case 4:
                return "";
            case 5:
                return "RHAccueilServlet";
            default:
                return "index";
        }
    }
}
