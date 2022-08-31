/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoFormacion;
import com.portfolio.mgb.Entity.Formacion;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.SFormacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ernesto Aquino
 */
@RestController
@RequestMapping("/formacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CFormacion {
    @Autowired
    SFormacion sFormacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Formacion>> list(){
        List<Formacion> list = sFormacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public  ResponseEntity<Formacion> getById(@PathVariable("id")int id){
        if(!sFormacion.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el id"), HttpStatus.BAD_REQUEST);
        }
        
        Formacion formacion = sFormacion.getOne(id).get();
        return new ResponseEntity(formacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!sFormacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        sFormacion.delete(id);
        return new ResponseEntity(new Mensaje("Contenido eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoFormacion dtoformacion){
        if(StringUtils.isBlank(dtoformacion.getContenidoM())){
            return new ResponseEntity(new Mensaje("El contenido es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sFormacion.existsByContenidoM(dtoformacion.getContenidoM())){
            return new  ResponseEntity(new Mensaje("El contenido ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Formacion formacion = new Formacion(
                dtoformacion.getContenidoM(),dtoformacion.getImgM()
            );
        sFormacion.save(formacion);
        return new ResponseEntity(new Mensaje("Contenido Creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoFormacion dtoformacion){
        if(!sFormacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if(sFormacion.existsByContenidoM(dtoformacion.getContenidoM()) && sFormacion.getByContenidoM(dtoformacion.getContenidoM()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese contenido ya esta presente"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoformacion.getContenidoM())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Formacion formacion = sFormacion.getOne(id).get();
        
        formacion.setContenidoM(dtoformacion.getContenidoM());
        formacion.setImgM(dtoformacion.getImgM());
        
        sFormacion.save(formacion);
        
        return new ResponseEntity(new Mensaje("Formacion Actualizada"), HttpStatus.OK);
    }
}
