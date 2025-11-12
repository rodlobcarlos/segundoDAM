import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QSlider
from PySide6.QtCore import Qt


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.slider = QSlider(Qt.Horizontal)  # Crear QSlider horizontal
        self.slider.setRange(0, 100)  # Rango de 0 a 100
        self.slider.setValue(50) # Inicializa valor en 50

        # Conectar la señal valueChanged(int) a un método
        self.slider.valueChanged.connect(self.on_value_changed)
        
        # Colocar el slider como widget central
        self.setCentralWidget(self.slider)

        # Mostrar el valor inicial en consola
        self.on_value_changed(self.slider.value())

        self.setWindowTitle("Brightness Control")

    # Método que se ejecuta cada vez que cambia el valor del slider
    def on_value_changed(self, value):
        print(f"Brightness level: {value}%")  


app = QApplication(sys.argv)
window = MainWindow()
window.resize(300, 100)
window.show()
sys.exit(app.exec())