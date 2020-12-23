select id,nombre,valor,estado,tipo
from parametro
where estado = :estado
and tipo = :tipo