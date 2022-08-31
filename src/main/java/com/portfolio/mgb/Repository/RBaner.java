/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mgb.Repository;

import com.portfolio.mgb.Entity.Baner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ernesto Aquino
 */
@Repository
public interface RBaner extends JpaRepository<Baner, Integer>{
    public Optional<Baner> findByProfesionH(String profesionH);
    public boolean existsByProfesionH(String profesionH);
}
