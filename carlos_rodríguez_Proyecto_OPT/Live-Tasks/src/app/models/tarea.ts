export class Tarea {
    titulo!: string;
    tipo!: string;
    estado!: 'propuesto' | 'en curso' | 'hecho';    
    descripcion!: string;
    fechaVencimiento!: Date;
}
