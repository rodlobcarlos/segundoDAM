create database simulacionHibernate1;
use simulacionHibernate1;

CREATE USER IF NOT EXISTS 'carlos'@'%' IDENTIFIED BY 'clave';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `simulacionHibernate1`.* TO 'carlos'@'%';
--  Refrescar
FLUSH PRIVILEGES;