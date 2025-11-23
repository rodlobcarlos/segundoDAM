import os
from PySide6.QtCore import Qt
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtWidgets import QApplication, QMainWindow, QToolBar

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Tool bar")

        menu_bar = self.menuBar()
        menu = menu_bar.addMenu("&Files")

        icon_rute = os.path.join(os.path.dirname(__file__), "usuario.png")

        self.accion1 = QAction(QIcon(icon_rute), "Print form console", self)
        self.accion1.setWhatsThis("Show from console or changed title or desactivated accions.")
        self.accion1.setShortcut(QKeySequence("Ctrl+P"))
        self.accion1.triggered.connect(self.show_message)

        self.accion2 = QAction(QIcon(icon_rute), "Changed title", self)
        self.accion2.setWhatsThis("Show from console or changed title or desactivated accions.")
        self.accion2.setShortcut(QKeySequence("Ctrl+M"))
        self.accion2.triggered.connect(self.changed_title)

        self.accion3 = QAction(QIcon(icon_rute), "Desactivated accions", self)
        self.accion3.setWhatsThis("Show from console or changed title or desactivated accions.")
        self.accion3.setShortcut(QKeySequence("Ctrl+L"))
        self.accion3.triggered.connect(self.desactivated_accions)


        self.accion4 = QAction(QIcon(icon_rute), "Activated accions", self)
        self.accion4.setWhatsThis("Show from console or changed title or desactivated accions.")
        self.accion4.setShortcut(QKeySequence("Ctrl+L"))
        self.accion4.triggered.connect(self.activated_accions)


        self.tool_bar1 = QToolBar("Principal bar")
        self.tool_bar1.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)
        self.tool_bar1.addAction(self.accion1)  
        self.tool_bar1.addAction(self.accion2)  
        self.tool_bar1.addAction(self.accion3)  
        self.addToolBar(self.tool_bar1)

        tool_bar2 = QToolBar("Second bar")
        tool_bar2.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)
        tool_bar2.addAction(self.accion4)
        tool_bar2.setEnabled(True)    
        self.addToolBar(tool_bar2)

        menu.addAction(self.accion1)
        menu.addAction(self.accion2)
        menu.addAction(self.accion3)

    def show_message(self):
        print("hellou")

    def changed_title(self):
        self.setWindowTitle("Changed title")
        print("Changed title")

    def desactivated_accions(self):
        self.tool_bar1.setEnabled(False)
        self.accion1.setEnabled(False)
        self.accion2.setEnabled(False)
        self.accion3.setEnabled(False)
        print("Desactivated accions")

    def activated_accions(self):
        self.tool_bar1.setEnabled(True)
        self.accion1.setEnabled(True)
        self.accion2.setEnabled(True)
        self.accion3.setEnabled(True)
        print("Activated accions")


if __name__ == "__main__":
    app = QApplication([])
    window = MainWindow()
    window.show()
    app.exec()