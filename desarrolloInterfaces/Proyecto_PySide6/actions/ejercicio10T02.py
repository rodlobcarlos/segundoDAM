from PySide6.QtWidgets import QApplication, QMainWindow
from PySide6.QtGui import QAction, QKeySequence

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana principal con menús")

        menu_bar = self.menuBar()

        menu = menu_bar.addMenu("&Files")

        # Mostrar mensaje
        accion1 = QAction("Print to the console", self)
        accion1.setShortcut(QKeySequence("Ctrl+M"))
        accion1.triggered.connect(self.print_to_the_console)
        menu.addSeparator()

        # Cambiar título
        accion2= QAction("Title changed", self)
        accion2.setShortcut(QKeySequence("Ctrl+L"))
        accion2.triggered.connect(self.title_changed)
        menu.addSeparator()


        #Salir
        accion3 = QAction("Aplication closed", self)
        accion3.setShortcut(QKeySequence("Ctrl+Q"))
        accion3.triggered.connect(self.aplication_closed)

        menu.addAction(accion1)
        menu.addAction(accion2)
        menu.addAction(accion3)


    def print_to_the_console(self):
        print("Hellou from the menu")

    def title_changed(self):
        self.setWindowTitle("Title changed from menu")
        print("Title changed from menu")

    def aplication_closed(self):
        print("Aplication closed")
        self.close()

if __name__ == "__main__":
    app = QApplication([])
    window = MainWindow()
    window.show()
    app.exec()