import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QTextEdit

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QTextEdit example")

        campo = QTextEdit()
        campo.setPlaceholderText("Welcome to the editor text...")

        # Conectamos señales
        campo.textChanged.connect(self.modified_text)

        self.setCentralWidget(campo)
        self.campo = campo

    def modified_text(self):
        print("The text was changed.")
        print(self.campo.toPlainText())

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()