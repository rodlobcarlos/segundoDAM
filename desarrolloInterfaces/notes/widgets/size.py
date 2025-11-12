'''
Este código muetra una ventana de tamaño fijo
'''

'''Importe de clases'''
from PySide6.QtCore import QSize 
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("My app")
        button = QPushButton("Press me!")

        self.setFixedSize(QSize(400, 300)) # Tamaño fijo de la ventana
        self.setCentralWidget(button)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()