'''
Este código abre una ventana con un botón.
'''

'''Importe de clases'''
from PySide6.QtWidgets import QApplication, QPushButton

app = QApplication([])

buttonWindow = QPushButton("Press me!") # Creo un botón interactivo
buttonWindow.show()
app.exec()