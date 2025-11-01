'''
Este código muestra una ventana principal 
con más funciones que una simple.
'''

'''Importe de clases'''
from PySide6 import QApplication, QMainWindow

app = QApplication([])

'''
 QMainWindow() incluye: mmenu y barra de herramientas, barra de estado, 
 centrado del contenido(setCentralWidget()), soporte para paneles acoplados(dock widgets).
'''
principalWindow = QMainWindow() 
principalWindow.show()
app.exec()