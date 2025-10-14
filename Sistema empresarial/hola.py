# FASE 1: Mostrar información por pantalla
print("Hola, mundo")
print("Hola Time of Software")
print(1,2,3,4)
print(1, 2, 3, 4, 5, sep=",")
print(1, 2, 3, 4, 5, end="-")

# FASE 2: Leer información desde teclado
print("¿Como te llamas?: ")
nombre = input()
print("Nos alegramos mucho de que nos hayas elegido para aprender Python,", nombre)

edad1 = input("¿Cuantos años tienes?: ")
print("Tienes", edad1, "años.")

edad2 = int(input("Dime tu edad: "))
es_mayor = edad2 >= 18
print("Es mayor de edad: ", es_mayor)