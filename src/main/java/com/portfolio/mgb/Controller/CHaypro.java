/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoHaypro;
import com.portfolio.mgb.Entity.Haypro;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.SHaypro;
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
@RequestMapping("/haypro")
@CrossOrigin(origins = "http://localhost:4200")
public class CHaypro {
    @Autowired
    SHaypro sHaypro;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Haypro>> list(){
        List<Haypro> list = sHaypro.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Haypro> getById(@PathVariable("id")int id){
        if(!sHaypro.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Haypro haypro = sHaypro.getOne(id).get();
        return new ResponseEntity(haypro, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHaypro.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sHaypro.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHaypro dtohaypro){
        if(StringUtils.isBlank(dtohaypro.getTituloH())){
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sHaypro.existsByTituloH(dtohaypro.getTituloH())){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Haypro haypro = new Haypro(
                dtohaypro.getTituloH(), dtohaypro.getTextoH(),dtohaypro.getLinkH(),dtohaypro.getImgH()
            );
        sHaypro.save(haypro);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
                
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHaypro dtohaypro){
        if(!sHaypro.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sHaypro.existsByTituloH(dtohaypro.getTituloH()) && sHaypro.getByTituloH(dtohaypro.getTituloH()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohaypro.getTituloH())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Haypro haypro = sHaypro.getOne(id).get();
        
        haypro.setTituloH(dtohaypro.getTituloH());
        haypro.setTextoH(dtohaypro.getTextoH());
        haypro.setLinkH(dtohaypro.getLinkH());
        haypro.setImgH(dtohaypro.getImgH());
                           
        sHaypro.save(haypro);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
