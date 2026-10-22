package edu.altair.apicrm.repositories;

import edu.altair.apicrm.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
