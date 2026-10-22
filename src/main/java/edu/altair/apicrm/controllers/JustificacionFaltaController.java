package edu.altair.apicrm.controllers;

import edu.altair.apicrm.dtos.CambiarEstadoFaltaDto;
import edu.altair.apicrm.dtos.JustificacionFaltaRequestDto;
import edu.altair.apicrm.dtos.JustificacionFaltaResponseDto;
import edu.altair.apicrm.dtos.ResumenFaltasDto;
import edu.altair.apicrm.services.JustificacionFaltaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JustificacionFaltaController {

    private final JustificacionFaltaService service;

    public JustificacionFaltaController(JustificacionFaltaService service) {
        this.service = service;
    }

    @GetMapping("/alumnos/{idAlumno}/faltas")
    public ResponseEntity<List<JustificacionFaltaResponseDto>> obtenerPorAlumno(
            @PathVariable Long idAlumno) {

        // TODO: Devuelve todas las faltas que tiene ese alumno.
        return ResponseEntity.ok(service.obtenerPorAlumno(idAlumno));
    }

    @GetMapping("/alumnos/{idAlumno}/faltas/resumen")
    public ResponseEntity<ResumenFaltasDto> obtenerResumen(
            @PathVariable Long idAlumno) {

        // TODO: Devuelve los contadores que necesita la pantalla.
        return ResponseEntity.ok(service.obtenerResumen(idAlumno));
    }

    @PostMapping("/alumnos/{idAlumno}/faltas")
    public ResponseEntity<JustificacionFaltaResponseDto> crear(
            @PathVariable Long idAlumno,
            @RequestBody JustificacionFaltaRequestDto request) {

        // TODO: Este es el endpoint que usará la vista para enviar una justificación.
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.crear(idAlumno, request));
    }

    @GetMapping("/faltas/{id}")
    public ResponseEntity<JustificacionFaltaResponseDto> obtenerPorId(
            @PathVariable Long id) {

        // TODO: Permite consultar una justificación concreta.
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PutMapping("/faltas/{id}")
    public ResponseEntity<JustificacionFaltaResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody JustificacionFaltaRequestDto request) {

        // TODO: Permite cambiar los datos de una justificación.
        return ResponseEntity.ok(service.actualizar(id, request));
    }

    @PatchMapping("/faltas/{id}/estado")
    public ResponseEntity<JustificacionFaltaResponseDto> cambiarEstado(
            @PathVariable Long id,
            @RequestBody CambiarEstadoFaltaDto request) {

        // TODO: Lo usamos para marcar una falta como justificada o rechazada.
        return ResponseEntity.ok(service.cambiarEstado(id, request));
    }

    @DeleteMapping("/faltas/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        // TODO: Borra una justificación si ya no hace falta.
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
