from PySide6.QtWidgets import (
    QApplication, 
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QLineEdit,
    QMessageBox
)
from PySide6.QtCore import Qt
from PySide6.QtGui import QAction, QKeySequence

class project2(QMainWindow):
    def __init__(self):
        super().__init__()
        # --- Título ventana ---
        self.setWindowTitle("Formulario de cuidad")

        # --- Contenedor y layout ---
        self.main_container = QWidget()
        self.layout_v = QVBoxLayout() 

        # --- QLineEdit ---
        self.line = QLineEdit()
        self.line.setMaxLength(20)
        self.line.setPlaceholderText("Escribe tu ciudad")

        self.line.returnPressed.connect(self.returnPressed)

        self.layout_v.addWidget(self.line)

        # --- Menu ---
        self.menu_bar = self.menuBar()
        self.menu = self.menu_bar.addMenu("Cuidad")

        # --- Acciones del menu ---
        self.accion1 = QAction("Establecer ciudad", self)
        self.accion1.setShortcut(QKeySequence("Ctrl+T"))
        self.accion1.triggered.connect(self.returnPressed)

        self.accion2 = QAction("Borrar ciudad", self)
        self.accion2.setShortcut(QKeySequence("Ctrl+L"))
        self.accion2.triggered.connect(self.clear)

        self.menu.addAction(self.accion1)
        self.menu.addAction(self.accion2)

        # --- ToolBar
        self.tool_bar = self.addToolBar("Barra de herramientas")
        self.tool_bar.addAction(self.accion1)
        self.tool_bar.addAction(self.accion2)

        # --- StatusBar ---
        self.status_bar = self.statusBar()
        self.status_bar.showMessage("Introduce tu ciudad y pulsa Enter")

        # --- Carga ---
        self.main_container.setLayout(self.layout_v)
        self.setCentralWidget(self.main_container)

    # --- Slots ---
    def returnPressed(self):
        text = self.line.text() # Guarda en text el texto del QLineEdit
        if not text: # Si está vacío 
            self.setWindowTitle("Sin ciudad")
            print("El campo está vacío")
        else: 
            self.setWindowTitle(text)
            self.status_bar.showMessage("Cuidad establecida correctamente")
            print("Ciudad actual -> ", text)

    def clear(self):
        button = QMessageBox.question(
            self,
            "Pregunta", # Título ventana
            "¿Seguro que quieres borrar la ciudad?", # Texto ventana
            QMessageBox.Yes | QMessageBox.No # Opciones
        )
        if button == QMessageBox.Yes:
            self.line.clear() # Limpiar QLineEdit
            self.setWindowTitle("Formulario de cuidad")
            self.status_bar.showMessage("Cuidad borrada")


# --- Bucle aplicación ---
app = QApplication([])
window = project2()
window.show()
app.exec()