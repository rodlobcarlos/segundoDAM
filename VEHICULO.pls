create or replace NONEDITIONABLE type vehiculo as object 
( /* TODO enter attribute and method declarations here */ 
    Bastidor NUMBER,
    Matricula VARCHAR2(10),
    Marca VARCHAR2(100),
    
    constructor function vehiculo(Bastidor NUMBER, Matricula VARCHAR2,  
        Marca VARCHAR2) return self as result
)