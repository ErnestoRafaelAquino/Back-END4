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
public class Hayki {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreH;
    private int porcentajeH;
    private String imgH;
    
    //constructor

    public Hayki() {
    }

    public Hayki(String nombreH, int porcentajeH, String imgH) {
        this.nombreH = nombreH;
        this.porcentajeH = porcentajeH;
        this.imgH = imgH;
    }
    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public int getPorcentajeH() {
        return porcentajeH;
    }

    public void setPorcentajeH(int porcentajeH) {
        this.porcentajeH = porcentajeH;
    }

    public String getImgH() {
        return imgH;
    }

    public void setImgH(String imgH) {
        this.imgH = imgH;
    }

}
