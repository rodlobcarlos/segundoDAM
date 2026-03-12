create or replace NONEDITIONABLE TYPE VTelefonos AS VARRAY(3) OF telefono;

/
-- 1. Eliminar
DROP TYPE BODY cliente;
DROP TYPE cliente FORCE;

-- 2. Crear tipo
CREATE OR REPLACE TYPE cliente AS OBJECT (
    IdCliente NUMBER,
    Dni VARCHAR2(9),
    NombreCliente VARCHAR2(50),
    Domicilio Direccion,
    ListaTelefonos VTelefonos,
    CONSTRUCTOR FUNCTION cliente(IdCliente NUMBER, Dni VARCHAR2, 
        NombreCliente VARCHAR2, Domicilio Direccion, 
        ListaTelefonos VTelefonos) RETURN SELF AS RESULT,
    MEMBER FUNCTION getTelefonos RETURN VARCHAR2
);
/

-- 3. Crear body
CREATE OR REPLACE TYPE BODY cliente AS
    CONSTRUCTOR FUNCTION cliente(IdCliente NUMBER, Dni VARCHAR2,
        NombreCliente VARCHAR2, Domicilio Direccion,
        ListaTelefonos VTelefonos) RETURN SELF AS RESULT AS
    BEGIN
        SELF.IdCliente := IdCliente;
        SELF.Dni := Dni;
        SELF.NombreCliente := NombreCliente;
        SELF.Domicilio := Domicilio;
        SELF.ListaTelefonos := ListaTelefonos;
        RETURN;
    END;
    MEMBER FUNCTION getTelefonos RETURN VARCHAR2 AS
        auxVariable VARCHAR2(80) := NULL;
    BEGIN
        IF SELF.ListaTelefonos IS NOT NULL THEN
            auxVariable := '[';
            FOR i IN 1..SELF.ListaTelefonos.COUNT LOOP
                auxVariable := CONCAT(auxVariable, SELF.ListaTelefonos(i).Numero);
                IF i < SELF.ListaTelefonos.COUNT THEN
                    auxVariable := CONCAT(auxVariable, ', ');
                END IF;
            END LOOP;
            auxVariable := CONCAT(auxVariable, ']');
        END IF;
        RETURN auxVariable;
    END;
END;
/

CREATE SEQUENCE cliente_sec
	START WITH 1
	INCREMENT BY 1
	MAXVALUE 99999
	MINVALUE 1
	NOCYCLE;
/

DROP TABLE tabla_reparacion;

CREATE TABLE tabla_reparacion (
    coche Vehiculo NOT NULL,
    fecha_ingreso DATE NOT NULL,
    fecha_salida DATE,
    reparaciones VARCHAR2(1000),
    clientes Cliente NOT NULL
);

DECLARE
    clinull Cliente;
    cli0 Cliente;
    cli1 Cliente;
    cli2 Cliente;
    reparacion1 Reparacion;

BEGIN 
    DBMS_OUTPUT.PUT_LINE('1');
    clinull := NEW Cliente(cliente_sec.NEXTVAL, 'dni', 'nombre', null, null);
    DBMS_OUTPUT.PUT_LINE('2');
    cli0    := NEW Cliente(cliente_sec.NEXTVAL, 'dni', 'nombre', null, null);
    DBMS_OUTPUT.PUT_LINE('3');
    cli1    := NEW Cliente(cliente_sec.NEXTVAL, 'dni', 'nombre', null, VTelefonos(Telefono('1111')));
    DBMS_OUTPUT.PUT_LINE('4');
    cli2    := NEW Cliente(cliente_sec.NEXTVAL, 'dni', 'nombre', null, VTelefonos(Telefono('1111'), Telefono('2222')));
    DBMS_OUTPUT.PUT_LINE('5');
    reparacion1 := new Reparacion(
        Vehiculo(1111, '2222', 'Audi'), 
        TO_DATE('10/01/2023','DD/MM/YYYY'),
        TO_DATE('15/01/2023','DD/MM/YYYY'),'Rueda pinchada', 
        Cliente(
            cliente_sec.NEXTVAL, '111111A', 'Ana',
            Direccion('Sevilla', 'C/ la otra', 1 , 11111), 
            VTelefonos(Telefono(null))
        ));
    DBMS_OUTPUT.PUT_LINE('6');
    dbms_output.put_line(clinull.getTelefonos());
    DBMS_OUTPUT.PUT_LINE('7');
    dbms_output.put_line(cli0.getTelefonos());
    DBMS_OUTPUT.PUT_LINE('8');
    dbms_output.put_line(cli1.getTelefonos());
    DBMS_OUTPUT.PUT_LINE('9');
    dbms_output.put_line(cli2.getTelefonos());
    DBMS_OUTPUT.PUT_LINE('10');
    DELETE FROM tabla_reparacion;
    DBMS_OUTPUT.PUT_LINE('11');
    Reparacion.insertar_reparacion_campos(
        Vehiculo(2222, '1111', 'Mercedes'), 
        TO_DATE('10/01/2023','DD/MM/YYYY'),
        TO_DATE('15/01/2023','DD/MM/YYYY'),
        'Cambio de aceite', 
        Cliente(
            cliente_sec.NEXTVAL, '49494949A', 'Pablo',
            Direccion('Sevilla', 'C/ la mia', 1, 11111), 
            VTelefonos(Telefono('1111'))
        )
    );
    DBMS_OUTPUT.PUT_LINE('12');
    Reparacion.insertar_reparacion_objeto(reparacion1);
    DBMS_OUTPUT.PUT_LINE('13');
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('----- FINALIZADO CON EXITO -----');
EXCEPTION
    WHEN OTHERS THEN 
        DBMS_OUTPUT.PUT_LINE('----- ERROR -----');
        DBMS_OUTPUT.put_line('Error:'||TO_CHAR(SQLCODE));
        DBMS_OUTPUT.put_line(SQLERRM);
        ROLLBACK;
END;
/

SELECT * FROM tabla_reparacion;

SELECT object_name, object_type, status 
FROM user_objects 
WHERE object_name IN ('VEHICULO', 'CLIENTE', 'DIRECCION', 'TELEFONO', 'REPARACION', 'VTELEFONOS')
ORDER BY object_type, object_name;

ALTER TABLE tabla_reparacion MODIFY (clientes Cliente);