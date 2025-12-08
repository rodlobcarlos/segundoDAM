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

class project5(QMainWindow):
    def __init__(self):
        super().__init__()
        # --- Título ventena ---

        # --- Contenedor y layout

        # --- QStackedLayout ---
        
        # --- QVBoxLayout ---

        # --- Menu ---

        # --- Acciones menu ---

    # --- Slots ---


# --- Bucle aplicación ---
app = QApplication([])
window = project5()
window.show()
app.exec()