'''
Este código muestra el tamaño máximo y mínimo de la ventana
'''

'''Importe de clases'''
from PySide6.QtCore import QSize
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("My app")
        button = QPushButton("Press me!")
        self.setCentralWidget(button)

        self.setMinimumSize(QSize(400, 200)) # Tamaño mínimo de la ventana
        self.setMaximumSize(QSize(700, 400)) # Tamaño máximo de la ventana


app = QApplication([])
window = MainWindow()
window.show()
app.exec()