from PySide6.QtWidgets import (
    QApplication, 
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QLineEdit,
    QPushButton,
    QHBoxLayout,
    QStackedLayout,
    QLabel,
    QColorDialog,
    QFontDialog
)
from PySide6.QtGui import QAction, QKeySequence

class project5(QMainWindow):
    def __init__(self):
        super().__init__()
        # 1. Título ventana
        self.setWindowTitle("Panel multipantalla")

        # 2. Contenedor principal y layout
        self.main_container = QWidget()
        self.layout_h = QHBoxLayout()
        self.main_container.setLayout(self.layout_h)

        # 3. QStackedLayout (La Pila)
        self.pila = QStackedLayout()
        
        # --- Pantalla 1 (Índice 0) ---
        self.label1 = QLabel("Pantalla 1")
        self.pila.addWidget(self.label1) 

        # --- Pantalla 2 (Índice 1) ---
        self.label2 = QLabel("Pantalla 2")
        self.pila.addWidget(self.label2)

        # --- Pantalla 3 (Índice 2): El Formulario ---
        # (Hemos borrado el label suelto que tenías antes aquí para corregir el índice)
        self.page3_widget = QWidget()
        self.page3_layout = QVBoxLayout() 
        
        self.line = QLineEdit()
        self.line.setPlaceholderText("Escribe algo...")
        
        # Esta es la etiqueta que cambiaremos de color y fuente
        self.label_form = QLabel()
        
        # Conexión directa
        self.line.textChanged.connect(self.label_form.setText)
        
        self.page3_layout.addWidget(QLabel("Pantalla 3"))
        self.page3_layout.addWidget(self.line)
        self.page3_layout.addWidget(self.label_form)
        self.page3_layout.addStretch() # Empuja todo hacia arriba
        
        self.page3_widget.setLayout(self.page3_layout)
        
        # Añadimos el widget contenedor a la pila
        self.pila.addWidget(self.page3_widget)

        # 4. Botones Laterales
        self.layout_v = QVBoxLayout()
        
        self.button1 = QPushButton("Ver pantalla 1")
        self.button1.clicked.connect(self.ver_pantalla1)

        self.button2 = QPushButton("Ver pantalla 2")
        self.button2.clicked.connect(self.ver_pantalla2)

        self.button3 = QPushButton("Ver pantalla 3")
        self.button3.clicked.connect(self.ver_pantalla3)

        self.layout_v.addWidget(self.button1)
        self.layout_v.addWidget(self.button2)
        self.layout_v.addWidget(self.button3)
        self.layout_v.addStretch()
        
        # 6. Menú y Toolbar
        self.menu_bar = self.menuBar()
        self.tool_bar = self.addToolBar("Barra Principal") # Creamos la Toolbar
        
        self.menu_ver = self.menu_bar.addMenu("&Ver")
        self.menu_formato = self.menu_bar.addMenu("&Formato")

        # --- Acciones ---
        self.accion1 = QAction("Pantalla 1", self)
        self.accion1.triggered.connect(self.ver_pantalla1)

        self.accion2 = QAction("Pantalla 2", self)
        self.accion2.triggered.connect(self.ver_pantalla2)

        self.accion3 = QAction("Pantalla 3", self)
        self.accion3.triggered.connect(self.ver_pantalla3)

        self.accion_color = QAction("Cambiar color del texto", self)
        self.accion_color.triggered.connect(self.cambiar_color)

        self.accion_fuente = QAction("Cambiar fuente del texto", self)
        self.accion_fuente.triggered.connect(self.cambiar_fuente)

        # Añadir al Menú
        self.menu_ver.addAction(self.accion1)
        self.menu_ver.addAction(self.accion2)
        self.menu_ver.addAction(self.accion3)

        self.menu_formato.addAction(self.accion_color)
        self.menu_formato.addAction(self.accion_fuente)

        # Añadir a la Toolbar 
        self.tool_bar.addAction(self.accion1)
        self.tool_bar.addAction(self.accion2)
        self.tool_bar.addAction(self.accion3)

        # 7. StatusBar
        self.status_bar = self.statusBar()
        self.status_bar.showMessage("Pantalla 1 activa")

        # 5. Montaje Final
        self.layout_h.addLayout(self.layout_v)
        self.layout_h.addLayout(self.pila)
        
        self.setCentralWidget(self.main_container)

    # --- Slots --- 
    def ver_pantalla1(self):
        self.pila.setCurrentIndex(0) 
        self.status_bar.showMessage("Pantalla 1 activa")

    def ver_pantalla2(self):
        self.pila.setCurrentIndex(1) 
        self.status_bar.showMessage("Pantalla 2 activa")

    def ver_pantalla3(self):
        self.pila.setCurrentIndex(2) 
        self.status_bar.showMessage("Pantalla 3 activa")

    def cambiar_color(self):
        color = QColorDialog.getColor()
        if color.isValid():
            hex_color = color.name()
            self.label_form.setStyleSheet(f"color: {hex_color}")
            self.status_bar.showMessage("Color actualizado")

    def cambiar_fuente(self):
        ok, font = QFontDialog.getFont()
        if ok:
            self.label_form.setFont(font)
            self.status_bar.showMessage("Fuente actualizada")

# --- Bucle aplicación ---
if __name__ == "__main__":
    app = QApplication([])
    window = project5()
    window.show()
    app.exec()