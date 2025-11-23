import sys
from PySide6.QtCore import Qt
from PySide6.QtWidgets import QApplication, QCheckBox, QMainWindow

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("User preferences")

        self.widget = QCheckBox("Checked all")
        self.widget.setCheckState(Qt.PartiallyChecked)
        self.widget.setTristate(True)
        self.widget.stateChanged.connect(self.show_state)

        self.setCentralWidget(self.widget)

    def show_state(self, s):
        state = Qt.CheckState(s)
        if state == Qt.Checked:
            print("Complete checked", s)
        elif state == Qt.Unchecked:
            print("Unchecked ", s)
        else:
            print("Partially checked", s)

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()