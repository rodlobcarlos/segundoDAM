import { Component, signal } from '@angular/core';
import { Tarea } from './models/tarea'
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Live&Tasks');
  tareaArray: Tarea[] = [
  {
    "titulo": "Diseñar prototipo Figma",
    "tipo": "Diseño",
    "estado": "en curso",
    "descripcion": "Crear el high-fidelity wireframe para la sección de login.",
    "fechaVencimiento": new Date(2026, 2, 15)
  },
  {
    "titulo": "Configurar base de datos",
    "tipo": "Backend",
    "estado": "propuesto",
    "descripcion": "Instalar PostgreSQL y definir el esquema inicial de tablas.",
    "fechaVencimiento": new Date(2026, 2, 28)
  },
  {
    "titulo": "Revisión de seguridad",
    "tipo": "DevOps",
    "estado": "hecho",
    "descripcion": "Auditoría de los endpoints de la API y cierre de vulnerabilidades XSS.",
    "fechaVencimiento": new Date(2026, 3, 17)
  },
  {
    "titulo": "Implementar desplegable de estados",
    "tipo": "Frontend",
    "estado": "en curso",
    "descripcion": "Añadir el select de Bootstrap en el componente de inserción de tareas.",
    "fechaVencimiento": new Date(2026, 4, 10)
  }];

  selectedTarea: Tarea = new Tarea();

  addOrEdit() {
    if (this.selectedTarea.titulo === '' || this.selectedTarea.titulo === undefined) {
    alert("Por favor, introduce un título");
    return;
  }

  // 2. Añadir una COPIA del objeto al array 
  // Usamos {...} para que sea una nueva tarea y no una referencia a la anterior
  this.tareaArray.push({ ...this.selectedTarea });

  // 3. Limpiar el formulario para la siguiente tarea
  this.selectedTarea = new Tarea();
  }
}