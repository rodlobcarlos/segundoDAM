# Carlos Rodríguez Lobato / Grupo 2ºDAM

#1
'''
Esta actividad pide dos enteros y 
realiza cada operación aritmética.
'''
entero1 = int(input("Dame un número: "))
entero2 = int(input("Dame un número: "))
suma = entero1 + entero2
resta = entero1 - entero2
multiplicacion = entero1*entero2
division = round(entero1/entero2, 2)
print("Suma:", suma)
print("Resta:", resta)
print("Multiplicacion:", multiplicacion)
print("Division:", division)

#2
'''
Esta actividad pide tres números y 
calcula el resultado promedio (la media)
'''
entero1 = float(input("Dame un número: "))
entero2 = float(input("Dame un número: "))
entero3 = float(input("Dame un número: "))
promedio = round((entero1 + entero2 + entero3) / 3, 2)
print("El promedio es:", promedio)


#3
'''
Esta actividad pide dos enteros y 
nos dice cual es mayor, si son iguales y
si el segundo número es distinto de cero
'''
entero1 = int(input("Dame un número: "))
entero2 = int(input("Dame un número: "))
mayor = (entero1 > entero2)
iguales = (entero1 == entero2)
distinto_0 = entero2 != 0
print("¿El primero es mayor?:", mayor)
print("¿Son iguales?:", iguales)
print("¿El segundo es distinto de cero?:", distinto_0)

#4
'''
Esta actividad pide dos lógicos y 
hace calculos con las funciones (and, or, not)
'''
primer_logico = eval(input("Dame el primer valor lógico: "))
segundo_logico = eval(input("Dame el segundo valor lógico: "))
print("Resultado de and:", primer_logico and segundo_logico)
print("Resultado de or:", primer_logico or segundo_logico)
print("Resultado de not logico:", not primer_logico)
print("Resultado de not segundo lógico:", not segundo_logico)

#5
'''
Esta actividad pide dos edades que al principio son String,
pero lo pasamos a valor de tipo int para luego calcular la suma y 
el promedio (la media)
'''
edad1 = str(input("Dame una edad: "))
edad2 = str(input("Dame una edad: "))
numero1 = int(edad1)
numero2 = int(edad2)
print("Suma total:", numero1 + numero2)
print("Promedio:", round(numero1+numero2) / 2)

#6
'''
Esta actividad pide dos números y 
realiza las operaciones de comparación (and, or, not) 
con otros valores que puede ser cualquir número
'''
entero1 = int(input("Dame un número: "))
entero2 = int(input("Dame un número: "))
compara_and = (entero1 > 10) and (entero2 < 5)
compara_or = (entero1 == entero2) or (entero2 > 0)
comapara_not = (entero1 < entero2)
print(compara_and)
print(compara_or)
print(comapara_not)


#7
'''
Esta actividad pide dos números y redondea
el resultado a un decimal
'''
entero1 = int(input("Dame un número: "))
entero2 = int(input("Dame un número: "))
redondeado = round(entero1/entero2, 1)
print("Resultado redondeado:", redondeado)