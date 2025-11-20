import os
import platform
import getpass
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtCore import QTimer
from PySide6.QtWidgets import QApplication, QMainWindow, QToolBar, QLabel

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("My app")

        menu_bar = self.menuBar()
        menu = menu_bar.addMenu("&File")

        # Ruta del icono
        icon_path = os.path.join(os.path.dirname(__file__), "usuario.png")

        # Mostrar mensaje temporal
        action_temp_message = QAction(QIcon(icon_path), "Show temporary message", self)
        action_temp_message.setStatusTip("Show a temporary message in the status bar")
        action_temp_message.setShortcut(QKeySequence("Ctrl+T"))
        action_temp_message.triggered.connect(self.show_temporary_message)

        # Limpiar mensaje
        action_clear_message = QAction(QIcon(icon_path), "Clear message", self)
        action_clear_message.setStatusTip("Clear the status bar message")
        action_clear_message.setShortcut(QKeySequence("Ctrl+L"))
        action_clear_message.triggered.connect(self.statusBar().clearMessage)

        # Mostrar información del sistema
        action_system_info = QAction(QIcon(icon_path), "Show system info", self)
        action_system_info.setStatusTip("Add system information to the status bar")
        action_system_info.setShortcut(QKeySequence("Ctrl+I"))
        action_system_info.triggered.connect(self.show_system_info)

        # Agregar acciones al menú
        menu.addAction(action_temp_message)
        menu.addAction(action_clear_message)
        menu.addAction(action_system_info)

        # BARRA DE HERRAMIENTAS 
        toolbar = QToolBar("Main Toolbar")
        toolbar.addAction(action_temp_message)
        toolbar.addAction(action_clear_message)
        toolbar.addAction(action_system_info)
        self.addToolBar(toolbar)

        # BARRA DE ESTADO 
        self.status_bar = self.statusBar()

        # Añadir un componente permanente con el usuario actual
        username = getpass.getuser()
        user_label = QLabel(f"User: {username}")
        self.status_bar.addPermanentWidget(user_label)

        # Mensaje inicial de 2 segundos
        self.status_bar.showMessage("Application started successfully", 2000)

        # QTimer para mostrar mensajes alternados 
        self.messages = ["Waiting for action…", "Ready to work"]
        self.message_index = 0

        self.timer = QTimer()
        self.timer.timeout.connect(self.show_alternating_message)
        self.timer.start(4000)  # Cada 4 segundos

    # Mostrar un mensaje temporal en la barra de estado
    def show_temporary_message(self):
        self.status_bar.showMessage("Temporary message: disappears in 3 seconds", 3000)

    # Añadir información del sistema a la barra de estado
    def show_system_info(self):
        system_name = platform.system()
        label = QLabel("System: ", system_name)
        self.status_bar.addWidget(label)

    # Alternar mensajes cada pocos segundos
    def show_alternating_message(self):
        self.status_bar.showMessage(self.messages[self.message_index], 3000)
        self.message_index = (self.message_index + 1) % len(self.messages)


if __name__ == "__main__":
    app = QApplication([])
    window = MainWindow()
    window.show()
    app.exec()
