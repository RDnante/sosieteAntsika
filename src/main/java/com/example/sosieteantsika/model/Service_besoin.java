package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class Service_besoin {
    Integer id_service_besoin;
    Integer id_service;
    Integer id_article;
    Double quantite;
    Date date;
    Integer status;

    public Service_besoin(Integer id_service_besoin, Integer id_service, Integer id_article, Double quantite, Date date,
            Integer status) {
        this.id_service_besoin = id_service_besoin;
        this.id_service = id_service;
        this.id_article = id_article;
        this.quantite = quantite;
        this.date = date;
        this.status = status;
    }

    public Service_besoin() {
    }

    public Integer getId_service_besoin() {
        return id_service_besoin;
    }

    public void setId_service_besoin(Integer id_service_besoin) {
        this.id_service_besoin = id_service_besoin;
    }

    public Integer getId_service() {
        return id_service;
    }

    public void setId_service(Integer id_service) {
        this.id_service = id_service;
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void insertServiceBesoin(Connection c, int idService, int idArticle, double quantite)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()) {
                c = (new Connect()).connecter();
                coTest = true;
            }

            Statement st = c.createStatement();
            String sql = "insert into service_besoin(id_service,id_article,quantite,date,status) values("+idService+","+idArticle+","+quantite+",DEFAULT,0)";
            int exct = st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public Service_besoin[] getAllServiceBesoinFiltre(Connection c, int idService)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()) {
                c = (new Connect()).connecter();
                coTest = true;
            }

            Statement st = c.createStatement();
            String sql = "select id_article, sum(quantite) from service_besoin where id_service ="+idService+" and status = 0 group by id_article";
            List<Service_besoin> allSb = new ArrayList<>();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allSb.add(new Service_besoin(0,idService,res.getInt(1),res.getDouble(2),null,0));
            }
            Service_besoin[] all = new Service_besoin[allSb.size()];
            return allSb.toArray(all);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    //status 0 en attente, 5 confirmer bondecommande fa mbola tsy ao anaty stock, 10 anaty stock
    public Service_besoin[] getAllServiceBesoin(Connection c, int idService)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}

            Statement st = c.createStatement();
            String sql = "select * from service_besoin where id_service ="+idService+" and status = 0";
            List<Service_besoin> allSb = new ArrayList<>();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allSb.add(new Service_besoin(res.getInt(1),res.getInt(2),res.getInt(3),res.getDouble(4),res.getDate(5),res.getInt(6)));
            }
            Service_besoin[] all = new Service_besoin[allSb.size()];
            return allSb.toArray(all);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public void updateStatus(Connection c, int status, int idServiceBesoin)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}

            Statement st = c.createStatement();
            String sql = "update service_besoin set status="+status+" where id_service_besoin = "+idServiceBesoin;
            int ok = st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    @Deprecated
    public List<Service_besoin> getServiBesoinByAchat(Connection connection) throws Exception {
        List<Service_besoin> valiny = new ArrayList<Service_besoin>();
        boolean verif = false;
        try {
            if (connection == null || connection.isClosed()) {
                verif = true;
                connection = new Connect().connecter();
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from service_besoin where id_service = 6 and status >= 10");
            while (resultSet.next()) {
                Service_besoin serviceBesoin = new Service_besoin();
                serviceBesoin.setId_service_besoin(resultSet.getInt("id_service_besoin"));
            }
        }catch (Exception e) {

        }
        finally {
            if (verif == true) {
                connection.close();
            }
        }

        return valiny;
    }


    public Service_besoin verificationServiceAchat(Connection c, int idServiceBesoin)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}

            Statement st = c.createStatement();
            String sql = "select * from service_besoin where id_service_besoin ="+idServiceBesoin;
            ResultSet res = st.executeQuery(sql);
            Service_besoin sb = new Service_besoin();
            while (res.next()) {
                sb = new Service_besoin(res.getInt(1), res.getInt(2), res.getInt(3), res.getDouble(4), res.getDate(5), res.getInt(6));
            }
            if (sb.getId_service()==6) {
                return sb;
            }
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public HashMap<String,String[]> getAll(Connection c)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}

            Statement st = c.createStatement();
            String sql = "select sum(quantite) as quantite, id_article from service_besoin group by id_article";
            ResultSet res = st.executeQuery(sql);
            Service_besoin sb = new Service_besoin();
            List<String> str = new ArrayList<>();
            List<String> stt = new ArrayList<>();
            while (res.next()) {
                str.add(res.getString(1));
                stt.add(res.getString(2));
            }

            String[] ss = new String[str.size()];
            String[] sd = new String[stt.size()];
            HashMap<String,String[]> resu = new HashMap<String,String[]>();
            resu.put("qt", str.toArray(ss));
            resu.put("article", stt.toArray(sd));

            return resu;
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

