package com.pe.tintegra.pacienteapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tc_parentesco")
public class Parentesco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parentesco")
    private Integer idParentesco;

    @Column(name = "no_parentesco", nullable = false)
    private String nombreParentesco;

    @Column(name = "il_activo", nullable = false)
    private Boolean activo;

    // Constructor, getters y setters
}