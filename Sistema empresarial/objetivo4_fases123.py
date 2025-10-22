# Carlos Rodríguez Lobato / Grupo 2ºDAM

alumno = int(input("¿Cuantos alumnos hay?: "))

if alumno <= 0:
    print("No puede haber 0 alumnos o menos!")
else:
    contador = 0
    while contador < alumno:
        nombre = input("Escribe un nombre: ")
        total_notas = int(input("¿Cuantas notas tiene?: "))
        if total_notas != 0:
            for i in range(total_notas):
                nota = int(input("Escribe la nota: "))
                media = (nota + nota) / total_notas
            if media >= 5:
                print("Aprobado")
            elif media > 4 and media < 5:
                print("Necesita mejorar")
            else:
                print("Suspenso")
            print(media)    
        contador += 1