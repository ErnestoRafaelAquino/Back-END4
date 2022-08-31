/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.Hayca;
import com.portfolio.mgb.Repository.RHayca;
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
public class SHayca {
    @Autowired
    RHayca rHayca;
    
    public List<Hayca> list(){
        return rHayca.findAll();
    }
    
    public Optional<Hayca> getOne(int id){
        return rHayca.findById(id);
    }
    
    public Optional<Hayca> getByTituloH(String tituloH){
        return rHayca.findByTituloH(tituloH);
    }
    
    public void save(Hayca hayca){
        rHayca.save(hayca);
    }
    
    public void delete(int id){
        rHayca.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHayca.existsById(id);
    }
    
    public boolean existsByTituloH(String tituloH){
        return rHayca.existsByTituloH(tituloH);
    }
}
