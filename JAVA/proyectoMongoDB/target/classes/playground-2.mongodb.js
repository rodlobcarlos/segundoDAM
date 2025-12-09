// Select the database to use.
use('Live&Tasks');

db.usuario.insertMany([
	{
		"id": "10001",
		"nombre_usuario": "alex_tech",
		"email": "alex.t@example.com",
		"es_premium": true,
		"configuracion_ia": {
			"permitir_autocompletado": true,
			"nivel_creatividad": 7,
			"idioma_preferido": "en-US"
		},
		"tareas": [
			{
				"id_tarea": "uuid-101",
				"titulo": "Configurar servidor",
				"descripcion": "Instalar Nginx y configurar firewall.",
				"estado": "HECHO",
				"prioridad": 1
			},
			{
				"id_tarea": "uuid-102",
				"titulo": "Revisar logs",
				"descripcion": "Analizar errores del último despliegue.",
				"estado": "EN_CURSO",
				"prioridad": 2
			}
		]
	},
	{
		"id": "10002",
		"nombre_usuario": "maria_design",
		"email": "maria.d@studio.net",
		"es_premium": false,
		"configuracion_ia": {
			"permitir_autocompletado": false,
			"nivel_creatividad": 9,
			"idioma_preferido": "es-ES"
		},
		"tareas": [
			{
				"id_tarea": "uuid-103",
				"titulo": "Bocetos logo",
				"descripcion": "Crear 3 propuestas para el cliente Alpha.",
				"estado": "PENDIENTE",
				"prioridad": 3
			}
		]
	},
	{
		"id": "10003",
		"nombre_usuario": "juan_perez",
		"email": "juan.perez@mail.com",
		"es_premium": true,
		"configuracion_ia": {
			"permitir_autocompletado": true,
			"nivel_creatividad": 5,
			"idioma_preferido": "es-MX"
		},
		"tareas": []
	},
	{
		"id": "10004",
		"nombre_usuario": "sara_connor",
		"email": "sara.c@future.org",
		"es_premium": true,
		"configuracion_ia": {
			"permitir_autocompletado": true,
			"nivel_creatividad": 2,
			"idioma_preferido": "en-UK"
		},
		"tareas": [
			{
				"id_tarea": "uuid-104",
				"titulo": "Proteger datos",
				"descripcion": "Encriptar base de datos de usuarios.",
				"estado": "PROPUESTA",
				"prioridad": 1
			},
			{
				"id_tarea": "uuid-105",
				"titulo": "Entrenamiento IA",
				"descripcion": "Ajustar modelo de predicción.",
				"estado": "FUTURO",
				"prioridad": 4
			}
		]
	},
	{
		"id": "10005",
		"nombre_usuario": "kenji_t",
		"email": "kenji.tanaka@tokyo.jp",
		"es_premium": false,
		"configuracion_ia": {
			"permitir_autocompletado": true,
			"nivel_creatividad": 6,
			"idioma_preferido": "ja-JP"
		},
		"tareas": [
			{
				"id_tarea": "uuid-106",
				"titulo": "Traducir manual",
				"descripcion": "Traducción de ES a JP del manual de usuario.",
				"estado": "EN_CURSO",
				"prioridad": 2
			}
		]
	},
	{
		"id": "10006",
		"nombre_usuario": "laura_v",
		"email": "laura.v@marketing.com",
		"es_premium": true,
		"configuracion_ia": {
			"permitir_autocompletado": true,
			"nivel_creatividad": 10,
			"idioma_preferido": "es-ES"
		},
		"tareas": [
			{
				"id_tarea": "uuid-107",
				"titulo": "Campaña Email",
				"descripcion": "Diseñar newsletter de navidad.",
				"estado": "PENDIENTE",
				"prioridad": 3
			},
			{
				"id_tarea": "uuid-108",
				"titulo": "Reunión KPI",
				"descripcion": "Presentar resultados mensuales.",
				"estado": "HECHO",
				"prioridad": 1
			}
		]
	},
	{
		"id": "10007",
		"nombre_usuario": "david_fitness",
		"email": "david.gym@fit.net",
		"es_premium": false,
		"configuracion_ia": {
			"permitir_autocompletado": false,
			"nivel_creatividad": 4,
			"idioma_preferido": "pt-BR"
		},
		"tareas": [
			{
				"id_tarea": "uuid-109",
				"titulo": "Renovar cuota",
				"descripcion": "Pagar la mensualidad del gimnasio.",
				"estado": "FUTURO",
				"prioridad": 5
			}
		]
	},
	{
		"id": "10008",
		"nombre_usuario": "emma_watson_fan",
		"email": "emma.fan88@uk.co",
		"es_premium": true,
		"configuracion_ia": {
			"permitir_autocompletado": true,
			"nivel_creatividad": 8,
			"idioma_preferido": "en-GB"
		},
		"tareas": [
			{
				"id_tarea": "uuid-110",
				"titulo": "Escribir blog",
				"descripcion": "Reseña de la última película.",
				"estado": "PROPUESTA",
				"prioridad": 3
			}
		]
	},
	{
		"id": "10009",
		"nombre_usuario": "dev_ops_guru",
		"email": "guru@cloud.io",
		"es_premium": true,
		"configuracion_ia": {
			"permitir_autocompletado": false,
			"nivel_creatividad": 1,
			"idioma_preferido": "en-US"
		},
		"tareas": [
			{
				"id_tarea": "uuid-111",
				"titulo": "Migración AWS",
				"descripcion": "Mover instancias EC2 a nueva región.",
				"estado": "EN_CURSO",
				"prioridad": 1
			},
			{
				"id_tarea": "uuid-112",
				"titulo": "Backup BD",
				"descripcion": "Verificar integridad de backups.",
				"estado": "HECHO",
				"prioridad": 1
			},
			{
				"id_tarea": "uuid-113",
				"titulo": "Script limpieza",
				"descripcion": "Automatizar borrado de logs viejos.",
				"estado": "PENDIENTE",
				"prioridad": 2
			}
		]
	},
	{
		"id": "10010",
		"nombre_usuario": "ana_cocina",
		"email": "ana.chef@food.com",
		"es_premium": false,
		"configuracion_ia": {
			"permitir_autocompletado": true,
			"nivel_creatividad": 8,
			"idioma_preferido": "it-IT"
		},
		"tareas": [
			{
				"id_tarea": "uuid-114",
				"titulo": "Comprar ingredientes",
				"descripcion": "Harina, huevos, leche para el pastel.",
				"estado": "PENDIENTE",
				"prioridad": 2
			}
		]
	},
	{
		"id": "10011",
		"nombre_usuario": "roberto_finanzas",
		"email": "roberto.cfo@bank.com",
		"es_premium": true,
		"configuracion_ia": {
			"permitir_autocompletado": true,
			"nivel_creatividad": 3,
			"idioma_preferido": "es-AR"
		},
		"tareas": [
			{
				"id_tarea": "uuid-115",
				"titulo": "Auditoría",
				"descripcion": "Preparar documentos para auditoría externa.",
				"estado": "FUTURO",
				"prioridad": 1
			}
		]
	},
	{
		"id": "10012",
		"nombre_usuario": "lisa_student",
		"email": "lisa.s@uni.edu",
		"es_premium": false,
		"configuracion_ia": {
			"permitir_autocompletado": true,
			"nivel_creatividad": 6,
			"idioma_preferido": "de-DE"
		},
		"tareas": [
			{
				"id_tarea": "uuid-116",
				"titulo": "Estudiar Historia",
				"descripcion": "Repasar para el examen final.",
				"estado": "EN_CURSO",
				"prioridad": 1
			},
			{
				"id_tarea": "uuid-117",
				"titulo": "Inscripción cursos",
				"descripcion": "Pagar matrícula del semestre.",
				"estado": "HECHO",
				"prioridad": 2
			}
		]
	},
	{
		"id": "10013",
		"nombre_usuario": "gamer_pro_99",
		"email": "pro.gamer@twitch.tv",
		"es_premium": true,
		"configuracion_ia": {
			"permitir_autocompletado": false,
			"nivel_creatividad": 5,
			"idioma_preferido": "en-US"
		},
		"tareas": [
			{
				"id_tarea": "uuid-118",
				"titulo": "Stream benéfico",
				"descripcion": "Configurar overlay y alertas.",
				"estado": "PROPUESTA",
				"prioridad": 2
			}
		]
	},
	{
		"id": "10014",
		"nombre_usuario": "marta_travel",
		"email": "marta.viajes@nomad.com",
		"es_premium": true,
		"configuracion_ia": {
			"permitir_autocompletado": true,
			"nivel_creatividad": 9,
			"idioma_preferido": "fr-CA"
		},
		"tareas": [
			{
				"id_tarea": "uuid-119",
				"titulo": "Reservar vuelo",
				"descripcion": "Buscar vuelos baratos a Bali.",
				"estado": "PENDIENTE",
				"prioridad": 1
			},
			{
				"id_tarea": "uuid-120",
				"titulo": "Seguro médico",
				"descripcion": "Contratar seguro de viaje internacional.",
				"estado": "PENDIENTE",
				"prioridad": 1
			}
		]
	},
	{
		"id": "10015",
		"nombre_usuario": "oliver_code",
		"email": "oliver.rust@dev.io",
		"es_premium": false,
		"configuracion_ia": {
			"permitir_autocompletado": false,
			"nivel_creatividad": 2,
			"idioma_preferido": "en-US"
		},
		"tareas": [
			{
				"id_tarea": "uuid-121",
				"titulo": "Aprender Rust",
				"descripcion": "Completar tutoriales básicos.",
				"estado": "EN_CURSO",
				"prioridad": 3
			}
		]
	}
])