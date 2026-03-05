import { Routes } from '@angular/router';
import { App } from './app';
import { TareaComponent } from './componentsTarea/tarea/tarea.component';
import { UsuarioComponent } from './componentsUsuario/usuario/usuario.component';

export const routes: Routes = [
  { path: '', component: App },
  { path: 'tareas', component: TareaComponent },
  { path: 'usuarios', component: UsuarioComponent },
];