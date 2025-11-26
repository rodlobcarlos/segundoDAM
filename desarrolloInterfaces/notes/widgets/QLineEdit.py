import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QLineEdit

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QLineEdit example")

        texto = QLineEdit()
        texto.setMaxLength(10)
        texto.setMaxLength(20)                   # Número máximo de caracteres
        texto.setPlaceholderText("Escribe aquí") # Texto de ayuda inicial

        texto.returnPressed.connect(self.show_message)
        texto.textChanged.connect(self.modificade_text)
        texto.textEdited.connect(self.edited_text)

        self.setCentralWidget(texto)
        self.texto = texto

    def show_message(self):
        print("Enter pulsed")
        self.texto.setText("¡Hellou!")

    def modificade_text(self, s):
        print("Modificade text", s)

    def edited_text(self, s):
        print("Text edited by user:", s)

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()