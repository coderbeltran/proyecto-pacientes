package com.pe.tintegra.pacienteapi.repository;

import com.pe.tintegra.pacienteapi.model.Paciente;
import com.pe.tintegra.pacienteapi.model.PacienteAcompanante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PacienteAcompananteRepository extends JpaRepository<PacienteAcompanante, Integer> {


    @Query(value = "SELECT * FROM obtener_detalle_acompanante(:idpaciente)", nativeQuery = true)
    PacienteAcompanante detalleAcompanante(
            @Param("idpaciente") Integer idpaciente
    );

    @Query(nativeQuery = true, value = "SELECT * FROM insertar_paciente_acompanante" +
            "(:id_paciente_input, :id_tipo_docide_input, :no_docide_input, :no_apepat_input, " +
            ":no_apemat_input, :no_nombres_input, :fe_nacimiento_input, :id_parentesco_input, " +
            ":nu_telefo_contacto_input, :no_direccion_input, :co_ubigeo_input) " +
            "AS result(po_cod_respuesta INTEGER, po_mensaje_respuesta VARCHAR, new_id INTEGER)")
    Map<String, Object> insertarPacienteAcompanante(
            @Param("id_paciente_input") Integer idPaciente,
            @Param("id_tipo_docide_input") Integer idTipoDocide,
            @Param("no_docide_input") String noDocide,
            @Param("no_apepat_input") String noApepat,
            @Param("no_apemat_input") String noApemat,
            @Param("no_nombres_input") String noNombres,
            @Param("fe_nacimiento_input") LocalDate feNacimiento,
            @Param("id_parentesco_input") Integer idParentesco,
            @Param("nu_telefo_contacto_input") String nuTelefoContacto,
            @Param("no_direccion_input") String noDireccion,
            @Param("co_ubigeo_input") String coUbigeo
    );
    @Query(value = "SELECT * FROM  admision.actualizar_acompanante("
            + ":idPacienteAcompanante, :idPaciente, :idTipoDocide, :noDocide, :noApepat, :noApemat, :noNombres, "
            + ":feNacimiento, :idParentesco, :nuTelefoContacto, :noDireccion, :coUbigeo) AS result(po_cod_respuesta INTEGER, po_mensaje_respuesta VARCHAR)", nativeQuery = true)
    Map<String, Object>  actualizarAcompanante(
            @Param("idPacienteAcompanante") Integer idPacienteAcompanante,
            @Param("idPaciente") Integer idPaciente,
            @Param("idTipoDocide") Integer idTipoDocide,
            @Param("noDocide") String noDocide,
            @Param("noApepat") String noApepat,
            @Param("noApemat") String noApemat,
            @Param("noNombres") String noNombres,
            @Param("feNacimiento") LocalDate feNacimiento,
            @Param("idParentesco") Integer idParentesco,
            @Param("nuTelefoContacto") String nuTelefoContacto,
            @Param("noDireccion") String noDireccion,
            @Param("coUbigeo") String coUbigeo
    );

}
