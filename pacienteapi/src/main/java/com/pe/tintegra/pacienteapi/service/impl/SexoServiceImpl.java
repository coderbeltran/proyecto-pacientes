package com.pe.tintegra.pacienteapi.service.impl;

import com.pe.tintegra.pacienteapi.model.Sexo;
import com.pe.tintegra.pacienteapi.repository.SexoRepository;
import com.pe.tintegra.pacienteapi.service.SexoService;
import com.pe.tintegra.pacienteapi.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SexoServiceImpl implements SexoService {
    private SexoRepository sexoRepository;


    @Override
    public ResponseEntity<?> listarSexo() {
        List<Sexo> listaSexos = sexoRepository.listarSexo();
        return ResponseUtil.handleSuccess(listaSexos);
    }
}
