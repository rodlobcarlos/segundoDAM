import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QComboBox

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QComboBox example")

        combo = QComboBox()
        combo.addItems(["Python", "Java", "C++", "Kotlin"])

        combo.currentIndexChanged.connect(self.index_change) # envía el número de índice (0, 1, 2…).
        combo.currentTextChanged.connect(self.text_change) #envía el texto de la opción elegida.
        combo.setEditable(True) # Se puede editar el texto
        combo.setMaxCount(10)  # limite de elementos

        self.setCentralWidget(combo)

    def index_change(self, i):
        print("Selecionte index :", i)

    def text_change(self, s):
        print("Selecionte text:", s)


app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()