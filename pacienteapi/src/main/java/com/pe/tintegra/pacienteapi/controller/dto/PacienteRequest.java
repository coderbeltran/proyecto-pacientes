package com.pe.tintegra.pacienteapi.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteRequest {
    private Integer idPaciente;
    private Integer tipoDocumento;
    private String documento;
    private String apellidoPat;
    private String apellidoMat;
    private String nombres;
    private Integer idSexo;
    private LocalDate fechaNacimiento;
    private String lugarNacimiento;
    private String direccion;
    private String ubigeo;
}
