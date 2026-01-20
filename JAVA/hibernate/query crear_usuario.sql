create database accesoDatosHibernate;
CREATE USER IF NOT EXISTS 'carlos'@'%' IDENTIFIED BY 'clave';
--  Asignar privilegios
GRANT ALL PRIVILEGES ON `accesoDatosHibernate`.* TO 'carlos'@'%';
--  Refrescar
FLUSH PRIVILEGES;