'''Carlos Rodríguez lobato'''
from PySide6.QtCore import QSize
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Principal window")
        self.button = QPushButton("Press") 
        self.button.setCheckable(True) 

        self.button.clicked.connect(self.the_button_was_clicked)
        self.button.pressed.connect(self.the_button_was_pressed)
        self.button.released.connect(self.the_button_was_released)


        self.setCentralWidget(self.button)

    def the_button_was_clicked(self):
            print("Button clicked!")

    def the_button_was_pressed(self):
          if self.the_button_was_pressed:
                self.button.setText("Released")
                print("Pressed button")

    def the_button_was_released(self):
          if self.the_button_was_released:
                self.button.setText("Press")
                print("Released button")

app = QApplication([])
window = MainWindow()
window.show()
app.exec()