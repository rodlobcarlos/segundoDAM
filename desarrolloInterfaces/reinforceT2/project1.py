from PySide6.QtWidgets import (
    QMainWindow, 
    QLabel,
    QApplication,
    QPushButton,
    QMessageBox,
    QWidget,
    QVBoxLayout
)
from PySide6.QtCore import Qt
from PySide6.QtGui import QAction, QKeySequence

class project1(QMainWindow):
    def __init__(self):
        super().__init__()
        # --- Titulo de la ventana ---
        self.setWindowTitle("Panel de mensajes")

        # --- Contenedor y layout ---
        self.main_container = QWidget() # Almacena todo label, botones y campos de texto
        self.layout_v = QVBoxLayout() # Todo widget dentro del layout se pone encima del otro V(vertical)
        
        # --- QLabel ---
        self.central_widget = QLabel("Sistema en espera...")
        self.font = self.central_widget.font() # Fuente del widget 
        self.font.setPointSize(20) # Tamaño de la fuente
        self.central_widget.setFont(self.font)
        self.central_widget.setAlignment(Qt.AlignHCenter | Qt.AlignVCenter) # Centrado

        self.layout_v.addWidget(self.central_widget) # Añade widget al layout

        # --- Menu ---
        self.menu_bar = self.menuBar()
        self.menu = self.menu_bar.addMenu("&Acciones")

        # Acciones del menu
        self.accion = QAction("Mostrar saludo", self)
        self.accion.setShortcut(QKeySequence("Ctrl+T"))
        self.accion.triggered.connect(self.mostrar_saludo) # Conecta al slot

        self.menu.addAction(self.accion)

        # --- QToolBar ---
        self.tool_bar = self.addToolBar("Barra de herramientas")
        self.tool_bar.addAction(self.accion) # Misma acción que el menu

        # --- Barra de estado ---
        self.status_bar = self.statusBar()
        self.status_bar.showMessage("Listo. Esperando acción...", 3000)

        # --- QPushButoon ---
        self.button = QPushButton("Mensaje")
        self.button.clicked.connect(self.mostrar_mesaje)

        self.layout_v.addWidget(self.button) # Añade widget al layout
        self.main_container.setLayout(self.layout_v) # Añade QWidget() al layout

        self.setCentralWidget(self.main_container) # Centraliza el QWidget()

    # --- Slots ---
    def mostrar_saludo(self):
        self.central_widget.setText("Sistema operativo iniciado...") # Cambia el nombre del QLabel
        self.setWindowTitle("Sistema operativo iniciado")
        self.status_bar.showMessage("Saludo mostrado", 3000)

    def mostrar_mesaje(self):
        QMessageBox.information(self, "Información", "¡Hola! Esto es un mensaje.")

# --- Bucle aplicación ---
app = QApplication([])
window = project1()
window.show()
app.exec()