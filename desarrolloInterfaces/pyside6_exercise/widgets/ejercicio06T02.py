import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QComboBox

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QComboBox example")

        combo = QComboBox()
        combo.addItems(["Python", "Java", "C++", "Kotlin"])

        combo.currentTextChanged.connect(self.text_change) #envía el texto de la opción elegida.
        combo.setEditable(True) # Se puede editar el texto
        combo.setInsertPolicy(QComboBox.InsertAfterCurrent)
        combo.setMaxCount(10) # limite de elementos

        self.setCentralWidget(combo)

    def text_change(self, s):
        self.setWindowTitle(s)
        print("Selecionte text:", s)

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()