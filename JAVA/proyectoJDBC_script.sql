CREATE DATABASE jdbcMySqlAcceso;
USE jdbcMySqlAcceso;
CREATE TABLE RodriguezCarlosJugadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100)  NOT NULL,
    puntosTotales INT DEFAULT 0
);

CREATE TABLE RodriguezCarlosPartidas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    torneo_id INT,
    narrador_id INT,
    fecha DATE NOT NULL,
    resultado ENUM('TODOS', 'NADIE', 'ALGUNOS') NOT NULL,
    FOREIGN KEY (narrador_id) REFERENCES RodriguezCarlosJugadores(id)
);

SELECT * FROM RodriguezCarlosJugadores;
SELECT * FROM RodriguezCarlosPartidas;
SELECT * FROM RodriguezCarlosPartidas ORDER BY fecha ASC;
SELECT nombre, puntosTotales FROM RodriguezCarlosJugadores ORDER BY puntosTotales DESC;

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

INSERT INTO devices (name, category, price, stock) VALUES (?, ?, ?, ?);
DELETE FROM devices WHERE id = ?;
SELECT * FROM devices WHERE category = ?;
SELECT d.name, AVG(r.rating) as media_rating FROM devices d LEFT JOIN reviews r ON d.id = r.device_id GROUP BY d.id, d.name HAVING media_rating IS NOT NULL;
SELECT SUM(stock) as total_stock FROM devices;
SELECT name, price FROM devices ORDER BY price DESC;  