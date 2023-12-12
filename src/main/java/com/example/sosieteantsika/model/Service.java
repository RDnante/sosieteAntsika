package com.example.sosieteantsika.model;

import com.example.sosieteantsika.connection.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public Service[] getAllService(Connection c)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Service> allS = new ArrayList<>();
            Statement st = c.createStatement();
            String sql = "select * from service";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allS.add(new Service(res.getInt(1),res.getString(2)));
            }
            Service[] all = new Service[allS.size()];
            return allS.toArray(all);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }
}
