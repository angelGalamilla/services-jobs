package com.banorte.aforexxi.catalago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banorte.aforexxi.catalago.model.ProcesoUnificado;

@Repository
public interface ProcesoUnificadoRepository extends JpaRepository<ProcesoUnificado, Integer> {

}
