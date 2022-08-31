/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ernesto Aquino
 */
@Entity
public class Formacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contenidoM;
    private String imgM;

    public Formacion() {
    }

    public Formacion(String contenidoM, String imgM) {
        this.contenidoM = contenidoM;
        this.imgM = imgM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenidoM() {
        return contenidoM;
    }

    public void setContenidoM(String contenidoM) {
        this.contenidoM = contenidoM;
    }

    public String getImgM() {
        return imgM;
    }

    public void setImgM(String imgM) {
        this.imgM = imgM;
    }
    
}
