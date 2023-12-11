package com.example.sosieteantsika.model;

import java.sql.Date;

public class Service_besoin {
    Integer id_service_besoin;
    Integer id_service;
    Integer id_article;
    Double quantite;
    Date date;
    Integer status;

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
}
