import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QDial # Importa los widgets necesarios


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.dial = QDial()
        self.dial.setRange(0, 10)  # Configura el rango de 0 a 10
        self.dial.setNotchesVisible(True)  # Hace visibles las muescas (notches)   
        self.dial.setValue(5) # Valor inicial del dial

        # Conectar la señal valueChanged(int) a un método
        self.dial.valueChanged.connect(self.on_value_changed)

        # Colocar el dial como widget central de la ventana
        self.setCentralWidget(self.dial)

        # Actualizar el título de la ventana al valor inicial
        self.on_value_changed(self.dial.value())

    # Método que se ejecuta cada vez que cambia el valor del dial
    def on_value_changed(self, value):
        self.setWindowTitle(f"Volume: {value} / 10")

        if value == 10:
            print("Maximum volume reached!")


app = QApplication(sys.argv)
window = MainWindow()
window.resize(200, 200)
window.show()
sys.exit(app.exec())
