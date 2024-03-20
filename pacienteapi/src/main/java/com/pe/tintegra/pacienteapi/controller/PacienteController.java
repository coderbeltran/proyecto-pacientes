package com.pe.tintegra.pacienteapi.controller;

import com.pe.tintegra.pacienteapi.controller.dto.PacienteAcompananteDTO;
import com.pe.tintegra.pacienteapi.controller.dto.RegistrarPacienteRequest;
import com.pe.tintegra.pacienteapi.model.Paciente;
import com.pe.tintegra.pacienteapi.model.PacienteAcompanante;
import com.pe.tintegra.pacienteapi.repository.PacienteRepository;
import com.pe.tintegra.pacienteapi.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PacienteController {

    private PacienteService pacienteService;
    private UbigeoService ubigeoService;

    private SexoService sexoService;

    private ParentescoService parentescoService;
    private TipoDocumentoService tipoDocumentoService;
    @GetMapping
    public ResponseEntity<?>  buscarPacientes(
            @RequestParam(required = false, defaultValue = "0") Integer tipoDocide,
            @RequestParam(required = false, defaultValue = "") String nombres,
            @RequestParam(required = false, defaultValue = "") String apellidos,
            @RequestParam(required = false, defaultValue = "") String doc) {

            return pacienteService.buscarPacientes( tipoDocide,nombres, apellidos, doc);

    }
    @GetMapping("/{paciente}")
    public ResponseEntity<?> detallePacienteAcompanante(@PathVariable("paciente") Integer idPaciente) {

        return pacienteService.detallePacienteAcompanante( idPaciente);

    }
    @PostMapping
    public ResponseEntity<?> registrar(
            @RequestBody RegistrarPacienteRequest request) {
        try {
            return pacienteService.registrarPaciente(request);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor: " + e.getMessage());
        }


    }

    @DeleteMapping("/{paciente}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable("paciente") Integer idPaciente) {

        return pacienteService.eliminarPaciente( idPaciente);

    }

    @PutMapping
    public ResponseEntity<?> actualizar(
            @RequestBody RegistrarPacienteRequest request) {
        return pacienteService.actualizarPaciente(request);
    }
    @GetMapping("/ubigeo")
    public ResponseEntity<?> listarUbigeo() {

        return ubigeoService.listarUbigeo();

    }

    @GetMapping("/sexo")
    public ResponseEntity<?> listarSexo() {

        return sexoService.listarSexo();

    }


    @GetMapping("/parentesco")
    public ResponseEntity<?> listarParentesco() {
        return parentescoService.listarParentesco();
    }

    @GetMapping("/tipodocumento")
    public ResponseEntity<?> listarTipoDocumentoIdentidad() {
        return tipoDocumentoService.listarTipoDocumentoIdentidad();
    }
}




    /*@PostMapping
    public ResponseEntity<Paciente> create(@RequestBody  @Validated PacienteDTO PacienteFormDTO) {
        boolean existDocumento = pacienteRepository.existsByNoDocide(PacienteFormDTO.getNoDocide());
        if (existDocumento) {
            return ResponseEntity.badRequest().build();

        }

        Paciente paciente=new Paciente();
        paciente.setIdTipoDocide(PacienteFormDTO.getIdTipoDocide());
        paciente.setNoDocide(PacienteFormDTO.getNoDocide());
        paciente.setNoApepat(PacienteFormDTO.getNoApepat());
        paciente.setNoApemat(PacienteFormDTO.getNoApemat());
        paciente.setNoNombres(PacienteFormDTO.getNoNombres());
        paciente.setIdSexo(PacienteFormDTO.getIdSexo());
        paciente.setFeNacimiento(PacienteFormDTO.getFeNacimiento());
        paciente.setNoLugarNacimiento(PacienteFormDTO.getNoLugarNacimiento());
        paciente.setNoDireccion(PacienteFormDTO.getNoDireccion());
        paciente.setCoUbigeo(PacienteFormDTO.getCoUbigeo());
        pacienteRepository.save(paciente);
        return ResponseEntity.created(URI.create("https://tintegra.pe")).body(paciente);
    }

    @PutMapping("/{id_paciente}")
    public ResponseEntity<Paciente> update(@PathVariable Integer id_paciente, @RequestBody @Validated PacienteDTO PacienteFormDTO) {
        boolean existDocumento= pacienteRepository.existsByNoDocideIdNot(PacienteFormDTO.getNoDocide(), id_paciente);
        if (existDocumento) {
            return ResponseEntity.badRequest().build();

        }

        Paciente pacienteFromDb = pacienteRepository.findById(id_paciente).orElse(null);
        if (pacienteFromDb == null) {
            return ResponseEntity.noContent().build();
        }

        pacienteFromDb.setIdTipoDocide(PacienteFormDTO.getIdTipoDocide());
        pacienteFromDb.setNoDocide(PacienteFormDTO.getNoDocide());
        pacienteFromDb.setNoApepat(PacienteFormDTO.getNoApepat());
        pacienteFromDb.setNoApemat(PacienteFormDTO.getNoApemat());
        pacienteFromDb.setNoNombres(PacienteFormDTO.getNoNombres());
        pacienteFromDb.setIdSexo(PacienteFormDTO.getIdSexo());
        pacienteFromDb.setFeNacimiento(PacienteFormDTO.getFeNacimiento());
        pacienteFromDb.setNoLugarNacimiento(PacienteFormDTO.getNoLugarNacimiento());
        pacienteFromDb.setNoDireccion(PacienteFormDTO.getNoDireccion());
        pacienteFromDb.setCoUbigeo(PacienteFormDTO.getCoUbigeo());
        pacienteRepository.save(pacienteFromDb);
        return ResponseEntity.ok(pacienteFromDb);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Paciente pacienteFromDb = pacienteRepository.findById(id).orElse(null);
        if (pacienteFromDb == null) {
            return ResponseEntity.noContent().build();
        }
        pacienteRepository.delete(pacienteFromDb);
        return ResponseEntity.notFound().build();
    }*/


