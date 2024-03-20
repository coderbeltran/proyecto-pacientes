package com.pe.tintegra.pacienteapi.repository;

import com.pe.tintegra.pacienteapi.model.Parentesco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentescoRepository extends JpaRepository<Parentesco, Integer> {

    @Query(value = "SELECT * FROM listar_parentesco()", nativeQuery = true)
    List<Parentesco> listarParentesco();
}
