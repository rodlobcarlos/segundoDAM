from PySide6.QtCore import QSize
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("My App")
        button = QPushButton("Press Me!")

        # Tamaño fijo
        self.setMinimumSize(QSize(300, 200))
        self.setMaximumSize(QSize(600, 400))
        self.setCentralWidget(button)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()