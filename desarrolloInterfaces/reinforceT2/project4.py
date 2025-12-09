from PySide6.QtWidgets import (
    QApplication, 
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QLineEdit,
    QMessageBox,
    QTextEdit,
    QPushButton,
    QFileDialog,
    QFormLayout,
    QLabel,
    QComboBox,
    QCheckBox,
    QDialog,
    QDialogButtonBox
)
from PySide6.QtCore import Qt
from PySide6.QtGui import QAction, QKeySequence

class dialog(QDialog):
    def __init__(self):
        super().__init__()
        # --- Título ventana ---
        self.setWindowTitle("Confirmación")

        # Layout del diálogo
        self.layout_v = QVBoxLayout()

        # --- Dialog ---
        self.text = QLabel("Quieres aplicar las preferencias?")
        self.layout_v.addWidget(self.text)

        self.button = QDialogButtonBox.Ok | QDialogButtonBox.Cancel
        self.box = QDialogButtonBox(self.button)
        self.layout_v.addWidget(self.box)

        self.box.accepted.connect(self.accept)
        self.box.rejected.connect(self.reject)
        
        self.setLayout(self.layout_v)

class project4(QMainWindow):
    def __init__(self):
        super().__init__()
        # --- Título ventana ---
        self.setWindowTitle("Preferencias del usuario")

        # --- Contenedor y layout ---
        self.main_container = QWidget()
        self.layout_f = QFormLayout()

    # ''''FORMULARIO''''

        # --- QLabel "Nombre"---
        self.name = QLabel("Nombre")
        self.layout_f.addWidget(self.name)

        # --- QLineEdit ---
        self.line = QLineEdit()
        self.line.setMaxLength(20)
        self.line.setPlaceholderText("Nombre")
        self.layout_f.addWidget(self.line)

        # --- QLabel "Preferencias"---
        self.preferences = QLabel("Preferencias")
        self.layout_f.addWidget(self.preferences)
        
        # --- QComoboBox ---
        self.combo = QComboBox()
        self.combo.addItems(["Python", "Java", "C++", "Kotlin"])
        self.combo.setEditable(True)
        self.combo.setMaxCount(10)
        self.layout_f.addWidget(self.combo)

        # --- QCheckBox ---
        self.ch_box = QCheckBox("Modo oscuro")
        self.ch_box.setCheckable(True)
        self.layout_f.addWidget(self.ch_box)

        # --- Menu ---
        self.menu_bar = self.menuBar()
        self.menu = self.menu_bar.addMenu("Preferencias")

        # --- Acciones menu ---
        self.accion = QAction("Confirmar cambios", self)
        self.accion.setShortcut(QKeySequence("Ctrl+T"))
        self.accion.triggered.connect(self.confirm)
        self.menu.addAction(self.accion)

        # --- ToolBar ---
        self.tool_bar = self.addToolBar("Barra de herramientas")
        self.tool_bar.addAction(self.accion)

        # --- StatusBar ---
        self.status_bar = self.statusBar()
        self.status_bar.showMessage("Configura tus preferencias y confirma")

        self.main_container.setLayout(self.layout_f)
        self.setCentralWidget(self.main_container)

    # --- Slots ---
    def confirm(self):
        dlg = dialog()

        if dlg.exec():
            self.accept()
        else:
            self.reject()

    def accept(self):
        QMessageBox.information(
            self,
            "Preferencias",
            "Las preferencias se han aplicado"
        )
        self.status_bar.showMessage("Preferencias aplicadas correctamente")
    
    def reject(self):
        print("Se han descartado los cambios")
        self.line.clear()

# --- Bucle aplicación ---
app = QApplication([])
window = project4()
window.show()
app.exec()