from PySide6.QtWidgets import (
    QMainWindow, QApplication, QPushButton, QMessageBox,
    QLineEdit, QComboBox, QRadioButton, QBoxLayout, QFormLayout
    )
from PySide6.QtGui import QAction, QIcon, QKeySequence
import os


class MiniNoteBlog(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("MiniNoteBlog")
        self.setMinimumSize(600, 400)

        self.menu1 = self.menuBar()
        self.menu2 = self.menuBar()
        self.toolBar = QAction("Limpiar nota")
        self.toolBar = QAction("Imprimir nota")

        self.file = self.menu1.addMenu("&Archivo")
        self.help = self.menu2.addMenu("&Ayuda")

        ruta_icono = os.path.join(os.path.dirname(__file__))

        self.accionFile = QAction(QIcon(ruta_icono), "Limpiar nota", self)
        accion = QAction(QIcon(ruta_icono), "Imprimir por consola", self)
        accion.setWhatsThis("Imprime un texto por consola al pulsar el botón o atajo") # Define un texto de ayuda que aparece si el usuario activa el modo What’s This? de Qt (atajo Shift + F1).
        accion.setShortcut(QKeySequence("Ctrl+P"))
        accion.triggered.connect(self.imprimir_por_consola)
        self.menu1.addAction(accion)
        
app = QApplication([])
window = MiniNoteBlog()
window.show()
app.exec()