# SISTEMA DE GESTIÓN DE MANTENIMIENTO IMPLEMENTADO EN JAVA

Universidad Tecnológica Nacional. FRRO
Año: 2022

Alumnos:
Virgolini, Pablo. 33586

Docentes:
Ing. Ricardo Tabacman
Ing. Adrian Meca

### RESUMEN




### ALCANCE

El sistema a desarrollar contemplará el alta de una rotura, la asignación del encargado de repararla, la carga de la reparación y el cierre conforme de la incidencia.

Casos de Uso de Usuario (No ABMC).-
* CU1. Solicitar Reparación.
* CU2. Asignar Reparación.
* CU3. Cumplir Solicitud.  


### MODELO DE DOMINIO

El Modelo de Dominio se realizó en DrawIO y puede accederse a través del [Siguiente Link](https://app.diagrams.net/#G1iHXsNnVO783qzQHKr5XABzJy6H62-ja1).

![Modelo de Dominio actual](/readmePics/MD1.png)



### MODELO DE DATOS



### CHECKLIST (AVANCE)
| Requerimiento |  Listado de CU incluidos | AVANCE | COMENTARIOS |
| ------------- | ------------- | ------------- | ------------- |
| ABMC simple | <ul><li> de Maquinas</li><li>de Usuarios</li><li>de Personas</li><li> de Cargos</li></ul> |
| ABMC dependiente | <ul><li>de Solicitud de Reparaciones</li><li>de Orden de Trabajo</li><li> de Estado de Reparaciones</li></ul> |
| CU NO ABMC | <ul><li> CUU1 Solicitar Reparación </li><li> CUU2 Asignar Reparación</li><li> CUU3 Cumplir Solicitud </li><li> Informar de Estadistica de Rotura</li></ul> |
| Listado simple |<ul><li> Usuarios</li><li> Maquinas </li></ul>|
| Listado complejo |Lista de Maquinas <br> filtradas por nombre y estado de reparación |
| CU Complejo Nivel Resumen | CU Gestión de Roturas|
| Nivel de acceso | <ul><li>Encargado de Sector <br>Solicita la reparación </li><li> Encargado de Reparacion <br> Carga Informe de reparación modificando estado </li><li> Encargado de Mantenimiento <br> Da de alta maquinas, todo lo anterior tmb, genera OT, asigna Encargado de Reparacion, consulta informe estadísticos. </li><li> Admin es Admin <br> Genera usuarios </li></ul>|
| Manejo de errores | No requiere detalles |
| Publicar en el sitio | No requiere detalles |
| Requerimiento extra | Manejo de archivos |

Además contará con:
* Custom Exceptions
* Log de errores
* Envío de emails <br>
    Genera un email al solicitar reparación para informar a mantenimiento
* Se puede Adjuntar imágenes <br>
    Permitirá adjuntar imágenes al declarar la rotura.




