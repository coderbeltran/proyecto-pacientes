package com.pe.tintegra.pacienteapi.repository;

import com.pe.tintegra.pacienteapi.model.Paciente;
import com.pe.tintegra.pacienteapi.model.RespuestaInsertarPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query(value = "SELECT * FROM buscar_pacientes(:tipo_docide_param, :nombres_param, :apellidos, :docide)", nativeQuery = true)
    List<Paciente> buscarPacientes(
            @Param("tipo_docide_param") Integer tipoDocide,
            @Param("nombres_param") String nombres,
            @Param("apellidos") String apellidos,
            @Param("docide") String doc
    );

    @Query(value = "SELECT * FROM obtener_detalle_paciente(:idpaciente)", nativeQuery = true)
    Paciente detallePaciente(
            @Param("idpaciente") Integer idpaciente
    );
    @Query(value = "SELECT * FROM admision.insertar_paciente(:id_tipo_docide, :no_docide, :no_apepat, :no_apemat, :no_nombres, :id_sexo, :fe_nacimiento, :no_lugar_nacimiento, :no_direccion, :co_ubigeo) AS result(po_cod_respuesta INTEGER, po_mensaje_respuesta VARCHAR,new_id INTEGER)", nativeQuery = true)
    Map<String, Object> insertarPaciente(
            @Param("id_tipo_docide") Integer idTipoDocide,
            @Param("no_docide") String noDocide,
            @Param("no_apepat") String noApepat,
            @Param("no_apemat") String noApemat,
            @Param("no_nombres") String noNombres,
            @Param("id_sexo") Integer idSexo,
            @Param("fe_nacimiento") LocalDate feNacimiento,
            @Param("no_lugar_nacimiento") String noLugarNacimiento,
            @Param("no_direccion") String noDireccion,
            @Param("co_ubigeo") String coUbigeo
    );

    @Query(value = "SELECT * FROM admision.actualizar_paciente("
            + ":idPaciente, :idTipoDocide, :noDocide, :noApepat, :noApemat, :noNombres, "
            + ":idSexo, :feNacimiento, :noLugarNacimiento, :noDireccion, :coUbigeo) AS result(po_cod_respuesta INTEGER, po_mensaje_respuesta VARCHAR)", nativeQuery = true)
    Map<String, Object> actualizarPaciente(
            @Param("idPaciente") Integer idPaciente,
            @Param("idTipoDocide") Integer idTipoDocide,
            @Param("noDocide") String noDocide,
            @Param("noApepat") String noApepat,
            @Param("noApemat") String noApemat,
            @Param("noNombres") String noNombres,
            @Param("idSexo") Integer idSexo,
            @Param("feNacimiento") LocalDate feNacimiento,
            @Param("noLugarNacimiento") String noLugarNacimiento,
            @Param("noDireccion") String noDireccion,
            @Param("coUbigeo") String coUbigeo
    );
    List<Paciente> findByNoNombres(String no_nombres);
    List<Paciente> findByNoApepat(String no_apepat);
    Optional<Paciente> findByNoDocide(String no_docide);
    //boolean existsByNoDocide(String no_docide);
    //boolean existsByNoDocideIdNot(String ndocumento, Integer id);
    /*@Modifying
    @Query(value = "SELECT * FROM admision.actualizar_paciente("
            + ":idPaciente) AS result(po_cod_respuesta INTEGER, po_mensaje_respuesta VARCHAR)", nativeQuery = true)
    Object[] eliminarPaciente(@Param("idPaciente") Integer idPaciente);*/

    @Query(value = "SELECT * FROM  admision.eliminar_paciente(:idPaciente) AS result(po_cod_respuesta INTEGER, po_mensaje_respuesta VARCHAR)", nativeQuery = true)
    Map<String, Object>  eliminarPaciente(@Param("idPaciente") Integer idPaciente);
}
