package com.pe.tintegra.pacienteapi.controller.dto.ubigeo;

import lombok.Data;

import java.util.List;

@Data
public class Departamento {
    private String id;
    private String nombre;
    private List<Provincia> provincias;
}
