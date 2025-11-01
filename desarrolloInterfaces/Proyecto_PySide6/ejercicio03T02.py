'''Carlos Rodríguez Lobato'''
import sys
from PySide6.QtCore import Qt
from PySide6.QtWidgets import QApplication, QLabel, QMainWindow

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("My App")

        widget = QLabel("Sistema en espera")
        font = widget.font()       
        font.setPointSize(24)       
        widget.setFont(font)
        widget.setAlignment(Qt.AlignHCenter | Qt.AlignBottom)  
        widget.setText("Sistema operativo iniciado")

        self.setCentralWidget(widget)

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()