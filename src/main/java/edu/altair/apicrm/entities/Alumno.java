package edu.altair.apicrm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumno {

    // TODO: Este id identifica al alumno en la API.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    // TODO: Guardamos el DNI porque es un dato básico del alumno.
    @Column(nullable = false, unique = true, length = 20)
    private String dni;

    // TODO: Nombre del alumno que aparece en el CRM.
    @Column(nullable = false, length = 100)
    private String nombre;

    public Alumno() {
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
