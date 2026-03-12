create or replace NONEDITIONABLE TYPE cliente AS OBJECT (
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
