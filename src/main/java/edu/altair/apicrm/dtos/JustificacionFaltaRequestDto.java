package edu.altair.apicrm.dtos;

import java.time.LocalDate;

// TODO: Son los datos que necesitamos cuando el alumno manda una justificación.
public record JustificacionFaltaRequestDto(
        LocalDate fecha,
        String tramoHorario,
        String motivo,
        String justificante,
        Integer minutos
) {
}
