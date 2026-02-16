create database proyectoTransversal;
use proyectoTransversal;

CREATE USER IF NOT EXISTS 'carlos'@'%' IDENTIFIED BY 'clave';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `proyectoTransversal`.* TO 'carlos'@'%';
--  Refrescar
FLUSH PRIVILEGES;