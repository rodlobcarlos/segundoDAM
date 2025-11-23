import os
from PySide6.QtCore import Qt
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtWidgets import (
    QApplication, QMainWindow, QToolBar, QLabel, QDockWidget, QTextEdit
)

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Exercise - Dockable Components")

        self.setCentralWidget(QLabel("Main application area"))

        # PANEL 1
        dock1 = QDockWidget("Panel 1", self)
        dock1.setWidget(QTextEdit("Notes panel"))
        dock1.setFeatures(QDockWidget.NoDockWidgetFeatures)  # Fijo
        self.addDockWidget(Qt.LeftDockWidgetArea, dock1)

        # PANEL 2
        dock2 = QDockWidget("Panel 2", self)
        dock2.setWidget(QLabel("Status panel"))
        dock2.setFeatures(QDockWidget.DockWidgetFloatable)  # Flotante
        self.addDockWidget(Qt.RightDockWidgetArea, dock2)

        # PANEL 3
        dock3 = QDockWidget("Panel 3", self)
        dock3.setWidget(QLabel("Help panel"))
        dock3.setFeatures(QDockWidget.DockWidgetFloatable | QDockWidget.DockWidgetClosable)  # Flotante + cerrable
        self.addDockWidget(Qt.BottomDockWidgetArea, dock3)

        # BARRA DE ESTADO 
        status_bar = self.statusBar()
        status_bar.showMessage("Ready. Panels created successfully.", 3000)

        # BARRA DE HERRAMIENTAS 
        toolbar = QToolBar("Main Toolbar")
        self.addToolBar(toolbar)

        icon_path = os.path.join(os.path.dirname(__file__), "console-log-icon.png")
        action_print = QAction(QIcon(icon_path), "Print to console", self)
        action_print.setShortcut(QKeySequence("Ctrl+P"))
        action_print.triggered.connect(self.print_to_console)
        toolbar.addAction(action_print)

    def print_to_console(self):
        print("Action triggered from the toolbar.")

if __name__ == "__main__":
    app = QApplication([])
    window = MainWindow()
    window.show()
    app.exec()
