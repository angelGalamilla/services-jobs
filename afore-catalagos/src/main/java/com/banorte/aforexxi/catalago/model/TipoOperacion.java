package com.banorte.aforexxi.catalago.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cat_tipo_operacion")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoOperacion implements Serializable {


  private static final long serialVersionUID = -1134530640924233854L;

  @Id
  @GeneratedValue
  @Column(name = "id_cat_tipo_operacion", nullable = false, length = 5)
  private Integer idOperacion;

  @Column(name = "clave", length = 10)
  private String clave;

  @Column(name = "nombre", length = 255)
  private String nombre;

  @ManyToOne
  @JoinColumn(name = "idTramite", nullable = false)
  private Tramite tramite;
  
  @Column(name = "activo", columnDefinition = "integer default 1", length = 1)
  private Integer activo;
}
