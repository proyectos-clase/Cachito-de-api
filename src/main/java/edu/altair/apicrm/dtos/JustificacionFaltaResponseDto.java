package edu.altair.apicrm.dtos;

import edu.altair.apicrm.entities.EstadoJustificacion;
import java.time.LocalDate;

// TODO: Este objeto es lo que devolvemos al frontend y no la entidad directamente.
public record JustificacionFaltaResponseDto(
        Long idJustificacion,
        Long idAlumno,
        LocalDate fecha,
        String tramoHorario,
        String motivo,
        String justificante,
        Integer minutos,
        EstadoJustificacion estado
) {
}
