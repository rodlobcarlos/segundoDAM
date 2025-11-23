import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QTabWidget, QLabel


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        # Agregar pestañas con contenido (QLabel) y nombre de la pestaña
        self.widget = QTabWidget()
        self.widget.addTab(QLabel("Welcome"), "Window 1")
        self.widget.addTab(QLabel("Second window"), "Window 2")
        self.widget.addTab(QLabel("Third window"), "Window 3")

        # Conectar la señal currentChanged(int) a un método
        self.widget.currentChanged.connect(self.window_changed)

        self.setCentralWidget(self.widget)
        self.setWindowTitle("Window 1")

    # Método que se ejecuta cuando se cambia de pestaña
    def window_changed(self, i):
        window_name = self.widget.tabText(i)  # Obtener el nombre de la pestaña seleccionada
        self.setWindowTitle(window_name)
        print("Índice seleccionado:", i)


app = QApplication(sys.argv)
MainWindow = MainWindow()
MainWindow.show()
app.exec()