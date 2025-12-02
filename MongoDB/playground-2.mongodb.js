// Select the database to use.
use('Live&Tasks');

db.usuario.insertMany([
  {
    "id": 1,
    "nombre_usuario": "Carlos_Rodriguez",
    "email": "carlos.rodriguez@email.com",
    "es_premium": true,
    "configuracion_ia": {
      "permitir_autocompletado": true,
      "nivel_creatividad": 85,
      "idioma_preferido": "Español"
    },
    "tareas": [
      {
        "id_tarea": 101,
        "titulo": "Finalizar borrador del proyecto",
        "descripcion": "Terminar el análisis de mercado y la propuesta de la aplicación Live&Tasks",
        "estado": "En curso",
        "prioridad": 5
      },
      {
        "id_tarea": 102,
        "titulo": "Hacer la compra semanal",
        "descripcion": "Comprar frutas, verduras y leche",
        "estado": "Pendiente",
        "prioridad": 2
      }
    ]
  },
  {
    "id": 2,
    "nombre_usuario": "Laura_Design",
    "email": "laura.design@email.com",
    "es_premium": false,
    "configuracion_ia": {
      "permitir_autocompletado": false,
      "nivel_creatividad": 40,
      "idioma_preferido": "Inglés"
    },
    "tareas": [
      {
        "id_tarea": 201,
        "titulo": "Idea para app de música",
        "descripcion": "Investigar API de Spotify para futura integración",
        "estado": "Propuesta",
        "prioridad": 1
      },
      {
        "id_tarea": 202,
        "titulo": "Reunión con clientes",
        "descripcion": "Presentación de prototipos iniciales",
        "estado": "Hecho",
        "prioridad": 4
      }
    ]
  }
])