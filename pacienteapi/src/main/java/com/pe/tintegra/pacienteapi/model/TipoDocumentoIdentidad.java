package com.pe.tintegra.pacienteapi.model;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tc_tipo_documento_identidad")
public class TipoDocumentoIdentidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento_identidad")
    private Integer idTipoDocumentoIdentidad;

    @Column(name = "descripcion_tipo_documento_identidad", length = 50)
    private String descripcionTipoDocumentoIdentidad;

    @Column(name = "codigo_ieds", length = 2)
    private String codigoIeds;

    @Column(name = "fl_estado", columnDefinition = "bit", nullable = false)
    private Boolean estado;

    // Constructor, getters y setters
}