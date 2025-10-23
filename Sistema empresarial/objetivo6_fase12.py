# Carlos Rodríguez Lobato / Grupo 2ºDAM

'''
Gestor de una biblioteca
'''

class Autor: 
    def __init__(self, nombre, apellidos):
        self.nombre = nombre
        self.apellidos = apellidos

    def mostrarAutor(self):
        return f"Autor: {self.nombre} {self.apellidos}"   

class Libro:
    def __init__(self, titulo, isbn, autor):
        self.titulo = titulo
        self.isbn = isbn
        self.autor = autor

    def añadirAutor(self):
        return f"Libro: {self.titulo}, ISBN: {self.isbn}, {self.autor.mostrarAutor()}"
    
    def mostrarLibro(self):
        return f"Titulo: {self.titulo}, ISBN: {self.isbn}, {self.autor.mostrarAutor()}"
    
    def obtenerTitulo(self):
        return f"Libro: {self.titulo}"


class Biblioteca:
    def __init__(self):
        self.listalibros = []
         
    def numeroLibros(self):
        return len(self.listalibros)

    def añadirLibro(self, nuevoLibro):
        return self.listalibros.append(nuevoLibro)
    
    def borrarLibro(self, titulo):
        for libro in self.listalibros:
            if libro.titulo == titulo:
                self.listalibros.remove(libro)
            else:
                print("No se encontro el libro con título: ", titulo)
    
    def mostrarBiblioteca(self):
        for i in self.listalibros:
            print(i.mostrarLibro())
    
def menu():
    print("Menu")
    print("1) Añadir libro a la biblioteca")
    print("2) Mostrar biblioteca")
    print("3) Borrar libro")
    print("4) ¿Número de libros?")
    print("5) Salir")

    opcion = input("Elige una opción: ")
    return opcion

b = Biblioteca()
opcion = ""
while opcion != "5":
    opcion = menu()
    if opcion == "1":
        titulo = input("Introduce un título: ")
        isbn = input("Introduce un isbn: ")
        nombreAutor = input("Introduce el nombre del autor: ")
        apellidoAutor = input("Introduce el apellido del autor: ")
        a = Autor(nombreAutor, apellidoAutor)
        l = Libro(titulo, isbn, a)
        b.añadirLibro(l)
        print("Libro añadido: ", l.mostrarLibro())
    elif opcion == "2":
        print("----- Libro ------")
        b.mostrarBiblioteca()  
    elif opcion == "3":
        mostrarTitulo = input("Introduce el título del libro que quieres borrar: ")
        b.borrarLibro(mostrarTitulo)
    elif opcion == "4":
        print(b.numeroLibros())
    elif opcion == "5":
        print("Saliste del programa!")
    else:
        print("Opción no válida.")