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
public class dtoBaner {
    @NotBlank
    private String profesionH;
    @NotBlank
    private String acercaH;
    @NotBlank
    private String imgH;
    
    //constructor vacio
    public dtoBaner() {
    }
    
    //constructor 

    public dtoBaner(String profesionH, String acercaH, String imgH) {
        this.profesionH = profesionH;
        this.acercaH = acercaH;
        this.imgH = imgH;
    }
    //GettER and Setter

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
