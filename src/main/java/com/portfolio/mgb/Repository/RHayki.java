/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mgb.Repository;

import com.portfolio.mgb.Entity.Hayki;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ernesto Aquino
 */
@Repository
public interface RHayki extends JpaRepository<Hayki, Integer>{
    public Optional<Hayki> findByNombreH(String nombreH);
    public boolean existsByNombreH(String nombreH);
}
