/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoHayca;
import com.portfolio.mgb.Entity.Hayca;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.SHayca;
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
@RequestMapping("/hayca")
@CrossOrigin(origins = "http://localhost:4200")
public class CHayca {
    @Autowired
    SHayca sHayca;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hayca>> list(){
        List<Hayca> list = sHayca.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hayca> getById(@PathVariable("id") int id){
        if(!sHayca.existsById(id))
            return new ResponseEntity(new Mensaje("no existe el id"), HttpStatus.NOT_FOUND);
        Hayca hayca = sHayca.getOne(id).get();
        return new ResponseEntity(hayca, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHayca.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sHayca.delete(id);
        return new ResponseEntity(new Mensaje("carta eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHayca dtohayca){      
        if(StringUtils.isBlank(dtohayca.getTituloH())){
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sHayca.existsByTituloH(dtohayca.getTituloH())){
            return new ResponseEntity(new Mensaje("Esa hayca existe"), HttpStatus.BAD_REQUEST);
        }
        
        Hayca hayca = new Hayca(
                dtohayca.getTituloH(), dtohayca.getTextoH(),dtohayca.getImgH()
            );
        sHayca.save(hayca);
        return new ResponseEntity(new Mensaje("Hayca agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHayca dtohayca){
         //Validamos si existe el ID
        if(!sHayca.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de hayca
        if(sHayca.existsByTituloH(dtohayca.getTituloH()) && sHayca.getByTituloH(dtohayca.getTituloH()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa hayca ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtohayca.getTituloH()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Hayca hayca = sHayca.getOne(id).get();
        hayca.setTituloH(dtohayca.getTituloH());
        hayca.setTextoH(dtohayca.getTextoH());
        hayca.setImgH(dtohayca.getImgH());
        
        sHayca.save(hayca);
        return new ResponseEntity(new Mensaje("Hayca actualizada"), HttpStatus.OK);
        
    }
}
