'''
Este código personaliza QMainWindow()
'''

'''Importe de clases'''
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self): # Constructor de la super clase
        super().__init__() # Inicializa la clase base
        self.setWindowTitle("My firts app!") 
        button = QPushButton("Press me")
        self.setCentralWidget(button) # Centra el botton en la ventana

app = QApplication([])
window = MainWindow()
window.show()
app.exec()