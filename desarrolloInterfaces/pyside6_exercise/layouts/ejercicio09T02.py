from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QPushButton,
    QStackedLayout, QLabel, QVBoxLayout, QHBoxLayout
)
class PrincipalWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("My layout")

        principal_layout = QHBoxLayout()
        principal_component = QWidget()
        principal_component.setLayout(principal_layout)
        self.setCentralWidget(principal_component)

        horizontal_layout = QHBoxLayout()

        principal_component.setLayout(horizontal_layout)
        self.setCentralWidget(principal_component)

        horizontal_layout.addWidget(QPushButton("H1"))
        horizontal_layout.addWidget(QPushButton("H2"))
        horizontal_layout.addWidget(QPushButton("H3"))
        horizontal_layout.addWidget(QPushButton("H4"))

        vertical_layout = QVBoxLayout()
        vertical_layout.addWidget(QPushButton("V1"))
        vertical_layout.addWidget(QPushButton("V2"))
        vertical_layout.addWidget(QPushButton("V3"))
        vertical_layout.addWidget(QPushButton("V4"))

        principal_layout.addLayout(vertical_layout)
        principal_layout.addLayout(horizontal_layout)


app = QApplication([])
window = PrincipalWindow()
window.show()
app.exec()