package com.pe.tintegra.pacienteapi.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AcompananteRequest {
    private Integer idPacienteAcompanante;
    private Integer idPaciente;
    private Integer tipoDocumento;
    private String documento;
    private String apellidoPat;
    private String apellidoMat;
    private String nombres;
    private LocalDate fechaNacimiento;
    private Integer idParentesco;
    private String telefono;
    private String direccion;
    private String ubigeo;
}
