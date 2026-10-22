package edu.altair.apicrm.services.impl;

import edu.altair.apicrm.dtos.CambiarEstadoFaltaDto;
import edu.altair.apicrm.dtos.JustificacionFaltaRequestDto;
import edu.altair.apicrm.dtos.JustificacionFaltaResponseDto;
import edu.altair.apicrm.dtos.ResumenFaltasDto;
import edu.altair.apicrm.entities.Alumno;
import edu.altair.apicrm.entities.EstadoJustificacion;
import edu.altair.apicrm.entities.JustificacionFalta;
import edu.altair.apicrm.repositories.AlumnoRepository;
import edu.altair.apicrm.repositories.JustificacionFaltaRepository;
import edu.altair.apicrm.services.JustificacionFaltaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JustificacionFaltaServiceImpl implements JustificacionFaltaService {

    private final JustificacionFaltaRepository justificacionRepository;
    private final AlumnoRepository alumnoRepository;

    public JustificacionFaltaServiceImpl(
            JustificacionFaltaRepository justificacionRepository,
            AlumnoRepository alumnoRepository) {
        this.justificacionRepository = justificacionRepository;
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<JustificacionFaltaResponseDto> obtenerPorAlumno(Long idAlumno) {
        comprobarAlumno(idAlumno);

        return justificacionRepository.findByAlumnoIdAlumnoOrderByFechaDesc(idAlumno)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public JustificacionFaltaResponseDto obtenerPorId(Long idJustificacion) {
        return toResponse(buscar(idJustificacion));
    }

    @Override
    public JustificacionFaltaResponseDto crear(
            Long idAlumno,
            JustificacionFaltaRequestDto request) {

        // TODO: Antes de crear comprobamos que el alumno existe.
        Alumno alumno = comprobarAlumno(idAlumno);

        JustificacionFalta falta = new JustificacionFalta();
        falta.setAlumno(alumno);
        aplicarDatos(falta, request);

        // TODO: Una solicitud nueva se queda pendiente hasta que alguien la revise.
        falta.setEstado(EstadoJustificacion.PENDIENTE);

        return toResponse(justificacionRepository.save(falta));
    }

    @Override
    public JustificacionFaltaResponseDto actualizar(
            Long idJustificacion,
            JustificacionFaltaRequestDto request) {

        // TODO: Buscamos la falta y cambiamos los datos que vienen de la petición.
        JustificacionFalta falta = buscar(idJustificacion);
        aplicarDatos(falta, request);

        return toResponse(justificacionRepository.save(falta));
    }

    @Override
    public JustificacionFaltaResponseDto cambiarEstado(
            Long idJustificacion,
            CambiarEstadoFaltaDto request) {

        // TODO: Esto permite aceptar o rechazar una justificación.
        JustificacionFalta falta = buscar(idJustificacion);
        falta.setEstado(request.estado());

        return toResponse(justificacionRepository.save(falta));
    }

    @Override
    public void eliminar(Long idJustificacion) {
        // TODO: Primero buscamos la falta para evitar borrar algo que no existe.
        JustificacionFalta falta = buscar(idJustificacion);
        justificacionRepository.delete(falta);
    }

    @Override
    public ResumenFaltasDto obtenerResumen(Long idAlumno) {
        // TODO: Estos datos son para los contadores que aparecen en la vista.
        comprobarAlumno(idAlumno);

        List<JustificacionFalta> faltas =
                justificacionRepository.findByAlumnoIdAlumnoOrderByFechaDesc(idAlumno);

        long justificadas = faltas.stream()
                .filter(f -> f.getEstado() == EstadoJustificacion.JUSTIFICADA)
                .count();

        long rechazadas = faltas.stream()
                .filter(f -> f.getEstado() == EstadoJustificacion.RECHAZADA)
                .count();

        long pendientes = faltas.stream()
                .filter(f -> f.getEstado() == EstadoJustificacion.PENDIENTE)
                .count();

        return new ResumenFaltasDto(
                faltas.size(),
                justificadas,
                rechazadas,
                pendientes
        );
    }

    private Alumno comprobarAlumno(Long idAlumno) {
        // TODO: Reutilizamos el repositorio de alumnos para comprobar que existe.
        return alumnoRepository.findById(idAlumno)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No existe el alumno con id " + idAlumno
                        ));
    }

    private JustificacionFalta buscar(Long id) {
        // TODO: Así no repetimos la misma búsqueda en varios métodos.
        return justificacionRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No existe la justificación con id " + id
                        ));
    }

    private void aplicarDatos(
            JustificacionFalta falta,
            JustificacionFaltaRequestDto request) {

        // TODO: Pasamos los datos que llegan de la API a la entidad.
        falta.setFecha(request.fecha());
        falta.setTramoHorario(request.tramoHorario());
        falta.setMotivo(request.motivo());
        falta.setJustificante(request.justificante());
        falta.setMinutos(request.minutos());
    }

    private JustificacionFaltaResponseDto toResponse(JustificacionFalta falta) {
        // TODO: Devolvemos un DTO para no devolver directamente la entidad.
        return new JustificacionFaltaResponseDto(
                falta.getIdJustificacion(),
                falta.getAlumno().getIdAlumno(),
                falta.getFecha(),
                falta.getTramoHorario(),
                falta.getMotivo(),
                falta.getJustificante(),
                falta.getMinutos(),
                falta.getEstado()
        );
    }
}
