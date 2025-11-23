from PySide6.QtWidgets import QApplication, QPushButton, QMainWindow
 
# Primera ventana
class PrincipalWindow(QMainWindow):
    def __init__(self): # Constructor de la clase
        super().__init__()
        self.setWindowTitle("App") # Título de la ventana

        button = QPushButton("Press me!") # Botón de la ventana
        self.setMinimumSize(300, 200) # Tamaño mínimo de la ventana
        self.setMaximumSize(600, 400) # Tamaño máximo de la ventana
        self.setCentralWidget(button) # Centrar botón

# Segunda ventana
class Window_2(QMainWindow):
    def __init__(self): # Constructor de la clase
        super().__init__()
        self.setWindowTitle("App 2") # Título de la ventana

        button = QPushButton("Press me!") # Botón de la ventana
        self.setCentralWidget(button) # Centrar botón

app = QApplication([])
window1 = PrincipalWindow()
window1.show()
window2 = Window_2()
window2.show()
app.exec()