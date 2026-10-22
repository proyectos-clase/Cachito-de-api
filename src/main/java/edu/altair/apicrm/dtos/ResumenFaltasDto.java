package edu.altair.apicrm.dtos;

// TODO: Estos contadores son los que necesitamos para el resumen de la vista.
public record ResumenFaltasDto(
        long total,
        long justificadas,
        long rechazadas,
        long pendientes
) {
}
