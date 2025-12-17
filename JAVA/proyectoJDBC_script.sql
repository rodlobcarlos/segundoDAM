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