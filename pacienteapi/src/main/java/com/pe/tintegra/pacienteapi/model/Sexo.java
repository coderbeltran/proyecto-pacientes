package com.pe.tintegra.pacienteapi.model;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tc_sexo")
public class Sexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sexo")
    private Integer idSexo;

    @Column(name = "descripcion_sexo", length = 25)
    private String descripcionSexo;

    @Column(name = "fl_estado", columnDefinition = "bit", nullable = false)
    private Boolean estado;

    // Constructor, getters y setters
}