package com.banorte.aforexxi.catalago.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banorte.aforexxi.catalago.model.SubProceso;
import com.banorte.aforexxi.catalago.model.Tramite;

@Repository
public interface TramiteRepository extends JpaRepository<Tramite, Integer> {

  public List<Tramite> findBySubproceso(SubProceso subproceso);
}
