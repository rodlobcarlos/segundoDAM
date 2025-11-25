import sys
from PySide6.QtWidgets import (
    QApplication, QMessageBox, QMainWindow, QPushButton
)
from PySide6.QtCore import Slot

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Gestión de Tareas") # Título principal
        
        boton = QPushButton("Gestionar tarea") # Botón principal
        boton.clicked.connect(self.mostrar_dialogo)
        self.setCentralWidget(boton)

    def mostrar_dialogo(self):
        boton_pulsado = QMessageBox.question(
            self,
            "Acción sobre la tarea", # Título
            "¿Qué quieres hacer con la tarea seleccionada?", # Mensaje
            buttons=QMessageBox.Yes | QMessageBox.No | QMessageBox.Ignore,
            defaultButton=QMessageBox.Ignore 
        )

        titulo_salida = "Resultado de la Tarea"
        if boton_pulsado == QMessageBox.Yes:
            mensaje_salida = "La tarea se ha marcado como completada."
            QMessageBox.information(self, titulo_salida, mensaje_salida)
            
        elif boton_pulsado == QMessageBox.No:
            mensaje_salida = "La tarea se ha pospuesto para más tarde."
            QMessageBox.warning(self, titulo_salida, mensaje_salida)
            
        elif boton_pulsado == QMessageBox.Ignore:
            mensaje_salida = "La tarea se mantiene sin cambios."
            QMessageBox.information(self, titulo_salida, mensaje_salida)

# Bloque de ejecución
if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())