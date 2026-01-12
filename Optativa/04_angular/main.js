"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// main.ts
var saludos = function (persona) {
    return "Hola, " + persona;
};
var usuario = "Marcos";
console.log(usuario);
var sentencia = "Hola, mi nombre es ".concat(usuario);
console.log(sentencia);
//let object1: Array<number> = [a,1, b,2, c,3];
//console.log(Object.values(object1))
document.body.innerHTML = saludos(usuario);
