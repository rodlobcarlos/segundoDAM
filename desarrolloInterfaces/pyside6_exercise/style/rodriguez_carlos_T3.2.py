"""
TAREA 3.2 - Editor de notas con avisos
Componentes derivados de widgets Qt con señales personalizadas y avisos visuales
"""

import sys
from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QTextEdit,
    QLabel,
    QPushButton
)
from PySide6.QtCore import Signal
from PySide6.QtGui import QPalette, QColor


class AreaTextoLimitada(QTextEdit):
    """
    Widget derivado de QTextEdit que limita la cantidad de caracteres
    y proporciona avisos visuales mediante cambios de color de fondo.
    """
    
    # Señales personalizadas
    longitudCambiada = Signal(int)  # Emite la longitud actual del texto
    limiteSuperado = Signal(bool)   # Emite True cuando se supera el límite
    
    def __init__(self, parent=None):
        super().__init__(parent)
        
        # Atributos privados
        self.limite_maximo = 200  # Límite de caracteres
        self.color_base = self.palette().color(QPalette.Base)  # Guardar color del tema
        
        # Conectar la señal estándar textChanged a nuestro método personalizado
        self.textChanged.connect(self.verificar_longitud)
        
        # Establecer color inicial (color del tema)
        self.aplicar_color_fondo(self.color_base)
    
    def verificar_longitud(self):
        """
        Método interno que verifica la longitud del texto y actualiza
        los avisos visuales según el porcentaje de uso del límite.
        """
        texto_actual = self.toPlainText()
        longitud_actual = len(texto_actual)
        
        # Si se supera el límite, recortar el texto
        if longitud_actual > self.limite_maximo:
            # Mantener solo los primeros 200 caracteres
            cursor = self.textCursor()
            posicion_cursor = cursor.position()
            self.setPlainText(texto_actual[:self.limite_maximo])
            # Restaurar posición del cursor
            cursor.setPosition(min(posicion_cursor, self.limite_maximo))
            self.setTextCursor(cursor)
            longitud_actual = self.limite_maximo
        
        # Calcular porcentaje de uso
        porcentaje = (longitud_actual / self.limite_maximo) * 100
        
        # Obtener la paleta actual
        paleta = self.palette()
        
        # Aplicar colores según el porcentaje
        if porcentaje < 80:
            # Menos del 80% → color del tema
            paleta.setColor(QPalette.Base, self.color_base)
            paleta.setColor(QPalette.Text, self.palette().color(QPalette.Text))
            self.limiteSuperado.emit(False)
        elif porcentaje < 100:
            # Entre 80% y 100% → fondo amarillo suave con texto oscuro
            paleta.setColor(QPalette.Base, QColor("#FFF2CC"))
            paleta.setColor(QPalette.Text, QColor("#000000"))
            self.limiteSuperado.emit(False)
        else:
            # 100% → fondo rojo suave con texto oscuro
            paleta.setColor(QPalette.Base, QColor("#FFCCCC"))
            paleta.setColor(QPalette.Text, QColor("#000000"))
            self.limiteSuperado.emit(True)
        
        # Aplicar la paleta modificada
        self.setPalette(paleta)
        
        # Emitir señal con la longitud actual
        self.longitudCambiada.emit(longitud_actual)
    
    def aplicar_color_fondo(self, color):
        """
        Aplica un color de fondo al widget usando QPalette.
        color: QColor con el color a aplicar
        """
        paleta = self.palette()
        paleta.setColor(QPalette.Base, color)
        self.setPalette(paleta)
    
    def obtener_limite_maximo(self):
        """
        Método que devuelve el límite máximo de caracteres.
        """
        return self.limite_maximo


class EtiquetaContadorCaracteres(QLabel):
    """
    Widget derivado de QLabel que muestra el contador de caracteres
    con avisos visuales mediante cambios de color de texto.
    """
    
    def __init__(self, limite_maximo=200, parent=None):
        super().__init__(parent)
        
        # Atributos privados
        self.limite_maximo = limite_maximo
        
        # Inicializar el texto con contador en 0
        self.actualizar_texto(0)
    
    def actualizar_contador(self, longitud_actual):
        """
        Método público para actualizar el contador de caracteres.
        Cambia el color del texto según la proximidad al límite.
        longitud_actual: int con el número actual de caracteres
        """
        # Actualizar el texto mostrado
        self.actualizar_texto(longitud_actual)
        
        # Calcular porcentaje de uso
        porcentaje = (longitud_actual / self.limite_maximo) * 100
        
        # Obtener la paleta actual
        paleta = self.palette()
        
        # Aplicar colores según el porcentaje (colores brillantes para tema oscuro)
        if porcentaje < 80:
            # Normal → texto del tema (claro en tema oscuro)
            paleta.setColor(QPalette.WindowText, self.palette().color(QPalette.WindowText))
        elif porcentaje < 100:
            # Cerca del límite → naranja brillante
            paleta.setColor(QPalette.WindowText, QColor("#FFA500"))
        else:
            # Límite superado → rojo brillante
            paleta.setColor(QPalette.WindowText, QColor("#FF6B6B"))
        
        # Aplicar la paleta modificada
        self.setPalette(paleta)
    
    def actualizar_texto(self, longitud_actual):
        """
        Actualiza el texto mostrado en la etiqueta.
        longitud_actual: int con el número actual de caracteres
        """
        texto = f"Caracteres: {longitud_actual} / {self.limite_maximo}"
        self.setText(texto)


class BotonLimpiarAviso(QPushButton):
    """
    Widget derivado de QPushButton que limpia el texto y proporciona
    avisos visuales mediante cambios de color de fondo.
    """
    
    # Señal personalizada
    textoLimpiado = Signal()  # Emite cuando se limpia el texto
    
    def __init__(self, area_texto, parent=None):
        super().__init__("Limpiar texto", parent)
        
        # Atributo privado con referencia al área de texto
        self.area_texto = area_texto
        self.color_base = self.palette().color(QPalette.Button)  # Guardar color del tema
        
        # Conectar el click del botón a la acción de limpiar
        self.clicked.connect(self.limpiar_texto)
        
        # Establecer color inicial (color del tema)
        self.aplicar_color_fondo(self.color_base)
    
    def limpiar_texto(self):
        """
        Método interno que limpia el contenido del área de texto,
        cambia el color del botón y emite la señal personalizada.
        """
        # Limpiar el área de texto
        self.area_texto.clear()
        
        # Cambiar color a verde suave con texto oscuro
        paleta = self.palette()
        paleta.setColor(QPalette.Button, QColor("#CCFFCC"))
        paleta.setColor(QPalette.ButtonText, QColor("#000000"))
        self.setPalette(paleta)
        self.setAutoFillBackground(True)
        
        # Emitir señal personalizada
        self.textoLimpiado.emit()
    
    def aplicar_color_fondo(self, color):
        """
        Aplica un color de fondo al botón usando QPalette.
        
        Args:
            color: QColor con el color a aplicar
        """
        paleta = self.palette()
        paleta.setColor(QPalette.Button, color)
        self.setPalette(paleta)
        self.setAutoFillBackground(True)


class VentanaPrincipal(QMainWindow):
    """
    Ventana principal que integra los tres widgets derivados
    y gestiona sus conexiones mediante señales y slots.
    """
    
    def __init__(self):
        super().__init__()
        
        # Configurar la ventana
        self.configurar_ventana()
        
        # Crear los widgets
        self.crear_widgets()
        
        # Configurar el layout
        self.configurar_layout()
        
        # Conectar las señales
        self.conectar_senales()
    
    def configurar_ventana(self):
        """
        Configura las propiedades básicas de la ventana.
        """
        self.setWindowTitle("Editor de notas con avisos")
        self.setMinimumSize(500, 400)
    
    def crear_widgets(self):
        """
        Crea las instancias de los widgets derivados y auxiliares.
        """
        # Crear el área de texto limitada
        self.area_texto = AreaTextoLimitada()
        
        # Crear la etiqueta contador con el límite del área de texto
        limite = self.area_texto.obtener_limite_maximo()
        self.etiqueta_contador = EtiquetaContadorCaracteres(limite)
        
        # Crear el botón de limpiar (necesita referencia al área de texto)
        self.boton_limpiar = BotonLimpiarAviso(self.area_texto)
        
        # Crear etiqueta informativa
        self.etiqueta_info = QLabel("Estado: Listo para escribir")
        # No aplicar estilos para mantener el tema oscuro
    
    def configurar_layout(self):
        """
        Configura el layout principal y añade los widgets.
        """
        # Crear widget central y layout
        contenedor = QWidget()
        layout = QVBoxLayout()
        
        # Añadir widgets al layout
        layout.addWidget(self.etiqueta_contador)
        layout.addWidget(self.area_texto)
        layout.addWidget(self.boton_limpiar)
        layout.addWidget(self.etiqueta_info)
        
        # Establecer el layout en el contenedor
        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)
    
    def conectar_senales(self):
        """
        Conecta las señales personalizadas de los widgets derivados
        con los métodos correspondientes de la ventana.
        """
        # Conectar señal longitudCambiada del área de texto con el contador
        self.area_texto.longitudCambiada.connect(
            self.etiqueta_contador.actualizar_contador
        )
        
        # Conectar señal limiteSuperado para actualizar mensaje informativo
        self.area_texto.limiteSuperado.connect(self.actualizar_aviso_limite)
        
        # Conectar señal textoLimpiado del botón para actualizar mensaje
        self.boton_limpiar.textoLimpiado.connect(self.actualizar_mensaje_limpiado)
    
    def actualizar_aviso_limite(self, superado):
        """
        Actualiza el mensaje informativo cuando se alcanza el límite.
        superado: bool indicando si se superó el límite
        """
        if superado:
            self.etiqueta_info.setText("Estado: ¡Límite alcanzado! No se pueden añadir más caracteres")
            paleta = self.etiqueta_info.palette()
            paleta.setColor(QPalette.Window, QColor("#8B0000"))  # Rojo oscuro
            paleta.setColor(QPalette.WindowText, QColor("#FFCCCC"))  # Texto claro
            self.etiqueta_info.setPalette(paleta)
            self.etiqueta_info.setAutoFillBackground(True)
        else:
            self.etiqueta_info.setText("Estado: Listo para escribir")
            # Restaurar colores del tema
            self.etiqueta_info.setPalette(self.palette())
            self.etiqueta_info.setAutoFillBackground(False)
    
    def actualizar_mensaje_limpiado(self):
        """
        Actualiza el mensaje informativo cuando se limpia el texto.
        """
        self.etiqueta_info.setText("Estado: Texto limpiado correctamente")
        paleta = self.etiqueta_info.palette()
        paleta.setColor(QPalette.Window, QColor("#1F831F"))  # Verde oscuro
        paleta.setColor(QPalette.WindowText, QColor("#CCFFCC"))  # Texto claro
        self.etiqueta_info.setPalette(paleta)
        self.etiqueta_info.setAutoFillBackground(True)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())