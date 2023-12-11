package com.example.sosieteantsika.model;

import com.example.sosieteantsika.connection.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Service {
    int id_service;
    String nom;
    
    public Service(int id_service, String nom) {
        this.id_service = id_service;
        this.nom = nom;
    }
    public Service() {
    }
    public int getId_service() {
        return id_service;
    }
    public void setId_service(int id_service) {
        this.id_service = id_service;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Service getServiceById(Integer id, Connection connection) throws Exception {
        Service service = new Service();
        boolean verif = false;
        try {
            if (connection == null || connection.isClosed()) {
                Connect connect = new Connect();
                connection = connect.connecter();
                verif = true;
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from service where id_service ="+id);
            resultSet.next();
            service.setId_service(resultSet.getInt("id_service"));
            service.setNom(resultSet.getString("nom"));
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("erreur getServiceById"+e.getMessage());
        }
        finally {
            if (verif == true) {
                connection.close();
            }
        }

        return service;
    }
}
