package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoHayki;
import com.portfolio.mgb.Entity.Hayki;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.SHayki;
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

@RestController
@RequestMapping("/hayki")
@CrossOrigin(origins = "http://localhost:4200")
public class CHayki {
    @Autowired
    SHayki sHayki;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hayki>> list(){
        List<Hayki> list = sHayki.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hayki> getById(@PathVariable("id") int id){
        if(!sHayki.existsById(id))
            return new ResponseEntity(new Mensaje("no existe el id"), HttpStatus.NOT_FOUND);
        Hayki hayki = sHayki.getOne(id).get();
        return new ResponseEntity(hayki, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHayki.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sHayki.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHayki dtohayki){      
        if(StringUtils.isBlank(dtohayki.getNombreH())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sHayki.existsByNombreH(dtohayki.getNombreH())){
            return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);
        }
        
        Hayki hayki = new Hayki(
                dtohayki.getNombreH(), dtohayki.getPorcentajeH(),dtohayki.getImgH()
            );
        sHayki.save(hayki);
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHayki dtohayki){
         //Validamos si existe el ID
        if(!sHayki.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de hayki
        if(sHayki.existsByNombreH(dtohayki.getNombreH()) && sHayki.getByNombreH(dtohayki.getNombreH()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtohayki.getNombreH()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Hayki hayki = sHayki.getOne(id).get();
        hayki.setNombreH(dtohayki.getNombreH());
        hayki.setPorcentajeH(dtohayki.getPorcentajeH());
        hayki.setImgH(dtohayki.getImgH());
        
        sHayki.save(hayki);
        return new ResponseEntity(new Mensaje("Hayki actualizada"), HttpStatus.OK);
        
    }
}

