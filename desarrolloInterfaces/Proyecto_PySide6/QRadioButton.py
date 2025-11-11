from PySide6.QtWidgets import QRadioButton, QMainWindow, QApplication

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QRadioBotton window")

        button = QRadioButton("Activate the function")
        button.setCheckable(True) # Permite que el botón pueda activarse/desactivarse

        # Conectar la señal 'toggled' a un método
        button.toggled.connect(self.the_button_was_toggled)

        self.setCentralWidget(button)

    # Método que se ejecuta cuando se activa/desactiva el botón
    def the_button_was_toggled(self, checked):
        if checked:
            self.setWindowTitle("Function activated")
            print("Checked?", checked)
        else:
            self.setWindowTitle("Function not activated")
            print("Checked?", checked)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()