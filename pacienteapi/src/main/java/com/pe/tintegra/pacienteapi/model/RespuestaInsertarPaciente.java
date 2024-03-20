package com.pe.tintegra.pacienteapi.model;

import lombok.Data;

@Data
public class RespuestaInsertarPaciente {
    private Integer codigoRespuesta;
    private String mensajeRespuesta;
    private Integer nuevoId;
}
