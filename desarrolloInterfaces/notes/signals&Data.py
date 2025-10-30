'''
Este código enseñá la conección de una señal a 
un dato.
'''

'''Importe de clases'''
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("My app!")

        button = QPushButton("Press me!!")
        button.setCheckable(True)

        button.clicked.connect(self.this_button_was_clicked)
        button.clicked.connect(self.this_button_was_toggled)

        self.setCentralWidget(button)

    def this_button_was_clicked(self):
        print("Clicked!")

    def this_button_was_toggled(self, checked):
        print("Checked?", checked)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()