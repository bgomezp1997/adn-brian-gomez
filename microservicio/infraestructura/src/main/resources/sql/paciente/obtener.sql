select 
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
from paciente p
    inner join eps e on e.id = p.id_eps
where p.id = :id