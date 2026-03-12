create or replace TYPE VProductos AS VARRAY(15) OF producto;
/

create or replace type tienda as object (
    IdTienda NUMBER,
    NombreTienda VARCHAR2 (100),
    ListaProductos VProductos,
    
    CONSTRUCTOR FUNCTION tienda (NombreTienda VARCHAR2, ListaProductos VProductos)
        RETURN SELF AS RESULT,
        
    MEMBER FUNCTION getproductos RETURN VARCHAR2
);
/

CREATE SEQUENCE seq_producto_id
START WITH 1
INCREMENT BY 1;

create table tiendas(
    datosTienda tienda
);

-- TIENDA 1: ElectroHogar
INSERT INTO TIENDAS (datosTienda) VALUES (
    Tienda(1, 'ElectroHogar', VProductos(
        Producto(seq_producto_id.NEXTVAL, 'Lavadora Lg', 450),
        Producto(seq_producto_id.NEXTVAL, 'Frigorífico', 650),
        Producto(seq_producto_id.NEXTVAL, 'Microondas', 120),
        Producto(seq_producto_id.NEXTVAL, 'Tostadora', 25),
        Producto(seq_producto_id.NEXTVAL, 'Aspiradora', 180)
    ))
);

-- TIENDA 2: TechWorld
INSERT INTO TIENDAS (datosTienda) VALUES (
    Tienda(2, 'TechWorld', VProductos(
        Producto(seq_producto_id.NEXTVAL, 'Laptop Pro', 1200),
        Producto(seq_producto_id.NEXTVAL, 'Ratón Gamer', 45),
        Producto(seq_producto_id.NEXTVAL, 'Teclado Mecánico', 90),
        Producto(seq_producto_id.NEXTVAL, 'Monitor 27"', 210),
        Producto(seq_producto_id.NEXTVAL, 'Webcam HD', 55)
    ))
);

-- TIENDA 3: SportCenter
INSERT INTO TIENDAS (datosTienda) VALUES (
    Tienda(3, 'SportCenter', VProductos(
        Producto(seq_producto_id.NEXTVAL, 'Bicicleta Montaña', 500),
        Producto(seq_producto_id.NEXTVAL, 'Mancuernas 10kg', 40),
        Producto(seq_producto_id.NEXTVAL, 'Esterilla Yoga', 15),
        Producto(seq_producto_id.NEXTVAL, 'Reloj Deportivo', 130),
        Producto(seq_producto_id.NEXTVAL, 'Zapatillas Running', 85)
    ))
);

SELECT t.datosTienda.NombreTienda AS Nombre_de_la_Tienda FROM TIENDAS t;

SELECT p.NombreProducto, p.Precio
FROM TIENDAS t, TABLE(t.datosTienda.ListaProductos) p
WHERE t.datosTienda.NombreTienda = 'ElectroHogar';

/
DECLARE
    -- Cursor para obtener los objetos tienda
    CURSOR c_tiendas IS SELECT datosTienda FROM TIENDAS;
    v_cont NUMBER;
BEGIN
    FOR reg IN c_tiendas LOOP
        DBMS_OUTPUT.PUT_LINE('Tienda: ' || reg.datosTienda.NombreTienda);
        
        v_cont := 1; -- Reiniciamos el contador para cada tienda
        
        -- Recorremos el VARRAY interno de la tienda actual
        FOR i IN 1..reg.datosTienda.ListaProductos.COUNT LOOP
            DBMS_OUTPUT.PUT_LINE('  Producto ' || v_cont || ': ' || 
                                 reg.datosTienda.ListaProductos(i).NombreProducto || 
                                 ', Precio: ' || reg.datosTienda.ListaProductos(i).Precio);
            v_cont := v_cont + 1;
        END LOOP;
        
        DBMS_OUTPUT.PUT_LINE(' '); -- Espacio entre tiendas
    END LOOP;
END;
/
-- Guardamos los cambios
COMMIT;

-- Body Cliente
/*
create or replace NONEDITIONABLE TYPE BODY cliente AS
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
*/

-- Body direccion
/*
create or replace NONEDITIONABLE type body direccion as

  constructor function direccion(ciudad varchar2, calle varchar2, 
        numero number, codigo_postal number) 
        return self as result as
  begin
      SELF.Ciudad := Ciudad;
      SELF.Calle := Calle;
      SELF.Numero := Numero;
      SELF.Codigo_postal := Codigo_postal;
    return;
  end direccion;

  member function getdireccion return varchar2 as
  begin
    return 'Dirección:  ' || SELF.Ciudad || ', Calle: ' || SELF.Calle || 
        ', Número: ' || SELF.Numero || ', Código postal: ' || SELF.Codigo_postal;
  end getdireccion;

end;
*/

-- Body producto
/*
create or replace NONEDITIONABLE type body producto as

  constructor function producto(idproducto number, nombreproducto varchar2, precio number)
        return self as result as
  begin
    -- TAREA: Se necesita implantación para FUNCTION PRODUCTO.producto
    SELF.IdProducto := IdProducto;
    SELF.NombreProducto := NombreProducto;
    SELF.Precio := Precio;
    return;
  end producto;

  member function getinformacion return varchar2 as
  begin
    -- TAREA: Se necesita implantación para FUNCTION PRODUCTO.getinformacion
    return 'Producto ' || SELF.IdProducto || ': ' || SELF.NombreProducto || ', Precio: ' || SELF.Precio;
  end getinformacion;

end;
*/

-- Body reparacion
/*
create or replace NONEDITIONABLE TYPE BODY reparacion AS

    CONSTRUCTOR FUNCTION reparacion(coche Vehiculo, fecha_ingreso DATE, 
        fecha_salida DATE, reparaciones VARCHAR2, cliente Cliente) 
        RETURN SELF AS RESULT AS
    BEGIN
        SELF.Coche := coche;
        SELF.Fecha_ingreso := fecha_ingreso;
        SELF.Fecha_salida := fecha_salida;
        SELF.Reparaciones := reparaciones;
        SELF.Clientes := cliente;
        RETURN;
    END;

    STATIC PROCEDURE insertar_reparacion_campos(
        p_coche Vehiculo, 
        p_fecha_ingreso DATE, 
        p_fecha_salida DATE, 
        p_reparaciones VARCHAR2, 
        p_cliente Cliente
    ) AS
    BEGIN
        INSERT INTO tabla_reparacion 
        VALUES (p_coche, p_fecha_ingreso, p_fecha_salida, p_reparaciones, p_cliente);
    END;

    STATIC PROCEDURE insertar_reparacion_objeto(reparacion Reparacion) AS
    BEGIN
        insertar_reparacion_campos(
            reparacion.Coche,
            reparacion.Fecha_ingreso,
            reparacion.Fecha_salida,
            reparacion.Reparaciones,
            reparacion.Clientes
        );
    END;

END;
*/

-- Body tienda
/*
create or replace NONEDITIONABLE type body tienda as

  constructor function tienda (nombretienda varchar2, listaproductos vproductos)
        return self as result as
  begin
    -- TAREA: Se necesita implantación para FUNCTION TIENDA.tienda
    SELF.NombreTienda := NombreTienda;
    SELF.ListaProductos := ListaProductos;
    return;
  end tienda;

  member function getproductos return varchar2 as
    info VARCHAR2(1000) := '';
  begin
    -- TAREA: Se necesita implantación para FUNCTION TIENDA.getproductos
    for i in 1..self.ListaProductos.count loop
    info := info || ' - ' || self.ListaProductos(i).getinformacion();
        end loop;
        return info;
    end;
end;
*/

