package com.pe.tintegra.pacienteapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "tb_paciente"  )
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "id_sexo")
    private Integer idSexo;
    @Column(name = "fe_nacimiento")
    private LocalDate feNacimiento;
    @Column(name = "no_lugar_nacimiento")
    private String noLugarNacimiento;
    @Column(name = "no_direccion")
    private String noDireccion;
    @Column(name = "co_ubigeo")
    private String coUbigeo;
}
