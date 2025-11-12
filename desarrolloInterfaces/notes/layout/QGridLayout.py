from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QGridLayout, QPushButton
)
class PrincipalWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Cuadricular layout")
        # Creamos un objeto layout cuadrícula
        cuadricular_layout = QGridLayout()
        principal_component = QWidget()
        principal_component.setLayout(cuadricular_layout)
        self.setCentralWidget(principal_component)
        # Añadimos cuatro botones a la primera fila
        # Los números indican la fila y la columna donde situar el widget
        cuadricular_layout.addWidget(QPushButton("0,0"), 0, 0)
        cuadricular_layout.addWidget(QPushButton("0,1"), 0, 1)
        cuadricular_layout.addWidget(QPushButton("0,2"), 0, 2)
        cuadricular_layout.addWidget(QPushButton("0,3"), 0, 3)
        # Añadimos un botón a la segunda fila que ocupe cuatro columnas
        cuadricular_layout.addWidget(QPushButton("1,0-3"), 1, 0, 1, 4)
        # Añadimos dos botones a la tercera fila, que ocupen dos columnas cada uno
        cuadricular_layout.addWidget(QPushButton("2,0-1"), 2, 0, 1, 2)
        cuadricular_layout.addWidget(QPushButton("2,2-3"), 2, 2, 1, 2)

app = QApplication([])
Window = PrincipalWindow()
Window.show()
app.exec()