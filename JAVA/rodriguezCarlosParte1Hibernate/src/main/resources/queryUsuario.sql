create database carlosRodriguezLobato;
use carlosRodriguezLobato;

CREATE USER IF NOT EXISTS 'carlos'@'%' IDENTIFIED BY 'clave';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `carlosRodriguezLobato`.* TO 'carlos'@'%';
--  Refrescar
FLUSH PRIVILEGES;