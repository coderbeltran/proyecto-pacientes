package com.pe.tintegra.pacienteapi.service.impl;

import com.pe.tintegra.pacienteapi.model.Sexo;
import com.pe.tintegra.pacienteapi.model.TipoDocumentoIdentidad;
import com.pe.tintegra.pacienteapi.repository.SexoRepository;
import com.pe.tintegra.pacienteapi.repository.TipoDocumentoIdentidadRepository;
import com.pe.tintegra.pacienteapi.service.SexoService;
import com.pe.tintegra.pacienteapi.service.TipoDocumentoService;
import com.pe.tintegra.pacienteapi.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    private TipoDocumentoIdentidadRepository tipoDocumentoRepository;


    @Override
    public ResponseEntity<?> listarTipoDocumentoIdentidad() {
        List<TipoDocumentoIdentidad> tipoDocumentos =  tipoDocumentoRepository.listarTipoDocumentoIdentidad();
        return ResponseUtil.handleSuccess(tipoDocumentos);
    }
}
