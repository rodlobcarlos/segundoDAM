# Carlos Rodríguez Lobato / Grupo 2ºDAM

'''
Esta actividad pide que demos un número de alumnos,
luego la nota de cada alumno, hacer una media de esa nota de manera individual y
luego calcular la media de todos lo alumnos. Siempre validando cada nota y media.
Por último, decir cuantos aprobados, suspensos y por mejorar hay.
'''
alumno = int(input("¿Cuantos alumnos hay?: "))
suma_media = 0
contador1 = 0
contador2 = 0
contador3 = 0

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
                suma_media +=media
            if media >= 5:
                print("Aprobado")
                contador1 +=1
            elif media > 4 and media < 5:
                print("Necesita mejorar")
                contador2 +=1
            else:
                print("Suspenso")
                contador3 +=1
            print(media)
        contador += 1
suma_media = suma_media / alumno
print("Media total: ", suma_media)
print("Aprobados", contador1)
print("Necesita mejorar", contador2)
print("Suspenso", contador3)