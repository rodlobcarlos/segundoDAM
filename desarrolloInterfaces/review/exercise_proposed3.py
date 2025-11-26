from PySide6.QtWidgets import QMainWindow, QApplication, QLabel, QPushButton

class Window(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("App")

        label = QLabel("Sistema en espera")
        font = label.font()
        font.setPointSize(24)
        label.setFont(font)
        
        self.setCentralWidget(label)