create or replace NONEDITIONABLE TYPE reparacion AS OBJECT (
    Coche Vehiculo,
    Fecha_ingreso DATE,
    Fecha_salida DATE,
    Reparaciones VARCHAR2(1000),
    Clientes Cliente,
    
    CONSTRUCTOR FUNCTION reparacion(coche Vehiculo, fecha_ingreso DATE, 
        fecha_salida DATE, reparaciones VARCHAR2, cliente Cliente) 
        RETURN SELF AS RESULT,
        
    STATIC PROCEDURE insertar_reparacion_campos(
        p_coche Vehiculo, 
        p_fecha_ingreso DATE, 
        p_fecha_salida DATE, 
        p_reparaciones VARCHAR2, 
        p_cliente Cliente
    ),
    STATIC PROCEDURE insertar_reparacion_objeto(reparacion Reparacion) 
);