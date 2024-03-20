package com.pe.tintegra.pacienteapi.repository;

import com.pe.tintegra.pacienteapi.model.Ubigeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UbigeoRepository extends JpaRepository<Ubigeo, Integer> {

    @Query(value = "SELECT * FROM listar_ubigeo()", nativeQuery = true)
    List<Ubigeo> listarUbigeo();

}
