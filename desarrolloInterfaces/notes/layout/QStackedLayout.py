from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QPushButton,
    QStackedLayout, QLabel, QVBoxLayout, QHBoxLayout
)
class PrincipalWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Stacked layout")
        principal_layout = QHBoxLayout()
        principal_component = QWidget()
        principal_component.setLayout(principal_layout)
        self.setCentralWidget(principal_component)
      
        # Creamos un QStackedLayout y añadimos cuatro "capas" al layout apilado
        self.pile = QStackedLayout()
        self.pile.addWidget(QLabel("Layer 1"))
        self.pile.addWidget(QLabel("Layer 2"))
        self.pile.addWidget(QLabel("Layer 3"))
      
        # Creamos un layout vertical con tres botones
        # Cada botón hará visible una capa a través de la ranura
        layout_button = QVBoxLayout()
        button1 = QPushButton("See layer 1")
        button1.clicked.connect(self.activated_layout1)
        button2 = QPushButton("See layer 2")
        button2.clicked.connect(self.activated_layout2)
        button3 = QPushButton("See layer 3")
        button3.clicked.connect(self.activated_layout3)
        layout_button.addWidget(button1)
        layout_button.addWidget(button2)
        layout_button.addWidget(button3)
      
        # Añadimos los layouts al layout principal
        principal_layout.addLayout(self.pile)
        principal_layout.addLayout(layout_button)

    def activated_layout1(self):
        self.pile.setCurrentIndex(0)
    def activated_layout2(self):
        self.pile.setCurrentIndex(1)
    def activated_layout3(self):
        self.pile.setCurrentIndex(2)

app = QApplication([])
window = PrincipalWindow()
window.show()
app.exec()