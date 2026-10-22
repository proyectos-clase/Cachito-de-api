package edu.altair.apicrm.dtos;

import edu.altair.apicrm.entities.EstadoJustificacion;

// TODO: Separamos el cambio de estado para poder aceptar o rechazar una justificación.
public record CambiarEstadoFaltaDto(
        EstadoJustificacion estado
) {
}
