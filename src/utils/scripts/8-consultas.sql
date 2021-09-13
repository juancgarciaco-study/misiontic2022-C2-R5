SELECT 'Consulta 1';
SELECT conte_titulo as titulo FROM contenido ORDER BY titulo ASC ;

SELECT 'Consulta 2';
SELECT c.conte_titulo AS titulo, l.libro_resumen AS resumen, l.libro_anio as año
FROM contenido c 
INNER JOIN libro l ON (c.conte_id = l.libro_id)
WHERE l.libro_anio > 2000
ORDER BY titulo ;

SELECT 'Consulta 3';
SELECT c.conte_titulo AS titulo
FROM contenido c 
INNER JOIN libro l ON (c.conte_id = l.libro_id)
WHERE l.libro_editor = 55
;

SELECT 'Consulta 4';
SELECT c.conte_titulo AS titulo
FROM publicacion p
INNER JOIN contenido c ON ( c.conte_id = p.publ_contenido ) 
WHERE p.publ_usuario = 'lucky'
ORDER BY titulo
;

SELECT 'Consulta 5';
SELECT u.usu_username AS alias, u.usu_nombre AS Nombre, u.usu_apellido AS Apellido 
FROM publicacion p
INNER JOIN usuario u ON ( u.usu_username = p.publ_usuario )
WHERE publ_contenido = 102
ORDER BY alias
;

SELECT 'Consulta 6';
SELECT COUNT(1) AS "Cantidad"
FROM contenido c 
INNER JOIN libro l ON ( l.libro_id = c.conte_id )
WHERE l.libro_anio > 2000
;

