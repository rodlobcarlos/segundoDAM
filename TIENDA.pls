create or replace NONEDITIONABLE type tienda as object (
    IdTienda NUMBER,
    NombreTienda VARCHAR2 (100),
    ListaProductos VProductos,
    
    CONSTRUCTOR FUNCTION tienda (NombreTienda VARCHAR2, ListaProductos VProductos)
        RETURN SELF AS RESULT,
        
    MEMBER FUNCTION getproductos RETURN VARCHAR2
);
