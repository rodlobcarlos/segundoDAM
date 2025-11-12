from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QFormLayout,
    QLabel, QLineEdit, QSpinBox, QDoubleSpinBox
)
class PrincipalWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Vertical layout")
        # Creamos un objeto layout formulario
        form_layout = QFormLayout()
        principal_component = QWidget()
        principal_component.setLayout(form_layout)
        self.setCentralWidget(principal_component)
        # Cada fila contendrá una etiqueta y un componente de entrada
        form_layout.addRow(QLabel("Text:"), QLineEdit())
        form_layout.addRow(QLabel("Integer:"), QSpinBox())
        form_layout.addRow(QLabel("Decimal:"), QDoubleSpinBox())

app = QApplication([])
Window = PrincipalWindow()
Window.show()
app.exec()