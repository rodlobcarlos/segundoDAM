import sys
import os
from PySide6.QtWidgets import QApplication, QMainWindow, QVBoxLayout, QWidget, QComboBox, QLabel
from PySide6.QtWebEngineWidgets import QWebEngineView
from PySide6.QtCore import QUrl

class VisorInterno(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Dashboard de Informes Qt")
        self.resize(1000, 800)

        # Widgets principales
        self.central_widget = QWidget()
        self.setCentralWidget(self.central_widget)
        self.layout = QVBoxLayout(self.central_widget)

        # Selector
        self.combo = QComboBox()
        self.informes = [
            "DI_U05_A02_03.html",
            "DI_U05_A02_08.html",
            "DI_U05_A03_11.html"
        ]
        self.combo.addItems(self.informes)
        self.combo.currentIndexChanged.connect(self.cargar_informe)

        # Visor Web
        self.web_view = QWebEngineView()
        
        # Montaje de la interfaz
        self.layout.addWidget(QLabel("Seleccione el informe a visualizar:"))
        self.layout.addWidget(self.combo)
        self.layout.addWidget(self.web_view)

        # Carga inicial
        self.cargar_informe()

    def cargar_informe(self):
        archivo = self.combo.currentText()
        ruta_absoluta = os.path.abspath(archivo)
        
        if os.path.exists(ruta_absoluta):
            self.web_view.setUrl(QUrl.fromLocalFile(ruta_absoluta))
        else:
            self.web_view.setHtml(f"<h1>Error</h1><p>El archivo {archivo} no existe en la ruta especificada.</p>")

if __name__ == "__main__":
    # Importante: WebEngine suele requerir inicialización antes de la App en algunas plataformas
    app = QApplication(sys.argv)
    ventana = VisorInterno()
    ventana.show()
    sys.exit(app.exec())