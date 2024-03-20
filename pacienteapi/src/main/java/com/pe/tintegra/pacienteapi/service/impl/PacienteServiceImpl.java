package com.pe.tintegra.pacienteapi.service.impl;

import com.pe.tintegra.pacienteapi.controller.dto.AcompananteRequest;
import com.pe.tintegra.pacienteapi.controller.dto.PacienteAcompananteDTO;
import com.pe.tintegra.pacienteapi.controller.dto.PacienteRequest;
import com.pe.tintegra.pacienteapi.controller.dto.RegistrarPacienteRequest;
import com.pe.tintegra.pacienteapi.model.Paciente;
import com.pe.tintegra.pacienteapi.model.PacienteAcompanante;
import com.pe.tintegra.pacienteapi.repository.PacienteAcompananteRepository;
import com.pe.tintegra.pacienteapi.repository.PacienteRepository;
import com.pe.tintegra.pacienteapi.service.PacienteService;
import com.pe.tintegra.pacienteapi.util.ResponseUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteAcompananteRepository pacienteAcompananteRepository;

    @Override
    public ResponseEntity<?> buscarPacientes(Integer tipoDocumento, String nombre, String apellidos, String documento) {
        try {
            List<Paciente> pacientes = pacienteRepository.buscarPacientes(tipoDocumento, nombre, apellidos, documento);
            return ResponseUtil.handleSuccess(pacientes);
        } catch (Exception e) {
            return ResponseUtil.handleError(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> detallePacienteAcompanante(Integer idPaciente) {
        try {
            RegistrarPacienteRequest responseDetalle = new RegistrarPacienteRequest();


            PacienteRequest pacienteResp = new PacienteRequest();
            AcompananteRequest acomResp = new AcompananteRequest();
            Paciente paciente = pacienteRepository.detallePaciente(idPaciente);
            pacienteResp.setIdPaciente(paciente.getIdPaciente());
            pacienteResp.setTipoDocumento(paciente.getIdTipoDocide());
            pacienteResp.setDocumento(paciente.getNoDocide());
            pacienteResp.setApellidoPat(paciente.getNoApepat());
            pacienteResp.setApellidoMat(paciente.getNoApemat());
            pacienteResp.setNombres(paciente.getNoNombres());
            pacienteResp.setIdSexo(paciente.getIdSexo());
            pacienteResp.setFechaNacimiento(paciente.getFeNacimiento());
            pacienteResp.setLugarNacimiento(paciente.getNoLugarNacimiento());
            pacienteResp.setDireccion(paciente.getNoDireccion());
            pacienteResp.setUbigeo(paciente.getCoUbigeo());

            responseDetalle.setPaciente(pacienteResp);
            log.info("pacientes: {}", paciente);
            PacienteAcompanante pacienteAcompanante = pacienteAcompananteRepository.detalleAcompanante(idPaciente);
            log.info("pacienteAcompanante: {}", pacienteAcompanante);
            if (pacienteAcompanante != null) {
                acomResp.setIdPacienteAcompanante(pacienteAcompanante.getIdPacienteAcompanante());
                acomResp.setTipoDocumento(pacienteAcompanante.getIdTipoDocide());
                acomResp.setDocumento(pacienteAcompanante.getNoDocide());
                acomResp.setApellidoPat(pacienteAcompanante.getNoApepat());
                acomResp.setApellidoMat(pacienteAcompanante.getNoApemat());
                acomResp.setNombres(pacienteAcompanante.getNoNombres());
                acomResp.setFechaNacimiento(pacienteAcompanante.getFeNacimiento());
                acomResp.setIdParentesco(pacienteAcompanante.getIdParentesco());
                acomResp.setTelefono(pacienteAcompanante.getNuTelefoContacto());
                acomResp.setDireccion(pacienteAcompanante.getNoDireccion());
                acomResp.setUbigeo(pacienteAcompanante.getCoUbigeo());
                responseDetalle.setAcompanante(acomResp);
            }
            return ResponseUtil.handleSuccess(responseDetalle);
        } catch (Exception e) {
            return ResponseUtil.handleError(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> registrarPaciente(RegistrarPacienteRequest request) {
        try {
            PacienteRequest paciente = request.getPaciente();
            AcompananteRequest pacienteAcompanante = request.getAcompanante();

            Map<String, Object> result = pacienteRepository.insertarPaciente(
                    paciente.getTipoDocumento(),
                    paciente.getDocumento(),
                    paciente.getApellidoPat(),
                    paciente.getApellidoMat(),
                    paciente.getNombres(),
                    paciente.getIdSexo(),
                    paciente.getFechaNacimiento(),
                    paciente.getLugarNacimiento(),
                    paciente.getDireccion(),
                    paciente.getUbigeo()
            );
            System.out.println(result);

            Integer poCodRespuesta = (Integer) result.get("po_cod_respuesta");
            String poMensajeRespuesta = (String) result.get("po_mensaje_respuesta");
            System.out.println(poCodRespuesta);
            String mensajeRespuesta = (String) result.get("po_mensaje_respuesta");
            if (poCodRespuesta == 1) {
                Integer idPaciente = (Integer) result.get("new_id");
                paciente.setIdPaciente(idPaciente);
                pacienteAcompanante.setIdPaciente(idPaciente);

                Map<String, Object> resultAcom = pacienteAcompananteRepository.insertarPacienteAcompanante(
                        paciente.getIdPaciente(),
                        pacienteAcompanante.getTipoDocumento(),
                        pacienteAcompanante.getDocumento(),
                        pacienteAcompanante.getApellidoPat(),
                        pacienteAcompanante.getApellidoMat(),
                        pacienteAcompanante.getNombres(),
                        pacienteAcompanante.getFechaNacimiento(),
                        pacienteAcompanante.getIdParentesco(),
                        pacienteAcompanante.getTelefono(),
                        pacienteAcompanante.getDireccion(),
                        pacienteAcompanante.getUbigeo()
                );
                poCodRespuesta = (Integer) resultAcom.get("po_cod_respuesta");
                poMensajeRespuesta = (String) resultAcom.get("po_mensaje_respuesta");

                if (poCodRespuesta == 1) {
                    Integer idPacienteAcompanante = (Integer) resultAcom.get("new_id");
                    pacienteAcompanante.setIdPacienteAcompanante(idPacienteAcompanante);
                    request.setPaciente(paciente);
                    request.setAcompanante(pacienteAcompanante);
                    return ResponseUtil.handleSuccess(request);
                } else {
                    return ResponseUtil.handleError(HttpStatus.BAD_REQUEST, "Error al insertar acompañante: " + poMensajeRespuesta);
                }
            } else {
                return ResponseUtil.handleError(HttpStatus.BAD_REQUEST, "Error al insertar paciente: " + poMensajeRespuesta);
            }
        } catch (Exception e) {
            return ResponseUtil.handleError(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> actualizarPaciente(RegistrarPacienteRequest request) {
        try {

            PacienteRequest paciente = request.getPaciente();
            AcompananteRequest pacienteAcompanante = request.getAcompanante();


            // Actualizar paciente
            Map<String, Object> result = pacienteRepository.actualizarPaciente(
                    paciente.getIdPaciente(),
                    paciente.getTipoDocumento(),
                    paciente.getDocumento(),
                    paciente.getApellidoPat(),
                    paciente.getApellidoMat(),
                    paciente.getNombres(),
                    paciente.getIdSexo(),
                    paciente.getFechaNacimiento(),
                    paciente.getLugarNacimiento(),
                    paciente.getDireccion(),
                    paciente.getUbigeo()
            );


            Integer poCodRespuesta = (Integer) result.get("po_cod_respuesta");
            String poMensajeRespuesta = (String) result.get("po_mensaje_respuesta");
            if (poCodRespuesta == 1) {


                Map<String, Object> resultAcom = pacienteAcompananteRepository.actualizarAcompanante(
                        pacienteAcompanante.getIdPacienteAcompanante(),
                        paciente.getIdPaciente(),
                        pacienteAcompanante.getTipoDocumento(),
                        pacienteAcompanante.getDocumento(),
                        pacienteAcompanante.getApellidoPat(),
                        pacienteAcompanante.getApellidoMat(),
                        pacienteAcompanante.getNombres(),
                        pacienteAcompanante.getFechaNacimiento(),
                        pacienteAcompanante.getIdParentesco(),
                        pacienteAcompanante.getTelefono(),
                        pacienteAcompanante.getDireccion(),
                        pacienteAcompanante.getUbigeo()
                );


                poCodRespuesta = (Integer) resultAcom.get("po_cod_respuesta");
                poMensajeRespuesta = (String) resultAcom.get("po_mensaje_respuesta");

                if (poCodRespuesta == 1) {
                    return ResponseEntity.ok().body(request);
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar acompañante: " + poMensajeRespuesta);
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar paciente: " + poMensajeRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> eliminarPaciente(Integer idPaciente) {
        Map<String, Object> result = pacienteRepository.eliminarPaciente(idPaciente);
        Integer poCodRespuesta = (Integer) result.get("po_cod_respuesta");
        String poMensajeRespuesta = (String) result.get("po_mensaje_respuesta");
        System.out.println(poCodRespuesta + " - " + poMensajeRespuesta);
        if (poCodRespuesta == 1) {
            return ResponseUtil.handleSuccess("");
        } else {
            return ResponseUtil.handleError(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar paciente: " + poMensajeRespuesta);
        }
    }
}
