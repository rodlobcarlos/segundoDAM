from PySide6.QtCore import QSize
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana principal")
        button = QPushButton("boton")

        # Tamaño fijo
        self.setMinimumSize(QSize(300, 200))
        self.setMaximumSize(QSize(600, 400))
        self.setCentralWidget(button)

class SecundaryWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana secundaria")
        button = QPushButton("boton")

        # Tamaño fijo
        self.setMinimumSize(QSize(300, 200))
        self.setMaximumSize(QSize(600, 400))
        self.setCentralWidget(button)

app = QApplication([])
window = MainWindow()
window1 = SecundaryWindow()
window1.show()
window.show()
app.exec()