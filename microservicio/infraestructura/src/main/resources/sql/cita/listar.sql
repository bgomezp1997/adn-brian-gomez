select 
    c.id, 
    c.fecha_cita,
    m.id as id_medico,
    m.nombres as nombres_medico,
    m.apellidos as apellidos_medico,
    m.identificacion as identificacion_medico,
    m.fecha_creacion as fecha_creacion_medico,
    m.email as email_medico,
    m.especialidad as especialidad_medico,
    m.numero_tarjeta_profesional as numero_tarjeta_profesional_medico,
    p.id as id_paciente,
    p.nombres as nombres_paciente,
    p.apellidos as apellidos_paciente,
    p.identificacion as identificacion_paciente,
    p.fecha_creacion as fecha_creacion_paciente,
    p.email as email_paciente,
    p.estrato as estrato_paciente,
    e.id as id_eps,
    e.nombre as nombre_eps,
    e.nit as nit_eps,
    e.telefono as telefono_eps,
    e.email as email_eps
from cita c
    inner join medico m on m.id = c.id_medico
    inner join paciente p on p.id = c.id_paciente
    inner join eps e on e.id = p.id_eps
order by c.fecha_cita;