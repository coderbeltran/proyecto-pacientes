package com.pe.tintegra.pacienteapi.repository;

import com.pe.tintegra.pacienteapi.model.TipoDocumentoIdentidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TipoDocumentoIdentidadRepository extends JpaRepository<TipoDocumentoIdentidad, Integer> {

    @Query(value = "SELECT * FROM listar_tipo_documento_identidad()", nativeQuery = true)
    List<TipoDocumentoIdentidad> listarTipoDocumentoIdentidad();
}