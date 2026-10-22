package edu.altair.apicrm.repositories;

import edu.altair.apicrm.entities.JustificacionFalta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JustificacionFaltaRepository extends JpaRepository<JustificacionFalta, Long> {

    // TODO: Recuperamos las faltas del alumno ordenadas por fecha.
    List<JustificacionFalta> findByAlumnoIdAlumnoOrderByFechaDesc(Long idAlumno);
}
