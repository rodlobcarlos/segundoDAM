from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

# Primera ventana
class PrincipalWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("App")

        # Botón central
        centralButton = QPushButton("Encender")
        centralButton.setCheckable(True) # Permite al botón quedarse marcado
        self.setCentralWidget(centralButton)

        #--- Signals ---
        centralButton.clicked.connect(self.clicked) # Conexción pulsado
        centralButton.toggled.connect(self.toggled) # Conexción alternado

    #--- Slots ---
    def clicked(self): 
        print("Pulsado")

    def toggled(self, checked):
        if checked: 
            self.setWindowTitle("Ventana encendida")
            print(checked)
        else:
            self.setWindowTitle("Ventana apagada")
            print(checked)

app = QApplication([])
window = PrincipalWindow()
window.show()
app.exec()