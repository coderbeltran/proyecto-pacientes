package com.pe.tintegra.pacienteapi.model;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tc_ubigeo")
public class Ubigeo {

    @Id
    @Column(name = "codigo_ubigeo", length = 6)
    private String codigoUbigeo;

    @Column(name = "descripcion_departamento", length = 200)
    private String descripcionDepartamento;

    @Column(name = "descripcion_provincia", length = 200)
    private String descripcionProvincia;

    @Column(name = "descripcion_distrito", length = 200)
    private String descripcionDistrito;

    @Column(name = "fl_estado", columnDefinition = "bit", nullable = false)
    private Boolean estado;

    @Column(name = "codigo_departamento", length = 2)
    private String codigoDepartamento;

    @Column(name = "codigo_provincia", length = 2)
    private String codigoProvincia;

    @Column(name = "codigo_distrito", length = 2)
    private String codigoDistrito;

    // Constructor, getters y setters
}
