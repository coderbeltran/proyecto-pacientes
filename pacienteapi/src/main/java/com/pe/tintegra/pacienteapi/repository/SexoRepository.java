package com.pe.tintegra.pacienteapi.repository;

import com.pe.tintegra.pacienteapi.model.Sexo;
import com.pe.tintegra.pacienteapi.model.Ubigeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SexoRepository extends JpaRepository<Sexo, Integer> {

    @Query(value = "SELECT * FROM listar_sexo()", nativeQuery = true)
    List<Sexo> listarSexo();

}
