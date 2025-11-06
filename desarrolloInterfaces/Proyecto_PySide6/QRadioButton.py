from PySide6.QtWidgets import QRadioButton, QMainWindow

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QRadioBotton window")

        self.button = QRadioButton("Activated function")
        self.button.setCheckable(True)

        self.button.clicked.connect(self.button.clicked)

        self.centralWidget(self.button)

app = QMainWindow([])
window = MainWindow()
window.show()
app.exec()