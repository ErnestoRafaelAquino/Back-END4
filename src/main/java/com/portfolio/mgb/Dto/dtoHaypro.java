/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Ernesto Aquino
 */
public class dtoHaypro {
    @NotBlank
    private String tituloH;
    @NotBlank
    private String textoH;
    @NotBlank
    private String linkH;
    @NotBlank
    private String imgH; 
    
    //constructor

    public dtoHaypro() {
    }

    public dtoHaypro(String tituloH, String textoH, String linkH, String imgH) {
        this.tituloH = tituloH;
        this.textoH = textoH;
        this.linkH = linkH;
        this.imgH = imgH;
    }
    
    //Getter and Setter

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

    public String getLinkH() {
        return linkH;
    }

    public void setLinkH(String linkH) {
        this.linkH = linkH;
    }

    public String getImgH() {
        return imgH;
    }

    public void setImgH(String imgH) {
        this.imgH = imgH;
    }
    
}
