# Carlos Rodríguez Lobato / Grupo 2ºDAM

'''
Esta actividad pide que iniciemos un coche con velocidadInicial = 0,
luego nos pide que aceleremos y frenemos, por último sacar
la velocidad actual del vehiculo.
'''

class Vehiculo:

    def __init__(self, marca, velocidadInicial=0):
        self.__marca = marca
        self.__velocidadInicial = velocidadInicial

    def Setmarca(self, marca):
        self.__marca = marca
    def Getmarca(self):
        return self.__marca
    
    def SetvelocidadInicial(self, velocidadInicial):
        self.__velocidadInicial = velocidadInicial
    def GetvelocidadInicial(self):
        return self.__velocidadInicial
    
    def acelerar(self, velocidad):
        self.__velocidadInicial += velocidad
        return self.__velocidadInicial
    
    def desacelerar(self, velocidad):
        self.__velocidadInicial -= velocidad
        return self.__velocidadInicial 
    
    def mostrarVelocidad(self):
        return self.__velocidadInicial
    
class Coche(Vehiculo):
    
    def __init__(self, marca, velocidadInicial=0):
        super().__init__(marca, velocidadInicial)
        self.__bocina = "tuuuut"

    def tocarClaxon(self):
        return self.__bocina

        
coche = Coche("Ford Mustang", 23.7)
print("La velocidad inicial del coche es: ", coche.GetvelocidadInicial())
print(coche.acelerar(10))
print(round(coche.desacelerar(5), 2))
print("La velocidad actual es: ", round(coche.mostrarVelocidad(), 2))
print(coche.tocarClaxon())