package com.pe.tintegra.pacienteapi.controller.dto;

import lombok.Data;

@Data
public class RegistrarPacienteRequest {
    public PacienteRequest paciente;
    public AcompananteRequest acompanante;
}
