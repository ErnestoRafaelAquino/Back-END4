/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.Baner;
import com.portfolio.mgb.Repository.RBaner;
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
public class SBaner {
    @Autowired
    RBaner rBaner;
    
    public List<Baner> list(){
        return rBaner.findAll();
    }
    
    public Optional<Baner> getOne(int id){
        return rBaner.findById(id);
    }
    
    public Optional<Baner> getByProfesionH(String profesionH){
        return rBaner.findByProfesionH(profesionH);
    }
    
    public void save(Baner baner){
        rBaner.save(baner);
    }
    
    public void delete(int id){
        rBaner.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rBaner.existsById(id);
    }
    
    public boolean existsByProfesionH(String profesionH){
        return rBaner.existsByProfesionH(profesionH);
    }
}
