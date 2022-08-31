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
public class dtoFormacion {
    @NotBlank
    private String contenidoM;
    @NotBlank
    private String imgM;

    public dtoFormacion() {
    }

    public dtoFormacion(String contenidoM, String imgM) {
        this.contenidoM = contenidoM;
        this.imgM = imgM;
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
