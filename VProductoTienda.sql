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