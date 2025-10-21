# Carlos Rodríguez Lobato / Grupo 2ºDAM

#1
'''
Esta actividad pide tres números y 
tenemos que compararlos con los métodos (and, or y not)
'''
num1 = int(input("Dame un número: "))
num2 = int(input("Dame un número: "))
num3 = int(input("Dame un número: "))
comparador_and = (num1 < num2) and (num2 < num3)
comparador_or = (num1 == num2) or (num2 == num3)
comparador_not = not(num1 > num3)
print(comparador_and)
print(comparador_or)
print(comparador_not)