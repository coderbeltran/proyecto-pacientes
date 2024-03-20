package com.pe.tintegra.pacienteapi.service;

import com.pe.tintegra.pacienteapi.controller.dto.PacienteAcompananteDTO;
import org.springframework.http.ResponseEntity;

public interface UbigeoService {
    ResponseEntity<?> listarUbigeo();
}
