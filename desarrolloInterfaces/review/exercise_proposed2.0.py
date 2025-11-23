from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

# Ventana principal
class Window (QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("App")

        # Central button
        self.centralButton = QPushButton("Pulsar")
        self.centralButton.setCheckable(True) # Permite al botón quedarse marcado
        self.setCentralWidget(self.centralButton)

        #--- Signals ---
        self.centralButton.clicked.connect(self.clicked) # ""Funcion importante""
        self.centralButton.pressed.connect(self.pressed)
        self.centralButton.released.connect(self.released)

    #--- Slots ---
    def clicked(self):
        print("Pulsar")

    def pressed(self):
        if self.pressed: # Si es presionado
            self.centralButton.setText("Soltar") # Cambiar texto del botón
            print("Botón presionado.")
    
    def released(self):
        if self.released: # Si es soltado
            self.centralButton.setText("Pulsar") # Cambiar texto del botón
            print("Botón liberado.")

app = QApplication([])
window = Window()
window.show()
app.exec()