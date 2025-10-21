# Carlos Rodríguez Lobato / Grupo 2ºDAM

#1
'''
Esta actividad pide que evaluemos si un número es positivo,
negativo o cero
'''
numero = int(input("Dame un número: "))
if(numero > 0):
    print("El número es positivo")
elif(numero < 0):
    print("El número es negativo")
else:
    print("El número es cero")

#2
'''
Esta actividad pide que evaluemos si un número es mayor que otro,
si es menor o si son iguales
'''
numero1 = int(input("Dame un número: "))
numero2 = int(input("Dame un número: "))
if(numero1 > numero2):
    print(numero1, " es mayor que ", numero2)
elif(numero1 < numero2):
    print(numero1, " es menor que ", numero2)
else:
    print("Ambos son iguales")

#3
'''
Esta actividad pide mostrar si la palabra que se pide 
está dentro de la frase que se pide
'''
frase = str(input("Escribe una frase: "))
palabra = str(input("Escribe una palabra: "))
if(palabra in frase):
    print("La palabra está en la frase")
else:
    print("La palabra no está en la frase")

#4
'''
Esta actividad pide que verifiquemos el formato de una cadena
'''
texto = str(input("Escribe un texto: "))
if(texto[0].isupper()):
    print("Empieza por mayúscula")
elif(texto[-1].endswith(".")):
    print("Termina en punto")
else:
    print("El texto no cumple las condiciones")

#5
'''
Esta actividad pide calcular una nota
'''
nota = float(input("Dame una nota: "))
if(nota >= 0 and nota <= 4):
    print("Insuficiente")
elif(nota == 5):
    print("Sufciente")
elif(nota == 6):
    print("bien")
elif(nota >= 7 and nota <= 8):
    print("Notable")
elif(nota >= 9 and nota <= 10):
    print("Sobresaliente")
else:
    print("Nota no válida")