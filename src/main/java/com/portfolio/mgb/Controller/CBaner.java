/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoBaner;
import com.portfolio.mgb.Entity.Baner;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.SBaner;
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
@RequestMapping("/baner")
@CrossOrigin(origins = "http://localhost:4200")
public class CBaner {
    @Autowired
    SBaner sBaner;
    
        @GetMapping("/lista")
    public ResponseEntity<List<Baner>> list(){
        List<Baner> list = sBaner.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Baner> getById(@PathVariable("id") int id){
        if(!sBaner.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Baner baner = sBaner.getOne(id).get();
        return new ResponseEntity(baner, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sBaner.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sBaner.delete(id);
        return new ResponseEntity(new Mensaje("elemento eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoBaner dtobaner){      
        if(StringUtils.isBlank(dtobaner.getProfesionH())){
            return new ResponseEntity(new Mensaje("El elemento es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sBaner.existsByProfesionH(dtobaner.getProfesionH())){
            return new ResponseEntity(new Mensaje("Esa elemento existe"), HttpStatus.BAD_REQUEST);
        }
        
        Baner baner = new Baner(
                dtobaner.getAcercaH(), dtobaner.getProfesionH(),dtobaner.getImgH()
            );
        sBaner.save(baner);
        return new ResponseEntity(new Mensaje("baner agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBaner dtobaner){
         //Validamos si existe el ID
        if(!sBaner.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara profesion de baner
        if(sBaner.existsByProfesionH(dtobaner.getProfesionH()) && sBaner.getByProfesionH(dtobaner.getProfesionH()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa profesion ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtobaner.getProfesionH()))
            return new ResponseEntity(new Mensaje("La profesion es obligatoria"), HttpStatus.BAD_REQUEST);
        
        Baner baner = sBaner.getOne(id).get();
        baner.setProfesionH(dtobaner.getProfesionH());
        baner.setAcercaH(dtobaner.getAcercaH());
        baner.setImgH(dtobaner.getImgH());
        
        sBaner.save(baner);
        return new ResponseEntity(new Mensaje("baner actualizada"), HttpStatus.OK);
        
    }
}
