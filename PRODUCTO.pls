create or replace NONEDITIONABLE type producto as object 
( /* TODO enter attribute and method declarations here */ 
    IdProducto NUMBER,
    NombreProducto VARCHAR2 (100),
    Precio NUMBER,
    
    CONSTRUCTOR FUNCTION producto(IdProducto NUMBER, NombreProducto VARCHAR2, Precio NUMBER)
        RETURN SELF AS RESULT,
        
    MEMBER FUNCTION getinformacion RETURN VARCHAR2
);