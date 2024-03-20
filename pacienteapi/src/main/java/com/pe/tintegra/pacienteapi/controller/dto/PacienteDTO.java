package com.pe.tintegra.pacienteapi.controller.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class PacienteDTO {
    private Integer idTipoDocide;
    private String noDocide;
    private String noApepat;
    private String noApemat;
    private String noNombres;
    private Integer idSexo;
    private LocalDate feNacimiento;
    private String noLugarNacimiento;
    private String noDireccion;
    private String coUbigeo;
}
