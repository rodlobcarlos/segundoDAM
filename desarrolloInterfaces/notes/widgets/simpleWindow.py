'''
Este código abre una ventana con un botón.
'''

'''Importe de clases'''
from PySide6.QtWidgets import QApplication, QWidget

app = QApplication([]) # Inicia la aplicación y sus bucles de eventos.

window = QWidget() # Crea una ventana básica.
window.show() # Muestra la ventana.
app.exec() # Ejecuta la app hasta que se cierra.