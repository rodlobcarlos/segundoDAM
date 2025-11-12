'''Carlos Rodríguez lobato'''
from PySide6.QtCore import QSize
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Principal window")
        button = QPushButton("Tern on") 
        button.setCheckable(True) 

        button.clicked.connect(self.the_button_was_clicked)
        button.clicked.connect(self.the_button_was_toggled)

        self.setCentralWidget(button)

    def the_button_was_clicked(self):
            print("Button clicked!")

    def the_button_was_toggled(self, checked):
            if checked:
                  self.setWindowTitle("Window on")
            else:
                  self.setWindowTitle("Window off")
            print("Checkd?", checked) 

app = QApplication([])
window = MainWindow()
window.show()
app.exec()