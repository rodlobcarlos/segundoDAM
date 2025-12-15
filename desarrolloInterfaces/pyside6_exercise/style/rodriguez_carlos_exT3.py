import sys
from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QMainWindow,
    QVBoxLayout,
    QPushButton,
    QLabel
)
from PySide6.QtGui import QPainter, QColor, QPen, QPalette
from PySide6.QtCore import QRect, Qt
import os


class IndicadorCircular(QWidget):
    def __init__(self):
        super().__init__()
        # Texto que se mostrará dentro del círculo.
        # Se puede cambiar desde fuera con setTexto().
        self.texto = "OK"
        self.valor = "0"

    def setTexto(self, texto):
        # Guardamos el nuevo texto.
        self.text = texto
        
        # update() avisa a Qt de que debe volver a dibujar el widget.
        self.update()

    def paintEvent(self, event):
        # QPainter es el objeto que permite dibujar dentro del widget.
        painter = QPainter(self)

        # Activamos el suavizado de bordes para evitar formas “dentadas”.
        painter.setRenderHint(QPainter.Antialiasing)

        # Configuramos el color de relleno del círculo (verde).
        painter.setBrush(QColor("#FFFFFF"))
        '''
        if self.valor == 0:
            painter.setBrush(QColor("#ffffff"))
        elif self.valor >= 1 and self.valor <= 3:
            painter.setBrush(QColor("#fffb00"))
            self.setTexto("AVISO")
        elif self.valor >= 4 and self.valor <= 7:
            painter.setBrush(QColor("#ff0000"))
            self.setTexto("ERRO")
'''
        # Borde del círculo en color negro.
        painter.setPen(QPen(Qt.black))

        # Calculamos el tamaño máximo posible de un cuadrado dentro del widget.
        # Esto asegura que el círculo no se deforme aunque el widget no sea cuadrado.
        lado = min(self.width(), self.height())

        # Creamos un rectángulo cuadrado, centrado en el widget.
        recto = QRect(
            (self.width() - lado) // 2,   # posición X centrada
            (self.height() - lado) // 2,  # posición Y centrada
            lado,                         # ancho del cuadrado
            lado                          # alto del cuadrado
        )

        # Dibujamos el círculo dentro del rectángulo calculado.
        painter.drawEllipse(recto)

        # Cambiamos el lápiz para dibujar texto en blanco.
        painter.setPen(QPen(Qt.black))

        # Dibujamos el texto centrado dentro del círculo mediante AlignCenter.
        painter.drawText(recto, Qt.AlignCenter, self.texto)
        

class ContadorSimple(QWidget):
    def __init__(self, parent=None):
        super().__init__(parent)

        self.valor = 0
        self.color_base = self.palette().color(QPalette.Base)  # Guardar color del tema
        

        self.etiqueta = QLabel("Incidencias abiertas: 0", self)

        self.incidencia = QPushButton("Añadir incidencia", self)
        self.reinicio = QPushButton("Reset", self)
        
        self.incidencia.clicked.connect(self.incrementar)
        self.reinicio.clicked.connect(self.reiniciar)

        layout = QVBoxLayout(self)
        layout.addWidget(self.etiqueta)
        layout.addWidget(self.incidencia)
        layout.addWidget(self.reinicio)

    def incrementar(self):
        self.valor = self.valor + 1
        self.etiqueta.setText("Incidencias abiertas: " + str(self.valor))

    def valor(self):
        return self.valor

    def reiniciar(self):
        self.valor = 0
        self.etiqueta.setText("Incidencias abiertas: 0")
        
class Panel_de_control(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Panel de control de incidencias")
        self.resize(300, 300)

        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        # Nuestro widget personalizado
        self.indicador = IndicadorCircular()
        self.contador = ContadorSimple()

        layout.addWidget(self.indicador)
        layout.addWidget(self.contador)
        self.setCentralWidget(contenedor)
    
    '''
    def color(self):
        self.indicador.valor = self.valor
        self.indicador.update()
        '''


if __name__ == "__main__":
    app = QApplication(sys.argv)
    app.setStyle("Fusion")

    # --- CARGA OBLIGATORIA DESDE ARCHIVO EXTERNO ---
    ruta_script = os.path.dirname(os.path.abspath(__file__))
    # Asegúrate de que este nombre coincida EXACTAMENTE con tu archivo .qss
    nombre_archivo_qss = "rodriguez_carlos_estilos.qss"
    ruta_qss = os.path.join(ruta_script, nombre_archivo_qss)

    with open(ruta_qss, "r") as f:
        app.setStyleSheet(f.read())    

    ventana = Panel_de_control()
    ventana.show()
    sys.exit(app.exec())