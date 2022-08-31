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
public class Baner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String profesionH;
    private String acercaH;
    private String imgH;

    //Constructor vacio
    public Baner() {
    }
    //Constructor
    public Baner(String profesionH, String acercaH, String imgH) {
        this.profesionH = profesionH;
        this.acercaH = acercaH;
        this.imgH = imgH;
    }
    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfesionH() {
        return profesionH;
    }

    public void setProfesionH(String profesionH) {
        this.profesionH = profesionH;
    }

    public String getAcercaH() {
        return acercaH;
    }

    public void setAcercaH(String acercaH) {
        this.acercaH = acercaH;
    }

    public String getImgH() {
        return imgH;
    }

    public void setImgH(String imgH) {
        this.imgH = imgH;
    }
    
}
