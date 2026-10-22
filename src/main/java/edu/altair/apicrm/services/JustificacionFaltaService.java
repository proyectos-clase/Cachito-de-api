package edu.altair.apicrm.services;

import edu.altair.apicrm.dtos.CambiarEstadoFaltaDto;
import edu.altair.apicrm.dtos.JustificacionFaltaRequestDto;
import edu.altair.apicrm.dtos.JustificacionFaltaResponseDto;
import edu.altair.apicrm.dtos.ResumenFaltasDto;

import java.util.List;

public interface JustificacionFaltaService {

    // TODO: Aquí dejamos las operaciones que va a ofrecer nuestra API.
    List<JustificacionFaltaResponseDto> obtenerPorAlumno(Long idAlumno);

    JustificacionFaltaResponseDto obtenerPorId(Long idJustificacion);

    JustificacionFaltaResponseDto crear(Long idAlumno, JustificacionFaltaRequestDto request);

    JustificacionFaltaResponseDto actualizar(Long idJustificacion, JustificacionFaltaRequestDto request);

    JustificacionFaltaResponseDto cambiarEstado(Long idJustificacion, CambiarEstadoFaltaDto request);

    void eliminar(Long idJustificacion);

    ResumenFaltasDto obtenerResumen(Long idAlumno);
}
