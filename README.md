# API CRM - Justificación de faltas

API desarrollada con Spring Boot para la funcionalidad de justificación de faltas del CRM.

## Configuración

- Maven
- Java 25
- Spring Boot 4.1.1
- Spring Web
- Spring Data JPA
- PostgreSQL

## Paquete

`edu.altair.apicrm`

## Funcionalidad

La API permite:

- Crear una justificación de falta.
- Consultar las faltas de un alumno.
- Consultar una falta concreta.
- Modificar una justificación.
- Cambiar su estado.
- Eliminar una justificación.
- Consultar un resumen con los contadores.

## Endpoints

- `GET /api/alumnos/{idAlumno}/faltas`
- `GET /api/alumnos/{idAlumno}/faltas/resumen`
- `POST /api/alumnos/{idAlumno}/faltas`
- `GET /api/faltas/{id}`
- `PUT /api/faltas/{id}`
- `PATCH /api/faltas/{id}/estado`
- `DELETE /api/faltas/{id}`

## Base de datos

La aplicación está preparada para PostgreSQL en `localhost:5432`, base de datos `crm`.

Los datos de conexión se pueden cambiar en:

`src/main/resources/application.properties`
