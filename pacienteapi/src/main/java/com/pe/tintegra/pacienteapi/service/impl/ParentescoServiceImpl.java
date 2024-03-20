package com.pe.tintegra.pacienteapi.service.impl;

import com.pe.tintegra.pacienteapi.model.Parentesco;
import com.pe.tintegra.pacienteapi.model.Sexo;
import com.pe.tintegra.pacienteapi.repository.ParentescoRepository;
import com.pe.tintegra.pacienteapi.repository.SexoRepository;
import com.pe.tintegra.pacienteapi.service.ParentescoService;
import com.pe.tintegra.pacienteapi.service.SexoService;
import com.pe.tintegra.pacienteapi.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParentescoServiceImpl implements ParentescoService {
    private ParentescoRepository parentescoRepository;


    @Override
    public ResponseEntity<?> listarParentesco() {
        List<Parentesco>  parentescos  = parentescoRepository.listarParentesco();
        return ResponseUtil.handleSuccess(parentescos);
    }
}
