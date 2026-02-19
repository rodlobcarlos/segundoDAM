import sys
import os
from PySide6.QtWidgets import QApplication, QWidget, QVBoxLayout, QPushButton, QLabel
from PySide6.QtGui import QDesktopServices
from PySide6.QtCore import QUrl

class VentanaInformesExternos(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Visor de Informes Externos")
        self.resize(300, 200)
        
        # Lista de archivos (asegúrate de que estén en la misma carpeta)
        self.informes = [
            "DI_U05_A02_03.html",
            "DI_U05_A02_08.html",
            "DI_U05_A03_11.html"
        ]
        
        self.init_ui()

    def init_ui(self):
        layout = QVBoxLayout()
        layout.addWidget(QLabel("Selecciona un informe para abrir en el navegador:"))

        for nombre_archivo in self.informes:
            btn = QPushButton(f"Abrir {nombre_archivo}")
            # Usamos una función lambda para pasar el nombre del archivo al método
            btn.clicked.connect(lambda checked, f=nombre_archivo: self.abrir_informe(f))
            layout.addStretch()
            layout.addWidget(btn)

        self.setLayout(layout)

    def abrir_informe(self, nombre_fichero):
        # Obtenemos la ruta absoluta para evitar errores de ruta relativa
        ruta = os.path.abspath(nombre_fichero)
        if os.path.exists(ruta):
            QDesktopServices.openUrl(QUrl.fromLocalFile(ruta))
        else:
            print(f"Error: No se encuentra el archivo {nombre_fichero}")

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaInformesExternos()
    ventana.show()
    sys.exit(app.exec())