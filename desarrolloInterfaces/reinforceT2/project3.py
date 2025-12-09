from PySide6.QtWidgets import (
    QApplication, 
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QLineEdit,
    QMessageBox,
    QTextEdit,
    QPushButton,
    QFileDialog
)
from PySide6.QtCore import Qt
from PySide6.QtGui import QAction, QKeySequence

class project3(QMainWindow):
    def __init__(self):
        super().__init__()
        # --- Título ventana ---
        self.setWindowTitle("Editor de notas")

        # --- Contenedor y layout
        self.main_container = QWidget()
        self.layout_v = QVBoxLayout()
        
        # --- QLineEdit ---
        self.line = QLineEdit()
        self.line.setPlaceholderText("Título de la nota")

        self.line.textChanged.connect(self.textChangedLine)
        self.layout_v.addWidget(self.line)

        # --- QTextEdit ---
        self.text = QTextEdit()
        self.text.setPlainText("Escribe aquí...")
        
        self.text.textChanged.connect(self.textChangedText)
        self.layout_v.addWidget(self.text)

        # --- Menu ---
        self.menu_bar = self.menuBar()
        self.menu = self.menu_bar.addMenu("Archivo")

        self.accion1 = QAction("Nuevo", self)
        self.accion1.setShortcut(QKeySequence("Ctrl+T"))
        self.accion1.triggered.connect(self.clear)

        self.accion2 = QAction("Abrir", self)
        self.accion2.setShortcut(QKeySequence("Ctrl+L"))
        self.accion2.triggered.connect(self.open)

        self.accion3 = QAction("Guardar como", self)
        self.accion3.setShortcut(QKeySequence("Ctrl+P"))
        self.accion3.triggered.connect(self.save)

        self.menu.addAction(self.accion1)
        self.menu.addAction(self.accion2)
        self.menu.addAction(self.accion3)

        # --- QToolBar ---
        self.tool_bar = self.addToolBar("Barra de herramientas")
        self.tool_bar.addAction(self.accion1)
        self.tool_bar.addAction(self.accion2)
        self.tool_bar.addAction(self.accion3)

        # --- StatusBar ---
        self.status_bar = self.statusBar()
        self.status_bar.showMessage("Listo. Esperando accion...", 3000)

        # --- QPushButton ---
        self.button = QPushButton("Acerca de")
        self.layout_v.addWidget(self.button)

        self.button.clicked.connect(self.acerca)

        self.main_container.setLayout(self.layout_v)
        self.setCentralWidget(self.main_container)

        # --- Slots ---
        
    def textChangedLine(self):
        text = self.line.text()
        if not text:
            self.setWindowTitle("Editor de notas")
        else:
            self.setWindowTitle(text)
            print()

    def textChangedText(self):
        print("Contenido actual")
    
    def clear(self):
        self.line.clear()
        self.text.clear()
        self.status_bar.showMessage("Nota nueva")

    def open(self):
        dialoge_window = QFileDialog.getOpenFileName(
        self,
        caption="Guardar como ...",
        dir="./",
        filter="Documentos de texto (*.txt)",
        selectedFilter="Documentos de texto (*.txt)"
    )  
        file = dialoge_window[0]
        print(file)
        self.status_bar.showMessage("Se ha abierto el archivo")

    def acerca(self):
        QMessageBox.information(
            self,
            "Información",
            "Esto es un editor de notas de prueba"
        )

       
    def save(self):
        dialoge_window = QFileDialog.getSaveFileName(
        self,
        caption="Guardar archivo ...",
        dir="./",
        filter="Documentos de texto (*.txt);;Documentos PDF (*.pdf)",
        selectedFilter="Documentos de texto (*.txt)"
    )

        file = dialoge_window[0]
        print(file)
        self.status_bar.showMessage("Se ha guardado el archivo")

# --- Bucle aplicación ---
app = QApplication([])
window = project3()
window.show()
app.exec()