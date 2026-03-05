import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Usuario } from '../../models/usuario';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './usuario.component.html',
})
export class UsuarioComponent {
  usuarios: Usuario[] = [
    { id: 1, nombre: 'Carlos García', email: 'carlos.garcia@email.com', rol: 'Administrador' },
    { id: 2, nombre: 'Laura Martínez', email: 'laura.martinez@email.com', rol: 'Usuario' },
];

  usuarioSeleccionado: Usuario = new Usuario();

  agregarOEditar() {
    if (this.usuarioSeleccionado.id === 0) {
      this.usuarioSeleccionado.id = this.usuarios.length + 1;
      this.usuarios.push(this.usuarioSeleccionado);
    }
    this.usuarioSeleccionado = new Usuario();
  }

  abrirParaEditar(usuario: Usuario) {
    this.usuarioSeleccionado = usuario;
  }

  eliminar() {
    this.usuarios = this.usuarios.filter(x => x !== this.usuarioSeleccionado);
    this.usuarioSeleccionado = new Usuario();
  }
}