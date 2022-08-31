/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mgb.Repository;

import com.portfolio.mgb.Entity.Haypro;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ernesto Aquino
 */
@Repository
public interface RHaypro extends JpaRepository<Haypro, Integer>{
    public Optional<Haypro> findByTituloH(String tituloH);
    public boolean existsByTituloH(String tituloH);
}
