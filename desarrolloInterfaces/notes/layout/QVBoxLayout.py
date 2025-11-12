from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QVBoxLayout, QPushButton
)

class PrincipalWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Vertical layout")

        # 1 Creamos el layout vertical
        vertical_layout = QVBoxLayout()

        # 2 Creamos el contenedor principal y le asignamos el layout
        principal_component = QWidget()
        principal_component.setLayout(vertical_layout)

        # 3 Lo establecemos como contenido central del QMainWindow
        self.setCentralWidget(principal_component)

        # 4 Añadimos los widgets al layout (después de asignarlo)
        vertical_layout.addWidget(QPushButton("One"))
        vertical_layout.addWidget(QPushButton("Two"))
        vertical_layout.addWidget(QPushButton("Three"))
        vertical_layout.addWidget(QPushButton("Four"))


app = QApplication([])
window = PrincipalWindow()
window.show()
app.exec()