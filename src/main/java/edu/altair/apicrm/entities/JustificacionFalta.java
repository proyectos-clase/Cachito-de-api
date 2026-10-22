package edu.altair.apicrm.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "justificaciones_faltas")
public class JustificacionFalta {

    // TODO: Este id sirve para distinguir cada justificación.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_justificacion")
    private Long idJustificacion;

    // TODO: Una justificación siempre pertenece a un alumno.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    // TODO: Día en el que se produjo la falta.
    @Column(nullable = false)
    private LocalDate fecha;

    // TODO: Aquí guardamos el tramo seleccionado en la pantalla.
    @Column(name = "tramo_horario", nullable = false, length = 100)
    private String tramoHorario;

    // TODO: Motivo que escribe el alumno.
    @Column(nullable = false, length = 500)
    private String motivo;

    // TODO: Por ahora guardamos el nombre o referencia del archivo.
    @Column(length = 500)
    private String justificante;

    // TODO: Nos sirve para llevar el tiempo de falta.
    @Column(nullable = false)
    private Integer minutos;

    // TODO: Toda nueva solicitud empieza pendiente.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoJustificacion estado;

    public JustificacionFalta() {
    }

    public Long getIdJustificacion() { return idJustificacion; }
    public void setIdJustificacion(Long idJustificacion) { this.idJustificacion = idJustificacion; }

    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getTramoHorario() { return tramoHorario; }
    public void setTramoHorario(String tramoHorario) { this.tramoHorario = tramoHorario; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getJustificante() { return justificante; }
    public void setJustificante(String justificante) { this.justificante = justificante; }

    public Integer getMinutos() { return minutos; }
    public void setMinutos(Integer minutos) { this.minutos = minutos; }

    public EstadoJustificacion getEstado() { return estado; }
    public void setEstado(EstadoJustificacion estado) { this.estado = estado; }
}
