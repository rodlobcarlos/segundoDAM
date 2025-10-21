# Carlos Rodríguez Lobato / Grupo 2ºDAM

#1
'''
Esta actividdad pide que utilicemos los métodos 
(capitalize, upper, lower, swapcase) para ver el cambio en la frase
'''
print("----- FORMATO DEL TEXTO ----------")
frase = "Lenguaje de Programación"
print("Capitalizada:", frase.capitalize())
print("Mayúsculas:", frase.upper())
print("Minúsculas:", frase.lower())
print("Invertida:", frase.swapcase())

#2
'''
Esta actividad pide que veamos si en la frase
hay solo letras, números, las dos, si está
en mayúsculas o minúsculas
'''
print("----- ANALISIS DEL CONTENIDO ----------")
print("¿Solo letras?: ", frase.isalpha())
print("¿Solo números?: ", frase.isdigit())
print("¿Letras y números?: ", frase.isalnum())
print("¿Está en mayúscula?: ", frase.isupper())
print("¿Está en minúscula?: ", frase.islower())

#3
'''
Esta actividad pide que comprobemos la longitud de la frase y
también los caracteres que no tienen espacio
'''
print("----- LONGITUD ---------")
print("Número total de caracteres: ", len(frase))
sin_espacios = frase.replace(" ", "")
print("Caracteres reales (sin espacio): ", len(sin_espacios))

#4
'''
Esta actividad pide que quitemos los espacios del principio,
final y a los dos lados
'''
print("----- LIMPIEZA ------")
print("Sin espacios al principio: ", frase.lstrip())
print("Sin espacios al final: ", frase.rstrip())
print("Sin espacios en ambos lados: ", frase.strip())

#5
'''
Esta actividad pide remplazar una palabra por otra nueva
'''
print("----- REMPLAZAR -------")
busca = input("Palabra a buscar: ")
nueva = input("Palabra nueva: ")
frase_modificada = frase.replace(busca, nueva)
print("Frase modificada: ", frase_modificada)

#6
'''
Esta actividad pide el caracter mayor y caracter menor
'''
print("----- CARACTERES ------")
print("Caractér mayor: ",max(frase))
print("Caractér menor: ", min(frase))

#7
'''
Esta actividad nos lista las palabras separadas y 
también el número de palabras
'''
print("------ LISTA DE PALABRAS --------")
print("Lista: ", frase.split())
numero_palabras = len(frase.split())
print("Numero de palabras: ", numero_palabras)

#8
'''
Esta actividad pide que separemos las palabras con split("/")
'''
print("------- DIVISION POR / -------- ")
print("Resultado del split(/): ", frase.split("/"))