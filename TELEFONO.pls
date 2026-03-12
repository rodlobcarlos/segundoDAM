create or replace NONEDITIONABLE type telefono as object 
( /* TODO enter attribute and method declarations here */
    Numero NUMBER,
    
    constructor function telefono(Numero NUMBER) return self as result
);