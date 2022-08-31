/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.Haypro;
import com.portfolio.mgb.Repository.RHaypro;
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
public class SHaypro {
    @Autowired
     RHaypro rHaypro;
    
    public List<Haypro> list(){
         return rHaypro.findAll();
     }
    
     public Optional<Haypro> getOne(int id){
         return rHaypro.findById(id);
     }
     
     public Optional<Haypro> getByTituloH(String tituloH){
         return rHaypro.findByTituloH(tituloH);
     }
     
     public void save(Haypro haypro){
         rHaypro.save(haypro);
     }
     
     public void delete(int id){
         rHaypro.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rHaypro.existsById(id);
     }
     
     public boolean existsByTituloH(String tituloH){
         return rHaypro.existsByTituloH(tituloH);
     }
}
