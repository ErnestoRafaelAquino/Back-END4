/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.Formacion;
import com.portfolio.mgb.Repository.RFormacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ernesto Aquino
 */
@Service
@Transactional
public class SFormacion {
    @Autowired
    RFormacion rFormacion;
    
    public List<Formacion> list(){
        return rFormacion.findAll();
    }
    
    public Optional<Formacion> getOne(int id){
        return rFormacion.findById(id);
    }
    
    public  Optional<Formacion> getByContenidoM(String contenidoM){
        return rFormacion.findByContenidoM(contenidoM);
    }
    
    public void save(Formacion formacion){
        rFormacion.save(formacion);
    }
    
    public void delete(int id){
        rFormacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rFormacion.existsById(id);
    }
    
    public boolean existsByContenidoM(String contenidoM){
        return rFormacion.existsByContenidoM(contenidoM);
    }
}
