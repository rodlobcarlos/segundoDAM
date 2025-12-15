import sys
from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QMainWindow,
    QVBoxLayout,
    QPushButton
)
from PySide6.QtGui import QPainter, QColor, QPen
from PySide6.QtCore import Qt, QRect, QTimer


class RedCircle(QWidget):
    def __init__(self):
        super().__init__()
        self.active = False

    def paintEvent(self, event):
        # QPainter es el objeto encargado de dibujar dentro del widget.
        painter = QPainter(self)

        # Color de relleno del círculo (rojo).
        painter.setBrush(QColor("red"))

        # Color del borde (negro) usando un QPen, grosor por defecto.
        painter.setPen(QPen(Qt.black))

        # Si active=True pinta Rojo Brillante, de lo contrario pinta Gris Oscuro
        if self.active:
            color = QColor("#FF0000")
        else:
            color = QColor("#463e3e")

        painter.setBrush(color)

        # Calculamos el tamaño máximo posible de un cuadrado dentro del widget.
        # Esto asegura que el círculo no se deforme aunque el widget no sea cuadrado.
        side = min(self.width(), self.height())

        # Creamos un rectángulo cuadrado, centrado en el widget.
        rect = QRect(
            (self.width() - side) // 2,   # posición X centrada
            (self.height() - side) // 2,  # posición Y centrada
            side,                         # ancho del cuadrado
            side                          # alto del cuadrado
        )

        # Dibujamos el círculo dentro del rectángulo calculado.
        painter.drawEllipse(rect)


class YellowCircle(QWidget):
    def __init__(self):
        super().__init__()
        self.active = False

    def paintEvent(self, event):
        # QPainter es el objeto encargado de dibujar dentro del widget.
        painter = QPainter(self)

        # Color de relleno del círculo (amarillo).
        painter.setBrush(QColor("#FBFF00"))

        # Color del borde (negro) usando un QPen, grosor por defecto.
        painter.setPen(QPen(Qt.black))

        # Si active=True pinta Amarillo, de lo contrario pinta Gris Oscuro
        if self.active:
            color = QColor("#EEFF00")
        else:
            color = QColor("#463e3e")
            
        painter.setBrush(color)

        # Calculamos el tamaño máximo posible de un cuadrado dentro del widget.
        # Esto asegura que el círculo no se deforme aunque el widget no sea cuadrado.
        side = min(self.width(), self.height())

        # Creamos un rectángulo cuadrado, centrado en el widget.
        rect = QRect(
            (self.width() - side) // 2,   # posición X centrada
            (self.height() - side) // 2,  # posición Y centrada
            side,                         # ancho del cuadrado
            side                          # alto del cuadrado
        )

        # Dibujamos el círculo dentro del rectángulo calculado.
        painter.drawEllipse(rect)


class GreenCircle(QWidget):
    def __init__(self):
        super().__init__()
        self.active = False

    def paintEvent(self, event):
        # QPainter es el objeto encargado de dibujar dentro del widget.
        painter = QPainter(self)

        # Color de relleno del círculo (verde).
        painter.setBrush(QColor("green"))

        # Color del borde (negro) usando un QPen, grosor por defecto.
        painter.setPen(QPen(Qt.black))

        # Si active=True pinta Verde Brillante, de lo contrario pinta Gris Oscuro
        if self.active:
            color = QColor("#73FF00")
        else:
            color = QColor("#463e3e")
            
        painter.setBrush(color)

        # Calculamos el tamaño máximo posible de un cuadrado dentro del widget.
        # Esto asegura que el círculo no se deforme aunque el widget no sea cuadrado.
        side = min(self.width(), self.height())

        # Creamos un rectángulo cuadrado, centrado en el widget.
        rect = QRect(
            (self.width() - side) // 2,   # posición X centrada
            (self.height() - side) // 2,  # posición Y centrada
            side,                         # ancho del cuadrado
            side                          # alto del cuadrado
        )

        # Dibujamos el círculo dentro del rectángulo calculado.
        painter.drawEllipse(rect)


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Traffic Light Panel")
        self.resize(300, 300)

        self.layout_v = QVBoxLayout()
        self.main_container = QWidget()

        self.red_light = RedCircle()
        self.yellow_light = YellowCircle()
        self.green_light = GreenCircle()

        self.layout_v.addWidget(self.red_light)
        self.layout_v.addWidget(self.yellow_light)
        self.layout_v.addWidget(self.green_light)

        self.timer = QTimer(self)
        self.timer.setInterval(2000)  # Configurado a 2 segundos
        # Conectamos el timer a la misma función que usa el botón
        self.timer.timeout.connect(self.change_clicked)
        self.timer.start()  # Inicia automáticamente al crear el componente

        self.reset()

        self.main_container.setLayout(self.layout_v)
        self.setCentralWidget(self.main_container)

    def reset(self):
        self.current_state = "red"
        self.update()

    def change_clicked(self):
        if self.current_state == "red":
            self.current_state = "yellow"
        elif self.current_state == "yellow":
            self.current_state = "green"
        elif self.current_state == "green":
            self.current_state = "red"
        
        # Llamada para actualizar el dibujo
        self.update()

    def update(self):
        # Actualizamos la variable 'active' 
        self.red_light.active = (self.current_state == "red")
        self.yellow_light.active = (self.current_state == "yellow")
        self.green_light.active = (self.current_state == "green")

        # Forzamos el repintado de cada widget
        self.red_light.update()
        self.yellow_light.update()
        self.green_light.update()


if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = MainWindow()
    window.show()
    app.exec()