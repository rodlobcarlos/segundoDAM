# Carlos Rodríguez Lobato / Grupo 2ºDAM

#1
'''
Esta actividad imprime por consola
las tres listas
'''
lista_productos = ["Portátil", "Sobre mesa", "Servidor"]
lista_perifericos = ["Ratón", "Teclado", "Webcam"]
lista_accesorios = ["Funda", "Altavoz", "Webcam"]
print(lista_productos)
print(lista_perifericos)
print(lista_accesorios)

#2
'''
Esta actividad imprime una tupla 
'''
tupla_precios = ("750", "1200", "2200")
print(tupla_precios)

#3
'''
Esta actividad imprime el catalogo (que es un diccionario) y
el elemento teclado de la segunda lista
'''
catalogo = {"Productos": lista_productos, 
            "Periféricos": lista_perifericos,
            "Accesorios": lista_accesorios
            }
print(catalogo)
print(lista_perifericos[1])