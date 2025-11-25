import sys
from PySide6.QtWidgets import (
    QMainWindow, QApplication, QWidget, QVBoxLayout, QPushButton, QLabel,
    QFileDialog, QColorDialog, QFontDialog,
)
from PySide6.QtCore import Slot, Qt
from PySide6.QtGui import QFont, QColor

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Gestión de archivo y preferencias")

        self.texto_base = "Contenido inicial. Pulsa 'Abrir archivo de texto' para cargar un archivo."

        # Añade un QWidget central
        widget_central = QWidget()
        self.setCentralWidget(widget_central)

        # Añade un QVBoxLayout
        layout = QVBoxLayout()

        # Añade un QLabel para mostrar el contenido del archivo
        self.label_contenido = QLabel(self.texto_base)
        self.label_contenido.setAlignment(Qt.AlignmentFlag.AlignCenter)
        self.label_contenido.setMinimumHeight(100)
        self.label_contenido.setStyleSheet("background-color: white; padding: 10px; border: 1px solid gray;")
        layout.addWidget(self.label_contenido)
        
        # 1. Abrir archivo de texto
        self.btn_abrir = QPushButton("Abrir archivo de texto")
        self.btn_abrir.clicked.connect(self.abrir_archivo)
        layout.addWidget(self.btn_abrir)

        # 2. Guardar archivo como...
        self.btn_guardar = QPushButton("Guardar archivo como...")
        self.btn_guardar.clicked.connect(self.guardar_archivo)
        layout.addWidget(self.btn_guardar)

        # 3. Elegir color de fondo
        self.btn_color = QPushButton("Elegir color de fondo")
        self.btn_color.clicked.connect(self.elegir_color)
        layout.addWidget(self.btn_color)

        # 4. Cambiar fuente del texto
        self.btn_fuente = QPushButton("Cambiar fuente del texto")
        self.btn_fuente.clicked.connect(self.cambiar_fuente)
        layout.addWidget(self.btn_fuente)

        widget_central.setLayout(layout)
        self.resize(500, 300)

    # --- 2. Acción: Abrir archivo de texto ---
    def abrir_archivo(self):
        # Abre un diálogo QFileDialog.getOpenFileName()
        # Filtra solo archivos .txt.
        ruta_archivo, _ = QFileDialog.getOpenFileName(
            self,
            "Abrir archivo de texto",
            "",
            "Archivos de Texto (*.txt);;Todos los archivos (*)"
        )

        if ruta_archivo:
            try:
                # Si el usuario selecciona un archivo, muéstralo en el QLabel
                with open(ruta_archivo, 'r', encoding='utf-8') as f:
                    contenido = f.read()
                    self.label_contenido.setText(contenido)
            except Exception as e:
                self.label_contenido.setText(f"ERROR al leer archivo: {e}")

    # --- 3. Acción: Guardar archivo como... ---
    def guardar_archivo(self):
        # Abre un diálogo QFileDialog.getSaveFileName()
        # Establece como filtro *.txt.
        ruta_archivo, _ = QFileDialog.getSaveFileName(
            self,
            "Guardar archivo como...",
            "",
            "Archivos de Texto (*.txt)"
        )

        if ruta_archivo:
            try:
                # Guarda en ese archivo el texto que esté mostrando el QLabel
                contenido = self.label_contenido.text()
                with open(ruta_archivo, 'w', encoding='utf-8') as f:
                    f.write(contenido)
            except Exception as e:
                self.label_contenido.setText(f"ERROR al guardar archivo: {e}")

    # --- 4. Acción: Elegir color de fondo ---
    def elegir_color(self):
        # Abre un diálogo QColorDialog.getColor().
        color_seleccionado = QColorDialog.getColor(
            self.label_contenido.palette().color(self.label_contenido.backgroundRole()),
            self,
            "Seleccionar color de fondo"
        )

        # Si el color es válido (el usuario pulsó OK)
        if color_seleccionado.isValid():
            # Cambia el color de fondo del QLabel usando setStyleSheet()
            color_hex = color_seleccionado.name() # Obtiene el código HEX del color
            # Mantenemos el padding y el borde, solo cambiamos el fondo
            self.label_contenido.setStyleSheet(
                f"background-color: {color_hex}; padding: 10px; border: 1px solid gray;"
            )

    # --- 5. Acción: Cambiar fuente del texto ---
    def cambiar_fuente(self):
        # Abre un diálogo QFontDialog.getFont().
        fuente, ok = QFontDialog.getFont(
            self.label_contenido.font(),
            self,
            "Seleccionar fuente para el texto"
        )

        # Si el usuario pulsa OK
        if ok:
            # Aplica la fuente al texto del QLabel.
            self.label_contenido.setFont(fuente)

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())