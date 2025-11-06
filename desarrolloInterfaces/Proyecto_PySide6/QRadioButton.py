from PySide6.QtWidgets import QRadioButton, QMainWindow, QApplication

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QRadioBotton window")

        button = QRadioButton("Activate the function")
        button.setCheckable(True)

        button.toggled.connect(self.the_button_was_toggled)

        self.setCentralWidget(button)

    def the_button_was_toggled(self, checked):
        if checked:
            self.setWindowTitle("Function activated")
            print("Checked?", checked)
        else:
            self.setWindowTitle("Function not activated")
            print("Checked?", checked)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()