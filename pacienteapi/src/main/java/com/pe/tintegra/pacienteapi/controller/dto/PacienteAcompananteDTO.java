package com.pe.tintegra.pacienteapi.controller.dto;

import com.pe.tintegra.pacienteapi.model.Paciente;
import com.pe.tintegra.pacienteapi.model.PacienteAcompanante;
import lombok.Data;

@Data
public class PacienteAcompananteDTO {
    private Paciente paciente;
    private PacienteAcompanante acompanante;
}
