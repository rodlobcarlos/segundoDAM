create or replace NONEDITIONABLE type direccion as object 
( /* TODO enter attribute and method declarations here */ 
    Ciudad VARCHAR2(30),
    Calle VARCHAR2(50),
    Numero NUMBER,
    Codigo_postal NUMBER,
    
    constructor function direccion(Ciudad VARCHAR2, Calle VARCHAR2, 
        Numero NUMBER, Codigo_postal NUMBER) 
        return self as result,
        
    member function getDireccion return VARCHAR2 
);