import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Tarea } from '../../models/tarea';

@Component({
  selector: 'app-tarea',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './tarea.component.html',
})
export class TareaComponent {
  tareas: Tarea[] = [
    { id: 1, titulo: 'Comprar comida', descripcion: 'Leche, huevos, pan', estado: 'Pendiente' },
    { id: 2, titulo: 'Leer un libro', descripcion: 'Terminar el libro de Angular', estado: 'En progreso' },
  ];

  tareaSeleccionada: Tarea = new Tarea();

  agregarOEditar() {
    if (this.tareaSeleccionada.id === 0) {
      this.tareaSeleccionada.id = this.tareas.length + 1;
      this.tareas.push(this.tareaSeleccionada);
    }
    this.tareaSeleccionada = new Tarea();
  }

  abrirParaEditar(tarea: Tarea) {
    this.tareaSeleccionada = tarea;
  }

  eliminar() {
    this.tareas = this.tareas.filter(x => x !== this.tareaSeleccionada);
    this.tareaSeleccionada = new Tarea();
  }
}