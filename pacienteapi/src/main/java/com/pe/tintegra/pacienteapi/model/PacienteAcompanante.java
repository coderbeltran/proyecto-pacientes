package com.pe.tintegra.pacienteapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_paciente_acompanante")
public class PacienteAcompanante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente_acompanante")
    private Integer idPacienteAcompanante;

    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "id_tipo_docide")
    private Integer idTipoDocide;

    @Column(name = "no_docide")
    private String noDocide;

    @Column(name = "no_apepat")
    private String noApepat;

    @Column(name = "no_apemat")
    private String noApemat;

    @Column(name = "no_nombres")
    private String noNombres;

    @Column(name = "fe_nacimiento")
    private LocalDate feNacimiento;

    @Column(name = "id_parentesco")
    private Integer idParentesco;

    @Column(name = "nu_telefo_contacto")
    private String nuTelefoContacto;

    @Column(name = "no_direccion")
    private String noDireccion;

    @Column(name = "co_ubigeo")
    private String coUbigeo;

}