# Carlos Rodríguez Lobato / Grupo 2ºDAM

'''

'''

class Video:

    def __init__(self, tituloVideo, duracion, categoria):
        self.__tituloVideo = tituloVideo
        self.__duracion = duracion
        self.__categoria = categoria

    def mirarVideo(self):
        return f"El video que se esta viendo se titula {self.__tituloVideo} con una duracion de {self.__duracion} y de categoria {self.__categoria}"
    
    def detenerVideo(self):
        return "Deteniendo el vídeo."
    
class Audio:

    def __init__(self, tituloAudio, artistaAudio):
       self.__tituloAudio = tituloAudio
       self.__artistaAudio = artistaAudio

    def escucharAudio(self):
        return f"Se está escuchando el audio {self.__tituloAudio} del artista {self.__artistaAudio}" 
    
    def detenerAudio(self):
        return "Deteniendo audio."
    
class Media(Video, Audio):

    def __init__(self, tituloVideo, duracion, categoria, 
                 tituloAudio, artistaAudio, tituloMedio, categoriaMedio, duracionMedio,
                 artistaMedio):
        Video.__init__(self, tituloVideo, duracion, categoria)
        Audio.__init__(self, tituloAudio, artistaAudio)
        self.__tituloMedio = tituloMedio
        self.__categoriaMedio = categoriaMedio
        self.__duracionMedio = duracionMedio
        self.__artistaMedio = artistaMedio

media = Media("Nuevo mundo",
    "30 min", "Aventura", "Hola de nuevo", "Carlos", "Mi mezcla especial", 
    "Documental musical", "45 min", "Carlos Rodríguez")
print("Iniciando el audio")
print(media.escucharAudio())
print(media.mirarVideo())
print(media.detenerAudio())
print(media.detenerVideo())