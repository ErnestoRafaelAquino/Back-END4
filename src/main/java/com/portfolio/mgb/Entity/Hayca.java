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
public class Hayca {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloH;
    private String textoH;
    private String imgH;

    //Constructor vacio
    public Hayca() {
    }

    //Constructor
    public Hayca(String tituloH, String textoH, String imgH) {
        this.tituloH = tituloH;
        this.textoH = textoH;
        this.imgH = imgH;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloH() {
        return tituloH;
    }

    public void setTituloH(String tituloH) {
        this.tituloH = tituloH;
    }

    public String getTextoH() {
        return textoH;
    }

    public void setTextoH(String textoH) {
        this.textoH = textoH;
    }

    public String getImgH() {
        return imgH;
    }

    public void setImgH(String imgH) {
        this.imgH = imgH;
    }
      
}
