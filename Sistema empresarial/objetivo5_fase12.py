# Carlos Rodríguez Lobato / Grupo 2ºDAM

'''
Esta actividad nos pide una calculadora con varias opciones,
que controle que no se divida por cero.
'''
import math

def menu():
    print("=============================")
    print("    CALCULARDORA AVANZADA")
    print("=============================")
    print("1) Sumar")
    print("2) Restar")
    print("3) Multiplicar")
    print("4) Dividir")
    print("5) Potencia")
    print("6) Raíz_cuadrada")
    print("7) Modulo")
    print("8) Salir")

    opcion = input("Elige una opción: ")
    return opcion

def sumar():
    num1 = float(input("Introduce el primer número: "))
    num2 = float(input("Introduce el segundo número: "))
    return round(num1 + num2, 2)

def restar():
    num1 = float(input("Introduce el primer número: "))
    num2 = float(input("Introduce el segundo número: "))
    return round(num1 - num2, 2)

def multiplicar():
    num1 = float(input("Introduce el primer número: "))
    num2 = float(input("Introduce el segundo número: "))
    return round(num1 * num2, 2)

def dividir():
    num1 = float(input("Introduce el primer número: "))
    num2 = float(input("Introduce el segundo número: "))
    if(num2 == 0):
        print("No se puede dividir entre cero")
        num1 = float(input("Introduce el primer número: "))
        num2 = float(input("Introduce el segundo número: "))
        return round(num1 % num2, 2)

    else:
        return round(num1 / num2, 2)

def potencia():
    num1 = float(input("Introduce el primer número: "))
    num2 = float(input("Introduce el segundo número: "))
    return round(num1 ** num2, 2)

def raiz_cuadrada():
    num1 = float(input("Introduce el primer número: "))
    return round(math.sqrt(num1), 2)

def modulo():
    num1 = float(input("Introduce el primer número: "))
    num2 = float(input("Introduce el segundo número: "))
    if(num2 == 0):
        print("No se puede dividir entre cero")
        num1 = float(input("Introduce el primer número: "))
        num2 = float(input("Introduce el segundo número: "))
        return round(num1 % num2, 2)

    else:
        return round(num1 % num2, 2)

opcion = ""

while opcion != "8":
    opcion = menu()
    if opcion == "1":
        print(sumar())
    elif opcion == "2":
        print(restar())
    elif opcion == "3":
        print(multiplicar())
    elif opcion == "4":
        print(dividir())
    elif opcion == "5":
        print(potencia())
    elif opcion == "6":
        print(raiz_cuadrada())
    elif opcion == "7":
        print(modulo())
    elif opcion == "8":
        print("Saliste del programa!")
    else:
            print("Opción no válida.")