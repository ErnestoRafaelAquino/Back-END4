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

public class dtoHayki {
    @NotBlank
    private String nombreH;
    @NotBlank
    private int porcentajeH;
    @NotBlank
    private String imgH;
    
    //constructor

    public dtoHayki() {
    }

    public dtoHayki(String nombreH, int porcentajeH, String imgH) {
        this.nombreH = nombreH;
        this.porcentajeH = porcentajeH;
        this.imgH = imgH;
    }
    
    //GettER and Setter

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
