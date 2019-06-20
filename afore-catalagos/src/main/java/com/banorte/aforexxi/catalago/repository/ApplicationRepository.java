package com.banorte.aforexxi.catalago.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banorte.aforexxi.catalago.model.ProcesoUnificado;
import com.banorte.aforexxi.catalago.model.SubProceso;

@Repository
public interface ApplicationRepository extends JpaRepository<SubProceso, Integer> {

  public List<SubProceso> findByProceso(ProcesoUnificado proceso);
}
