from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QHBoxLayout, QPushButton
)
class PrincipalWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("horizontal layout")
        # Creamos un objeto layout horizontal
        horizontal_layout = QHBoxLayout()
        # Creamos un componente principal para la ventana
        principal_component = QWidget()
        # Le asignamos el layout vertical como disposición
        principal_component.setLayout(horizontal_layout)
        self.setCentralWidget(principal_component)
        # Añadimos cuatro botones al layout vertical
        horizontal_layout.addWidget(QPushButton("One"))
        horizontal_layout.addWidget(QPushButton("Two"))
        horizontal_layout.addWidget(QPushButton("Three"))
        horizontal_layout.addWidget(QPushButton("Four"))

app = QApplication([])
window = PrincipalWindow()
window.show()
app.exec()