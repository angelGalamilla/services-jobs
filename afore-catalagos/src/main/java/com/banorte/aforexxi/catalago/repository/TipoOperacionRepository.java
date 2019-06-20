package com.banorte.aforexxi.catalago.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banorte.aforexxi.catalago.model.TipoOperacion;
import com.banorte.aforexxi.catalago.model.Tramite;

@Repository
public interface TipoOperacionRepository extends JpaRepository<TipoOperacion, Integer> {

  public List<TipoOperacion> findByTramite(Tramite tramite);
}
