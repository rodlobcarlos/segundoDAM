# Carlos Rodríguez Lobato / Grupo 2ºDAM

alumno = int(input("¿Cuantos alumnos hay?: "))

while alumno != 0:
    nombre = str(input("Escrie su nombre: "))
    for nombre in range(alumno):
        total_notas = int(input("¿Cuantas notas tiene?: "))
        if total_notas <= 0:
            print("Dato no válido")
        else:
            nota = int(input("Dame una nota: "))
    for nota in range(total_notas):
        media = (nota + nota) / total_notas
        if media >= 5:
            print("Apronado")
        elif media > 4 and media < 5:
            print("Necesita mejorar")
        elif media < 4:
            print("Suspenso")
            
        
    
if(alumno <= 0):
    print("No puede haber 0 alumnos o menos!")