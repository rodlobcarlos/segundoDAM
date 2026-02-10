create database simulacion;
use simulacion;

CREATE USER IF NOT EXISTS 'root123'@'%' IDENTIFIED BY 'root123';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `simulacion`.* TO 'root123'@'%';
--  Refrescar
FLUSH PRIVILEGES;