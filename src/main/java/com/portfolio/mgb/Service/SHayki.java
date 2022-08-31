/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.Hayki;
import com.portfolio.mgb.Repository.RHayki;
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
public class SHayki {
    @Autowired
    RHayki rHayki;
    
    public List<Hayki> list(){
        return rHayki.findAll();
    }
    
    public Optional<Hayki> getOne(int id){
        return rHayki.findById(id);
    }
    
    public Optional<Hayki> getByNombreH(String nombreH){
        return rHayki.findByNombreH(nombreH);
    }
    
    public void save(Hayki hayki){
        rHayki.save(hayki);
    }
    
    public void delete(int id){
        rHayki.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHayki.existsById(id);
    }
    
    public boolean existsByNombreH(String nombreH){
        return rHayki.existsByNombreH(nombreH);
    }
}
