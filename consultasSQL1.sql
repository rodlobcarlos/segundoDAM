-- Esta consulta se utiliza para filtrar estudiantes basándose en un valor que se proporciona externamente (representado aquí por ? o un marcador de posición).
SELECT nombre, notaMedia
FROM Estudiantes
WHERE notaMedia < ?;

-- Esta consulta combina la información de las tablas Estudiantes y Direcciones para filtrar por la ciudad.
SELECT E.nombre, E.notaMedia, D.ciudad
FROM Estudiantes E
JOIN Direcciones D ON E.direccion_id = D.id
WHERE D.ciudad = 'Sevilla'
ORDER BY E.nombre DESC;

-- Esta consulta utiliza la función de agregación AVG() para calcular la media de las puntuaciones de cada estudiante.
SELECT E.nombre, AVG(S.puntuacion) AS score_medio
FROM Estudiantes E
JOIN Scores S ON E.id = S.estudiante_id
GROUP BY E.id, E.nombre;

-- Esta consulta utiliza la función COUNT() y agrupa los resultados por estudiante y por el tipo de puntuación (tipo).
SELECT E.nombre, S.tipo, COUNT(S.id) AS numero_puntuaciones
FROM Estudiantes E
JOIN Scores S ON E.id = S.estudiante_id
GROUP BY E.id, E.nombre, S.tipo
ORDER BY E.nombre, S.tipo;