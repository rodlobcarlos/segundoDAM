from PySide6.QtWidgets import QApplication, QLabel, QWidget
class Window(QWidget):
    def __init__(self):
        QWidget.__init__(self)
        self.setWindowTitle("Window")
        # Creamos dos QLabels con el componente como parent
        self.label1 = QLabel("Label 1", self)
        self.label2 = QLabel("Label 2", self)
        # Necesitamos mover la segunda 30 píxeles hacia abajo para que no se solape con la primera
        self.label2.move(0, 30)

if __name__ == "__main__":
    app = QApplication([])
    Window = Window()
    # Mostramos la ventana
    Window.show()
    app.exec()