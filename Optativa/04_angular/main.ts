// main.ts
let saludos = (persona: string) => {
    return "Hola, " + persona;
}
let usuario: string = "Marcos";
console.log(usuario);

let sentencia = `Hola, mi nombre es ${usuario}`;
console.log(sentencia);

//let object1: Array<number> = [a,1, b,2, c,3];
//console.log(Object.values(object1))
document.body.innerHTML = saludos(usuario);

export{};