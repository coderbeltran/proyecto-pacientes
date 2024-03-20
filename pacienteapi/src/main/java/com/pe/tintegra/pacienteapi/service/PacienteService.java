package com.pe.tintegra.pacienteapi.service;

import com.pe.tintegra.pacienteapi.controller.dto.PacienteAcompananteDTO;
import com.pe.tintegra.pacienteapi.controller.dto.RegistrarPacienteRequest;
import org.springframework.http.ResponseEntity;

public interface PacienteService {
    ResponseEntity<?> buscarPacientes(Integer tipoDocumento,String nombre,String apellidos,String documento);
    ResponseEntity<?> detallePacienteAcompanante(Integer idPaciente);
    ResponseEntity<?> registrarPaciente(RegistrarPacienteRequest request);
    ResponseEntity<?> actualizarPaciente(RegistrarPacienteRequest request);
    ResponseEntity<?> eliminarPaciente(Integer idPaciente);
}
